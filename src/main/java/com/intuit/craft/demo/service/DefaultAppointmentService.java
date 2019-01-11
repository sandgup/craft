/**
 * 
 */
package com.intuit.craft.demo.service;

import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.intuit.craft.demo.client.model.Appointment;
import com.intuit.craft.demo.entity.DBAppointment;
import com.intuit.craft.demo.entity.DBSlot;
import com.intuit.craft.demo.exception.BadRequest;
import com.intuit.craft.demo.exception.ResourceNotFound;
import com.intuit.craft.demo.repository.IAppointmentRepo;
import com.intuit.craft.demo.repository.ISlotRepo;
import com.intuit.craft.demo.validator.AppointmentFailFastValidator;

/**
 * @author SANDGUP
 *
 */
@Service
public class DefaultAppointmentService implements IAppointmentService {

  @Autowired
  private IAppointmentRepo appointmentRepo;
  @Autowired
  private ISlotRepo slotRepo;
  @Autowired
  private INotifyService notifyService;

  @Autowired
  private AppointmentFailFastValidator appointmentFailFastValidator;

  @Value("${appointment.max_days}")
  private String maxDays;

  @Override
  public void createAppointment(Appointment appointment) {

    // TODO Auto-generated method stub
    appointmentFailFastValidator.Validate(appointment);

    DBAppointment dbAppointment = new DBAppointment(appointment.getCustId(), appointment.getDate(),
        appointment.getQueryType());
    DBSlot dbSlot = new DBSlot(appointment.getDate());
    slotRepo.decrementSlot(dbSlot);
    appointmentRepo.createAppointment(dbAppointment);
    notifyService.sendNotification(appointment);


  }

  @Override
  public void deleteAppoinment(String custId) {
    DBAppointment appointment = appointmentRepo.getAppointment(custId);
    slotRepo.decrementSlot(new DBSlot(appointment.getSlot()));



  }

  @Override
  public void updateAppointment(Appointment appointment) {
    DBAppointment dbAppointment = appointmentRepo.getAppointment(appointment.getCustId());
    long convert = TimeUnit.HOURS.convert(
        System.currentTimeMillis() - dbAppointment.getSlot().getTime(), TimeUnit.MILLISECONDS);
    if (convert > 1) {
      throw new BadRequest("update allowed untill 1 hr before");
    }
    slotRepo.decrementSlot(new DBSlot(dbAppointment.getSlot()));
    slotRepo.incrementSlot(new DBSlot(appointment.getDate()));
    appointmentRepo.updateAppointment(dbAppointment);
    notifyService.sendNotification(appointment);

  }

  @Override
  public Appointment getAppointment(String custId) {
    DBAppointment dbAppointment = appointmentRepo.getAppointment(custId);
    if (dbAppointment == null) {
      throw new ResourceNotFound("No Appointment available");
    }
    Appointment appointment = new Appointment();
    appointment.setCustId(dbAppointment.getCustId());
    appointment.setDate(dbAppointment.getSlot());
    appointment.setQueryType(dbAppointment.getQueryType());

    return appointment;
  }


}

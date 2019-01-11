/**
 * 
 */
package com.intuit.craft.demo.service;

import com.intuit.craft.demo.client.model.Appointment;

/**
 * @author SANDGUP
 *
 */
public interface IAppointmentService {

  void createAppointment(Appointment appointment);

  void deleteAppoinment(String custId);

  void updateAppointment(Appointment appointment);

  Appointment getAppointment(String custId);



}

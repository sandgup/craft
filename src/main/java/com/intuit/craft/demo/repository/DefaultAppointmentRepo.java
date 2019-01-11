/**
 * 
 */
package com.intuit.craft.demo.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.intuit.craft.demo.entity.DBAppointment;

/**
 * @author SANDGUP
 *
 */
@Repository
public class DefaultAppointmentRepo implements IAppointmentRepo {

  private Map<String, DBAppointment> appointmentsMap = new HashMap<>();

  public void createAppointment(DBAppointment dbAppointment) {
    appointmentsMap.put(dbAppointment.getCustId(), dbAppointment);
    // return dbAppointment;

  }

  public void updateAppointment(DBAppointment dbAppointment) {
    appointmentsMap.put(dbAppointment.getCustId(), dbAppointment);
    // return dbAppointment;

  }

  public DBAppointment getAppointment(String custId) {
    return appointmentsMap.get(custId);

  }

  public void deleteAppointment(String custId) {
    appointmentsMap.remove(custId);

  }



}

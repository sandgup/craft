package com.intuit.craft.demo.repository;

import com.intuit.craft.demo.entity.DBAppointment;

public interface IAppointmentRepo {

  void createAppointment(DBAppointment appointment);

  void deleteAppointment(String custId);

  void updateAppointment(DBAppointment appointment);

  DBAppointment getAppointment(String custId);


}

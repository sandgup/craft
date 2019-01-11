package com.intuit.craft.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.intuit.craft.demo.client.model.Appointment;

@Service
public class DefaultNotificationService implements INotifyService {

  @Override
  @Async
  public void sendNotification(Appointment appointment) {
    System.out.println("Hi " + appointment.getCustId()
        + ". Your appointment is confirmed for the date " + appointment.getDate());

  }

}

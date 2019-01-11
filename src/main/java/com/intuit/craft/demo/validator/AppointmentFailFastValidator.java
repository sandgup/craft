/**
 * 
 */
package com.intuit.craft.demo.validator;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.intuit.craft.demo.client.model.Appointment;
import com.intuit.craft.demo.exception.BadRequest;

/**
 * Fail fast validation for Appointment parameters.
 * 
 * @author SANDGUP
 *
 */
@Component
public class AppointmentFailFastValidator {

  @Value("${appointment.max_days}")
  private int maxDays;
  private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentFailFastValidator.class);


  public void Validate(Appointment appointment) {

    long convert = TimeUnit.DAYS.convert(
        System.currentTimeMillis() - appointment.getDate().getTime(), TimeUnit.MILLISECONDS);
    if (convert > maxDays) {
      LOGGER.error("BAD_REQUEST");
      throw new BadRequest("slot is beyond " + maxDays + " days");

    }

  }

}

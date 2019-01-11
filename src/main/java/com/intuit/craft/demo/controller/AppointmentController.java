package com.intuit.craft.demo.controller;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.intuit.craft.demo.client.model.Appointment;
import com.intuit.craft.demo.exception.BadRequest;
import com.intuit.craft.demo.service.IAppointmentService;
import com.intuit.craft.demo.service.ISlotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Appointment Controller exposing search endpoints over http.
 * 
 * @author SANDGUP
 *
 */
@RestController
@RequestMapping("/appointments")
@Api(description = "Endpoints for Appointment Scheduling.", tags = "Appointment Scheduler")
public class AppointmentController {
  private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);

  @Autowired
  private IAppointmentService appointmentService;
  @Autowired
  private ISlotService SlotService;


  @ApiOperation(value = "Retreive Customer Appointment",
      notes = "Retreive Customer Appointment for customer Id.",
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,
      httpMethod = "GET", response = Appointment.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successful retrieval of Appointment.",
          response = String.class, responseContainer = "List"),
      @ApiResponse(code = 400, message = "Bad Request.Input Request is not valid.",
          response = BadRequest.class),
      @ApiResponse(code = 500, message = "Internal Server Error.Something is broken.",
          response = RuntimeException.class)})

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Appointment> getAppointment(
      @PathVariable(value = "id") final String custId) {
    LOGGER.info("getAppointmentByCustomerId " + custId);
    Appointment appointment = appointmentService.getAppointment(custId);
    LOGGER.info("Appointment " + appointment);
    return new ResponseEntity<>(appointment, HttpStatus.OK);
  }

  @GetMapping(value = "/slots/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Date>> getAppointmentSlots(
      @PathVariable(value = "date") final String date) {
    LOGGER.info("getAppointmentByCustomerId " + date);

    List<Date> slots = SlotService.getSlots(date);
    LOGGER.info("getAppointmentSlots " + date);
    return new ResponseEntity<>(slots, HttpStatus.OK);
  }


  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Integer> createAppointment(@RequestBody final Appointment appointment) {
    LOGGER.info("createAppointment " + appointment);
    appointmentService.createAppointment(appointment);
    LOGGER.info("Appointment " + appointment);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Integer> deleteAppointment(
      @PathVariable(value = "id") final String custId) {
    LOGGER.info("deleteAppointment " + custId);
    appointmentService.deleteAppoinment(custId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Integer> updateAppointment(@RequestBody final Appointment appointment) {
    LOGGER.info("updateAppointment " + appointment);
    appointmentService.updateAppointment(appointment);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}

package com.intuit.craft.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.intuit.craft.demo.client.model.Appointment;
import com.intuit.craft.demo.controller.AppointmentController;
import com.intuit.craft.demo.service.IAppointmentService;
import com.intuit.craft.demo.service.INotifyService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AppointmentController.class, secure = false)
public class AppointmentControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private IAppointmentService iappointmentservice;

  @MockBean
  private INotifyService inotifyservice;
  java.util.Date date = new java.util.Date();



  @Test
  public void getAppointmentTest() throws Exception {
    Appointment mockAppointment = new Appointment();
    mockAppointment.setDate(date);
    mockAppointment.setCustId("Cust_101");
    Mockito.when(iappointmentservice.getAppointment(Mockito.any())).thenReturn(mockAppointment);

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/Cust_101").accept(MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    String expected = "{custId:Cust_101,date:" + mockAppointment.getDate() + "}";
    org.junit.Assert.assertEquals(expected,
        new String(result.getResponse().getContentAsByteArray()));

  }


}

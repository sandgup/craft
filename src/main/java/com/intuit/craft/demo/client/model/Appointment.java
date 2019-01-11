package com.intuit.craft.demo.client.model;

import java.util.Date;

public class Appointment {

  private String custId;
  private Date date;
  private String queryType;

  public String getCustId() {
    return custId;
  }

  public void setCustId(String custId) {
    this.custId = custId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getQueryType() {
    return queryType;
  }

  public void setQueryType(String queryType) {
    this.queryType = queryType;
  }



}

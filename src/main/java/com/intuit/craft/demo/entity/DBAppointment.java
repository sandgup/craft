/**
 * 
 */
package com.intuit.craft.demo.entity;

import java.util.Date;

/**
 * @author SANDGUP
 *
 */
public class DBAppointment {

  private String custId;
  private Date slot;
  private String queryType;


  public DBAppointment(String custId, Date slot, String queryType) {
    super();
    this.custId = custId;
    this.slot = slot;
    this.queryType = queryType;
  }

  public String getCustId() {
    return custId;
  }

  public void setCustId(String custId) {
    this.custId = custId;
  }

  public Date getSlot() {
    return slot;
  }

  public void setSlot(Date slot) {
    this.slot = slot;
  }

  public String getQueryType() {
    return queryType;
  }

  public void setQueryType(String queryType) {
    this.queryType = queryType;
  }

}

/**
 * 
 */
package com.intuit.craft.demo.entity;

import java.util.Date;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author SANDGUP
 *
 */
public class DBSlot {

  // private String executiveId;
  private Date date;

  // public String getExecutiveId() {
  // return executiveId;
  // }

  public Date getDate() {
    return date;
  }



  public DBSlot(Date date) {
    super();
    // this.executiveId = executiveId;
    this.date = date;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  @Override
  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o, "date");
  }

  @Override
  public int hashCode() {
    return this.date.hashCode();
  }

}

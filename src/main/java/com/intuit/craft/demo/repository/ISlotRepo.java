package com.intuit.craft.demo.repository;

import java.util.Date;
import java.util.List;
import com.intuit.craft.demo.entity.DBSlot;

public interface ISlotRepo {


  void decrementSlot(DBSlot dbSlot);

  void incrementSlot(DBSlot dbSlot);

  List<DBSlot> getSlots(Date date);


}

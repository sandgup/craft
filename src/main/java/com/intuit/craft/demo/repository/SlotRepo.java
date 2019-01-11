/**
 * 
 */
package com.intuit.craft.demo.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.intuit.craft.demo.entity.DBSlot;
import com.intuit.craft.demo.exception.ResourceNotAvailable;

/*
 * fix me exception logic must be handled via service Repo must store the data in some db
 */

/**
 * @author SANDGUP
 *
 */
@Repository
public class SlotRepo implements ISlotRepo {
  private volatile static Map<DBSlot, Integer> slotMap = new HashMap<>();
  static {
    Calendar cal = Calendar.getInstance();
    cal.clear();
    cal.set(2019, 0, 11, 9, 0);
    DBSlot dbSlot1 = new DBSlot(cal.getTime());
    cal.clear();
    cal.set(2019, 0, 11, 10, 0);
    DBSlot dbSlot2 = new DBSlot(cal.getTime());
    slotMap.put(dbSlot1, 10);
    slotMap.put(dbSlot2, 10);
  }

  @Override
  public void decrementSlot(DBSlot dbSlot) {
    synchronized (slotMap) {
      Integer integer = slotMap.getOrDefault(dbSlot, 0);

      if (integer > 1) {
        slotMap.put(dbSlot, --integer);
      } else {
        throw new ResourceNotAvailable("no Slot available");
      }

    }

  }

  @Override
  public void incrementSlot(DBSlot dbSlot) {
    synchronized (slotMap) {
      Integer integer = slotMap.get(dbSlot);
      if (integer < 10) {
        slotMap.put(dbSlot, ++integer);
      }

    }
  }

  @Override
  public List<DBSlot> getSlots(Date date) {
    LinkedList<DBSlot> collect = slotMap.keySet().stream().filter((s) -> {
      if (s.getDate().getYear() == date.getYear() && s.getDate().getMonth() == date.getMonth()
          && s.getDate().getDate() == date.getDate() && slotMap.get(s) > 0) {
        return true;

      } else
        return false;
    }).collect(Collectors.toCollection(LinkedList::new));
    return collect;
  }



}

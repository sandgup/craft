/**
 * 
 */
package com.intuit.craft.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intuit.craft.demo.entity.DBSlot;
import com.intuit.craft.demo.repository.ISlotRepo;

/**
 * @author SANDGUP
 *
 */
@Service
public class DefaultSlotService implements ISlotService {
  @Autowired
  private ISlotRepo slotRepo;


  @Override
  public List<Date> getSlots(String date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    Date parse;
    try {
      parse = dateFormat.parse(date);
    } catch (ParseException e1) {
      throw new BadRequestException("bad date");
    }
    List<DBSlot> dbSlots = slotRepo.getSlots(parse);
    List<Date> slots = new ArrayList<>(dbSlots.size());
    dbSlots.stream().forEach((e) -> {
      slots.add(e.getDate());
    });
    return slots;
  }

}

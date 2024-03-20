package com.mentormate.openair.repository;

import com.mentormate.openair.controller.NotFoundException;
import com.mentormate.openair.model.Timeslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeSlotService {
    private final TimeslotRepository timeslotRepository;

    @Autowired
    public TimeSlotService(TimeslotRepository timeslotRepository) {
        this.timeslotRepository = timeslotRepository;
    }

    public List<String> getAvailableTimeSlots() {
        List<Object[]> slots = timeslotRepository.listAvailableSlots();
        if (slots.isEmpty()) {
            throw new NotFoundException("No available time slots found. Please try next year");
        }
        List<String> timeSlots = new ArrayList<>();

        System.out.println(slots + " Slots from DB");

        for (Object[] slotData : slots) {
            System.out.println(slotData);
            int id = (int) slotData[0];
            LocalTime startTime = LocalTime.parse(slotData[1].toString());
            LocalTime endTime = LocalTime.parse(slotData[2].toString());
            System.out.println(startTime);
            Timeslot parsedTimeSlot = new Timeslot(id, startTime, endTime);
            System.out.println(parsedTimeSlot);
            timeSlots.add(parsedTimeSlot.toString());
        }
        System.out.println("-----------------------");
        System.out.println("Timeslots " + timeSlots);


        return timeSlots;
    }
}

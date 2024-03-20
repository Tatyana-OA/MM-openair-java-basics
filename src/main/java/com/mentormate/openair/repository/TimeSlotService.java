package com.mentormate.openair.repository;

import com.mentormate.openair.controller.NotFoundException;
import com.mentormate.openair.model.Timeslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TimeSlotService {
    private final TimeslotRepository timeslotRepository;

    @Autowired
    public TimeSlotService(TimeslotRepository timeslotRepository) {
        this.timeslotRepository = timeslotRepository;
    }

    public Map<String, List<Timeslot>> getAvailableTimeSlots() {
        Map<String, List<Timeslot>> timeslotMap = new HashMap<>();

        List<Object[]> slotsDay1 = timeslotRepository.getAvailableSlotsForDay1();
        List<Object[]> slotsDay2 = timeslotRepository.getAvailableSlotsForDay2();
        List<Object[]> slotsDay3 = timeslotRepository.getAvailableSlotsForDay3();

        if (slotsDay1.isEmpty() && slotsDay2.isEmpty() && slotsDay3.isEmpty()) {
            throw new NotFoundException("No available time slots found. Please try next year");
        }

        timeslotMap.put("2024-07-19", mapToObjectList(slotsDay1));
        timeslotMap.put("2024-07-20", mapToObjectList(slotsDay2));
        timeslotMap.put("2024-07-21", mapToObjectList(slotsDay3));

        return timeslotMap;
    }


    private List<Timeslot> mapToObjectList(List<Object[]> slotData) {
        return slotData.stream()
                .map(slot -> new Timeslot((int) slot[0], (LocalTime) slot[1], (LocalTime) slot[2]))
                .collect(Collectors.toList());
    }
}

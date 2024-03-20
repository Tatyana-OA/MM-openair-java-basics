package com.mentormate.openair.controller;

import com.mentormate.openair.model.Band;
import com.mentormate.openair.model.Timeslot;
import com.mentormate.openair.repository.ApiResponse;
import com.mentormate.openair.repository.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/timeslots")
public class TimeSlotController {

    private final TimeSlotService timeslotsService;

    @Autowired
    public TimeSlotController(TimeSlotService timeslotsService) {
        this.timeslotsService = timeslotsService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<String>>>  getTimeslots() {
        try {
            List<String> slots = timeslotsService.getAvailableTimeSlots();
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Here are the available timeslots", slots));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null));
        }

    }
}

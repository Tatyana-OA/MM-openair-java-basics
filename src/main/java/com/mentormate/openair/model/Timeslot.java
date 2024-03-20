package com.mentormate.openair.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;


import java.time.LocalTime;

@AllArgsConstructor
@Entity
@Table(name = "timeslots")
public class Timeslot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_time", nullable = false)
    private LocalTime start_time;

    @Column(name = "end_time", nullable = false)
    private LocalTime end_time;



}
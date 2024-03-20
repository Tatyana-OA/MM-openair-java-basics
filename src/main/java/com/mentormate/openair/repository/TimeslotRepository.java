package com.mentormate.openair.repository;


import com.mentormate.openair.model.Timeslot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeslotRepository extends ListCrudRepository<Timeslot, Integer> {

    @Query("SELECT t.id, t.start_time, t.end_time, b.day FROM Timeslot t LEFT JOIN Band b ON b.timeslot_id = t.id AND b.day = '2024-07-19' WHERE b.timeslot_id IS NULL")
    List<Object[]> getAvailableSlotsForDay1();

    @Query("SELECT t.id, t.start_time, t.end_time, b.day FROM Timeslot t LEFT JOIN Band b ON b.timeslot_id = t.id AND b.day = '2024-07-20' WHERE b.timeslot_id IS NULL")
    List<Object[]> getAvailableSlotsForDay2();

    @Query("SELECT t.id, t.start_time, t.end_time, b.day FROM Timeslot t LEFT JOIN Band b ON b.timeslot_id = t.id AND b.day = '2024-07-21' WHERE b.timeslot_id IS NULL")
    List<Object[]> getAvailableSlotsForDay3();


}
package com.mentormate.openair.controller;

public class NotSavedException extends RuntimeException{

    public NotSavedException() {
        super("Band could not be saved. Make sure all fields are filled in correctly and band is not already performing or that the timeslot you are requesting is free. Check available timeslots at /api/timeslots");
    }

    public NotSavedException(int bandId) {
        super("Could not save or update band with id: " + bandId);
    }

    public NotSavedException(String ex) {
        super(ex);
    }
}

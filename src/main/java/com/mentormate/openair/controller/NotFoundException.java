package com.mentormate.openair.controller;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("No band records in the database");
    }
    public NotFoundException(int bandId) {
        super("No results for band with id: " + bandId);
    }

    public NotFoundException(String message) {
        super(message);
    }
}

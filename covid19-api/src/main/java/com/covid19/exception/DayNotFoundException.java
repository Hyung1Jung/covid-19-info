package com.covid19.exception;

public class DayNotFoundException extends  RuntimeException{
    public DayNotFoundException(String date) {
        super("Could not find restaurant " + date);
    }
}

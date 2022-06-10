package com.chainsys.springproject.beans;
// Multiple factory methods in one class
// Calendar factory is also called as initiating bean because methods in this bean instantiates objects for other beans
public class CalendarFactory {

    // The factory method is not static here
    public Calendar createCalendar() {
        // The Calendar constructor is default access modifier so, can be called here
        // The calendar class and the calendar factory class are both in the same
        // package
        return new Calendar();
    }

    public Appointments createAppointment() {
        return new Appointments();
    }
}
package com.home.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by li.ma on 2018/7/20.
 */
public class BookingCreatedEvent extends ApplicationEvent {
    private Booking booking;

    public BookingCreatedEvent(Object source) {
        super(source);
    }

    public BookingCreatedEvent(Object source, Booking booking) {
        super(source);
        this.booking = booking;
    }

    public Booking getBooking() {
        return booking;
    }
}

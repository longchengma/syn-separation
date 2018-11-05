package com.home.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService implements ApplicationContextAware {

//    @Autowired
//    private ApplicationContext context;


    private ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }


    //事件源
    @Transactional
    public void persistBooking(Booking booking) {
        System.out.println("插入数据库");

//      em.persist(booking);    log.debug("fire BookingCreatedEvent");

        BookingCreatedEvent bookingCreatedEvent = new BookingCreatedEvent(this, booking);

        this.context.publishEvent(bookingCreatedEvent);   //触发event
    }
}

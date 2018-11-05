package com.home.google.gvava.eventBus;

import com.google.common.eventbus.Subscribe;

/**
 * Created by li.ma on 2018/8/27.
 */
public class Event {
    @Subscribe
    public void sub(String message) {
        System.out.println(message);
    }
}

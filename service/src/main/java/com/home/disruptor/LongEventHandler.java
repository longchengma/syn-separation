package com.home.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * Created by li.ma on 2018/8/9.
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.getValue());
    }
}

package com.home.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by li.ma on 2018/8/9.
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}

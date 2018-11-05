package com.home.designPattern.bridging;

public abstract class RemoteControl implements ITV {
    public ITV tv;

    public RemoteControl(ITV tv) {
        this.tv = tv;
    }

    @Override
    public void turnOn() {
        tv.turnOn();
    }

    @Override
    public void turnOff() {
        tv.turnOff();
    }

    @Override
    public void changeChanel(int channel) {
        tv.changeChanel(channel);
    }
}
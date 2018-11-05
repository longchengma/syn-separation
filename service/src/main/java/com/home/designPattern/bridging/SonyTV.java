package com.home.designPattern.bridging;

public class SonyTV implements ITV {
    @Override
    public void turnOn() {
        System.out.println("Sony is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Sony is turned on.");
    }

    @Override
    public void changeChanel(int channel) {
        System.out.println("Sony is changed chanel- " + channel);
    }
}
package com.home.designPattern.bridging;

public class LogitechRemoteControl extends RemoteControl {

    public LogitechRemoteControl(ITV tv) {
        super(tv);
    }

    public void setChannelKeyboard(int channel) {
        tv.changeChanel(channel);
        System.out.println("Logitech use keyword to set channel.");
    }
}
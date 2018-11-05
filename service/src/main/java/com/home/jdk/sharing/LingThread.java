package com.home.jdk.sharing;

/**
 * Created by li.ma on 2018/8/9.
 */
public class LingThread extends Thread {
    SharingLong[] shares;

    int index;

    LingThread(SharingLong[] shares, int index) {
        this.shares = shares;
        this.index = index;
    }

    public void run() {
        for (int i = 0; i < 100000000; i++) {
            shares[index].v++;
        }
    }
}

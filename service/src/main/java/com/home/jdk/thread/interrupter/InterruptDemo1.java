package com.home.jdk.thread.interrupter;

/**
 * Created by li.ma on 2018/9/7.
 */
public class InterruptDemo1 extends Thread {
    public void run() {

        int number = 0;

        while (true) {
            System.out.println(isInterrupted());
            // 检查线程是否被中断，中断就停止下载
            if (isInterrupted()) {

                System.err.println("太慢了，我不下了");
                return;
            } else if (number >= 500) {
                System.out.println("下载完成");
                return;
            }

            number++;
            System.out.println("已下载" + number + "M");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Thread thread = new InterruptDemo1();

        // 启动线程
        thread.start();

        // 等待10秒后中断线程
        Thread.sleep(1000);

        // 中断线程   此时线程正处于sleep当中、会抛出一个Interrupt异常
        thread.interrupt();


        //thread
    }
}

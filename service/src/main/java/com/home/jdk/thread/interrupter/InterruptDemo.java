package com.home.jdk.thread.interrupter;

/**
 * Created by li.ma on 2018/9/7.
 */
public class InterruptDemo extends Thread{
    public void run() {

        int number = 0;

        // 记录程序开始的时间
        Long start = System.currentTimeMillis();

        while (true) {

            // 每次执行一次结束的时间
            Long end = System.currentTimeMillis();

            // 获取时间差
            Long interval = end - start;

            // 如果时间超过了10秒，那么我们就结束下载
            if (interval >= 10000) {
                // 中断线程
                interrupted();
                System.err.println("太慢了，我不下了");

                System.out.println(isInterrupted());

                return;
            } else if (number >= 500) {
                System.out.println("文件下载完成");
                // 中断线程
                interrupted();
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


    public static void main(String[] args) {
        InterruptDemo interruptDemo = new InterruptDemo();

        interruptDemo.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // 这个线程收到中断信号之后就会抛出InterruptedException异常，同时会把中断状态设置为true          wait()、join(）
        interruptDemo.interrupt();
    }
}

package com.home.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by li.ma on 2018/6/12.
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
public class JmhDemo {
    static int millis = 24 * 3600 * 1000;

    public static void main(String[] args) throws Exception{
        Options options = new OptionsBuilder().include(JmhDemo.class.getName()).forks(1).build();

        new Runner(options).run();
    }

    @Benchmark
    @Threads(5)
    public void runCalender() {
        Calendar calendar = Calendar.getInstance();
    }


    public void runSystem () {
        long result = System.currentTimeMillis() / millis;
    }
}

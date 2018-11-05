package com.home.threadpool.forkJoinPool;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * Created by li.ma on 2018/8/15.
 */
public class FactorialTask  extends RecursiveTask<BigInteger> {

    private int start = 1;

    private int n;

    private static final int THRESHOLD = 20;

    public FactorialTask(int n) {
        this.n = n;
    }

    public FactorialTask(int start, int n) {
        this.start = start;
        this.n = n;
    }

    @Override
    protected BigInteger compute() {
        if((n - start) >= THRESHOLD) {
            System.out.println("forkJoin begin......................");

            return ForkJoinTask.invokeAll(createSubTasks()).stream().map(ForkJoinTask::join).reduce(BigInteger.ONE, BigInteger::multiply);
        } else {
            System.out.println("method calculate begin *************************");
            return calculate(start, n);
        }
    }

    private BigInteger calculate(int start, int end) {
        return IntStream.rangeClosed(start, end).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
    }

    private Collection<FactorialTask> createSubTasks() {
        System.out.printf("method createSubTasks in start is %d, n is %d", start, n);
        System.out.println();

        List<FactorialTask> dividedTasks = new ArrayList<>();
        int mid = (start + n) / 2;
        dividedTasks.add(new FactorialTask(start, mid));
        dividedTasks.add(new FactorialTask(mid + 1, n));
        return  dividedTasks;
    }
}

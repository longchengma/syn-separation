package com.home.servlet.asyn;

/**
 * Created by li.ma on 2018/7/31.
 */
import javax.servlet.AsyncContext;
import java.io.IOException;
import java.io.PrintWriter;

public class AsyncRequestProcessor implements Runnable {
    private AsyncContext asyncContext;
    private int milliseconds;

    public AsyncRequestProcessor() {

    }

    public AsyncRequestProcessor(AsyncContext asyncContext, int milliseconds) {
        this.asyncContext = asyncContext;
        this.milliseconds = milliseconds;
    }

    @Override
    public void run() {
        System.out.println("Async Supported? "
                + asyncContext.getRequest().isAsyncSupported());
        longProcessing(milliseconds);
        try {
            PrintWriter out = asyncContext.getResponse().getWriter();
            out.write("Processing done for " + milliseconds + " milliseconds!!");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        asyncContext.complete();
    }

    private void longProcessing(int secs) {
        // wait for given time before finishing
        try {
            Thread.sleep(secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String h = "35/35.5/36/36.5/37/37.5/38/38.5/39/40/40.5/41/42/42.5/43/44/44.5/45/45.5/46/46.5/47/48";

        String[] split = h.split("/");
        int len  =1;
        for (String item : split) {
            System.out.print("('" + item + "', 48, "+ len++ +")");
            System.out.print(",");
        }

    }
}
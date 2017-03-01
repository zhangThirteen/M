package com.zyy.m.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/3/1.
 */

public class ThreadUtil {

    private static ExecutorService executorService;


    public static void execute(Runnable task){
        if (executorService==null){
            executorService = Executors.newFixedThreadPool(10);
            executorService.submit(task);
        }
    }

}

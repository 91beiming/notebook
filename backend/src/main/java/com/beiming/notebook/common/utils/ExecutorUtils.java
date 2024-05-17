package com.beiming.notebook.common.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lcl
 * @date 2024/3/1 16:26
 */
public class ExecutorUtils {

    private static final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

    public static void execute(Runnable runnable) {
        executorService.execute(runnable);
    }

    public static ExecutorService getInstance() {
        return executorService;
    }
}

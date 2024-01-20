package com.example.multithreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DataProcessor {
    public static final Logger logger = LoggerFactory.getLogger(DataProcessor.class);
    private ExecutorService executor;
    private AtomicInteger taskCounter = new AtomicInteger(0);
    private Map<String, Future<Integer>> taskResult = new HashMap<>();


    public void shutdown() {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            logger.error("Прерывание при ожидании задач.");
            Thread.currentThread().interrupt();
        } finally {
            if (!executor.isTerminated()) {
                logger.error("Отмена незавершённых задач.");
            }
            executor.shutdownNow();
            logger.info("Пул завершён.");
        }
    }

    public String submitCalculateSumTask(List<Integer> numbers) {
        String taskName = "task" + taskCounter.incrementAndGet();
        logger.info("Задача '{}' взята в работу.", taskName);
        CalculateSumTask task = new CalculateSumTask(numbers, taskName);
        Future<Integer> future = executor.submit(task);

        synchronized (taskResult) {
            taskResult.put(taskName, future);
        }
        logger.info("Задача '{}' отправлена на выполнение.", taskName);
        return taskName;
    }

    public Optional<Integer> getResultTask(String taskName) {
        Future<Integer> future;
        synchronized (taskResult) {
            future = taskResult.get(taskName);
        }

        if (future == null) {
            return Optional.empty();
        }

        try {
            Integer result = future.get();
            return Optional.ofNullable(result);
        } catch (InterruptedException | ExecutionException e) {
            logger.error("Ошибка при получении результата задачи.");
            return Optional.empty();
        }
    }

    public int getActiveTaskCount() {
        if (executor instanceof ThreadPoolExecutor) {
            return ((ThreadPoolExecutor) executor).getActiveCount();
        }
        return -1;
    }

    public boolean isShutdown() {
        return executor.isShutdown();
    }

    public boolean isTerminated() {
        return executor.isTerminated();
    }

    public DataProcessor() {
        executor = Executors.newFixedThreadPool(10);
    }
}

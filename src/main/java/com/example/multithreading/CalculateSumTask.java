package com.example.multithreading;

import java.util.List;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculateSumTask implements Callable<Integer> {
    public static final Logger logger = LoggerFactory.getLogger(CalculateSumTask.class);
    private List<Integer> numbersList;
    private String taskName;

    public CalculateSumTask(List<Integer> numbersList, String taskName) {
        this.numbersList = numbersList;
        this.taskName = taskName;
    }

    @Override
    public Integer call() {
        logger.info("Задача '{}' начата в потоке '{}'.", taskName, Thread.currentThread().getName());
        int sum = 0;

        try {
            for (Integer num : numbersList) {
                sum += num;
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            logger.error("Задача '{}' была прервана в потоке '{}'", taskName, Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }

        logger.info("Задача '{}' завершена в потоке '{}'. Итоговая сумма: {}", taskName, Thread.currentThread().getName(), sum);
        return sum;
    }

}

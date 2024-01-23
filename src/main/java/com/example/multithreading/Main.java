package com.example.multithreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        DataProcessor processor = new DataProcessor();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            List<Integer> numbers = generateRandomNumbers(random, 10, 50);
            processor.submitCalculateSumTask(numbers);
        }

        while (processor.getActiveTaskCount() > 0) {
            int activeTask = processor.getActiveTaskCount();
            logger.info("Активных задач осталось: '{}'", activeTask);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                logger.error("Прервано ожидание завершения задач: ", e);
                Thread.currentThread().interrupt();
            }
        }

        processor.shutdown();
    }

    private static List<Integer> generateRandomNumbers(Random random, int count, int maxNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(maxNumber));
        }
        return numbers;
    }
}

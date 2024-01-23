package com.example.multithrading1;

public class Main {

    public static void main(String[] args) {
        testCounter(100);
    }

    private static void testCounter(int numOfThreads) {
        testSingleCount(new UnsynchronizedCounter(), numOfThreads, "UnsynchronizedCounter");
        testSingleCount(new VolatileCounter(), numOfThreads, "VolatileCounter");
        testSingleCount(new SynchronizedBlockCounter(), numOfThreads, "SynchronizedBlockCounter");
        testSingleCount(new AtomicIntegerCounter(), numOfThreads, "AtomicIntegerCounter");
        testSingleCount(new ReentrantLockCounter(), numOfThreads, "ReentrantLockCounter");
    }

    private static void testSingleCount(SiteVisitCounter counter, int numOfThreads, String counterName) {
        MultithreadingSiteVisitor visitor = new MultithreadingSiteVisitor(counter);
        visitor.visitMultithread(numOfThreads);
        printResults(counterName, visitor, counter);
    }

    private static void printResults(String counterName, MultithreadingSiteVisitor visitor, SiteVisitCounter counter) {
        visitor.waitUntilAllVisited();
        System.out.println(counterName + ": ");
        System.out.printf("Total time: %.3f second%n", visitor.getTotalTimeOfHandling() / 1000.0);
        System.out.println("Visit Count: " + counter.getVisitCount());
        System.out.println();
    }
}


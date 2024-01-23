package com.example.multithrading1;

import java.util.ArrayList;
import java.util.List;

public class MultithreadingSiteVisitor {
    private SiteVisitCounter siteVisitCounter;
    private List<Thread> threadList = new ArrayList<>();
    private long startTime;
    private long endTime;


    public MultithreadingSiteVisitor(SiteVisitCounter siteVisitCounter) {
        this.siteVisitCounter = siteVisitCounter;
    }

    public void visitMultithread(int numOfThreads) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numOfThreads; i++) {
            Thread thread = new Thread(() -> siteVisitCounter.incrementVisitCount());
            threadList.add(thread);
            thread.start();
        }
    }

    public void waitUntilAllVisited() {
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Ожидающий поток был прерван другим потоком");
            }
        }
        endTime = System.currentTimeMillis();
    }

    public long getTotalTimeOfHandling() {
        return (endTime - startTime);
    }
}

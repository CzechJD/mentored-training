package com.example.multithrading1;

public class SynchronizedBlockCounter implements SiteVisitCounter {
    private int count;
    private final Object lock = new Object();
    @Override
    public void incrementVisitCount() {
        synchronized (lock) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
        }
    }

    @Override
    public int getVisitCount() {
        synchronized (lock) {
            return count;
        }
    }
}

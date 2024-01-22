package com.example.multithrading1;

public class SynchronizedBlockCounter implements SiteVisitCounter {
    private int count;
    private final Object object = new Object();
    @Override
    public void incrementVisitCount() {
        synchronized (object) {
            count++;
        }
    }

    @Override
    public int getVisitCount() {
        synchronized (object) {
            return count;
        }
    }
}

package com.example.multithrading1;

public class UnsynchronizedCounter implements SiteVisitCounter {
    private int count;
    @Override
    public void incrementVisitCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        count++;
    }

    @Override
    public int getVisitCount() {
        return count;
    }
}

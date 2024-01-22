package com.example.multithrading1;

public class VolatileCounter implements SiteVisitCounter {
    private volatile int count;
    @Override
    public void incrementVisitCount() {
        count++;
    }

    @Override
    public int getVisitCount() {
        return count;
    }
}

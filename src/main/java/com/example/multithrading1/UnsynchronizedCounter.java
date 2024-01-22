package com.example.multithrading1;

public class UnsynchronizedCounter implements SiteVisitCounter {
    private int count;
    @Override
    public void incrementVisitCount() {
        count++;
    }

    @Override
    public int getVisitCount() {
        return count;
    }
}

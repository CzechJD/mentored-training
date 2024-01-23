package com.example.multithrading1;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements SiteVisitCounter {
    AtomicInteger count = new AtomicInteger(0);

    @Override
    public void incrementVisitCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        count.incrementAndGet();
    }

    @Override
    public int getVisitCount() {
        return count.get();
    }
}

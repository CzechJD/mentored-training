package com.example.multithrading1;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements SiteVisitCounter {
    AtomicInteger count = new AtomicInteger(0);

    @Override
    public void incrementVisitCount() {
        count.incrementAndGet();
    }

    @Override
    public int getVisitCount() {
        return count.get();
    }
}

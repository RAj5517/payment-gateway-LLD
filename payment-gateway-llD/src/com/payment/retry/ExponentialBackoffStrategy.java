package com.payment.retry;

import java.util.function.Supplier;

public class ExponentialBackoffStrategy implements RetryStrategy {

    private final int maxRetries;

    public ExponentialBackoffStrategy(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    @Override
    public boolean execute(Supplier<Boolean> action) {

        long delay = 500;

        for (int i = 0; i < maxRetries; i++) {

            if (action.get()) return true;

            try {
                Thread.sleep(delay);
                delay *= 2;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return false;
    }
}

package com.payment.retry;

import java.util.function.Supplier;

public class LinearRetryStrategy implements RetryStrategy {

    private final int maxRetries;

    public LinearRetryStrategy(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    @Override
    public boolean execute(Supplier<Boolean> action) {
        for (int i = 0; i < maxRetries; i++) {
            if (action.get()) return true;
        }
        return false;
    }
}

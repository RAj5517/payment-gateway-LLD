package com.payment.retry;

import java.util.function.Supplier;

public interface RetryStrategy {
    boolean execute(Supplier<Boolean> action);
}

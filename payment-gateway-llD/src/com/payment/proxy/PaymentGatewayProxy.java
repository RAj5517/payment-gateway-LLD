package com.payment.proxy;

import com.payment.gateway.PaymentGateway;
import com.payment.model.PaymentRequest;
import com.payment.retry.RetryStrategy;

public class PaymentGatewayProxy extends PaymentGateway {

    private final PaymentGateway realGateway;
    private final RetryStrategy retryStrategy;

    public PaymentGatewayProxy(PaymentGateway realGateway,
                               RetryStrategy retryStrategy) {
        this.realGateway = realGateway;
        this.retryStrategy = retryStrategy;
    }

    @Override
    public boolean processPayment(PaymentRequest request) {
        return retryStrategy.execute(
                () -> realGateway.processPayment(request)
        );
    }

    @Override
    public boolean validate(PaymentRequest request) {
        return realGateway.validate(request);
    }

    @Override
    public boolean initiate(PaymentRequest request) {
        return realGateway.initiate(request);
    }

    @Override
    public boolean confirm(PaymentRequest request) {
        return realGateway.confirm(request);
    }
}

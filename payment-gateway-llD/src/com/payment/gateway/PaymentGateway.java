package com.payment.gateway;

import com.payment.model.PaymentRequest;

public abstract class PaymentGateway {

    public boolean processPayment(PaymentRequest request) {

        if (!validate(request)) return false;
        if (!initiate(request)) return false;
        if (!confirm(request)) return false;

        return true;
    }

    public abstract boolean validate(PaymentRequest request);
    public abstract boolean initiate(PaymentRequest request);
    public abstract boolean confirm(PaymentRequest request);
}

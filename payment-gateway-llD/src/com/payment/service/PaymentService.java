package com.payment.service;

import com.payment.gateway.PaymentGateway;
import com.payment.model.PaymentRequest;

public class PaymentService {

    private PaymentGateway gateway;

    public void setGateway(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public boolean processPayment(PaymentRequest request) {
        return gateway.processPayment(request);
    }
}

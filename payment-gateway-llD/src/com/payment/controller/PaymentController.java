package com.payment.controller;

import com.payment.factory.GatewayFactory;
import com.payment.factory.GatewayType;
import com.payment.model.PaymentRequest;
import com.payment.service.PaymentService;

public class PaymentController {

    private final PaymentService service = new PaymentService();

    public boolean handlePayment(GatewayType type, PaymentRequest request) {

        service.setGateway(GatewayFactory.createGateway(type));

        return service.processPayment(request);
    }
}

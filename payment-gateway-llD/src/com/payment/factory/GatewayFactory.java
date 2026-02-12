package com.payment.factory;

import com.payment.gateway.PaymentGateway;
import com.payment.gateway.impl.PaytmGateway;
import com.payment.gateway.impl.RazorpayGateway;
import com.payment.proxy.PaymentGatewayProxy;
import com.payment.retry.LinearRetryStrategy;

public class GatewayFactory {

    public static PaymentGateway createGateway(GatewayType type) {

        PaymentGateway realGateway;

        switch (type) {
            case PAYTM:
                realGateway = new PaytmGateway();
                break;
            case RAZORPAY:
                realGateway = new RazorpayGateway();
                break;
            default:
                throw new IllegalArgumentException("Unsupported gateway");
        }

        return new PaymentGatewayProxy(realGateway,
                new LinearRetryStrategy(3));
    }
}

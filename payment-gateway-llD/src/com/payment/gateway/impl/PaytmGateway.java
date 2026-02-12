package com.payment.gateway.impl;

import com.payment.bank.PaytmBankingSystem;
import com.payment.bank.BankingSystem;
import com.payment.gateway.PaymentGateway;
import com.payment.model.PaymentRequest;

public class PaytmGateway extends PaymentGateway {

    private final BankingSystem bankingSystem = new PaytmBankingSystem();

    @Override
    public boolean validate(PaymentRequest request) {
        return request.getAmount() > 0 && request.getCurrency().equals("INR");
    }

    @Override
    public boolean initiate(PaymentRequest request) {
        return bankingSystem.processPayment(request.getAmount());
    }

    @Override
    public boolean confirm(PaymentRequest request) {
        return true;
    }
}

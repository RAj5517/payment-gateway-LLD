package com.payment.gateway.impl;

import com.payment.bank.RazorpayBankingSystem;
import com.payment.bank.BankingSystem;
import com.payment.gateway.PaymentGateway;
import com.payment.model.PaymentRequest;

public class RazorpayGateway extends PaymentGateway {

    private final BankingSystem bankingSystem = new RazorpayBankingSystem();

    @Override
    public boolean validate(PaymentRequest request) {
        return request.getAmount() > 0;
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

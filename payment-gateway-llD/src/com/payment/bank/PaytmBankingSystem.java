package com.payment.bank;

import java.util.Random;

public class PaytmBankingSystem implements BankingSystem {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Paytm payment...");
        return new Random().nextInt(100) < 70; // 70% success
    }
}

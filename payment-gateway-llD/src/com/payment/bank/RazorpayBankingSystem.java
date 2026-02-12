package com.payment.bank;

import java.util.Random;

public class RazorpayBankingSystem implements BankingSystem {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Razorpay payment...");
        return new Random().nextInt(100) < 85; // 85% success
    }
}

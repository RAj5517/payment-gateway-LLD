package com.payment.model;

public class PaymentRequest {

    private String sender;
    private String receiver;
    private double amount;
    private String currency;

    public PaymentRequest(String sender, String receiver, double amount, String currency) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.currency = currency;
    }

    public String getSender() { return sender; }
    public String getReceiver() { return receiver; }
    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
}

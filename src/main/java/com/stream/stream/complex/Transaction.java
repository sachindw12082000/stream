package com.stream.stream.complex;

import java.time.LocalDate;

public class Transaction {
    private String transactionId;
    private double amount;
    private LocalDate date;

    public Transaction(String transactionId, double amount, LocalDate date) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    @Override
    public String toString() {
        return "Transaction{" +
               "transactionId='" + transactionId + '\'' +
               ", amount=" + amount +
               ", date=" + date +
               '}';
    }
}

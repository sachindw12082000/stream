package com.stream.stream.level3;

import java.time.LocalDate;

public class Transaction3 {
    private String transactionId;
    private String customerName;
    private double amount;
    private LocalDate date;

    public Transaction3() {
    }

    public Transaction3(String transactionId, String customerName, double amount, LocalDate date) {
        this.transactionId = transactionId;
        this.customerName = customerName;
        this.amount = amount;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}

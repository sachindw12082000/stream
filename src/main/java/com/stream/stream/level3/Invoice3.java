package com.stream.stream.level3;

import java.util.List;

public class Invoice3 {
    private int invoiceId;
    private String clientName;
    private double totalAmount;
    private List<String> items;

    public Invoice3() {
    }

    public Invoice3(int invoiceId, String clientName, double totalAmount, List<String> items) {
        this.invoiceId = invoiceId;
        this.clientName = clientName;
        this.totalAmount = totalAmount;
        this.items = items;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", clientName='" + clientName + '\'' +
                ", totalAmount=" + totalAmount +
                ", items=" + items +
                '}';
    }
}

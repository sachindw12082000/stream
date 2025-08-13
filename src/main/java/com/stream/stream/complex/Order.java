package com.stream.stream.complex;

import java.util.List;

public class Order {
    private String customerName;
    private List<String> productNames;

    public Order(String customerName, List<String> productNames) {
        this.customerName = customerName;
        this.productNames = productNames;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public List<String> getProductNames() { return productNames; }
    public void setProductNames(List<String> productNames) { this.productNames = productNames; }

    @Override
    public String toString() {
        return "Order{" +
               "customerName='" + customerName + '\'' +
               ", productNames=" + productNames +
               '}';
    }
}

package com.stream.stream.level3;

import java.util.List;

public class Order3 {
    private int orderId;
    private String customerName;
    private List<Product3> products;
    private String status;

    public Order3() {}

    public Order3(int orderId, String customerName, List<Product3> products, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.products = products;
        this.status = status;
    }

    // Getters and Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public List<Product3> getProducts() { return products; }
    public void setProducts(List<Product3> products) { this.products = products; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Order{" +
            "orderId=" + orderId +
            ", customerName='" + customerName + '\'' +
            ", products=" + products +
            ", status='" + status + '\'' +
            '}';
    }
}

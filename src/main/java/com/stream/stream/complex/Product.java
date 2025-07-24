package com.stream.stream.complex;

public class Product {
    private String name;
    private String category;
    private double revenue;

    public Product(String name, String category, double revenue) {
        this.name = name;
        this.category = category;
        this.revenue = revenue;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getRevenue() { return revenue; }
    public void setRevenue(double revenue) { this.revenue = revenue; }

    @Override
    public String toString() {
        return "Product{" +
               "name='" + name + '\'' +
               ", category='" + category + '\'' +
               ", revenue=" + revenue +
               '}';
    }
}

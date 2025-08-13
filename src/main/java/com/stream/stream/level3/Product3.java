package com.stream.stream.level3;

public class Product3 {
    private int id;
    private String name;
    private String category;
    private double price;
    private String manufacturer;

    public Product3() {}

    public Product3(int id, String name, String category, double price, String manufacturer) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", category='" + category + '\'' +
            ", price=" + price +
            ", manufacturer='" + manufacturer + '\'' +
            '}';
    }
}

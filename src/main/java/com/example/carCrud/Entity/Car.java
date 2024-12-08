package com.example.carCrud.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Car_Inventory")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable = false,name = "Car_brand")
    private String brand;
    @Column(name = "Price")
    private double price;
    @Column(name = "Car_Description")
    private String description;
    @Column(name = "year_of_make")
    private int year;
    @Column(name = "Model")
    private String model;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
       this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

package com.example.test_manager.entity;

import java.util.HashMap;

public class Phone {
    private int id;
    private String name;
    private int brand;
    private double price;
    private String description;

    public Phone(int id, String name, int brand, double price, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
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

    public Phone() {
        this.name = "";
        this.brand = 0;
        this.price = 0;
        this.description = "";
    }

    public Phone(String name, int brand, double price, String description) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand=" + brand +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
    public boolean isValid(){
        return getErrors().size()==0;
    }
    public HashMap<String,String> getErrors(){
        HashMap<String,String> errors = new HashMap<>();
        if(name ==null || name.length() ==0){
            errors.put("name","Vui lòng nhập tên");
        }
        if(description ==null||name.length()==0){
            errors.put("description","Vui lòng nhập mô tả");
        }
        if(price==0){
            errors.put("price","Vui lòng nhập giá tiền");
        }else if(price <0) {
            errors.put("price", "Giá tiền phải lớn hơn 0");
        }
        return errors;
    }
}


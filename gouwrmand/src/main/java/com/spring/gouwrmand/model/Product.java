package com.spring.gouwrmand.model;
import com.spring.gouwrmand.entity.FoodItem;

public class Product {
    private int food_id;
    private String food_type;
    private String food_name;
    private double food_price;
    private double food_discount;
    private String food_description;
    private int food_status;

    public Product(FoodItem foodItem) {
        this.food_id = foodItem.getFood_id();
        this.food_type = foodItem.getFood_type();
        this.food_name = foodItem.getFood_name();
        this.food_price = foodItem.getFood_price();
        this.food_discount = foodItem.getFood_discount();
        this.food_description = foodItem.getFood_description();
        this.food_status = foodItem.getFood_status();
    }

    public Product(int food_id, String food_type, String food_name, double food_price, double food_discount, String food_description, int food_status) {
        this.food_id = food_id;
        this.food_type = food_type;
        this.food_name = food_name;
        this.food_price = food_price;
        this.food_discount = food_discount;
        this.food_description = food_description;
        this.food_status = food_status;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public double getFood_price() {
        return food_price;
    }

    public void setFood_price(double food_price) {
        this.food_price = food_price;
    }

    public double getFood_discount() {
        return food_discount;
    }

    public void setFood_discount(double food_discount) {
        this.food_discount = food_discount;
    }

    public String getFood_description() {
        return food_description;
    }

    public void setFood_description(String food_description) {
        this.food_description = food_description;
    }

    public int getFood_status() {
        return food_status;
    }

    public void setFood_status(int food_status) {
        this.food_status = food_status;
    }
}

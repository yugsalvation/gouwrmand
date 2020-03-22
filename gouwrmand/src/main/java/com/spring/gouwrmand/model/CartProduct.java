package com.spring.gouwrmand.model;

public class CartProduct {
    private Product product;
    private int quantity;

    public CartProduct() {
        this.quantity = 0;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return this.product.getFood_price() * this.quantity;
    }
}

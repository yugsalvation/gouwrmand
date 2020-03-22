package com.spring.gouwrmand.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartProduct> cart = new ArrayList<CartProduct>();

    public Cart() {
    }

    public List<CartProduct> getCartProducts() {
        return this.cart;
    }

    private CartProduct findProductById(int id) {
        for (CartProduct product : this.cart) {
            if (product.getProduct().getFood_id()==id) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product, int quantity) {
        CartProduct productById = this.findProductById(product.getFood_id());

        if (productById == null) {
            productById = new CartProduct();
            productById.setQuantity(0);
            productById.setProduct(product);
            this.cart.add(productById);
        }
        int newQuantity = productById.getQuantity() + quantity;
        if (newQuantity <= 0) {
            this.cart.remove(productById);
        } else {
            productById.setQuantity(newQuantity);
        }
    }

    public void updateQuantity(Cart cart) {
        if (cart != null) {
            List<CartProduct> products = cart.getCartProducts();
            for (CartProduct product : products) {
                this.updateProduct(product.getProduct().getFood_id(), product.getQuantity());
            }
        }
    }

    public void updateProduct(int id, int quantity) {
        CartProduct product = this.findProductById(id);

        if (product != null) {
            if (quantity <= 0) {
                this.cart.remove(product);
            } else {
                product.setQuantity(quantity);
            }
        }
    }

    public void removeProduct(Product product) {
        CartProduct cartProduct = this.findProductById(product.getFood_id());
        if (cartProduct != null) {
            this.cart.remove(product);
        }
    }

    public boolean isEmpty() {
        return this.cart.isEmpty();
    }

    public int getQuantityTotal() {
        int quantity = 0;
        for (CartProduct product : this.cart) {
            quantity += product.getQuantity();
        }
        return quantity;
    }

    public double getAmountTotal() {
        double total = 0;
        for (CartProduct product : this.cart) {
            total += product.getAmount();
        }
        return total;
    }
}

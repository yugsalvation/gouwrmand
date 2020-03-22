package com.spring.gouwrmand.utils;

import javax.servlet.http.HttpServletRequest;
import com.spring.gouwrmand.model.Cart;

public class Utils {

    // Products in the cart, stored in Session.
    public static Cart getCartSession(HttpServletRequest request) {
        Cart cartInfo = (Cart) request.getSession().getAttribute("myCart");
        if (cartInfo == null) {
            cartInfo = new Cart();
            request.getSession().setAttribute("myCart", cartInfo);
        }
        return cartInfo;
    }

    public static void removeCartSession(HttpServletRequest request) {
        request.getSession().removeAttribute("myCart");
    }

}
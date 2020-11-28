package com.pleczycki.testing.cart;

import com.pleczycki.testing.order.OrderStatus;

class CartService {

    private CartHandler cartHandler;

    CartService(CartHandler cartHandler) {
        this.cartHandler = cartHandler;
    }

    Cart processCart(Cart cart) {
        if(cartHandler.canHandleCart(cart)) {
            cartHandler.sendToPrepare(cart);
            cart.getOrders().forEach(order -> order.changeOrderStatus(OrderStatus.PREPARING));
        } else {
            cart.getOrders().forEach(order -> order.changeOrderStatus(OrderStatus.REJECTED));
        }
        return cart;
    }
}

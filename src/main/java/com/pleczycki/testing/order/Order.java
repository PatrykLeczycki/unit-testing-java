package com.pleczycki.testing.order;

import com.pleczycki.testing.Meal;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private OrderStatus orderStatus;
    private List<Meal> meals = new ArrayList<>();

    void cancel() {
        this.meals.clear();
    }

    int totalPrice() {

        int sum = this.meals
                .stream()
                .mapToInt(Meal::getPrice)
                .sum();

        if (sum < 0) {
            throw new IllegalStateException("Price limit exceeded");
        }
        return sum;
    }

    public void changeOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void addMealToOrder(Meal meal) {
        this.meals.add(meal);
    }

    public void removeMealFromOder(Meal meal) {
        this.meals.remove(meal);
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "meals=" + meals +
                '}';
    }
}

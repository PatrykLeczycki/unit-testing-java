package com.pleczycki.testing.order;

import com.pleczycki.testing.Meal;
import com.pleczycki.testing.order.Order;
import com.pleczycki.testing.order.OrderBackup;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setUp() throws FileNotFoundException {
        System.out.println("setUp()");
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @Test
    void backupOrderWithOneMeal() throws IOException {
        //given
        Meal meal = new Meal(7, "Fries");
        Order order = new Order();
        order.addMealToOrder(meal);

        //when
        orderBackup.backupOrder(order);

        //then
        System.out.println("Order: " + order.toString() + " backed up.");
    }

    @AfterAll
    static void tearDown() throws IOException {
        System.out.println("tearDown()");
        orderBackup.closeFile();
    }
}
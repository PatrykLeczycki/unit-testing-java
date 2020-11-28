package com.pleczycki.testing.order;

import com.pleczycki.testing.order.Order;
import com.pleczycki.testing.order.OrderBackup;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderBackupExecutionOrderTest {

    @Test
    void callingBackupWithoutCreatingFileFirstShouldThrowException() {
        //given
        OrderBackup orderBackup = new OrderBackup();

        //when
        assertThrows(IOException.class, () -> orderBackup.backupOrder(new Order()));
    }
}

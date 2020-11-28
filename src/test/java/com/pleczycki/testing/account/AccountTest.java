package com.pleczycki.testing.account;

import com.pleczycki.testing.account.Account;
import com.pleczycki.testing.account.Address;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AccountTest {

//    @Test
//    void newlyCreatedAccountShouldNotBeActive() {
//        // given + when
//        Account newAccount = new Account();
//
//        // then
//        assertFalse(newAccount.isActive());
//        assertThat(newAccount.isActive()).isFalse();
//    }

    @Test
    void activatedAccountShouldHaveActiveFlagSet() {
        // given
        Account newAccount = new Account();

        // when
        newAccount.activate();

        // then
        assertTrue(newAccount.isActive());
    }

//    @Test
//    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {
//        //given
//        Account account = new Account();
//
//        //when
//        Address address = account.getDefaultDeliveryAddress();
//
//        //then
//        assertNull(address);
//        assertThat(address).isNull();
//    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {
        //given
        Address address = new Address("Krakowska", "67c");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);

        //when
        Address defaultDeliveryAddress = account.getDefaultDeliveryAddress();

        //then
        assertNotNull(defaultDeliveryAddress);
    }

    @RepeatedTest(3)
    void newAccountWithNotNullAddressShouldBeActive() {
        System.out.println("start");
        //given
        Address address = new Address("Puławska", "46/6");

        //when
        Account account = new Account(address);

        //then
        assumingThat(address != null, () -> {
            assertTrue(account.isActive());
        });
    }

    @Test
    void invalidEmailShouldThrowException() {

        //given
        Account account = new Account();

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> account.setEmail("wrongEmail"));
    }

    @Test
    void validEmailShouldBeSet() {
        //given
        Account account = new Account();

        //when
        account.setEmail("patryk.leczycki1@gmail.com");

        //then
        assertThat(account.getEmail(), is("patryk.leczycki1@gmail.com"));
    }
}

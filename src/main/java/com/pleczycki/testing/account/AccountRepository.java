package com.pleczycki.testing.account;

import java.util.List;

public interface AccountRepository {
    List<Account> getAllAccounts();
    List<String> getByName(String string);
}
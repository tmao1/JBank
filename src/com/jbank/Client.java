package com.jbank;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by localadmin on 7/28/16.
 */
public class Client {
    private String id;
    private String name;
    private boolean isActive;
    private ArrayList<Account> accounts;

    public Client(String name) {
        this.name = name;
        this.isActive = true;
        this.accounts = new ArrayList<>();
        this.id = String.valueOf(UUID.randomUUID());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void openAccount(AccountType type) throws Exception
    {
        this.accounts.add(new Account(type));
    }

    public void closeAccount(String id) throws Exception
    {
        if (!this.accounts.isEmpty()) {
            Account[] acct = this.accounts.stream()
                    .filter(account -> account.getId() == id)
                    .toArray(Account[]::new);
            if (acct.length > 0 ) {
                acct[0].setBalance(0f);
                acct[0].setClosed();
            }
        }

    }

}

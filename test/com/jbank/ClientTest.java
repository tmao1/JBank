package com.jbank;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 7/28/16.
 */
public class ClientTest {

    Client client;

    @Before
    public void setUp() throws Exception {
        client = new Client("first client");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConstructorwithName() throws Exception {

        Client c = new Client("first client");
        assertNotNull(c.getId());
        assertEquals(c.getName(), "first client");
        assertEquals(0, c.getAccounts().size());
        assertEquals(true, c.isActive());
    }

    @Test
    public void testOpenAccount() throws Exception {
        Client c = new Client("first client");
        c.openAccount(AccountType.CHECKING);
        assertEquals(AccountType.CHECKING, c.getAccounts().get(0).getType());
    }

    @Test
    public void testCloseAccount() throws Exception {
        client.openAccount(AccountType.CHECKING);
        client.closeAccount(client.getAccounts().get(0).getId());
        assertEquals(1, client.getAccounts().size());
        assertEquals(true, client.getAccounts().get(0).isClosed());
    }

    @Test
    public void testCloseAccountClearsBalance() throws Exception {
        client.openAccount(AccountType.CHECKING);
        client.openAccount(AccountType.SAVING);
        client.getAccounts().get(1).Deposit(100f);

        client.closeAccount(client.getAccounts().get(1).getId());
        assertEquals(0, client.getAccounts().get(1).getBalance(), 0);
        assertEquals(true, client.getAccounts().get(1).isClosed());
    }

    @Test
    public void testCloseAccountWhenNoAccountsExist() throws Exception {
        client.closeAccount("acctId");
    }

    @Test
    public void testCloseAccountWhenAccountsDoesNotExist() throws Exception {
        client.openAccount(AccountType.CHECKING);
        client.closeAccount("acctId");
    }



}
package com.jbank;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 7/28/16.
 */
public class TransactionTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConstructorwithAmountAndType() throws Exception {

        Transaction t = new Transaction(50f, TransactionType.DEPOSIT);
        assertNotNull(t.getId());
        assertNotNull(t.getDate());
        assertEquals(50f, t.getAmount(), 0);
        assertEquals(TransactionType.DEPOSIT, t.getType());

    }

    @Test
    public void testsetAmount() throws Exception {
        Transaction t = new Transaction(50f, TransactionType.DEPOSIT);
        assertEquals(50f, t.getAmount(), 0);

        t.setAmount(100f);
        assertEquals(100f, t.getAmount(), 0);

    }

    @Test
    public void testsetType() throws Exception {
        Transaction t = new Transaction(50f, TransactionType.DEPOSIT);
        assertEquals(TransactionType.DEPOSIT, t.getType());

        t.setType(TransactionType.PAYMENT);
        assertEquals(TransactionType.PAYMENT, t.getType());

    }

    @Test
    public void testtoString() throws Exception {
        Transaction t = new Transaction(50f, TransactionType.DEPOSIT);
        assertThat(t.toString(), containsString("DEPOSIT 50.0"));

    }
}
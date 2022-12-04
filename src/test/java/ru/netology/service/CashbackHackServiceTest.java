package ru.netology.service;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CashbackHackServiceTest {
    private CashbackHackService service;
    @BeforeMethod
    public void setUp() {
        service = new CashbackHackService();
    }

    // <editor-fold desc="One less">
    @Test
    public void testNegative() {
        assertThrows(() -> service.remain(-1));
    }

    @Test
    public void testOneLessBoundarySize() {
        int actual = service.remain(999);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void testOneLessMultipleBoundarySize() {
        int actual = service.remain(9999);
        int expected = 1;
        assertEquals(actual, expected);
    }
    // </editor-fold>

    // <editor-fold desc="Multiple of boundary size">
    @Test
    public void testZero() {
        int actual = service.remain(0);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void testBoundarySize() {
        int actual = service.remain(1000);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void testMultipleBoundarySize() {
        int actual = service.remain(11000);
        int expected = 0;
        assertEquals(actual, expected);
    }
    // </editor-fold>

    // <editor-fold desc="One more">
    @Test
    public void testOne() {
        int actual = service.remain(1);
        int expected = 999;
        assertEquals(actual, expected);
    }

    @Test
    public void testOneMoreBoundarySize() {
        int actual = service.remain(1001);
        int expected = 999;
        assertEquals(actual, expected);
    }

    @Test
    public void testOneMoreMultipleBoundarySize() {
        int actual = service.remain(15001);
        int expected = 999;
        assertEquals(actual, expected);
    }
    // </editor-fold>

    // <editor-fold desc="Between">
    @Test
    public void test500() {
        int actual = service.remain(500);
        int expected = 500;
        assertEquals(actual, expected);
    }

    @Test
    public void test14321() {
        int actual = service.remain(4321);
        int expected = 679;
        assertEquals(actual, expected);
    }
    // </editor-fold>
}
package ru.netology.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CashbackHackServiceTest {
    private CashbackHackService service;

    @Before
    public void setUp() {
        service = new CashbackHackService();
    }

    // <editor-fold desc="One less">
    @Test
    public void testNegative() {
        assertThrows(Exception.class, () -> service.remain(-1));
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
        // Так как метод должен вводить остаток до минимальной суммы на которую полностью будет начислен кэшбэк,
        // а при нулевом вводе ничего не будет потрачено и никакого кэшбэка не будет начислено,
        // то несмотря на то, что формально 0 кратен 1000, ответ 0 не подходит, потому что не вызовет начисления кэшбэка.
        // Следующий кратный 1000 ответ после 0 будет 1000.
        int expected = 1000;
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
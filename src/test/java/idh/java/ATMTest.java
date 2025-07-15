package idh.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ATMTest {

    ATM atm;

    @BeforeEach
    void setUp() {
        atm = new ATM();
    }

    @Test
    void testNormalAmount_85() throws Exception {
        int[] expected = {0, 0, 0, 1, 1, 1, 1}; // 50+20+10+5
        assertArrayEquals(expected, atm.convertToBills(85));
    }

    @Test
    void testLargeAmount() throws Exception {
        int[] expected = {2, 1, 1, 1, 1, 1, 1}; // 1385 = 2x500 + ...
        assertArrayEquals(expected, atm.convertToBills(1385));
    }

    @Test
    void testZeroAmount() throws Exception {
        int[] expected = {0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, atm.convertToBills(0));
    }

    @Test
    void testNegativeAmount() throws Exception {
        int[] expected = {0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, atm.convertToBills(-20));
    }

    @Test
    void testNotDivisibleBy5() {
        assertThrows(ATM.IllegalInputException.class, () -> {
            atm.convertToBills(123);
        });
    }

    @Test
    void testMinValidAmount() throws Exception {
        int[] expected = {0, 0, 0, 0, 0, 0, 1}; // 5
        assertArrayEquals(expected, atm.convertToBills(5));
    }

    @Test
    void testOnlyBiggestBill() throws Exception {
        int[] expected = {1, 0, 0, 0, 0, 0, 0}; // 500
        assertArrayEquals(expected, atm.convertToBills(500));
    }
}

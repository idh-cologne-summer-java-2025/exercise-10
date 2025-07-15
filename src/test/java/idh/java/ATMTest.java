package idh.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class ATMTest {

    private ATM atm;

    @BeforeEach
    public void setUp() {
        atm = new ATM(); // Create a new ATM instance before each test
    }

    @Test
    public void testConvertToBills_ValidAmount() throws ATM.IllegalInputException {
        int[] expected = new int[] {0, 0, 1, 1, 0, 0, 1}; // Expected: 100 + 50 + 5 = 155
        int[] actual = atm.convertToBills(155);          // Actual: Call the method with input 155
        assertArrayEquals(expected, actual);             // Check if actual result matches expected
    }

    @Test
    public void testConvertToBills_MinimumValid() throws ATM.IllegalInputException {
        int[] expected = new int[] {0, 0, 0, 0, 0, 0, 1}; // Expected: 5 can only be made with one 5-bill
        int[] actual = atm.convertToBills(5);            // Input is 5
        assertArrayEquals(expected, actual);             
    }

    @Test
    public void testConvertToBills_LargeAmount() throws ATM.IllegalInputException {
        int[] expected = new int[] {3, 1, 1, 1, 1, 1, 1};  // Expected: 3x500, 1x200, 1x100, 1xx50, 1x20, 1x10, 1x5
        int[] actual = atm.convertToBills(1885);        // Call method with 1885
        assertArrayEquals(expected, actual);              // Should return minimal number of bills
    }

    @Test
    public void testConvertToBills_NegativeAmount() throws ATM.IllegalInputException {
        int[] expected = new int[] {0, 0, 0, 0, 0, 0, 0}; // Expected: negative input returns only zeroes
        int[] actual = atm.convertToBills(-50);           
        assertArrayEquals(expected, actual);              // Should return all zero bills
    }

    @Test
    public void testConvertToBills_InvalidNotDivisibleByFive() {
        assertThrows(ATM.IllegalInputException.class, () -> {
            atm.convertToBills(123); // 123 is not divisible by 5, should throw exception
        });
    }

}
package idh.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ATMTest {

    private ATM atm;

    @BeforeEach
    public void setUp() {
        atm = new ATM(); // Create a new ATM instance before each test
    }
    
    @Test
    public void testConvertToBills_ValidAmount() throws ATM.IllegalInputException {
        int[] expect = new int[] {1, 0, 0, 1, 0, 0, 1};
        int[] actual = atm.convertToBills(500+50+5);          
        assertArrayEquals(expect, actual);
    }

    @Test
    public void testConvertToBills_MinAmount() throws ATM.IllegalInputException {
        int[] expect = new int[] {0, 0, 0, 0, 0, 0, 1}; // 5 is the minimum bill
        int[] actual = atm.convertToBills(5);
        assertArrayEquals(expect, actual);             
    }

    @Test
    public void testConvertToBills_LargeAmount() throws ATM.IllegalInputException {
        int[] expect = new int[] {1, 1, 1, 1, 1, 1, 1};
        int[] actual = atm.convertToBills(500+200+100+50+20+10+5);
        assertArrayEquals(expect, actual);
    }

    @Test
    public void testConvertToBills_NegativeAmount() throws ATM.IllegalInputException {
        int[] expect = new int[] {0, 0, 0, 0, 0, 0, 0}; // negative input returns nought
        int[] actual = atm.convertToBills(-1);           
        assertArrayEquals(expect, actual);
    }

    @Test
    public void testConvertToBills_IllegalAmount() {
        assertThrows(ATM.IllegalInputException.class, () -> {
            atm.convertToBills(9); // exception since amount not divisible by 5
        });
    }

}
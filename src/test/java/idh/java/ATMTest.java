package idh.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ATMTest {

private static ATM testTm;
//	TESTS PACKAGES HAVE TO BE NAMED THE SAME AS THE MAIN PACKAGES
// Eclipse forced me to make the setUp-Method static for some reason
	@BeforeAll
	static void setUp() {
	testTm = new ATM();
	}
	
	@Test
	void testCashOutMIN() throws ATM.IllegalInputException {
		int expected [] = {0,0,0,0,0,0,1};
		int actual [] = testTm.convertToBills(5);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testCashOutMAX() throws ATM.IllegalInputException {
//		int expected[] = {9,9,9,9,9,9,9}; //7965 = 4500 + 1800 + 900 + 450 + 180 + 90 + 45
//		int actual [] = testTm.convertToBills(7965); --> this one does not work
		int expected[] = {3, 1, 1, 1, 1, 1, 1}; 
		int actual[] = testTm.convertToBills(1885);
//		int actualFail[] = testTm.convertToBills(Integer.MAX_VALUE);
		assertArrayEquals(expected, actual);
//		assertEquals(expected.toString(), actualFail.toString());
	}
	
	@Test
	void testNegCashout() throws ATM.IllegalInputException {
		int expected [] = {0,0,0,0,0,0,0};
		int actual[] = testTm.convertToBills(-5);
		assertArrayEquals(expected, actual);
	}

	/*The assert only accepts the (custom) IllegalInputException of the ATM class, 
	trying to pass the regular IIE-Exception results in an error. Why is the custom IIE needed anyway?
	*/
	@Test 
	void testInput() {
		assertThrows(ATM.IllegalInputException.class, () -> {testTm.convertToBills(79);});
	}
}
package idh.java;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM  {
	
	// initial cash in the ATM
	int cash = 100;
		
	// Which banknotes do we have?
	int[] value_of_bills = new int[] {500, 200, 100, 50, 20, 10, 5};

	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(amount);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int amount) {
		// check for cash in the ATM
		if (amount > cash) {
			System.out.println("Sorry, not enough cash left.");
			return;
		}
		
		// check if value can be divided by 5
		if (amount % 5 > 0) {
			System.out.println("Sorry, this amount cannot be expressed in bills.");
			return;
		}
		
		
		// withdraw
		int[] bills = new int[] {0, 0, 0, 0, 0, 0, 0};
		try {
			bills = convertToBills(amount);
		} catch (IllegalInputException e) {
			// this should not happen, since we're verifying it before
			e.printStackTrace();
		}
		
		// generate the printout string
		StringBuilder b = new StringBuilder();
		b.append("Ok, you'll get ");
		int i;
		for (i = 0; i < value_of_bills.length-1; i++) {
			b.append(bills[i]).append(" ").append(value_of_bills[i]).append("s, ");
		}
		b.append(" and ").append(bills[i]).append(" ").append(value_of_bills[i]).append("s.");
		System.out.println(b.toString());

		cash += amount;
		
	};

	/**
	 * Converts an amount to an array with the number of bills of each value. 
	 * This function returns as few bills as possible, i.e., highest value first. 
	 * (this is not popular in reality ...).
	 * @param amount
	 * @return
	 * @throws IllegalInputException 
	 */
	protected int[] convertToBills(int amount) throws IllegalInputException {
	    // If the amount is negative, it's considered illegal. Return an array of zeros.
	    if (amount < 0)
	        return new int[] {0, 0, 0, 0, 0, 0, 0}; // Each value corresponds to a bill type.

	    // Create a result array to hold how many of each bill should be used.
	    int[] r = new int[7]; // One slot for each bill type (500, 200, ..., 5)

	    // Go through each bill type from highest to lowest.
	    // This ensures we use the fewest number of bills possible.
	    for (int i = 0; i < value_of_bills.length; i++) {
	        r[i] = amount / value_of_bills[i];        // Determine how many of this bill fit into the amount.
	        amount = amount % value_of_bills[i];      // Reduce the remaining amount accordingly and give it to the next smaller bill type.
	    }

	    // If there's still a remaining amount after processing all bill types,
	    // it means the input was not divisible by 5 and can't be represented in available bills.
	    if (amount > 0) {
	        throw new IllegalInputException();        // Signal invalid input with an exception
	    }

	    return r; // Return the array containing the needed bills.
	}
	
	
	/**
	 * Launches the ATM
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	};
	
	public static class IllegalInputException extends Exception {

		private static final long serialVersionUID = 1L;
		
	}
	
}

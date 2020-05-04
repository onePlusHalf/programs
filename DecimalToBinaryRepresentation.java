// Below programs implements one of the ways to find Binary,(0's and 1's) , representation of a given Decimal Number.

import java.util.Scanner;
import java.lang.StringBuilder;

public class DecimalToBinaryRepresentation {
	private static String getBinaryFromDecimal(Integer decimalNumber){
		int index = 0;
		// Because of how java handles Strings, using String here is not such a great idea.
		String binaryRepresentation = "";
		
		while(decimalNumber > 0){
			binaryRepresentation = binaryRepresentation.concat(Integer.toString(decimalNumber%2));
			decimalNumber = decimalNumber/2;
		}
		
		return new StringBuilder(binaryRepresentation).reverse().toString();
	}
	
	public static void main(String args[]) {
		// Below line lets user give input from standard input stream
		 Scanner S = new Scanner(System.in);
		 Integer decimalNumber = S.nextInt();
		// Integer decimalNumber = 123;
		
		String binaryRepresentation = getBinaryFromDecimal(decimalNumber);
		
		System.out.println("Binary representation of "+ decimalNumber + " is : "+ binaryRepresentation);
		
	}
	
	
}
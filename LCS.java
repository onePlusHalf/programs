// Longest Common Subsequence in 2 strings
// Brute Force approach is used in this program

import java.util.*;

public class LCS{
	private static int max(int a, int b){
		return a > b ? a : b;
	}
	
	private static int findLCS(String string1, String string2, int lengthString1, int lengthString2){
		if(lengthString1 == 0 || lengthString2 == 0)
			return 0;
		
		if(string1.charAt(lengthString1-1) == string2.charAt(lengthString2-1) && lengthString1 != lengthString2)
			return 1+findLCS(string1,string2, lengthString1-1,lengthString2-1);
		else
			return max(findLCS(string1, string2, lengthString1,lengthString2-1), findLCS(string1, string2, lengthString1-1,lengthString2));
	}
	
	public static void main(String args[]){
		Scanner S = new Scanner(System.in);
		
		System.out.println("Please Enter String 1 : ");
		String string1 = S.nextLine();
		int lengthString1 = string1.length();
		
		System.out.println("Please Enter String 2 : ");
		String string2 = S.nextLine();
		int lengthString2 = string2.length();
		
		
		System.out.println("LCS of string "+ string1 +" and "+string2 +" is : "+findLCS(string1, string2, lengthString1, lengthString2));
	}
}

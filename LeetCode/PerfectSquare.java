// Valid Perfect Square - https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/
// Given a positive integer `num` , check whether it is a perfect square
// Input: num = 16
// Solution : Like binary search , keep on dividing till square is greater than `num` than increment and check square
// Runtime : 0ms

import java.util.*;
class PerfectSquare {
    static boolean isPerfectSquare(int num) {
        int i = num;
        while((double)i*i > (double)num){
             i = i/2;             
        }
          
        for(int j = i;j<i*2;j++){
            if(j*j == num)
                return true;
        }
        return false;   
    }
	
	public static void main(String args[]){
		Scanner S = new Scanner(System.in);
		System.out.println("Enter number : ");
		int num = S.nextInt();
		
		if(isPerfectSquare(num))
			System.out.println(num + " is a perfect Square");
		else
			System.out.println(num + " is not a perfect Square");
		
	}
	
}


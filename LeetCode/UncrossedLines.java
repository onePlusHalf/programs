// Write Integers of A and B on two separate lines
// We can draw connecting lines such that
// 	- A[i] == B[j]
//  - No other line is intersecting it
// Example 1 : 
	// A = [1 , 4 , 2] 
	//      |     / 
	// B = [1 , 2 , 4]
// Solution : Idea is to find LCS between the 2 given arrays.Recursive approach times out , DP based solution works.

import java.util.*;

class Solution {
    private int max(int a, int b){
        return a > b ? a : b; 
    }
        
    private int findLCS(int[] A, int[] B, int indexA, int indexB){
        int[][] memoized =new int[indexA+1][indexB+1];
        
        for(int i = 0;i<=indexA;i++){
           for(int j = 0;j<=indexB;j++){
               if(i == 0 || j == 0)
                   memoized[i][j] = 0;
               else if(A[i-1] == B[j-1])
                   memoized[i][j] = 1 + memoized[i-1][j-1];
               else
                   memoized[i][j] = max(memoized[i][j-1], memoized[i-1][j]);
            
            } 
        }
    
        
        return memoized[indexA][indexB];
        
    }
    
    public int maxUncrossedLines(int[] A, int[] B) {
        return findLCS(A, B, A.length, B.length);
    }
}

public class UncrossedLines {
	public static void main(String args[]){
		Scanner S = new Scanner(System.in);
		System.out.print("Please enter length of first Line :");
		int M = S.nextInt();
		int[] m = new int[M];
		System.out.print("");
		for(int i = 0;i<M;i++){
			System.out.print("Please enter " + i +"th value : ");
			int mi = S.nextInt();
			m[i] = mi;
		}
		System.out.print("Please enter length of Second Line :");
		int N = S.nextInt();
		System.out.print("");
		int[] n = new int[N];
		for(int i = 0;i<N;i++){
			System.out.print("Please enter " + i +"th value : ");
			int ni = S.nextInt();
			n[i] = ni;
		}
		
		Solution solution = new Solution();
		System.out.println( "Max uncrossed Lines for given Points are : " + solution.maxUncrossedLines(m, n));
		
	}
}
// Check if it a straight line.
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
// Given an array of coordinates, check if they form a straight line.

// Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]

// Solution : The idea is to calculate angle between consecutive points and horizontal plane and compare all the points.

import java.lang.*;
import java.util.*;
import java.text.DecimalFormat;

public class StraightLine {
	static boolean checkStraightLine(int[][] coordinates) {
		double angle = 0;
		for(int i = 0;i<coordinates.length-1;i++){
			int x1 = coordinates[i][0];
			int y1 = coordinates[i][1];
			
			int x2 = coordinates[i+1][0];
			int y2 = coordinates[i+1][1];
			
			int x3 = x2;
			int y3 = y1;
			
			double height =Math.sqrt((y3 - y2)*(y3 - y2) + (x3 - x2)*(x3 - x2));
			double base = Math.sqrt((y1 - y2)*(y1 - y2) + (x1 - x2)*(x1 - x2));
			double angle1 = 180.0 / Math.PI * Math.atan2(height, base);
			
			
			DecimalFormat df = new DecimalFormat("##.######");
	
			if(i == 0)
				angle = angle1;
			else if(!df.format(angle1).equals(df.format(angle)))
				return false;
			
		}
		return true;
	}
	
	public static void main(String args[]){
		Integer numOfCoordinates;
		System.out.println("How many points are going to be there ?");
		Scanner S = new Scanner(System.in);
		numOfCoordinates = S.nextInt();
		
		int[][] coordinates = new int[numOfCoordinates][2];
		
		for(int i = 0;i< numOfCoordinates;i++){
			System.out.println("Enter X coordinate for point number " + (i+1) +" : ");
			int x = S.nextInt();
			
			coordinates[i][0] = x;
			
			System.out.println("Enter Y coordinate for point number " + (i+1) +" : ");
			int y = S.nextInt();
			
			coordinates[i][1] = y;
		}
		
		if(checkStraightLine(coordinates))
			System.out.println("Given points form a straight line.");
		else 
			System.out.println("Given points does not form a straight line.");
		
	}
	
}

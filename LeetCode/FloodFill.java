// Given an image represented by a 2-D Array of Integers.
// Each integer representing a Pixel value from 0 to 65535
// Flood Fill the image with given COLOR and Starting Point
// Flood Fill : Change only pixels which are 4 Directionally connected to current Pixel and have same color

class Solution {
    int[][] recolorImage(int[][] image, int[][] newImage, int[][] visited, int sr, int sc, int newColor){
        
        visited[sr][sc] = 1;
       
        if(sc > 0 && visited[sr][sc-1] == 0 && image[sr][sc] == image[sr][sc-1]){
           newImage = recolorImage(image,newImage, visited, sr, sc-1, newColor);
        }
        
        if(sr < image.length-1 && visited[sr+1][sc] == 0  && image[sr][sc] == image[sr+1][sc]){
           newImage = recolorImage(image,newImage, visited, sr+1, sc, newColor);
        }
        
        if(sr > 0 && visited[sr-1][sc] == 0  && image[sr][sc] == image[sr-1][sc]){
           newImage = recolorImage(image,newImage, visited, sr-1, sc, newColor);
        }
        
        if(sc < image[0].length-1 && visited[sr][sc+1] == 0  && image[sr][sc] == image[sr][sc+1]){
           newImage = recolorImage(image,newImage, visited, sr, sc+1, newColor);
        }
        newImage[sr][sc] = newColor;
        return newImage;
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] visited = new int[image.length][image[0].length];
        int[][] newImage = image;
        
        newImage = recolorImage(image,newImage, visited, sr, sc, newColor);
        
        return newImage;        
    }
}

 public class FloodFill{
	 private static void printImage(int[][] image){
		 for(int[] row: image){
			 for(int value: row){
				 System.out.print(value + " ");
			 }
			 System.out.println();
		 }
	 }
	 
	 public static void main(String args[]){
		 int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		 System.out.println("Current Image : ");
		 printImage(image);
		 
		 int startRow = 1;
		 int startCol = 1;
		 int newColor = 2;
		 System.out.println();

		 int[][] newImage = new Solution().floodFill(image, startRow, startCol, newColor);
 		 System.out.println("New Image : ");

		 printImage(newImage);
		 
		 
	 }
 }
//Single Element in a Sorted Array

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int size = nums.length;
        int start = 0;
        int end = size-1;
        if(size == 1)
            return nums[0];
        while(size>1){
            if(start == end)
                return nums[start];
          
            if(end - start == 1){
                if(start % 2 == 1)
                    return nums[start] == nums[start - 1] ? nums[end] : nums[start];
                else
                    return nums[start];
            }
            int currentIndex = (end+start)/2-1;
            if(currentIndex%2 == 0){
                if(nums[currentIndex] != nums[currentIndex+1]){
                     if(currentIndex == start)
                        return nums[currentIndex];
                    if(nums[currentIndex] != nums[currentIndex-1])
                        return nums[currentIndex];
                   
                     end = currentIndex - 1;
                     size = end - start + 1;
                } else {
                    start = currentIndex + 1;
                    size = end - start + 1;
                }
            } 
        else {
                if(nums[currentIndex] != nums[currentIndex-1]){
                     end = currentIndex - 1;
                     size = end - start + 1;
                } 
            else {
                    start = currentIndex + 1;
                    size = end - start + 1;
                }
             }
            
             if(start == end)
                return nums[start];
            
        } 
        
        return 0;
    }
}

 public class SingleElementInSortedArray{
	 public static void main(String args[]){
		 int[] nums = new int[]{1,1,2,2,3,4,4,5,5};
			
		 System.out.println("Single Element in given array is : " + new Solution().singleNonDuplicate(nums));
	 }
 }
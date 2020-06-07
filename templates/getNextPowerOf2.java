// Given an interger Value and you want to get the next power of 2 greater than or equal to number
// Input: the number for which you want to find the next power of 2
// Output: Next power of 2 greater than or equal to given number

	int getNextPowerOf2(int input){
		int count = 0;
		boolean isPowerOf2 = true;
		while(input>1){
			if(input%2 == 1)
				isNotPowerOf2 = false;
			input = input/2;
			count++;
		}
		
		return (int)Math.pow(2, count+1);
	}
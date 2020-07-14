// Problem statement : Paint Room wall in 3 colors , Red, White and Blue ,with following conditions : 
// 1: The wall must be painted only in strips of red, blue and white colour.
// 2:Strips of the same color cannot be placed next to each other.
// 3:A blue strip must always be placed between a white and a red or between a red and a white one.

// Solution : I started with finding a pattern, and i saw that for 
// - 1 Stripe, answer is 2
// - 2 Stripe, answer is 2
// - 3 Stripe, answer is 4
// - 4 Stripe, answer is 6

// So, answer lies in pattern which as, value[i] = value[i-1] + value[i-2] ,and i prestored the values in an array to save time.

//import for Scanner and other utility classes

import java.util.*;

public class RoomWallPainting {

    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        Integer T = s.nextInt();                
        Integer[] values = new Integer[100];
        values[0] = 2;
        values[1] = 2;
        for(int i = 2;i<100;i++){
            values[i] = (values[i-1] + values[i-2])%1000000007;
        }
        while(T > 0){
            Integer N = s.nextInt();
            System.out.println(values[N-1]);
            T--;
        }
    }
}
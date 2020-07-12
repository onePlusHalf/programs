// Task : 
// 	- deletes all the vowels,
//	- inserts a character "." before each consonant,
//	- replaces all uppercase consonants with corresponding lowercase ones.
// Note : Vowels are letters "A", "O", "Y", "E", "U", "I", and the rest are consonants.


import java.util.*;
import java.util.Arrays;
import java.util.List;

class DeleteReplaceConvertString {
 
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        Integer T = s.nextInt(); 
        String[] vowels = {"A", "O", "Y", "E", "U", "I", "a", "o", "y", "e", "u", "i"};
        List<String> vowels2 = Arrays.asList(vowels);
        String dummy = s.nextLine();
        while(T > 0){
            String input = s.nextLine();
            String output = "";
            int j = 0;
            for(int i = 0;i<input.length();i++){
                if(!vowels2.contains(Character.toString(input.charAt(i)))){
                    output += ".";
                    j++;
                    if(input.charAt(i) < 'a') {
                         output += (char)(input.charAt(i) + ' ');
                    } else 
                        output += input.charAt(i);
                    
                    j++;
                } else {

                }
            }
            System.out.println(output);
            T--;

        }               
    }
}

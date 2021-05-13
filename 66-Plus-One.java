public class Solution {
    public int[] plusOne(int[] digits) {
       
    if(digits==null||digits.length==0)
        return new int[0];
 
    int carry = 1;    
    for(int i=digits.length-1; i>=0; i--){
         if(digits[i] < 9) {
             digits[i]++;
             return digits;
         }
         else {
             digits[i] = 0;
         }
    }
         /* It will reach here when the digits array will be all 9's */
         /* All the values will be initialised as 0 in java or specifically make them 0*/
         int[] all_nine = new int[digits.length + 1];
         all_nine[0] = 1;
         
         return all_nine;
         
         
    }
 
   
}

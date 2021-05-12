public class Solution
{public int romanToInt(String s) {
    if(s == null){
        return 0;
    }
    // Let's dry run with LIV
    int length = s.length(); //3
    int sum = 0;
    int pre = 0;
    
    for(int i = length - 1; i >= 0; i--){
        int cur = romanTable(s.charAt(i)); // cur = 5 in first iteration, cur = 1 in second iteration
        
        if(i == length - 1){ // if last character
            sum = sum + cur;// sum = 5
           
        }else{
           if(cur < pre){
               sum = sum - cur; // sum = 4 in second iteration
           }else{
               sum = sum + cur; // sum = 54 in third iteration
           }
        }
        pre = cur; // pre = 5 in first iteration, pre = 4 in second iteration
        
    }
    
    return sum;
}
 
 // We always store the current value in pre and check everytime if cur < pre because if the pre is 
//greater than next curr, then instead of adding, we subtract
public int romanTable(char c){
    int num = 0;
    switch(c){
        case 'I':
            num = 1;
            break;
        case 'V':
            num = 5;
            break;
         case 'X':
            num = 10;
            break;
         case 'L':
             num = 50;
             break;
         case 'C':
             num = 100;
             break;
         case 'D':
             num = 500;
             break;
         case 'M':
             num = 1000;
             break;
         default:
             num = 0;
             break;
    }
    return num;
}
}

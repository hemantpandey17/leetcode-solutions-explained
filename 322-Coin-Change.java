public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int res=0;
        int[] dp = new int[amount+1]; 
        dp[0] = 0;
        int sum=1;
       
        while(sum<=amount) {
            int min = -1;
            for(int coin:coins) {
                if(sum >= coin && dp[sum-coin]!=-1) {
                    int temp = dp[sum - coin] + 1;
                    if(min < 0) // only when sum is not formed by any of coins
                        min = temp;
                    else
                        min = Math.min(temp,min); // min coins needed out of given coins
                }
            }
            dp[sum] = min;
           // System.out.println(Arrays.toString(dp));
            sum++;
        }
        
        return dp[amount];
        
        // If not given in sorted order
        // for(int i=coins.length-1;i>=0 && amount!=0 ;i--) {
        //     res += amount/coins[i];
        //     amount = amount%coins[i];
        // }
        // if(amount==0)
        //     return res;
        // else
        //     return -1;
    }
}

/*
Dry run :

coins = [1,2,5]
amount = 11

Creating a dp array of size 12, which holds minimum number of coins neeeded for amount 0-11
For amount 0, 0 minimum coins are needed

Now for sum = 1, we will determine the minimum number of coins needed
We will check for all coins - 1,2 and 5
Now, if (1<=1), temp = dp[0] + 1 = 1, min = 1
        (2 <= 1), false...
        (5 <= 1), false.....so dp[1] = min = 1
Now, sum becomes 2

    if (1 <=2) && dp[2-1]!=-1, temp = dp[1] + 1 = 2 (Using coin of 1, sum of 2 can be obtained in min 2 coins)
       (2 <=2) && dp[2-2]!=-1, temp = dp[0] + 1 = 1 (Using coin of 2, sum of 2 can be obtained in min 1 coin)
       (5 <=2), false..... so dp[2] = min = 1
       
...............
        

We check if the current sum is greater than equal to current coin and dp[sum - coin] != -1
dp[sum - coin] checks if the sum can be obtained by adding current coin or not.
*/

// public class Solution {
//     public int coinChange(int[] coins, int amount) {
//         if(coins == null || amout == 0)
//             return 0;
//         int res = 0;
//         int[] dp = new int[amount+1];
//         dp[0]=0;
        
//         int sum = 1;
//         while(sum<=amount) {
//             int minAtThisSum = -1;
//             for(int coin : coins) {
//                 if(sum >= coin && dp[sum-coin]!=-1) {
//                     int temp = dp[sum-coin]+1;
//                     if(minAtThisSum < 0)
//                         minAtThisSum = temp;
//                     else
//                         minAtThisSum = Math.min(temp, minAtThisSum);
//                 }
                    
//             }
//             dp[sum] = minAtThisSum;
//             sum++;
//         }
//         return dp[amount];
//     }
// }

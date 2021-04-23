class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i=1; i<prices.length; i++) {
            int profit = prices[i]-minPrice;
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}

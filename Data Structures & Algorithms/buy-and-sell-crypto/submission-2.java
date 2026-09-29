class Solution {
    public int maxProfit(int[] prices) 
    {
        int maxProfit = 0;
        int min = prices[0];
        for(int i=1; i<prices.length; i++)
        {
            min = Math.min(min,prices[i]);
            int currProfit = prices[i]-min;
            maxProfit = Math.max(currProfit,maxProfit);
        }

        return maxProfit;
    }
}

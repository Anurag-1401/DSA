class Solution {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE,profit = 0,maxProfit = 0;

        for(int price:prices){
            minValue = Math.min(minValue,price);
            profit = price - minValue;
            maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}
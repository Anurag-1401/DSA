class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0, buy = prices[0];

        for (int price : prices) {
            if (price < buy) buy = price;
            else if (price > buy + fee) {
                profit += price - buy - fee;
                buy = price - fee;
            }
        }

        return profit;
    }
}
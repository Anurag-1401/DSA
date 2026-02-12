class Solution {
    public int maxProfit(int[] prices, int fee) {

        int hold = -prices[0];
        int cash = 0;

        for (int price : prices) {

            int prevCash = cash;

            cash = Math.max(cash, hold + price - fee);
            hold = Math.max(hold, prevCash - price);
        }

        return cash;
    }
}

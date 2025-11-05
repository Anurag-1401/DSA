class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE,profit = 0,max = 0;

        for(int price : prices){
            if(price < min) min = price;
            else profit = price - min;
            if(profit>max) max = profit; 
        }
        return max;
    }
}
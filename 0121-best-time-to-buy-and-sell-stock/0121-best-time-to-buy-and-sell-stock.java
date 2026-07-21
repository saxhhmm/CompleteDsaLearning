class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                // Found a new lowest buying price
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                // Found a higher profit
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}

public class BestTimeToBuyAndSellStockI {
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int minPrice = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}

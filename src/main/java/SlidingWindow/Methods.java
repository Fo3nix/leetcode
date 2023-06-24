package SlidingWindow;

public class Methods {

    // maxProfit
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/978611419/
    public int maxProfit(int[] prices) {
        int minIndex = 0;
        int currentWin = 0;

        for(int i = 1; i<prices.length; i++){
            if(prices[minIndex]>=prices[i]) minIndex=i;
            else currentWin = Math.max(currentWin, prices[i]-prices[minIndex]);
        }

        return currentWin;
    }



}

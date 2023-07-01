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

    // lengthOfLongestSubstring
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/983974004/
    public int lengthOfLongestSubstring(String s) {
        int[] table = new int[95];

        int maxL = 0;
        int startI = 0;

        for(int i =0; i<s.length(); i++){
            startI = Math.max(startI, table[s.charAt(i)-32]);
            maxL = Math.max(maxL, i-startI+1);
            table[s.charAt(i)-32] = i+1;
        }
        maxL = Math.max(maxL, s.length()-startI);

        return maxL;


    }



}

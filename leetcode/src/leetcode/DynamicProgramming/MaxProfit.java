package leetcode.DynamicProgramming;

/**
 * @ClassName: MaxProfit
 * @Description https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/ 121. 买卖股票的最佳时机
 * @Author Ryan
 * @Date 2021.4.23 23:04
 * @Version 1.0.0-Beta
 **/
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {2,5,1,3};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]<min) min = prices[i];
            if(prices[i]-min>profit) profit = prices[i]-min;

            // dp[i] = max(dp[i - 1], prices[i] - minprice)
            // 也可以一维动态规划 只不过维护的是个dp数组 又因为我们只求最大利润 因此再优化成保留最后的那个最大利润就行
            // 如果要求输出最大利润的买卖时间 那就很需要这个一维dp数组了

            // 这里与贪心的最大子序列和也有神通
        }
        return profit;
    }
}

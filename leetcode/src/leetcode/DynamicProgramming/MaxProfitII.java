package leetcode.DynamicProgramming;

/**
 * @ClassName: MaxProfitII
 * @Description https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/ 122. 买卖股票的最佳时机 II
 * @Author Ryan
 * @Date 2021.4.24 10:09
 * @Version 1.0.0-Beta
 **/
public class MaxProfitII {

    public static int maxProfit(int[] prices){



        return 0;
    }
    public static int maxProfitOptimize(int[] prices){
        // 正如MaxProfit I 其实我们只用关注前一天 找最大利润 因此不必要维护整个数组 而是维护
        // 状态转移方程dp[i] dp[i-1] 完成状态转移即可 因此找两个变量完事
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
    public static int maxProfitByGreedy(int[] prices){
        /* 贪心算法 其实无论哪天卖 哪天卖 都可以拆分成0~1 1~2 2~3 这是0~3的情况
           当然实际上不可能当天买卖 但是我们可以这么等价计算 这样的话我们可以为所欲为 因为已经
           是最小粒度了 只要所有粒度都对profit正贡献就完事 没贡献就不算进去：）
           这就是子问题的贪心 最大化 使得全局最大化 贪心算法

        */
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit+= prices[i]>prices[i-1]?prices[i]-prices[i-1]:0;
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] prices = {7,78,78};
        System.out.println(maxProfitOptimize(prices));
    }
}

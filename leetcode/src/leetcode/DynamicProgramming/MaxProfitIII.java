package leetcode.DynamicProgramming;

/**
 * @ClassName: MaxProfitIII
 * @Description 123. 买卖股票的最佳时机 III https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * @Author Ryan
 * @Date 2021.4.26 21:18
 * @Version 1.0.0-Beta
 **/
public class MaxProfitIII {

    public static int maxProfitByGreedy(int[] prices){
//        第1次交易：初始第0天买入，从第1天顺序遍历，第i天价格比上次买入：
//
//        低，重新在当天买入。即 更新最小值
//        高，假设在当天卖出，利润 存入dp0[i]
//        遍历结束，第1次交易在第[0, 数组长度 - 1]天结束时的利润dp0
//        第2次交易：初始最后1天卖出，从倒数第2天倒序遍历，第i天价格比上次卖出：
//
//        高，重新在当天卖出。即 更新最大值
//        低，假设在当天买入，上次（最大值所在那天）卖出，利润 dp1
//        第2次交易，最早只能在第2天开始，第3天产生利润
//        2次交易的利润和 = 第i天作为第1次交易结束dp0[i] + 第i天以后进行第2次交易利润dp1
        // 总之 关键是能进行两次交易 第一次搞完 第二次交易倒序 从i 到 prices.length 中间开始
        // 但是不知道多次交易可否这么做 感觉还是可行啊

        return 0;
    }
    public static int maxProfit(int[] prices){
        int n = prices.length;

        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }

}

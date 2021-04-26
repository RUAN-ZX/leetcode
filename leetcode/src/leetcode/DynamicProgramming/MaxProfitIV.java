package leetcode.DynamicProgramming;

/**
 * @ClassName: MaxProfitIV
 * @Description
 * @Author Ryan
 * @Date 2021.4.26 22:02
 * @Version 1.0.0-Beta
 **/
public class MaxProfitIV {
    public static int maxProfit(int k, int[] prices){
        int n = prices.length;

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i][0] = -prices[0];
            result[i][1] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if(j==0) result[j][0] = Math.max(result[j][0] , -prices[i]);
                else result[j][0] = Math.max(result[j][0] , result[j-1][1]-prices[i]);
                result[j][1] = Math.max(result[j][1] , result[j][0]+prices[i]);

            }
        }
        return result[k-1][1];
    }
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        System.out.println(maxProfit(2,prices));
    }
}

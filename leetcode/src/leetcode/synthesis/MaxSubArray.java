package leetcode.synthesis;

/**
 * @ClassName: maxSubArray
 * @Description https://leetcode-cn.com/problems/maximum-subarray/ 53. 最大子序和
 * @Author Ryan
 * @Date 2021.4.23 20:43
 * @Version 1.0.0-Beta
 **/
public class MaxSubArray {

    // 贪心算法 利用max 如果我之前的加上你还不如你 那就用你 如果之前的都比你强就跳过你 我去寻找下一个大爹
    public static int maxSubArrayUsingGreedy(int[] nums){
//        int max = nums[0];
        int n = nums.length;
        int cur_max = nums[0];
        for (int i = 1; i < n; i++) {
            cur_max = Math.max(nums[i],cur_max+nums[i]);
            nums[0] = Math.max(cur_max,nums[0]);

        }
        return nums[0];
    }
    // 动态规划？
    public static int maxSubArrayUsingDynamic(int[] nums){
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if(nums[i-1]>0) nums[i]+=nums[i-1];
            nums[0] = Math.max(nums[0],nums[i]);
        }
        return nums[0];
    }
    public static void main(String[] args) {
        int[] nums = {-2};

        System.out.println(maxSubArrayUsingDynamic(nums));
    }
}

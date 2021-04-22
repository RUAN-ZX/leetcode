package leetcode;

/**
 * @ClassName: MoveZeroes
 * @Description https://leetcode-cn.com/problems/move-zeroes/ 283. 移动零
 * @Author Ryan
 * @Date 2021.4.22 20:11
 * @Version 1.0.0-Beta
 **/
public class MoveZeroes {
    public static void movezeros(int[] nums){
        int left = 0;
        int right = 0;
        if(nums.length<=1) return ;

        for (; right < nums.length; right++) {
           if(nums[left]==0 && nums[right]!=0) {
               nums[left] = nums[right] + nums[left];
               nums[right] = nums[left] - nums[right];
               nums[left] = nums[left] - nums[right];
               left++;
           }
           else if(nums[left]!=0) left++;
        }

        return ;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,1};
        MoveZeroes.movezeros(nums);
        for (int i: nums) {
            System.out.println(i);
        };
    }
}

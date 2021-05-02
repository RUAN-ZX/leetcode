package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: twoSum 1. 两数之和
 * @Description https://leetcode-cn.com/problems/two-sum/
 * @Author Ryan
 * @Date 2021.5.2 21:46
 * @Version 1.0.0-Beta
 **/
public class twoSum {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[] {0,1};
        for (int i = 0; i < nums.length; i++) {
            Integer temp= hashMap.get(nums[i]);
            if(temp!=null){
                result[0] = temp;
                result[1] = i;
                return result;
            }else hashMap.put(target-nums[i],i);
            // 这里利用哈希表 将Key存所需要的值 Value存下标
            // 其实如果值不大 你甚至可以用数组下标代替target-nums[i]
            // 值太大 那哈希表就是这种数组用法
        }
        return result;


    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] result = twoSum(nums,9);
        System.out.println(result[0]+'\n'+result[1]);

    }
}

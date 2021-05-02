package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: twoSumII
 * @Description
 * @Author Ryan
 * @Date 2021.5.2 22:10
 * @Version 1.0.0-Beta
 **/
public class twoSumII {
    // 哈希解法 时间O(n) 空间O(n)
    public static int[] twoSumByHashTable(int[] numbers, int target){
        Map<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[] {0,1};
        for (int i = 0; i < numbers.length; i++) {
            Integer temp= hashMap.get(numbers[i]);
            if(temp!=null){
                result[0] = temp;
                result[1] = i;
                return result;
            }else hashMap.put(target-numbers[i],i);
            // 这里利用哈希表 将Key存所需要的值 Value存下标
            // 其实如果值不大 你甚至可以用数组下标代替target-nums[i]
            // 值太大 那哈希表就是这种数组用法
        }
        return result;
    }

    public static int[] twoSumByDivision(int[] numbers, int target){
        // 可以采用二分 一个数固定 一个数二分查找它另一半 但是固定的那个是n 二分logn 因此 O(nlogn) 所以很一般这个方式
        return new int[] {-1,-1};
    }

    public static int[] twoSumByTwoPointer(int[] numbers, int target){
        //既然是升序序列 因此直接左右各一个指针 夹逼法
        // nums[left] + nums[right] > target then right--;
        // nums[left] + nums[right] < target then left++;
        // nums[left] + nums[right] == target then return;
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }

        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int[] result = twoSumByHashTable(numbers,9);
        System.out.println(result[0]+'\n'+result[1]);

    }
}

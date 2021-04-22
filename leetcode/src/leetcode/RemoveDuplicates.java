package leetcode;

/**
 * @ClassName: RemoveDuplicates
 *
 * @Description 26. 删除有序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @Author Ryan
 * @Date 2021.4.22 14:19
 * @Version 1.0.0-Beta
 **/
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int front = 1;
        int back = 1;
        for (front = 1; front < nums.length; front++) {
            if(nums[front]!=nums[back-1]){
                nums[back] = nums[front];
                back++;
            }
        }
        return back;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,2,2,3,4,5,5,6,7};

        int result = removeDuplicates(nums);
        for (int i = 0; i < result; i++) {
            System.out.println(nums[i]);
        }

    }

}

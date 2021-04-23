package leetcode.binarySearch;

/**
 * @ClassName: SearchRange
 * @Description https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @Author Ryan 34. 在排序数组中查找元素的第一个和最后一个位置
 * @Date 2021.4.23 11:00
 * @Version 1.0.0-Beta
 **/
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){

        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(searchRange(nums,8)) ;
    }

}

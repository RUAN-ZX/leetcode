package leetcode.binarySearch;

/**
 * @ClassName: SearchInsert
 * @Description https://leetcode-cn.com/problems/search-insert-position/  35. 搜索插入位置
 * @Author Ryan
 * @Date 2021.4.23 9:39
 * @Version 1.0.0-Beta
 **/
public class SearchInsert {
    public static int searchInsert(int[] nums, int target){
        int left=0;
        int right = nums.length-1;
        int mid = 0;

        while(right>=left){
            mid = left + ((right-left) >> 1);
            if(target<nums[mid]) right = mid-1;
            else if(target>nums[mid]) left = mid+1;
            else return mid;
        }

        return left;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        System.out.println(searchInsert(nums,7));
    }
}

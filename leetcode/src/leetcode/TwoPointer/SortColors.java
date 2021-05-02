package leetcode.TwoPointer;

/**
 * @ClassName: SortColors
 * @Description
 * @Author Ryan
 * @Date 2021.5.2 18:18
 * @Version 1.0.0-Beta
 **/
public class SortColors {
    public static void sortColors(int[] nums){
        int zeroFinder = 0;
        int oneFinder = 0;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[oneFinder];
                nums[oneFinder] = temp;
                ++oneFinder;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[zeroFinder];
                nums[zeroFinder] = temp;
                if (zeroFinder < oneFinder) {
                    temp = nums[i];
                    nums[i] = nums[oneFinder];
                    nums[oneFinder] = temp;
                }
                ++zeroFinder;
                ++oneFinder;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for (int num :
                nums) {
            System.out.println(num);
        }
    }
}

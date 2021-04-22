package leetcode;

/**
 * @ClassName: RemoveItems
 * @Description https://leetcode-cn.com/problems/remove-element/ 27. 移除元素
 * @Author Ryan
 * @Date 2021.4.22 16:10
 * @Version 1.0.0-Beta
 **/
public class RemoveItems {
    public static int removeItems(int[] nums, int val) {
        int front = nums.length-1;
        int back = 0;
        if(nums.length==0) return 0;
        else if(nums.length==1){
            if(nums[0]==val) return 0;
            else return 1;
        }

        for (; back <= front; back++) {
            if(nums[back]==val){
                while(nums[front]==val){
                    if(front<=back) return back;
                    front--;
                }
                nums[back] = nums[back] + nums[front];
                nums[front] = nums[back] - nums[front];
                nums[back] = nums[back] - nums[front];
                front --;
            }
        }
        return back;
    }


    public static int removeItemBetter(int[] nums, int val){
        int left = 0;
        int right = nums.length;

        while(left<right){
            if(nums[left]==val){
                nums[left] = nums[right-1];
                right--;
            }else left++;
        }
        return left;
    }
    public static void main(String[] args) {
//        int[] nums = {1,4,1,4,1,2,2,3,4,5,5,6,7};
        int[] nums = {3,2,3,3,3,3};

        int result = removeItemBetter(nums, 3);
//        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.println(nums[i]);
        }

    }
}

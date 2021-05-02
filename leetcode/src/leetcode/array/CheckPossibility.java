package leetcode.array;

/**
 * @ClassName: CheckPossibility 665. 非递减数列
 * @Description https://leetcode-cn.com/problems/non-decreasing-array/
 * @Author Ryan
 * @Date 2021.5.2 21:25
 * @Version 1.0.0-Beta
 **/
public class CheckPossibility {


    /*
        每次统计完改变次数之后 还需要 维持数组为非递减 最好的方式是直接等于
        但是 nums[0] ... nums[i-1]  nums[i] nums[i+1] ...
        前面的0~i-1 是维持好的 你要是随便改了 nums[i] = nums[i+1] 那万一是1 2 3 1 凉了
        如果直接nums[i+1] = nums[i] 那要是 1 2 1 3 还是凉了
        换言之 增大i元素 减小i+1元素都可能 那怎么判定？

        看i-2 因为i-2代表过去所有的数列的最高点 看他就相当于维持了过去所有的元素的非递减特性
     */
    public static boolean checkPossibility(int[] nums){
        if (nums.length == 1)   return true;
        boolean flag = nums[0] <= nums[1]; // 标识是否还能修改
        // 遍历时，每次需要看连续的三个元素
        for (int i = 1; i < nums.length - 1; i++)
        {
            if (nums[i] > nums[i + 1])  // 出现递减
            {
                if (flag)   // 如果还有修改机会，进行修改
                {
                    if (nums[i + 1] >= nums[ i - 1])// 修改方案1
                        nums[i] = nums[i + 1];
                    else                            // 修改方案2
                        nums[i + 1] = nums[i];
                    flag = false;                   // 用掉唯一的修改机会
                }
                else        // 没有修改机会，直接结束
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {4,2,3};
        System.out.println(checkPossibility(nums));
    }
}

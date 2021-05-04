package leetcode.hashTable;

import java.util.*;

/**
 * @ClassName: ThreeSum
 * @Description
 * @Author Ryan
 * @Date 2021.5.4 13:59
 * @Version 1.0.0-Beta
 **/
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {

            for (int j = i+1; j < nums.length; j++) {
                Integer temp = hashMap.get(-nums[i]-nums[j]);
                if (temp != null&&i!=j&&j!=temp&&i!=temp) {
                    ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[temp]));
                    Collections.sort(integers);
                    result.add(integers);
                } else hashMap.put(nums[j], j);
            }
        }
        ArrayList<Integer> removeIndex = new ArrayList();

        for (int i = 0; i < result.size(); i++) {
            for (int j = i+1; j < result.size(); ) {
                List<Integer> a= result.get(i);
                List<Integer> b= result.get(j);
                if(a.get(0).equals(b.get(0))
                        && a.get(1).equals(b.get(1))
                        && a.get(2).equals(b.get(2)))
                    result.remove(j);
                else j++;
            }
        }
        return result;


    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> t : result)
            for (Integer i : t)
                System.out.println(i);
    }
}

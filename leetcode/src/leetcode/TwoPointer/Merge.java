package leetcode.TwoPointer;

/**
 * @ClassName: Merge
 * @Description
 * @Author Ryan
 * @Date 2021.4.30 15:53
 * @Version 1.0.0-Beta
 **/
public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0) System.arraycopy(nums2, 0, nums1, 0, n);

        else if(n!=0){
            for (int p1 = m-1,p2 = n-1, p = m+n-1; p1 >= 0 || p2 >= 0; p--) {
                if(p1==-1) nums1[p]=nums2[p2--];
                else if(p2==-1) nums1[p]=nums1[p1--];
                else if (nums1[p1] < nums2[p2]){
                    nums1[p] = nums2[p2];
                    p2--;
                }
                else{
                    nums1[p] = nums1[p1];
                    p1--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);

        for (int value : nums1) {
            System.out.println(value);
        }
    }
}

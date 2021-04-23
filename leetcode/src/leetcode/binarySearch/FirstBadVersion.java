package leetcode.binarySearch;

/**
 * @ClassName: FirstBadVersion
 * @Description https://leetcode-cn.com/problems/first-bad-version/ 278. 第一个错误的版本
 * @Author Ryan
 * @Date 2021.4.23 10:39
 * @Version 1.0.0-Beta
 **/
public class FirstBadVersion {
    boolean isBadVersion(int version){
        return true;
    }
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = 0;
        while(left<=right){
            mid = left + ((right-left)>>1);
            if(isBadVersion(mid)==false) left = mid + 1;
            else if(isBadVersion(mid)==true) right = mid -1;
        }
        return left;
    }
}

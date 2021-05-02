package leetcode.array;

/**
 * @ClassName: PlusOne
 * @Description https://leetcode-cn.com/problems/plus-one/  66. 加一
 * @Author Ryan
 * @Date 2021.4.27 8:27
 * @Version 1.0.0-Beta
 **/
public class PlusOne {

    public static int[] plusOne(int[] digits){
        int n = digits.length;
        digits[n-1]+=1;
        for (int i = n-1; i > 0; i--) {
            if(digits[i]==10) {
                digits[i]=0;
                digits[i-1]+=1;
            }
        }
        if(digits[0]==10){
            int[] result= new int[n+1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
    public static void main(String[] args) {
        int[] digits = {9};
        for (int v:plusOne(digits)) {
            System.out.println(v);
        }
//        System.out.println();
    }
}

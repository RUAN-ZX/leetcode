package leetcode.String;



/**
 * @ClassName: AddBinary
 * @Description https://leetcode-cn.com/problems/add-binary/ 67. 二进制求和
 * @Author Ryan
 * @Date 2021.4.27 8:48
 * @Version 1.0.0-Beta
 **/
public class AddBinary {
    public static String addBinary(String a, String b){
        StringBuilder ans = new StringBuilder();


        // 思路关键 字符串翻转 适应不同长度的字符串 适应二进制权值
        // 另外 短的字符串遍历完 就可以只用长的字符串剩下部分 这里三目来实现
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(addBinary("111","11111"));
    }

}

package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GenerateTriangle2 119. 杨辉三角 II
 * @Description https://leetcode-cn.com/problems/pascals-triangle-ii/
 * @Author Ryan
 * @Date 2021.5.2 19:55
 * @Version 1.0.0-Beta
 **/
public class GenerateTriangle2 {

    // 所谓滚动数组 利用new ArrayList清空特性以及List为引用类型 可以软复制！仅仅存个指针相当于
    public static List<Integer> getByrowIndex(int rowIndex) {
        List<Integer> rowList = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0 || j==i) cur.add(1);
                else cur.add(rowList.get(j-1)+rowList.get(j));
            }
            rowList = cur;
        }


        return rowList;
    }

    // 可以原地解决！！！ 因为从末尾开始处理 刚好不会上下两行间互相影响 当然你也可以头插一个0 这样也能错开！
    public static List<Integer> getByrowIndex2(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
    public static void main(String[] args) {
        for (Integer a : getByrowIndex(5))
            System.out.println(a);
        for (Integer a : getByrowIndex2(5))
            System.out.println(a);
    }
}

package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GenerateTriangle 118. 杨辉三角
 * @Description https://leetcode-cn.com/problems/pascals-triangle/
 * @Author Ryan
 * @Date 2021.5.2 18:56
 * @Version 1.0.0-Beta
 **/
public class GenerateTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if(j==0 || j==i) rowList.add(1);
                else rowList.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            result.add(rowList);
        }


        return result;
    }



    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.println(result.get(i).get(j));
            }
        }


    }
}

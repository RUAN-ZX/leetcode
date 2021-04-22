package solution_leetcode;

/*
 * @id:1476. 子矩形查询
 * @time 2020-8-18
 * @method
 *   暴力更新 查询就好
 *       查询最好用arryaList 但性能最好都是数组 因为vector arrayList等都基于数组
 *   用栈记录更新的记录 每次输出结果就去栈里面找记录 empty判断栈空 然后就不用大规模更改原数组了
 * */
public class SubrectangleQueries {
/* method 1

    int[][] rect;
    public SubrectangleQueries(int[][] rectangle) {
        rect = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i=row1; i<row2; i++){
            for(int j=col1; j<col2; j++){
                rect[i][j]=newValue;
            }

        }
    }

    public int getValue(int row, int col) {
        return rect[row][col];
    }*/

/* method 2 直接用stack 但是问题在于 这个stack不应该弹栈 否则连续两次查询结果就可能错了
    所以逆序查询的数据结构比较好 第三种方法写个数组看看
    int[][] rect;
    Stack<Integer> Srow1 = new Stack<>();
    Stack<Integer> Srow2 = new Stack<>();
    Stack<Integer> Scol1 = new Stack<>();
    Stack<Integer> Scol2 = new Stack<>();
    Stack<Integer> Svalue = new Stack<>();

    public SubrectangleQueries(int[][] rectangle) {
        rect = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        Srow1.push(row1);
        Srow2.push(row2);
        Scol1.push(col1);
        Scol2.push(col2);
        Svalue.push(newValue);
    }

    private boolean between(int a, int b, int amin, int amax, int bmin, int bmax){
        if(a>amin && a<amax && b>bmin && b<bmax) return true;
        else return false;
    }
    public int getValue(int row, int col) {

        for(int i=0; i<502; i++){

            if(between(row,col,Srow1.pop(),Srow2.pop(),Scol1.pop(),Scol2.pop())){
                Srow1=Srow2=Scol1=Scol2=null;
                return Svalue.pop();
            }
            if(Srow1.empty()){
                break;
            }

        }
        return rect[row][col];
    }*/


    int[][] rect;
    int[][] Sinfo = new int[500][4];
    int sp = 0;

    public SubrectangleQueries(int[][] rectangle) {
        rect = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        Sinfo[sp][0] = row1;
        Sinfo[sp][1] = row2;
        Sinfo[sp][2] = col1;
        Sinfo[sp][3] = col2;
        Sinfo[sp][4] = newValue;

        sp++;
    }

    private boolean between(int a, int b, int amin, int amax, int bmin, int bmax) {
        if (a > amin && a < amax && b > bmin && b < bmax) return true;
        else return false;
    }

    public int getValue(int row, int col) {

        for (int i = sp; i >= 0; sp--) {

            if (between(row, col, Sinfo[i][0], Sinfo[i][1], Sinfo[i][2], Sinfo[i][3])) {
                return Sinfo[i][4];
            }

        }
        return rect[row][col];
    }
}

package leetcode.array;

/**
 * @ClassName: Maximumhealth
 * @Description
 * @Author Ryan
 * @Date 2021.4.23 19:40
 * @Version 1.0.0-Beta
 **/
public class Maximumhealth {
    public static int maxiumWealth(int[][] accounts){
        if(accounts[0].length==0) return 0;


        if(accounts.length==1)
            for (int i = 1; i < accounts[0].length; i++)
                accounts[0][0]+=accounts[0][i];
        else if(accounts[0].length==1)
            for (int i = 1; i < accounts.length; i++)
                accounts[0][0] = Math.max(accounts[0][0], accounts[i][0]);
        else {
            for (int i = 1; i < accounts[0].length; i++)
                accounts[0][0] += accounts[0][i];

            for(int x=1;x<accounts.length;x++){
                for(int y=1;y<accounts[x].length;y++)
                    accounts[x][0] += accounts[x][y];
                accounts[0][0] = Math.max(accounts[0][0], accounts[x][0]);
            }
        }
        return accounts[0][0];
    }
    public static void main(String[] args) {

        int[][] accounts = {{2,5,5,5,5,9}};


        System.out.println(maxiumWealth(accounts));

    }
}

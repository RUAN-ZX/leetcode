//面试题 01.07. 旋转矩阵
package solution_leetcode;

class rotatedMatrix {
    public static void swap(int a, int b) {
        a = a ^ b;
        b = b ^ a;
        a = b ^ a;
    }

    public static void rotate(int[][] matrix) {
//        System.out.print(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j] + " ");
                if (j == matrix.length - 1) System.out.print('\n');
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
//                System.out.println(a+"exchange"+b+"i"+i+"j"+j);
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[j][i] ^ matrix[i][j];
                matrix[i][j] = matrix[j][i] ^ matrix[i][j];

//                matrix[matrix.length-j-1][matrix.length-1+i]=matrix[matrix.length-j-1][matrix.length-1+i]^matrix[i][j];
//                matrix[i][j]=matrix[i][j]^matrix[matrix.length-j-1][matrix.length-1+i];
//                matrix[matrix.length-j-1][matrix.length-1+i]=matrix[i][j]^matrix[matrix.length-j-1][matrix.length-1+i];
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j < (matrix.length - 1) / 2) {
                    matrix[i][j] = matrix[i][j] ^ matrix[i][matrix.length - 1 - j];
                    matrix[i][matrix.length - 1 - j] = matrix[i][matrix.length - 1 - j] ^ matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length - 1 - j] ^ matrix[i][j];
                }
//                System.out.println(a+"exchange"+b+"i"+i+"j"+j);

            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j] + " ");
                if (j == matrix.length - 1) System.out.print('\n');
            }
        }


//        return matrix;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(test);
    }
}
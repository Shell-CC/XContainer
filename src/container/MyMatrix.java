import java.util.Arrays;

public class MyMatrix {
    public static void setZeroes(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[] flags = findFlags(matrix, M, N);
        if (flags == null) {
            return;
        }
        int m = flags[0]; int n = flags[1];
        for (int i = m; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    matrix[m][j] = 0;
                    matrix[i][n] = 0;
                }
            }
        }
        System.out.println(toString(matrix));
        matrix[m][n] = -1;
        for (int i = 0; i < M; i++) {
            if (matrix[i][n] == 0) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < N; j++) {
            if (matrix[m][j] == 0) {
                for (int i = 0; i < M; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            matrix[i][n] = 0;
        }
        for (int j = 0; j < N; j++) {
            matrix[m][j] = 0;
        }
    }

    private static int[] findFlags(int[][] matrix, int M, int N) {
        int[] a = new int[2];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return null;
    }

    public String toString(int[][] matrix) {
        String s = "[\n";
        for (int i = 0; i < matrix.length; i++) {
            s += "[ ";
            for (int j = 0; j < matrix[0].length; j++) {
                s = s + matrix[i][j] + " ";
            }
            s += "],\n";
        }
        return s + "]";
    }

    public static void main(String[] args) {
        int[][] m = {{9, 6, 1, 2, 5},
                     {1, 3, 2, 4, 0},
                     {3, 4, 0, 4, 1}};
        System.out.println(m);
        MyMatrix.setZeroes(m);
        System.out.println(MyMatrix.toString(m));
    }
}
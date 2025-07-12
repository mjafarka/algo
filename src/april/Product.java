package april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Matrix {
    int[][] mat;
    public Matrix() {
        mat = new int[26][26];
    }

     public Matrix(int[][] inputMat) {
        mat = new int[26][26];
        for (int i = 0 ; i < 26 ; i ++) {
            for (int j = 0 ;j < 26 ;j ++) {
                mat[i][j] = inputMat[i][j];
            }
        }
    }

    public static Matrix createIdentity() {

        Matrix identity = new Matrix();
        // int[][] identity = new int[26][26];

        for (int i = 0 ; i < 26 ; i++) {
            for (int j = 0 ; j < 26 ; j++) {
                if (i ==j) {
                    identity.mat[i][j] = 1;
                }
            }
        }

        return identity;
    }
}
public class Product {

    int mod = (int) Math.pow(10, 9) + 7;


    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[][] transMatrix = new int[26][26];

        for (int i = 0; i < 26; i++) {
            int nxt = nums.get(i);
            for (int j = 0; j < nxt; j++) {
                transMatrix[(i + j + 1) % 26][i] = 1;
            }
        }


        int[][] transMatrixAfter = pow(transMatrix,t);

        // System.out.println("transMatrixAfter = " + Arrays.deepToString(transMatrixAfter.mat));

        int[] charCount = new int[26];

        for (char c : s.toCharArray()) {
            charCount[c-'a'] ++;
        }

        // Matrix initial = new Matrix(charCount);

        int[] res  = new int[26];

        // Matrix res = multiply(transMatrixAfter,initial);

        for (int i = 0 ; i < 26 ; i++) {
            for (int j = 0 ; j < 26 ; j++) {
                res[i] += transMatrixAfter[i][j] * charCount[j];
            }
        }

        int lengAfterTrans = 0;

        System.out.println("res = " + Arrays.toString(res));
        for (int i = 0 ; i< 26 ; i++) {
            lengAfterTrans += res[i];
        }

        return lengAfterTrans;
    }

    private int[][] pow(int[][] m, int t) {
        if (t == 1) {
            return m;
        }

        boolean odd = false;

        if (t % 2 == 1) {
            odd = true;
        }

        int[][] res = pow(m, t / 2);
        if (odd == false) {
            return multiply(res, res);
        } else {
            return multiply(multiply(res, res), m);
        }
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int[][] res = new int[26][26];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {

                    long prod = (1l * a[i][k] * b[k][j]) % mod;
                    
                    res[i][j] += prod;

                    res[i][j] %= mod;

                    if (res[i][j] <0) {
                        System.out.println("less than zero found");
                    }
                }
            }
        }

        return res;
    }

    private Matrix multiply(Matrix a, Matrix b) {
        int[][] aMat = a.mat;
        int[][] bMat = b.mat;

        int[][] res = new int[26][26];

        for (int i = 0 ; i < 26 ; i ++) {
            for (int j = 0 ; j < 26 ; j++) {
                for (int k = 0 ;k < 26 ; k ++) {
                    res[i][j] += aMat[i][k] * bMat[k][j];
                }
            }
        }

        return new Matrix(res);
    }

    public static void main(String[] args) {
        // Creating an object directly using the constructor
        Product laptop = new Product();

        System.out.println(laptop.lengthAfterTransformations("u", 3, new ArrayList<>(Arrays.asList(1,1,2,2,3,1,2,2,1,2,3,1,2,2,2,2,3,3,3,2,3,2,3,2,2,3))));
    }
}
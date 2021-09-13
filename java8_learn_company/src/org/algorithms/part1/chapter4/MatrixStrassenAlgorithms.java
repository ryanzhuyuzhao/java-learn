package org.algorithms.part1.chapter4;

import java.util.Arrays;

public class MatrixStrassenAlgorithms {
    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
        int[][] b = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
        //循环暴力求解矩阵的乘积
        int[][] d = squareMatrixMultiply(a, b);
        //简单的分治算法求解矩阵的乘积
        int[][] c = squareMatrixMultiplyRecursive(a, b);
        for (int i = 0;i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 暴力枚举循环求出两个矩阵的乘积
     * @param a
     * @param b
     * @return
     */
    public static int[][] squareMatrixMultiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    c[i][j] = c[i][j] + a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }

    /**
     * 简单的分治算法求解矩阵的乘积
     * @param a
     * @param b
     * @return
     */
    public static int[][] squareMatrixMultiplyRecursive(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        if (n == 1) {
            c[0][0] = a[0][0] * b[0][0];
        }else {
            int[][] a11 = new int[a.length / 2][a.length / 2];
            for (int i = 0; i < a.length / 2; i++) {
                for (int j = 0; j < a.length / 2; j++) {
                    a11[i][j] = a[i][j];
                }
            }
            int[][] a12 = new int[a.length / 2][a.length / 2];
            for (int i = 0; i < a.length / 2; i++) {
                for (int j = a.length / 2; j < a.length; j++) {
                    a12[i][j - (a.length / 2)] = a[i][j];
                 }
            }
            int[][] a21 = new int[a.length / 2][a.length / 2];
            for (int i = a.length / 2; i < a.length; i++) {
                for (int j = 0; j < a.length / 2; j++) {
                    a21[i - (a.length / 2)][j] = a[i][j];
                }
            }
            int[][] a22 = new int[a.length / 2][a.length / 2];
            for (int i = a.length / 2; i < a.length; i++) {
                for (int j = a.length / 2;j < a.length; j++) {
                    a22[i - (a.length / 2)][j - (a.length / 2)] = a[i][j];
                }
            }

            int[][] b11 = new int[b.length / 2][b.length / 2];
            for (int i = 0; i < b.length / 2; i++) {
                for (int j = 0; j < b.length / 2; j++) {
                    b11[i][j] = b[i][j];
                }
            }
            int[][] b12 = new int[b.length / 2][b.length / 2];
            for (int i = 0; i < b.length / 2; i++) {
                for (int j = b.length / 2; j < b.length; j++) {
                    b12[i][j - (a.length / 2)] = b[i][j];
                }
            }
            int[][] b21 = new int[b.length / 2][b.length / 2];
            for (int i = b.length / 2; i < b.length; i++) {
                for (int j = 0; j < b.length / 2; j++) {
                    b21[i - (a.length / 2)][j] = b[i][j];
                }
            }
            int[][] b22 = new int[b.length / 2][b.length / 2];
            for (int i = b.length / 2; i < b.length; i++) {
                for (int j = b.length / 2;j < b.length; j++) {
                    b22[i - (a.length / 2)][j - (a.length / 2)] = b[i][j];
                }
            }
            int[][] c11 = addMatrix(squareMatrixMultiply(a11, b11), squareMatrixMultiplyRecursive(a12, b21));
            int[][] c12 = addMatrix(squareMatrixMultiplyRecursive(a11, b12), squareMatrixMultiplyRecursive(a12, b22));
            int[][] c21 = addMatrix(squareMatrixMultiplyRecursive(a21, b11), squareMatrixMultiplyRecursive(a22, b21));
            int[][] c22 = addMatrix(squareMatrixMultiplyRecursive(a21, b12), squareMatrixMultiplyRecursive(a22, b22));
            for (int i = 0; i < c11.length; i++) {
                for (int j = 0; j < c11.length; j++) {
                    c[i][j] = c11[i][j];
                }
            }
            for (int i = 0; i < c12.length; i++) {
                for (int j = 0; j < c12.length; j++) {
                    c[i][j + c12.length] = c12[i][j];
                }
            }
            for (int i = 0; i < c21.length; i++) {
                for (int j = 0; j < c21.length; j++) {
                    c[i + c21.length][j] = c21[i][j];
                }
            }
            for (int i = 0; i < c22.length; i++) {
                for (int j = 0; j <c22.length; j++) {
                    c[i + c22.length][j + c22.length] = c22[i][j];
                }
            }
        }
        return c;
    }

    /**
     * 计算两个矩阵之和
     * @param c
     * @param d
     * @return
     */
    public static int[][] addMatrix(int[][] c, int[][] d) {
        int n = c.length;
        int[][] e = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                e[i][j] = c[i][j] + d[i][j];
            }
        }
        return e;
    }

}

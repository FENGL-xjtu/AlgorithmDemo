package chapter2;

/**
 * @Author: Fengl
 * @Date: 2021/10/30-10-30-下午7:23
 * @Description: chapter2
 * @version: 1.0
 */
public class Demo13 {
    private int[][] sums;

    /**
     * 求子矩阵的元素和,要求考虑多次计算的情况,因此不能每次都做逐元素求和
     * 思路:依次遍历矩阵,记录(0,0)-(x,y)组成的元素的和,用sums[x][y]依次记录
     * @param matrix
     */
    public Demo13(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                rowSum += matrix[i][j];
                sums[i + 1][j + 1] = sums[i][j + 1] + rowSum;
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }

    public static void main(String[] args) {
        int[][] nums = {{3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}};
        System.out.println(new Demo13(nums).sumRegion(2, 1, 4, 3));
    }
}

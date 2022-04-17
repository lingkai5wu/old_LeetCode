package contest;

public class Q3 {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] grid = { { 23, 17, 15, 3, 20 }, { 8, 1, 20, 27, 11 }, { 9, 4, 6, 2, 21 }, { 40, 9, 1, 10, 6 },
                { 22, 7, 4, 5, 3 } };
        System.out.println(new Q3().maxTrailingZeros(grid));
    }

    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] g = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j][0] = grid[i][j] / 2;
                g[i][j][1] = grid[i][j] / 5;
            }
        }
        return -1;
    }

}

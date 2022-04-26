package projectionArea;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int[][] grid = { { 1, 2 }, { 3, 4 } };
        System.out.println(new Solution().projectionArea(grid));
    }

    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int areaX = 0, areaY = 0, areaZ = 0;
        for (int i = 0; i < n; i++) {
            int maxX = 0, maxY = 0;
            for (int j = 0; j < n; j++) {
                maxX = Math.max(grid[i][j], maxX);
                maxY = Math.max(grid[j][i], maxY);
                if (grid[i][j] != 0) {
                    areaZ++;
                }
            }
            areaX += maxX;
            areaY += maxY;
        }
        return areaX + areaY + areaZ;
    }
}

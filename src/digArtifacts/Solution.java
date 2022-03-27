package digArtifacts;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int n = 2;
        int[][] artifacts = { { 0, 0, 0, 0 }, { 0, 1, 1, 1 } }, dig = { { 0, 0 }, { 0, 1 } };
        System.out.println(new Solution().digArtifacts(n, artifacts, dig));
    }

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] area = new boolean[n][n];
        for (int[] d : dig) {
            area[d[0]][d[1]] = true;
        }

        int res = 0;
        for (int[] art : artifacts) {
            boolean flag = true;
            for (int i = art[0]; i <= art[2] && flag; i++) {
                for (int j = art[1]; j <= art[3]; j++) {
                    if (!area[i][j]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }
}

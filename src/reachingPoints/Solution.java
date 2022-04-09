package reachingPoints;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int sx = 1, sy = 1, tx = 3, ty = 5;
        System.out.println(new Solution().reachingPoints(sx, sy, tx, ty));
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        if (tx == sx && ty == sy) {
            return true;
        } else if (tx == sx) {
            return ty > sy && (ty - sy) % tx == 0;
        } else if (ty == sy) {
            return tx > sx && (tx - sx) % ty == 0;
        } else {
            return false;
        }
    }
}

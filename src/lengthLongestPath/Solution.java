package lengthLongestPath;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(new Solution().lengthLongestPath(input));
    }

    public int lengthLongestPath(String input) {
        int n = input.length();
        Map<Integer, Integer> map = new HashMap<>();
        char[] cs = input.toCharArray();
        int res = 0;
        int i = 0, j = 0;
        while (i < n) {
            int level = 0;
            while (cs[i++] == '\t') {
                level++;
            }
            j = i;
            boolean isDir = true;
            while (j < n && cs[j] != '\n') {
                if (cs[j] == '.') {
                    isDir = false;
                }
                j++;
            }
            int len = j - i + 1;
            i = j + 1;
            if (level > 0) {
                len += map.get(level - 1);
            }
            if (isDir) {
                map.put(level, len + 1);
            } else {
                res = Math.max(len, res);
            }
        }
        return res;
    }
}

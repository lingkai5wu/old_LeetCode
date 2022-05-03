package reorderLogFiles;

import java.util.Arrays;

import array.StringArrayOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String[] logs = { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car" };
        StringArrayOperation.println(new Solution().reorderLogFiles(logs));
    }

    class Log {
        int type, index;
        String origin, sign, content;

        Log(String s, int index) {
            this.origin = s;
            this.index = index;
            int i = 0;
            while (s.charAt(i) != ' ') {
                i++;
            }
            sign = s.substring(0, i);
            content = s.substring(i + 1);
            type = Character.isDigit(content.charAt(0)) ? 1 : 0;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        Log[] arr = new Log[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Log(logs[i], i);
        }
        Arrays.sort(arr, (a, b) -> {
            if (a.type != b.type) {
                return a.type - b.type;
            }
            if (a.type == 1) {
                return a.index - b.index;
            }
            return !a.content.equals(b.content) ? a.content.compareTo(b.content) : a.sign.compareTo(b.sign);
        });
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = arr[i].origin;
        }
        return res;
    }
}

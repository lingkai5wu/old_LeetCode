package isAlienSorted;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String[] words = { "hello", "leetcode" };
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(new Solution().isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            index[order.charAt(i) - 'a'] = i;
        }
        String pre = "";
        for (String cur : words) {
            boolean flag = false;
            for (int i = 0; i < pre.length() && i < cur.length(); i++) {
                int prev = index[pre.charAt(i) - 'a'];
                int curr = index[cur.charAt(i) - 'a'];
                if (prev < curr) {
                    flag = true;
                    break;
                } else if (prev > curr) {
                    return false;
                }
            }
            if (!flag && pre.length() > cur.length()) {
                return false;
            }
            pre = cur;
        }
        return true;
    }
}

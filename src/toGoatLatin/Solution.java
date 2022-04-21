package toGoatLatin;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String sentence = "I speak Goat Latin";
        System.out.println(new Solution().toGoatLatin(sentence));
    }

    public String toGoatLatin(String sentence) {
        int n = sentence.length();
        char[] cs = sentence.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder add = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && cs[j] != ' ') {
                j++;
            }
            if ("aeiouAEIOU".indexOf(cs[i]) > -1) {
                sb.append(sentence.substring(i, j));
            } else {
                sb.append(sentence.substring(i + 1, j)).append(cs[i]);
            }
            add.append('a');
            sb.append("ma").append(add);
            i = j;
            if (i < n) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}

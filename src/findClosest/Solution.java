package findClosest;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String[] words = { "I", "am", "a", "student", "from", "a", "university", "in", "a", "city" };
        String word1 = "a", word2 = "student";
        System.out.println(new Solution().findClosest(words, word1, word2));
    }

    public int findClosest(String[] words, String word1, String word2) {
        int word1Ptr = -1, word2Ptr = -1, res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                word1Ptr = i;
            }
            if (words[i].equals(word2)) {
                word2Ptr = i;
            }
            if (word1Ptr != -1 && word2Ptr != -1) {
                res = Math.min(Math.abs(word2Ptr - word1Ptr), res);
            }
        }
        return res;
    }
}

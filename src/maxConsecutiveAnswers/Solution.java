package maxConsecutiveAnswers;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String answerKey = "TFFT";
        int k = 1;
        System.out.println(new Solution().maxConsecutiveAnswers(answerKey, k));
    }

    String s;
    int n, k;

    public int maxConsecutiveAnswers(String answerKey, int k) {
        s = answerKey;
        n = s.length();
        this.k = k;
        return Math.max(getCnt('T'), getCnt('F'));
    }

    // 当 cnt 不超过 k 时候，右指针右移，超过 k 时候，左指针右移一次，同时判断 cnt 是否变化
    int getCnt(char c) {
        int cnt = 0, i = 0, j;
        for (j = 0; j < n; j++) {
            if (s.charAt(j) == c) {
                cnt++;
            }
            if (cnt > k && s.charAt(i++) == c) {
                cnt--;
            }
        }
        return j - i;
    }
}

package maxConsecutiveAnswers;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

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

    // �� cnt ������ k ʱ����ָ�����ƣ����� k ʱ����ָ������һ�Σ�ͬʱ�ж� cnt �Ƿ�仯
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

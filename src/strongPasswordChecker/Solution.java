package strongPasswordChecker;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        String password = "1111111111";
        System.out.println(new Solution().strongPasswordChecker(password));
    }

    public int strongPasswordChecker(String password) {
        char[] cs = password.toCharArray();
        int n = cs.length;

        int uppercase = 1, lowercase = 1, number = 1;
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                uppercase = 0;
            } else if (Character.isLowerCase(c)) {
                lowercase = 0;
            } else if (Character.isDigit(c)) {
                number = 0;
            }
        }
        int caseAndNumCnt = uppercase + lowercase + number;
        if (n < 6) {
            return Math.max(6 - n, caseAndNumCnt);
        } else if (n <= 20) {
            int tot = 0;
            for (int i = 0; i < n;) {
                int j = i;
                while (j < n && cs[j] == cs[i]) {
                    j++;
                }
                int cnt = j - i;
                if (cnt >= 3) {
                    tot += cnt / 3;
                }
                i = j;
            }
            return Math.max(tot, caseAndNumCnt);
        } else {
            int tot = 0;
            int[] cnts = new int[3];
            for (int i = 0; i < n;) {
                int j = i;
                while (j < n && cs[j] == cs[i]) {
                    j++;
                }
                int cnt = j - i;
                if (cnt >= 3) {
                    tot += cnt / 3;
                    cnts[cnt % 3]++;
                }
                i = j;
            }
            int base = n - 20, cur = base;
            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    cnts[i] = tot;
                }
                if (cnts[i] != 0 && cur != 0) {
                    int t = Math.min(cnts[i] * (i + 1), cur);
                    cur -= t;
                    tot -= t / (i + 1);
                }
            }
            return base + Math.max(tot, caseAndNumCnt);
        }
    }
}

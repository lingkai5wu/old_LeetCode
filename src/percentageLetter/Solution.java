package percentageLetter;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

        String s = "foobar";
        char letter = 'o';
        System.out.println(new Solution().percentageLetter(s, letter));
    }

    public int percentageLetter(String s, char letter) {
        int n = s.length();
        double res = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                res++;
            }
        }
        return (int) (res / n * 100);
    }
}

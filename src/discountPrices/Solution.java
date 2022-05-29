package discountPrices;

public class Solution {

    public static void main(String[] args) {
        String sentence = "706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6";
        int discount = 28;
        System.out.println(new Solution().discountPrices(sentence, discount));
    }

    public String discountPrices(String sentence, int discount) {
        int n = sentence.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = -1; i < n; i++) {
            j = i;
            while (i < n && sentence.charAt(i) != ' ') {
                i++;
            }
            String s = sentence.substring(j, i);
            if (s.matches("[$]{1}[0-9]+")) {
                sb.append('$');
                s = s.substring(1);
                if (!s.isEmpty()) {
                    Long num = Long.parseLong(s);
                    sb.append(String.format("%.2f", num * (1 - 0.01 * discount)));
                }
            } else {
                sb.append(s);
            }
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

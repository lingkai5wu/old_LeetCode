package daily;

public class No1374 {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("a".repeat(Math.max(0, n - 1)));
        if (n % 2 == 1) {
            sb.append('a');
        } else {
            sb.append('b');
        }
        return sb.toString();
    }
}

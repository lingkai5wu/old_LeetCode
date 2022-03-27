package array;

public class StringArrayOperation {
    public static void println(String[] stringArray) {
        System.out.println(stringArrayToString(stringArray));
    }

    private static String stringArrayToString(String[] stringArray) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringArray) {
            sb.append("\"");
            sb.append(item);
            sb.append("\",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}

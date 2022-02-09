package array;

public class Int2dArrayOperation {
    private static String int2dArrayToString(int[][] array) {
	if (array == null) {
	    return "null";
	}
	if (array.length == 0) {
	    return "[]";
	}

	StringBuilder sb = new StringBuilder("[");
	for (int[] item : array) {
	    sb.append("[");
	    for (int i : item) {
		sb.append(Integer.toString(i));
		sb.append(",");
	    }
	    sb.setCharAt(sb.length() - 1, ']');
	    sb.append(",");
	}

	sb.setCharAt(sb.length() - 1, ']');
	return sb.toString();
    }

    public static void println(int[][] array) {
	System.out.println(int2dArrayToString(array));
    }
}

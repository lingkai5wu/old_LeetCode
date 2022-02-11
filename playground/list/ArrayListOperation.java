package list;

import java.util.List;

public class ArrayListOperation {
    private static String int2dListToString(List<List<Integer>> nums) {
	StringBuilder sb = new StringBuilder("[");
	for (List<Integer> list : nums) {
	    sb.append(integerArrayListToString(list));
	    sb.append(",");
	}

	sb.setCharAt(sb.length() - 1, ']');
	return sb.toString();
    }

    private static String integerArrayListToString(List<Integer> nums) {
	return integerArrayListToString(nums, nums.size());
    }

    private static String integerArrayListToString(List<Integer> nums, int length) {
	if (length == 0) {
	    return "[]";
	}

	String result = "";
	for (int index = 0; index < length; index++) {
	    Integer number = nums.get(index);
	    result += Integer.toString(number) + ", ";
	}
	return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void printlnIntList(List<Integer> nums) {
	System.out.println(integerArrayListToString(nums));
    }

    public static void printlnLnt2dList(List<List<Integer>> nums) {
	System.out.println(int2dListToString(nums));
    }
}

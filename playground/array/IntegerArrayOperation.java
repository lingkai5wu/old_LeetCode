package array;

public class IntegerArrayOperation {
    private static String integerArrayToString(int[] nums) {
	return integerArrayToString(nums, nums.length);
    }

    private static String integerArrayToString(int[] nums, int length) {
	if (length == 0) {
	    return "[]";
	}

	String result = "";
	for (int index = 0; index < length; index++) {
	    int number = nums[index];
	    result += Integer.toString(number) + ", ";
	}
	return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void println(int[] nums) {
	System.out.println(integerArrayToString(nums));
    }

    public static void println(int[] nums, int length) {
	System.out.println(integerArrayToString(nums, length));
    }

    public static int[] stringToIntegerArray(String input) {
	input = input.trim();
	input = input.substring(1, input.length() - 1);
	if (input.length() == 0) {
	    return new int[0];
	}

	String[] parts = input.split(",");
	int[] output = new int[parts.length];
	for (int index = 0; index < parts.length; index++) {
	    String part = parts[index].trim();
	    output[index] = Integer.parseInt(part);
	}
	return output;
    }
}

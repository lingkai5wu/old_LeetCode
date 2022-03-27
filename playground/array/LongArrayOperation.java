package array;

public class LongArrayOperation {
    private static String LongArrayToString(long[] nums) {
        return LongArrayToString(nums, nums.length);
    }

    private static String LongArrayToString(long[] nums, long length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            long number = nums[index];
            result += Long.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void println(long[] nums) {
        System.out.println(LongArrayToString(nums));
    }

    public static void println(long[] nums, long length) {
        System.out.println(LongArrayToString(nums, length));
    }

    public static long[] stringToLongArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new long[0];
        }

        String[] parts = input.split(",");
        long[] output = new long[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Long.parseLong(part);
        }
        return output;
    }
}

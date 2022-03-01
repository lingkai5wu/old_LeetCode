package convert;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String s = "0123456789";
		int numRows = 4;
		System.out.println(new Solution().convert(s, numRows));
	}

	public String convert(String s, int numRows) {
		int n = s.length();
		if (numRows == 1 || n == 1) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		int part = 2 * numRows - 2;
		for (int row = 0; row < numRows; row++) {
			if (row == 0 || row == numRows - 1) {
				int i = row;
				while (i < n) {
					sb.append(s.charAt(i));
					i += part;
				}
			} else {
				int i = row, j = part - row;
				while (i < n || j < n) {
					if (i < n) {
						sb.append(s.charAt(i));
						i += part;
					}
					if (j < n) {
						sb.append(s.charAt(j));
						j += part;
					}
				}
			}
		}
		return sb.toString();
	}
}

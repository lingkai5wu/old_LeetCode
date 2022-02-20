package reversePrefix;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		String word = "abcdefd";
		char ch = 'd';
		System.out.println(new Solution().reversePrefix(word, ch));
	}

	public String reversePrefix(String word, char ch) {
		int idx = word.indexOf(ch);
		if (idx > -1) {
			char[] arr = word.toCharArray();
			int l = 0, r = idx;
			while (l < r) {
				char temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				l++;
				r--;
			}
			word = new String(arr);
		}
		return word;
	}
}

package isValid;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String s = "()[]{}";
		System.out.println(new Solution().isValid(s));
	}

	public boolean isValid(String s) {
		Deque<Character> st = new LinkedList<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				st.push(')');
			} else if (ch == '[') {
				st.push(']');
			} else if (ch == '{') {
				st.push('}');
			} else if (st.isEmpty() || ch != st.pop()) {
				return false;
			}
		}
		return st.isEmpty();
	}
}

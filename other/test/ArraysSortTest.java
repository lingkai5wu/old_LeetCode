package test;

import java.util.Arrays;

import array.StringArrayOperation;

public class ArraysSortTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		String[] words = { "aaa", "aab", "cc" };
		Arrays.sort(words, (a, b) -> {
			if (a.length() != b.length()) {
				return b.length() - a.length();
			}
			return a.compareTo(b);
		});
		StringArrayOperation.println(words);
	}

}

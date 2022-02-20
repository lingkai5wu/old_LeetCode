package strStr;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		String haystack = "hello", needle = "ll";
		System.out.println(new Solution().strStr1(haystack, needle));
		System.out.println(new Solution().strStr2(haystack, needle));
	}

	public int strStr1(String haystack, String needle) {
		int n = haystack.length(), m = needle.length();
		for (int i = 0; i + m <= n; i++) {
			boolean flag = true;
			for (int j = 0; j < m; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return i;
			}
		}
		return -1;
	}

	// KMP �㷨
	// ss: ԭ��(string) pp: ƥ�䴮(pattern)
	public int strStr2(String ss, String pp) {
		if (pp.isEmpty())
			return 0;

		// �ֱ��ȡԭ����ƥ�䴮�ĳ���
		int n = ss.length(), m = pp.length();
		// ԭ����ƥ�䴮ǰ�涼�ӿո�ʹ���±�� 1 ��ʼ
		ss = " " + ss;
		pp = " " + pp;

		char[] s = ss.toCharArray();
		char[] p = pp.toCharArray();

		// ���� next ���飬���鳤��Ϊƥ�䴮�ĳ��ȣ�next �����Ǻ�ƥ�䴮��صģ�
		int[] next = new int[m + 1];
		// ������� i = 2��j = 0 ��ʼ��i С�ڵ���ƥ�䴮���� ������ i �� 2 ��ʼ��
		for (int i = 2, j = 0; i <= m; i++) {
			// ƥ�䲻�ɹ��Ļ���j = next(j)
			while (j > 0 && p[i] != p[j + 1])
				j = next[j];
			// ƥ��ɹ��Ļ������� j++
			if (p[i] == p[j + 1])
				j++;
			// ���� next[i]����������ѭ����i++
			next[i] = j;
		}

		// ƥ����̣�i = 1��j = 0 ��ʼ��i С�ڵ���ԭ������ ��ƥ�� i �� 1 ��ʼ��
		for (int i = 1, j = 0; i <= n; i++) {
			// ƥ�䲻�ɹ� j = next(j)
			while (j > 0 && s[i] != p[j + 1])
				j = next[j];
			// ƥ��ɹ��Ļ������� j++����������ѭ���� i++
			if (s[i] == p[j + 1])
				j++;
			// ��һ��ƥ��ɹ���ֱ�ӷ����±�
			if (j == m)
				return i - m;
		}

		return -1;
	}
}

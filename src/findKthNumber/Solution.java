package findKthNumber;

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		int n = 13, k = 2;
		System.out.println(new Solution().findKthNumber(n, k));
	}

	public int findKthNumber(int n, int k) {
		// ��Ϊָ�룬ָ��ǰ����λ�á���p==kʱ��Ҳ���ǵ�����λ��k����
		int p = 1;
		int prefix = 1;

		while (p < k) {
			int count = getCount(prefix, n);
			if (p + count > k) {
				prefix *= 10;
				p++;
			} else {
				prefix++;
				p += count;
			}
		}
		return prefix;
	}

	int getCount(int prefix, int n) {
		long cur = prefix;
		long next = prefix + 1;
		int count = 0;

		while (cur <= n) {
			count += Math.min(next, n + 1) - cur;
			cur *= 10;
			next *= 10;
		}
		return count;
	}
}

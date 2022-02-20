package addTwoNumbers;

import list.LinkedListOperation;
import list.ListNode;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		ListNode l1 = LinkedListOperation.stringTo("[2,4,3]");
		ListNode l2 = LinkedListOperation.stringTo("[5,6,4]");

		ListNode res = new Solution().addTwoNumbers(l1, l2);

		LinkedListOperation.println(res);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode h = new ListNode(), t = h;
		int n = 0;
		while (l1 != null || l2 != null || n != 0) {
			if (l1 != null) {
				n += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				n += l2.val;
				l2 = l2.next;
			}
			t.next = new ListNode(n % 10);
			t = t.next;
			n /= 10;
		}
		return h.next;
	}
}

package detectCycle;

import list.LinkedListOperation;
import list.ListNode;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		ListNode head = LinkedListOperation.stringTo("[3,2,0,-4]");
		int pos = 1;
		if (pos >= 0) {
			ListNode p = head;
			for (int i = 0; i < pos; i++) {
				p = p.next;
			}
			ListNode q = p;
			while (q.next != null) {
				q = q.next;
			}
			q.next = p;

		}
		ListNode res = new Solution().detectCycle(head);
		System.out.println(res == null ? null : res.val);
	}

	public ListNode detectCycle(ListNode head) {
		ListNode p = head, q = p;
		while (q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
			if (p == q) {
				break;
			}
		}
		if (q == null || q.next == null) {
			return null;
		}

		p = head;
		while (p != q) {
			p = p.next;
			q = q.next;
		}
		return q;
	}
}

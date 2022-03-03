package removeNthFromEnd;

import list.LinkedListOperation;
import list.ListNode;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		ListNode head = LinkedListOperation.stringTo("[1,2,3,4,5]");
		int n = 2;
		LinkedListOperation.println(new Solution().removeNthFromEnd(head, n));
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0, head);
		ListNode p = dummy;
		ListNode q = head;
		for (int i = 0; i < n; i++) {
			q = q.next;
		}
		while (q != null) {
			q = q.next;
			p = p.next;
		}
		p.next = p.next.next;
		return dummy.next;
	}
}

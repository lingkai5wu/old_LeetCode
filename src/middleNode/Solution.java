package middleNode;

import list.LinkedListOperation;
import list.ListNode;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		ListNode head = LinkedListOperation.stringTo("[1,2,3,4,5]");
		System.out.println(new Solution().middleNode(head).val);
	}

	public ListNode middleNode(ListNode head) {
		ListNode p = head, q = p;
		while (q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
		}
		return p;
	}
}

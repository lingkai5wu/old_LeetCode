package mergeTwoLists;

import list.LinkedListOperation;
import list.ListNode;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		ListNode l1, l2;

		l1 = LinkedListOperation.stringTo("[1,2,4]");
		l2 = LinkedListOperation.stringTo("[1,3,4]");
		LinkedListOperation.println(new Solution().mergeTwoLists1(l1, l2));

		l1 = LinkedListOperation.stringTo("[1,2,4]");
		l2 = LinkedListOperation.stringTo("[1,3,4]");
		LinkedListOperation.println(new Solution().mergeTwoLists2(l1, l2));
	}

	public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
		ListNode h = new ListNode(), t = h;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				t.next = list1;
				list1 = list1.next;
			} else {
				t.next = list2;
				list2 = list2.next;
			}
			t = t.next;
		}
		t.next = list1 == null ? list2 : list1;
		return h.next;
	}

	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) {
			l1.next = mergeTwoLists2(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists2(l1, l2.next);
			return l2;
		}
	}
}

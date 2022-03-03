package mergeKLists;

import java.util.PriorityQueue;

import list.LinkedListOperation;
import list.ListNode;

public class Solution {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String[] strs = { "[1,4,5]", "[1,3,4]", "[2,6]" };
		ListNode[] lists1 = new ListNode[strs.length];
		ListNode[] lists2 = new ListNode[strs.length];
		for (int i = 0; i < strs.length; i++) {
			lists1[i] = LinkedListOperation.stringTo(strs[i]);
			lists2[i] = LinkedListOperation.stringTo(strs[i]);
		}
		LinkedListOperation.println(new Solution().mergeKLists1(lists1));
		LinkedListOperation.println(new Solution().mergeKLists2(lists2));
	}

	public ListNode mergeKLists1(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		ListNode dummy = new ListNode(-1), p = dummy;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
		for (ListNode head : lists) {
			if (head != null)
				pq.add(head);
		}

		while (!pq.isEmpty()) {
			// 获取最小节点，接到结果链表中
			ListNode node = pq.poll();
			p.next = node;
			if (node.next != null) {
				pq.add(node.next);
			}
			// p 指针不断前进
			p = p.next;
		}
		return dummy.next;
	}

	public ListNode mergeKLists2(ListNode[] lists) {
		return merge(lists, 0, lists.length - 1);
	}

	ListNode merge(ListNode[] lists, int i, int j) {
		if (i == j) {
			return lists[i];
		}
		if (i > j) {
			return null;
		}

		int mid = (i + j) >> 1;
		return mergeTwoLists(merge(lists, i, mid), merge(lists, mid + 1, j));
	}

	ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(-1), p = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				p.next = list1;
				list1 = list1.next;
			} else {
				p.next = list2;
				list2 = list2.next;
			}
			p = p.next;
		}
		p.next = list1 != null ? list1 : list2;
		return dummy.next;
	}
}

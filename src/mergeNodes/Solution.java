package mergeNodes;

import list.LinkedListOperation;
import list.ListNode;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        ListNode head = LinkedListOperation.stringTo("[0,1,0,3,0,2,2,0]");
        LinkedListOperation.println(new Solution().mergeNodes(head));
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode h = head, t = h.next;
        while (t != null) {
            int sum = 0;
            while (t.val != 0) {
                sum += t.val;
                t = t.next;
            }
            h.next = new ListNode(sum);
            t = t.next;
            h.next.next = t;
            h = h.next;
        }
        t = null;
        return head.next;
    }
}

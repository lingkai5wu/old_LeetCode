package allOne;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {
    class Node {
        int cnt;
        Set<String> set = new HashSet<>();
        Node left, right;

        Node(int cnt) {
            this.cnt = cnt;
        }
    }

    Node hh, tt;
    Map<String, Node> map = new HashMap<>();

    public AllOne() {
        hh = new Node(-1);
        tt = new Node(-1);
        hh.right = tt;
        tt.left = hh;
    }

    void clear(Node node) {
        if (node.set.size() == 0) {
            node.left.right = node.right;
            node.right.left = node.left;
        }
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.set.remove(key); // 移出原 node set 中的 key
            int cnt = node.cnt;
            Node next;
            if (node.right.cnt == cnt + 1) { // 已有 node
                next = node.right;
            } else {
                next = new Node(cnt + 1);
                next.right = node.right;
                next.left = node;
                next.right.left = next;
                node.right = next;
            }
            next.set.add(key);
            map.put(key, next);
            clear(node);
        } else {
            Node node;
            if (hh.right.cnt == 1) {
                node = hh.right;
            } else {
                node = new Node(1);
                node.right = hh.right;
                node.left = hh;
                hh.right.left = node;
                hh.right = node;
            }
            node.set.add(key);
            map.put(key, node);
        }
    }

    public void dec(String key) {
        Node node = map.get(key);
        node.set.remove(key); // 移出 node set 中的 key
        int cnt = node.cnt;
        if (cnt == 1) {
            map.remove(key);
        } else {
            Node prev;
            if (node.left.cnt == cnt - 1) { // 已有 node
                prev = node.left;
            } else {
                prev = new Node(cnt - 1);
                prev.right = node;
                prev.left = node.left;
                node.left.right = prev;
                node.left = prev;
            }
            prev.set.add(key);
            map.put(key, prev);
        }
        clear(node);
    }

    public String getMaxKey() {
        Node node = tt.left;
        for (String str : node.set) {
            return str;
        }
        return "";
    }

    public String getMinKey() {
        Node node = hh.right;
        for (String str : node.set) {
            return str;
        }
        return "";
    }
}

public class Solution {
    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey()); // 返回 "hello"
        System.out.println(allOne.getMinKey()); // 返回 "hello"
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey()); // 返回 "hello"
        System.out.println(allOne.getMinKey()); // 返回 "leet"
    }

}

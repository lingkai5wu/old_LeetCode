package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeOperation {
    public static Node stringTo(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        Node root = new Node(Integer.parseInt(item));
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 2;
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();

            List<Node> children = new ArrayList<>();
            while (true) {
                if (index == parts.length) {
                    break;
                }
                item = parts[index++];
                item = item.trim();
                if (item.equals("null")) {
                    break;
                }
                int childNumber = Integer.parseInt(item);
                Node child = new Node(childNumber);
                nodeQueue.add(child);
                children.add(child);
            }
            node.children = children;
        }
        return root;
    }
}

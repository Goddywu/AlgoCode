package c116_填充每个节点的下一个右侧节点指针;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
public class Main {

    // === 1. 第一反应 ===

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        int count = 0;
        int cap = 1;
        queue.offer(root);
        Node tmp = null;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            count ++;
            if (count == cap) {
                cap *= 2;
                n.next = null;
            } else {
                n.next = tmp;
            }
            if (n.right != null) queue.offer(n.right);
            if (n.left != null) queue.offer(n.left);
            tmp = n;
        }
        return root;
    }

    // === 2. better way ===

    public Node connect2(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                if (i < size - 1) {
                    n.next = queue.peek();
                } else {
                    n.next = null;
                }
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
        }
        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}

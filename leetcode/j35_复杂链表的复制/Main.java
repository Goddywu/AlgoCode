package j35_复杂链表的复制;

import entity.Node;

import java.util.HashMap;

// https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
public class Main {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        return copyRandomList(map, head);
    }

    private Node copyRandomList(HashMap<Node, Node> map, Node node) {
        if (node == null) return null;
        if (!map.containsKey(node)) {
            Node newNode = new Node(node.val);
            map.put(node, newNode);
            newNode.next = copyRandomList(map, node.next);
            newNode.random = copyRandomList(map, node.random);
        }
        return map.get(node);
    }
}

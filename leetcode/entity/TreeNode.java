package entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode ofIntegers(Integer... array) {
        return ofArray(array);
    }

    public static TreeNode ofArray(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        int idx = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (idx < array.length) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }

            if (array[idx] == null) {
                node.left = null;
            } else {
                node.left = new TreeNode(array[idx]);
            }
            queue.offer(node.left);
            idx++;

            if (idx >= array.length) {
                break;
            }
            if (array[idx] == null) {
                node.right = null;
            } else {
                node.right = new TreeNode(array[idx]);
            }
            queue.offer(node.right);
            idx++;
        }
        return root;
    }

    public Integer[] toArray() {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left == null && node.right == null) {
                continue;
            }
            if (node.left != null) {
                queue.offer(node.left);
            } else {
                ans.add(null);
            }
            if (node.right != null) {
                queue.offer(node.right);
            } else {
                ans.add(null);
            }
        }
        return ans.toArray(new Integer[0]);
    }
}
package c1_1000.c226_翻转二叉树;

import entity.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-24
 */
public class Main {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.ofIntegers(4, 2, 7, 1, 3, 6, 9);
        TreeNode treeAns1 = invertTree(tree1);
        System.out.println(Arrays.toString(treeAns1.toArray())); // [4,7,2,9,6,3,1]

        TreeNode tree2 = TreeNode.ofIntegers(2,1,3);
        TreeNode treeAns2 = invertTree(tree2);
        System.out.println(Arrays.toString(treeAns2.toArray())); // [2,3,1]

        TreeNode tree3 = TreeNode.ofIntegers();
        TreeNode treeAns3 = invertTree(tree3);
        System.out.println(Arrays.toString(treeAns3.toArray())); // []
    }
}

package 二叉树.order2_中序遍历;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-20
 * leetcode 94 https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 */
public class Main {

    /**
     * 递归
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    public static void inorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, result);
        result.add(node.val);
        inorderTraversal(node.right, result);
    }

    /**
     * 迭代
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);

        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> trees = Arrays.asList(
                TreeNode.ofArray(new Integer[]{11, 21, 22, 31, 32, 33, 34}), // [31, 21, 32, 11, 33, 22, 34]
                TreeNode.ofArray(new Integer[]{1, null, 2, 3}), // [1,3,2]
                TreeNode.ofArray(new Integer[]{}), // []
                TreeNode.ofArray(new Integer[]{1}) // [1]
        );

        for (int i = 0; i < trees.size(); i++) {
            System.out.println("--- tree" + (i + 1) + " ---");
            TreeNode tree = trees.get(i);
            System.out.println("1:" + inorderTraversal(tree));
            System.out.println("2:" + inorderTraversal2(tree));
        }
    }
}

package 二叉树.order3_后序遍历;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-20
 * leetcode 145 https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
 */
public class Main {

    /**
     * 递归
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    public static void postorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left, result);
        postorderTraversal(node.right, result);
        result.add(node.val);
    }

    /**
     * 迭代
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
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
            node = node.right;
        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> trees = Arrays.asList(
                TreeNode.ofArray(new Integer[]{11, 21, 22, 31, 32, 33, 34}), // [31, 32, 21, 33, 34, 22, 11]
                TreeNode.ofArray(new Integer[]{1, null, 2, 3}), // [3,2,1]
                TreeNode.ofArray(new Integer[]{}), // []
                TreeNode.ofArray(new Integer[]{1}) // [1]
        );

        for (int i = 0; i < trees.size(); i++) {
            System.out.println("--- tree" + (i + 1) + " ---");
            TreeNode tree = trees.get(i);
            System.out.println("1:" + postorderTraversal(tree));
            System.out.println("2:" + postorderTraversal2(tree));
        }
    }
}

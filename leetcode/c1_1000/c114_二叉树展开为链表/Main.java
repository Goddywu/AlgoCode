package c1_1000.c114_二叉树展开为链表;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-25
 */
public class Main {

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }

        for (int i = 0; i < list.size() - 1; i ++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.ofIntegers(1, 2, 5, 3, 4, null, 6);
        flatten(tree1);
        System.out.println(Arrays.toString(tree1.toArray()));
    }
}

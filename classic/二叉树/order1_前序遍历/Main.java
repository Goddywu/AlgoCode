package 二叉树.order1_前序遍历;

import entity.TreeNode;

import java.util.*;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-20
 * leetcode 144 https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 */
public class Main {

    /**
     * 递归
     * 时间复杂度O(n)，空间复杂度O(n)
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorderTraversal(root, result);
        return result;
    }

    private static void preorderTraversal(TreeNode node, List<Integer> result) {
        result.add(node.val);
        if (node.left != null) {
            preorderTraversal(node.left, result);
        }
        if (node.right != null) {
            preorderTraversal(node.right, result);
        }
    }

    /**
     * 递归，简写
     * 时间复杂度O(n)，空间复杂度O(n)
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal2(root, result);
        return result;
    }

    private static void preorderTraversal2(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preorderTraversal2(node.left, result);
        preorderTraversal2(node.right, result);
    }

    /**
     * 栈，记录中间值，存放进栈等着用右边
     * 时间复杂度O(n)，空间复杂度O(n)
     */
    public static List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;
        }
        return result;
    }

    /**
     * Morris遍历
     * 时间复杂度O(n)，空间复杂度O(1)
     */
    public static List<Integer> preorderTraversal4(TreeNode root) {
        /*
            1. 新建临时节点，令该节点为 root；
            2. 如果当前节点的左子节点为空，将当前节点加入答案，并遍历当前节点的右子节点；
            3. 如果当前节点的左子节点不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点：
            4. 如果前驱节点的右子节点为空，将前驱节点的右子节点设置为当前节点。然后将当前节点加入答案，并将前驱节点的右子节点更新为当前节点。当前节点更新为当前节点的左子节点。
            5. 如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空。当前节点更新为当前节点的右子节点。
            6. 重复步骤 2 和步骤 3，直到遍历结束。
         */
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // https://leetcode.cn/problems/binary-tree-preorder-traversal/solutions/87526/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
        // https://leetcode.cn/problems/binary-tree-preorder-traversal/solutions/461821/er-cha-shu-de-qian-xu-bian-li-by-leetcode-solution/

        return result;
    }

    /**
      * 遍历
      */
    public List<Integer> preorderTraversal4(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> trees = Arrays.asList(
                TreeNode.ofArray(new Integer[]{11, 21, 22, 31, 32, 33, 34}), // [11, 21, 31, 32, 22, 33, 34]
                TreeNode.ofArray(new Integer[]{1, null, 2, 3}), // [1,2,3]
                TreeNode.ofArray(new Integer[]{}), // []
                TreeNode.ofArray(new Integer[]{1}), // [1]
                TreeNode.ofArray(new Integer[]{1, 2}), // [1,2]
                TreeNode.ofArray(new Integer[]{1, null, 2}), // [1,2]
                TreeNode.ofArray(new Integer[]{1, 4, 3, 2}) // [1,4,2,3]
        );

        for (int i = 0; i < trees.size(); i++) {
            System.out.println("--- tree" + (i + 1) + " ---");
            TreeNode tree = trees.get(i);
            System.out.println("1:" + preorderTraversal(tree));
            System.out.println("2:" + preorderTraversal2(tree));
            System.out.println("3:" + preorderTraversal3(tree));
            System.out.println("4:" + preorderTraversal4(tree));
        }
    }
}

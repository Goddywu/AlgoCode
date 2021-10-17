package c1_1000.c230_二叉搜索树中第K小的元素;

import entity.TreeNode;

import java.util.*;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-13
 */
public class Main {

    ////////////////////// 笨办法，都放到数组中，再取 /////////////////////////////////////

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        putToQueue(list, root);
        return list.get(k - 1);
    }

    private static void putToQueue(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            putToQueue(list, node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            putToQueue(list, node.right);
        }
    }

    ////////////////////// 存个类来处理 /////////////////////////////////////

    public static int kthSmallest2(TreeNode root, int k) {
        int[] collect = new int[]{0, 0};
        findKth(root, k, collect);
        return collect[1];
    }

    private static void findKth(TreeNode node, int k, int[] collect) {
        if (collect[0] == k) {
            collect[1] = node.val;
            return;
        }

        if (node.left != null) {
            findKth(node.left, k, collect);
        }
        collect[0] += 1;
        if (collect[0] == k) {
            collect[1] = node.val;
            return;
        }
        if (node.right != null) {
            findKth(node.right, k, collect);
        }
    }

    public static void main(String[] args) {
        // k=1,答案：1
        TreeNode tree1 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        // k=3,答案：3
        TreeNode tree2 = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        // k=2,答案：2
        TreeNode tree3 = new TreeNode(1, null, new TreeNode(2));

        System.out.println("------method1----");
        System.out.println(kthSmallest(tree1, 1));
        System.out.println(kthSmallest(tree2, 3));
        System.out.println(kthSmallest(tree3, 2));

        System.out.println("------method2----");
        System.out.println(kthSmallest2(tree1, 1));
        System.out.println(kthSmallest2(tree2, 3));
        System.out.println(kthSmallest2(tree3, 2));
    }
}

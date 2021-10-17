package c1_1000.c530_二叉搜索树的最小绝对差;

import entity.TreeNode;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-14
 */
public class Main {

    public static int getMinimumDifference(TreeNode root) {
        int[] collect = new int[]{-1, Integer.MAX_VALUE}; // 上一个值，最佳答案
        getMinimumDifference(root, collect);
        return collect[1];
    }

    private static void getMinimumDifference(TreeNode node, int[] collect) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            getMinimumDifference(node.left, collect);
        }
        if (collect[0] != -1) {
            collect[1] = Math.min(collect[1], Math.abs(collect[0] - node.val));
        }
        collect[0] = node.val;
        if (node.right != null) {
            getMinimumDifference(node.right, collect);
        }
    }

    public static void main(String[] args) {
        // 1
        TreeNode tree1 = TreeNode.ofArray(new Integer[]{4, 2, 6, 1, 3});
        // 1
        TreeNode tree2 = TreeNode.ofArray(new Integer[]{1, 0, 48, null, null, 12, 49});
        // 9
        TreeNode tree3 = TreeNode.ofArray(new Integer[]{236, 104, 701, null, 227, null, 911});

        System.out.println(getMinimumDifference(tree1));
        System.out.println(getMinimumDifference(tree2));
        System.out.println(getMinimumDifference(tree3));

        /*
                    236
             104           701
            1   227      248    911


         */


    }
}

package c1_1000.c108_将有序数组转换为二叉搜索树;

import entity.TreeNode;

import java.util.Arrays;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-24
 */
public class Main {

    /**
     * 递归
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }

        int half = left + (right - left) / 2; // (left + right + 1) / 2;
        TreeNode node = new TreeNode(nums[half]);
        node.left = sortedArrayToBST(nums, left, half - 1);
        node.right = sortedArrayToBST(nums, half + 1, right);
        return node;
    }


    public static void main(String[] args) {
        TreeNode tree1 = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(Arrays.toString(tree1.toArray())); // [0,-3,9,-10,null,5] 或 [0,-10,5,null,-3,null,9]

        TreeNode tree2 = sortedArrayToBST(new int[]{1, 3});
        System.out.println(Arrays.toString(tree2.toArray())); // [3,1] 或 [1,null,3]
    }
}

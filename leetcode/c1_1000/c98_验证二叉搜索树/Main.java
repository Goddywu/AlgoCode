package c1_1000.c98_验证二叉搜索树;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // == 1. 递归

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    // == 2. 中序

    public boolean isValidBST2(TreeNode root) {
        List<Long> nums = new ArrayList<>();
        isValidBST2(root, nums);
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void isValidBST2(TreeNode node, List<Long> nums) {
        if (node == null) return;
        isValidBST2(node.left, nums);
        nums.add((long) node.val);
        isValidBST2(node.right, nums);
    }

}

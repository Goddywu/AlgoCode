package c416_分割等和子集;

public class Main {
    public boolean canPartition(int[] nums) {
        int count = 0;
        for (int n : nums) {
            count += n;
        }
        if (count % 2 != 0) return false;
        return findSum(nums, count / 2);
    }

    private boolean findSum(int[] nums, int count) {
        // FIXME 背包问题
        return false;
    }
}

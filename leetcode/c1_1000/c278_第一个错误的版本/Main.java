package c1_1000.c278_第一个错误的版本;

// https://leetcode-cn.com/problems/first-bad-version/
public class Main {

    private boolean isBadVersion(int n) {
        return false;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int half = left + (right - left) / 2;
            if (isBadVersion(half)) {
                right = half;
            } else {
                left = half + 1;
            }
        }
        return left;
    }
}

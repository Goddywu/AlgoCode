package c189_旋转数组;

public class Main {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        int[] copy = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = copy[i];
        }
    }
}

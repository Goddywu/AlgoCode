package c679_24点游戏;

public class Main {

    public static void main(String[] args) {

        System.out.println(judge(new int[] {}));
    }

    public static boolean judge(int[] nums) {
        if (nums.length == 0) return false;
        if (nums.length == 1) return 24 == nums[0];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                // fixme:
            }
        }
        return false;
    }
}

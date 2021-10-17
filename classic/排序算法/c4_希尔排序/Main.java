package 排序算法.c4_希尔排序;

import java.util.Arrays;

public class Main {

    /**
     * 1. 把所有数据分成n组，一般是总数/2组
     * 2. 组内走插入排序
     * 3. 把所有数据重新分为n/2组，排序，直至所有数据分为1组
     */
    public static int[] shellSort(int[] nums) {
        for (int groupNum = nums.length / 2; groupNum >= 1; groupNum /= 2) {
            for (int i = groupNum; i < nums.length; i++) {
                int val = nums[i];
                int cur = i;
                while (cur >= groupNum && nums[cur - groupNum] > val) {
                    nums[cur] = nums[cur - groupNum];
                    cur -= groupNum;
                }
                nums[cur] = val;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                shellSort(new int[]{3, 2, 6, 4, 2, 1, 9, 3})));
    }
}

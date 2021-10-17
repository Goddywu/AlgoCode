package c1_1000.c167_两数之和_输入有序数组;

public class Main {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target)
                return new int[]{left + 1, right + 1};
            else if (sum > target)
                right--;
            else
                left++;
        }
        return new int[]{};
    }
}

/**
 * https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4
 */
public class Main {

  public static int maxLength(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = -1;
        for (int right = 0; right < arr.length; right++) {
            int num = arr[right];
            if (map.containsKey(num)) {
                Integer pos = map.get(num);
                left = Math.max(left, pos);
            }
            maxLen = Math.max(right - left, maxLen);
            map.put(num, right);
        }
        return maxLen;
    }


    public static void main(String[] args) {

        System.out.println(maxLength(new int[]{2, 2, 3, 4, 3})); // 3
        System.out.println(maxLength(new int[]{1, 2, 3, 1, 2, 3, 2, 2})); // 3
        System.out.println(maxLength(new int[]{2, 2, 3, 4, 8, 99, 3})); // 5

    }
}

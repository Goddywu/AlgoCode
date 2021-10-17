package c1_1000.c274_H指数;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-30
 */
public class Main {

    public static int hIndex(int[] citations) {
        sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
    }

    private static void sort(int[] citations) {
        for (int i = 0; i < citations.length; i++) {
            for (int j = i + 1; j < citations.length; j++) {
                if (citations[i] > citations[j]) {
                    int tmp = citations[i];
                    citations[i] = citations[j];
                    citations[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5})); // 3
        System.out.println(hIndex(new int[]{1, 3, 1})); // 1
    }
}

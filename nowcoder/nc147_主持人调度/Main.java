public class Main {

    /**
     * 按进出来排序，看最大进了多少个
     */
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        int len = startEnd.length;
        int[] inArr = new int[len];
        int[] outArr = new int[len];
        for (int i = 0; i < len; i++) {
            inArr[i] = startEnd[i][0];
            outArr[i] = startEnd[i][1];
        }
        Arrays.sort(inArr);
        Arrays.sort(outArr);

        int i = 0;
        int j = 0;
        int count = 0;
        int maxCount = 0;
        while (i < len && j < len) {
            if (inArr[i] < outArr[j]) {
                count++;
                maxCount = Math.max(count, maxCount);
                i++;
            } else {
                count--;
                j++;
            }
        }
        return maxCount;
    }


}

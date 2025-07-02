public class Main {

    /**
     * 迭代
     * []
     * [], [1]
     * [], [1], [2], [1, 2]
     * [], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]
     * 每层多一倍
     */
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int num : S) {
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> list = new ArrayList<>(ans.get(i));
                list.add(num);
                ans.add(list);
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        System.out.println(subsets(new int[]{1, 2, 3})); // [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
        System.out.println(subsets(new int[]{}));


    }
  
}

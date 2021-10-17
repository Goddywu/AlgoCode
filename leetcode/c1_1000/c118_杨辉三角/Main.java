package c1_1000.c118_杨辉三角;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-08
 */
public class Main {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> oldRow = result.get(i - 1);
            for (int j = 1; j < oldRow.size(); j++) {
                row.add(oldRow.get(j) + oldRow.get(j - 1));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(5));
    }
}

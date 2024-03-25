package c1_1000.c119_杨辉三角;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> ans = new LinkedList<>();
        rowIndex += 1;
        while (rowIndex-- > 0) {
            int size = ans.size();
            ans.offer(1);
            while (size-- > 0) {
                int num = ans.poll();
                if (size > 0)
                    ans.offer(num + ans.peek());
                else
                    ans.offer(num);
            }
        }
        return ans;
    }

  public static void main(String[] args) {
    getRow(3);
  }
}

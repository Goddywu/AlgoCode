package c1_1000.c6_z字形变换;

import java.util.Arrays;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-18
 */
public class Main {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            sbs[Math.abs(index)].append(s.charAt(i));
            index++;
            if (index == numRows) {
                index = - numRows + 2;
            }
        }
        for (int i = 1; i < sbs.length; i++) {
            sbs[0].append(sbs[i].toString());
        }
        return sbs[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
        System.out.println(convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
        System.out.println(convert("A", 1)); // A
        System.out.println(convert("AB", 1));
    }
}

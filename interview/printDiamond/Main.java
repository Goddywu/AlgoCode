import java.util.*;

public class Main {


    /**
     *     *
     *    ***
     *   *****
     *    ***
     *     *
     */
    public static void printDiamond(int num) {
        for (int i = 0; i < num; i++) {
            printBlank(num - i - 1);
            printStar(2 * i + 1);
            System.out.println();
        }
        for (int i = num - 2; i >= 0; i--) {
            printBlank(num - i - 1);
            printStar(2 * i + 1);
            System.out.println();
        }
    }

    private static void printBlank(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    private static void printStar(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
    }




    public static void main(String[] args) {

        printDiamond(3);


    }
}

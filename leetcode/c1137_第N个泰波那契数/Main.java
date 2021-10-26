package c1137_第N个泰波那契数;

public class Main {

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int n1 = 0;
        int n2 = 1;
        int n3 = 1;
        while (n >= 3) {
            n--;
            int tmp = n3;
            n3 = n1 + n2 + n3;
            int tmp2 = n2;
            n2 = tmp;
            n1 = tmp2;
        }
        return n3;
    }

    public int tribonacci2(int n) {
        return tribonacci(n, 0, 1, 1);
    }

    private int tribonacci(int n, int n1, int n2, int n3) {
        if (n == 0) return n1;
        if (n == 1) return n2;
        if (n == 2) return n3;
        return tribonacci(n - 1, n2, n3, n1 + n2 + n3);
    }
}

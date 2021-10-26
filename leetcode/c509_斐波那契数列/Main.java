package c509_斐波那契数列;

public class Main {

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public int fib2(int n) {
        int a = 0;
        int b = 1;
        if (n == 0) return a;
        if (n == 1) return b;
        while (n > 1) {
            n--;
            int tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }
}

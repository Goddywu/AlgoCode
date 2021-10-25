package c50_Pow_x_n;

// https://leetcode-cn.com/problems/powx-n/
public class Main {

    public double myPow(double x, int n) {
        // fixme
        if (n == 0) return 0;
        else if (n == 1) return x;
        else if (n > 1) {
            double count = 1;
            for (int i = 1; i < n; i++) {
                count *= x;
            }
            return count;
        } else return 1 / myPow(x, -n);
    }
}

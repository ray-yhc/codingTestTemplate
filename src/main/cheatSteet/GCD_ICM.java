package cheatSteet;

public class GCD_ICM {


    static int icm(int x, int y) {
        return x * y / gcd(x, y);
    }

    static int gcd(int x, int y) {
        if (x < y)
            return gcd(y, x);
        if (y == 0)
            return x;
        else return gcd(y, x % y);
    }
}

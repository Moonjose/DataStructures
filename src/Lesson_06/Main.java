package Lesson_06;

public class Main {
    public static void main(String[] args) {
        //System.out.println(recursiveSum(5));
        System.out.println(recursiveHarmonicSum(2));
    }

    public static int recursiveSum(int n) {
        if(n == 1) {
            return 1;
        }
        return n + recursiveSum(n - 1);
    }

    public static double recursiveHarmonicSum(int n) {
        if (n == 1) {
            return 1.0;
        }
        return 1.0 / n + recursiveHarmonicSum(n - 1);
    }

    public static int recursivePow(int x, int k) {
        if (k == 0) {
            return 1;
        }
        return x * recursivePow(x, k - 1);
    }
}


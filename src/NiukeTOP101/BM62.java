package NiukeTOP101;

public class BM62 {
    public int Fibonacci(int n) {
        int[] fib = new int[n+1];
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
}

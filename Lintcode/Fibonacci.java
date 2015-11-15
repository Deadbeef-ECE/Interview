class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if(n == 1)   return 0;
        if(n == 2)   return 1;
        int f1 = 0, f2 = 1;
        int fib = 0;

        for(int i = 2; i <= n-1; i++){
            fib = f1 + f2;
            f1 = f2;
            f2 = fib;
        }
        return fib;
    }
}



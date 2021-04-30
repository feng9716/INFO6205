public class Question2 {
    public static void main(String[] args) {
        System.out.println(fib(4)); // 3
        System.out.println(fib(3)); // 2

        //Fib(5) = 5
        System.out.println(fib(5));
    }

    // Time Complexity O(n), access the index from 0 to n;
    // Space Complexity O(n), create an array with size n+1;
    private static int fib(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] =1;
        for(int i = 2 ; i< n+1;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

public class FibDynamic
{
  public static long fib(int n) {
    long[] dp = new long[n + 1]; // thus the last index is n
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }
  public static void main(String[] args)
  {
    System.out.println(fib(500));
  }
}
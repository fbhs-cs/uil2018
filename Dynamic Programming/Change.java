import java.util.Map;
import java.util.TreeMap;
public class Change {
  public static final int INFINITY = Integer.MAX_VALUE - 100;
  private int[] dp;
  private int change;
  private int[] values;
  public Change(int c, int[] v) {
    values = v;
    change = c;
  }
  public void run() {
    int minimumCoins = solve(change, values);
    System.out.println(minimumCoins);
    Map<Integer, Integer> coinMap = backtrack();
    System.out.println(coinMap);
  }
  public int solve(int change, int[] values) {
    dp = new int[change + 1];
    for (int i = 0; i < dp.length; i++) {
      dp[i] = INFINITY;
    }
    dp[0] = 0;
    for (int i = 1; i < dp.length; i++) {
      for (int value : values) {
        if (value <= i) {
          dp[i] = Math.min(dp[i], dp[i - value] + 1);
        }
      }
    }
    return dp[change];
  }
  
  
  public Map<Integer, Integer> backtrack() {
    int current = change;
    Map<Integer, Integer> coinMap = new TreeMap<>();
    while (current > 0) {
      for (int coin : values) {
        if (dp[current] - 1 == dp[current - coin]) {
          if (coinMap.get(coin) == null) {
            coinMap.put(coin, 1);
          } else {
            coinMap.put(coin, coinMap.get(coin) + 1);
          }
          current -= coin;
          break;
        }
      }
    }
    return coinMap;
  }
  public static void main(String[] args) {
    new Change(1795, new int[] {1, 3, 7, 8}).run();
  }
}
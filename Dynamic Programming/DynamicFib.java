import java.math.BigInteger;

public class DynamicFib
{
  public static BigInteger fib(int n)
  {
    BigInteger[] temp = new BigInteger[n+1];
    temp[0] = BigInteger.ZERO;
    temp[1] = BigInteger.ONE;
    for(int i =2;i<=n;i++)
      temp[i] = temp[i-1].add(temp[i-2]);
    return temp[n];
    
  }
  
  public static void main(String[] args)
  {
    System.out.println(fib(10000));
  }
}
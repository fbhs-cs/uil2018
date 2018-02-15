public class DynamicBinCoeff
{
  public static int binCoeff(int n, int k)
  {
    int[][] coeffs = new int[n+1][n+1];
    coeffs[0][0] = 1;
    for(int r = 1; r <= n; r++)
    {
      for(int c = 0; c<=n; c++)
      {
        if(c == 0 || c == r) //first or last
          coeffs[r][c] = 1;
        
        else
          coeffs[r][c] = coeffs[r-1][c-1] + coeffs[r-1][c];
      }
    }
    return coeffs[n][k];
  }
  
  public static void printPascal(int n)
  {
    for(int r = 0; r<=n; r++)
    {
      String out = "";
      int size = 2*n+1;
      int spaces = size / 2;
      for(int i = 0; i < spaces-r; i++)
        out += " ";
      for(int j = 0; j <= r; j++)
      {
        out += binCoeff(r,j) + " ";
      }
      System.out.println(out);
    }
  }
  public static void main(String[] args)
  {
    printPascal(10);
  }
}

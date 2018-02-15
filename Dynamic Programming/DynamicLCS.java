public class DynamicLCS
{
  public static int lcs(String s1, String s2)
  {
    char[] x = s1.toCharArray();
    char[] y = s2.toCharArray();
    int m = s1.length();
    int n = s2.length();
    
    int[][] L = new int[m+1][n+1];
    for(int i = 0;i<=m;i++)
    {
      for(int j =0;j<=n;j++)
      {
        if (i==0 || j == 0)
          L[i][j] = 0;
        
        else if(x[i-1] == y[j-1])
          L[i][j] = 1 + L[i-1][j-1];
        else
          L[i][j] = max(L[i-1][j],L[i][j-1]);
      }
    }
    
    return L[m][n];
    
    
  }
  
  public static void printLCS(String s1, String s2)
  {
    char[] x = s1.toCharArray();
    char[] y = s2.toCharArray();
    int m = s1.length();
    int n = s2.length();
    
    int[][] L = new int[m+1][n+1];
    
    for(int i = 0;i<=m;i++)
    {
      for(int j =0;j<=n;j++)
      {
        if (i==0 || j == 0)
          L[i][j] = 0;
        
        else if(x[i-1] == y[j-1])
          L[i][j] = 1 + L[i-1][j-1];
        else
          L[i][j] = max(L[i-1][j],L[i][j-1]);
      }
    }
    
    char[] lcs = new char[L[m][n]+1];
    int curr = L[m][n];
    int i = m;
    int j = n;
    while(i > 0 && j > 0)
    {
        if(x[i-1] == y[j-1])
        {
          lcs[curr] = x[i-1];
          i--;
          j--;
          curr--;
        }
        else if(L[i][j-1] > L[i-1][j])
        {
          j--;
        }
        else
          i--;
      
    }
    System.out.println(lcs);
  }
  
  
  public static int max(int a, int b)
  {
    return (a > b)? a : b;
  }
  
  public static void main(String[] args)
  {
    System.out.println(lcs("AGGTAB","GXTXAYB"));
    printLCS("AGGTAB","GXTXAYB");
  }
    
  
}



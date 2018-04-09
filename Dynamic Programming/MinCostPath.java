public class MinCostPath
{
  int[][] cm = {{1,2,3},
                {4,8,2},
                {1,5,3}};
  
  
  int mcp(int m, int n)
  {
    if (n < 0 || m < 0)
      return Integer.MAX_VALUE;
    
    if (m == 0 && n == 0)
      return cm[m][n];
    
    return Math.min(mcp(m-1,n-1),Math.min(mcp(m-1,n),mcp(m,n-1))) + cm[m][n];
  }
  
  public static void main(String[] args)
  {
    MinCostPath m = new MinCostPath();
    System.out.println(m.mcp(2,2));
    
  }
  
                
                  
            
  
}
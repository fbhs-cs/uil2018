public class Maze
{
    private final int TRIED = 3;
    private final int PATH = 7;

    private int[][] grid = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
                             {1,0,1,1,1,0,1,1,1,1,0,0,1},
                             {0,0,0,0,1,0,1,0,1,0,1,0,0},
                             {1,1,1,0,1,1,1,0,1,0,1,1,1},
                             {1,0,1,0,0,0,0,1,1,1,0,0,1},
                             {1,0,1,1,1,1,1,1,0,1,1,1,1},
                             {1,0,0,0,0,0,0,0,0,0,0,0,0},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1} };

    public boolean traverse(int row, int col)
    {
        boolean done = false;
        if (valid(row,col))
        {
           grid[row][col] = TRIED;
           System.out.println(this);
           //base case;
           if(row == grid.length-1 && col == grid[row].length-1) // solved
           {
             done = true;
           }
           //recursive case;
           else 
           {
             done = traverse(row,col+1); // right
             if (!done)
               done = traverse(row+1,col); //down
             if (!done)
               done = traverse(row-1,col); //up
             if (!done)
               done = traverse(row,col-1);//left
           }
           if (done) //this location is part of the final path
              grid[row][col] = PATH;
        }
        return done;
    }

    //determine if a specific location is valid
    private boolean valid(int row, int col)
    {
        boolean result = false;
 
        //check if cell is in the bounds of the matrix
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
          return false;
     
        //check if cell is not blocked and not previously tried
        if (grid[row][col] == 1) 
           result = true;

        return result;
    }
    
    
    // Attempts to recusively traverse the maze.  Inserts special 
// characters indicating locations that have been tried and 
// that eventually become part of the solution.


    
    //returns the maze as a string
    public String toString()
    {
        String result = "\n";

        for (int row=0; row < grid.length; row++)
        {
            for (int col=0; col < grid[row].length; col++)
               result += grid[row][col] + "";
            result += "\n";
        }

        return result;
    }
    
    public static void main(String[] args)
    {
      Maze m = new Maze();
      System.out.println(m);
      if(m.traverse(0,0))
        System.out.println(m);
      else
        System.out.println("No path!");
    }
}
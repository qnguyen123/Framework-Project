   

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Mouse {
    

    private char[][] maze;
    private boolean isSolved = false;
    private Solution solution;
    private Cell startingCell ;
    private Stack steps;
     private boolean noS = true;
    private boolean status = false;
   
    public Mouse (char[][] maze, int rowInp, int colInp)
    {
        
        this.maze = maze;
        solve(rowInp, colInp);
   
    }
    

    
    public void solve(int row, int col)
    {
        //take row and colum form the user to be a strating point
        startingCell = new Cell (row, col);
        Cell current = startingCell;
        maze[current.getX()][current.getY()] = ' ';
        
        
        Cell retrieved = new Cell(0,0);  
        solution = new Solution();
        //push the current open cell
        solution.push(current);
        
        
        while(!isSolved)
        {
            //find and get direction from the open cell
            retrieved = East(current);
            if(!checkSameSpot(retrieved, current))
            {
               
                current = retrieved;
                solution.push(current);
                maze[current.getX()][current.getY()] = ' ';
                isSolved = checkFinished(current);
                continue;
            }
            
            retrieved = North(current);
            if(!checkSameSpot(retrieved, current))
            {
          
                current = retrieved;
                solution.push(current);
                maze[current.getX()][current.getY()] = ' ';
                isSolved = checkFinished(current);
                continue;
            }
            
            retrieved = South(current);
            if(!checkSameSpot(retrieved, current))
            {
                current = retrieved;
                solution.push(current);
                maze[current.getX()][current.getY()] = ' ';
                isSolved = checkFinished(current);
                continue;
            }
            
            retrieved = West(current);
            if(!checkSameSpot(retrieved, current))
            {
               //maze[current.getX()][current.getY()] = 'X';
                current = retrieved;
                solution.push(current);
                maze[current.getX()][current.getY()] = ' ';
                isSolved = checkFinished(current);
                
                continue;
            }
            // if meet the dead end,  can't turn East, West, North, South, or go back, give the current cell is 2
            maze[current.getX()][current.getY()] = '2';
            solution.pop();
            current = solution.peek();
            isSolved = checkFinished(current);
           
        }
       // finish the isSolved, build the step from the Stack
        solution.buildSteps();
        steps = solution.getSteps();
    }
            
    
    public Cell North(Cell c)
    {
        if ((c.getX()-1) ==-1)
        {return c;}
        else
        {
            Cell spot = new Cell( c.getX()-1, c.getY());
            if ( checkSafe(spot))
            {
                return spot;
            }
            else
            {
                return c;
            }
        }
    }
    
     public Cell East(Cell c)
    {
         if ((c.getY()+1)  == maze.length)
        {return c;}
        else
        {
            Cell spot = new Cell( c.getX(), c.getY()+1);
            if ( checkSafe(spot))
            {
                return spot;
            }
            else
            {
                return c;
            }
        }
    }
    
     public Cell South(Cell c)
    {
         if ((c.getX() + 1) == maze.length )
        {return c;}
        else
        {
            Cell spot = new Cell( c.getX()+1, c.getY());
            if ( checkSafe(spot))
            {
                return spot;
            }
            else
            {
                return c;
            }
        }
    }
    
     public Cell West(Cell c)
    {
         if ((c.getY() - 1) == -1)
        {return c;}
        else
        {
            Cell spot = new Cell( c.getX(), c.getY()-1);
            if ( checkSafe(spot))
            {
                return spot;
            }
            else
            {
                return c;
            }
        }
    }
       
      
    //isPossible(...) is the main check - looks to see if 'nodes' have been visited or if there is a wall 
    public boolean checkSafe(Cell c)
    {
        if(maze[c.getX()][c.getY()] != 'X' && maze[c.getX()][c.getY()] == '0')
        {
            return true;
        }
        else {
            return false;
        }
    }
    
    //check if the current cell and the next Cell are the same
    public boolean checkSameSpot(Cell a, Cell b)
    {
        if((a.getX() == b.getX()) && (a.getY() == b.getY()))
        {
            
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    //check if the mouse reaches the wall = done
    public boolean checkFinished(Cell c)
    {
        if (checkSameSpot(c, startingCell))
        {
            System.out.println("No Solution");
            status = true;
            return false;
        }
        else
        {
            if (c.getY() == 0 || c.getY() == (maze.length-1) || c.getX() == 0 || c.getX() ==( maze.length-1) )
            {
                printSoln();
                return true;
               
            }
        }
        return false;
    }
    
    //print method
    public void printSoln()
    { 
        
         for(int i =0; i < maze.length; i++){
             for(int j=0; j < maze[i].length; j++){
                 if (maze[i][j] == '2')
                 {
                     maze[i][j]= '0';
                 }
                 System.out.print(maze[i][j] + " "); 
                }
              System.out.println();
            }
        
    }
}
   
	
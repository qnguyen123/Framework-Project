import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Exception;
import java.io.IOException;

public class Solver
{
 

    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        String fileName;
        MazeBuilder m;
      
        boolean finished, done = false;
        char reply;
        
        
        do
        {
            finished = false;
            System.out.print("\f");
            System.out.println("Begin Maze Program\n");
            try
            {            
                System.out.print("Enter file name (maze#.txt): ");
                fileName = in.next();
                File inFile = new File(fileName);
                m = new MazeBuilder(inFile);
                System.out.print(m.toString());  
               
                System.out.println("Hello! Your dimensions are: " + m.theMaze.length + "x" + m.theMaze.length + "\nEnter a valid starting location: ");
                   
               int rowInp = 10000;
               int colInp = 10000;
                 // the perfect loop to check if the user enter from the all or the open cell
                 while ( (rowInp != 0 || colInp != 0 || rowInp != m.theMaze.length || colInp != m.theMaze.length) ) 
                
                {
                    System.out.print("\nRow: ");
                    rowInp = (in.nextInt()-1);
        
                    System.out.print("\nColumn: ");
                    colInp = (in.nextInt()-1);
                    
                    if ((rowInp == 0 || colInp == 0 || rowInp == (m.theMaze.length-1) || colInp == (m.theMaze.length-1)) && ( m.theMaze[rowInp][colInp] != '0'))
                    {
                        System.out.println("\nSorry, ["+(rowInp+1)+", "+(colInp+1)+"] isn't an open cell.\n----------------------\nPlease enter it again:");
                    }
                        
                    else if ((rowInp == 0 || colInp == 0 || rowInp == (m.theMaze.length-1) || colInp == (m.theMaze.length-1)) &&  (m.theMaze[rowInp][colInp] == '0'))
                       {
               
                        break;
                    }
                     else if  ((rowInp != 0 && colInp != 0 && rowInp != m.theMaze.length && colInp != m.theMaze.length))
                    {
                        System.out.println("\nSorry, you didn't enter from the wall.\n---------------------\nPlease enter it again:");
                    }
                    
                
                }
               System.out.println("\n------The solution of "+fileName+": ------");
                Mouse Pathing = new Mouse(m.theMaze, rowInp, colInp);
              
            }
            catch(FileNotFoundException e)
            {
                System.out.println(e.getMessage());               
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            finally
            {
               done = !(getReply(in, "\n\nDo you wish to try again? "));
            }
        } while(!done);
        in.close();
        System.out.println("\n\nEnd Maze Solver\n\n");
    }
    
    
    public static boolean getReply(Scanner in, String message)
    {
        char ch = 'x';
        while (ch != 'Y' && ch != 'N')
        {
            System.out.print(message + " [Y]es or [N]o? ");
            ch = in.next().toUpperCase().charAt(0);
            in.nextLine();
        }
        return ch == 'Y';
    }
    
}
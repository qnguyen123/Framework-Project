import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class MazeBuilder
{
    /**  The array that contains the maze format */
    public char[][] theMaze;
    /** the maximum number of rows in the maze */
    private int maxRow;
    /** the maximum number of columns in the maze */
    private int maxCol;
    


  
    public MazeBuilder(File inFile) throws FileNotFoundException
    {
       Scanner input = new Scanner(inFile);
       maxRow = input.nextInt();
       maxCol = input.nextInt();
       input.nextLine();
       theMaze = new char[maxRow][maxCol];
       loadArray(input);
       input.close();    
    }   
    

    public void loadArray(Scanner input)
    {
        String str;
        for(int row = 0; row < maxRow; row++)
           for(int col = 0; col < maxCol; col++)
               theMaze[row][col] = input.next().charAt(0); 
        //first = true;
    }
    
   

 
    @Override
    public String toString()
    {
        String str = "\n";
        for(int row = 0; row < maxRow; row++)
        {            
            for(int col = 0; col < maxCol; col++)         
                str += (theMaze[row][col] + " ");
            str += "\n";
        }
        return str;
    }
}

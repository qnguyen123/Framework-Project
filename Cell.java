

public class Cell
{
     // variables for row and colum
    private int row;
    private int col;

    // the default the construction for the cell 
    public Cell()
    {
       row = 0;
       col = 0;
    }
    // The coppy the construction for the cell 
    
    public Cell(Cell copy)
    {
       row = copy.row;
       col = copy.col;
    }
    
    public Cell( int row, int col)
    {
      this.row = row;
      this.col = col;
    }
    
 
    public int getRow()
    { 
       return row;
    }
    
 
    public int getCol()
    { 
       return col;
    
    }
    
    public void setRow(int row)
    { 
      this.row = row;
    }
    
 
    public void setCol( int col)
    { 
      this.col =col;
    
    }
}

import java.util.Stack;

public class Solution
{
   
    private Stack solution;
    private Stack steps;
    
    public Solution()
    {
        solution = new Stack();
        steps = new Stack();
    }
    
    
    public void buildSteps()
    {   
        steps = new Stack();
        Stack tempSolution = solution;
        tempSolution = solution;
       
       
        while (!tempSolution.isEmpty())
        {
            steps.push(tempSolution.pop());
             
        }
    
    }
    
    public void push(Cell c)
    {
        solution.push(c);
    }
    
    public Cell pop()
    {
        return (Cell) solution.pop();
    }
    
    public Cell peek()
    {
        return (Cell) solution.peek();
    }
    
    public Stack getSteps()
    {
        return steps;
    }
}

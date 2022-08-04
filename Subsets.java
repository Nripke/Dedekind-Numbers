import java.util.*;

public class Subsets
{
    private ArrayList<Subset> subsets = new ArrayList<Subset>();
    
    public void start(int length)
    {
        for (int i = 1; i < (int) (Math.pow(2, length)); i++)
        {
            subsets.add(new Subset(i, generateBit(i, length)));   
        }
    }
    
    public boolean[] generateBit(int b10, int length)
    {
        boolean[] bits = new boolean[length];
        for(int i = length-1; i>=0; i--)
        {
            if (b10-Math.pow(2, i) >= 0) {bits[i] = true; b10 -= Math.pow(2, i);}
        }
        //printArray(bits);
        return bits;
    }
    
    public boolean isComp(int root, int child)
    {
        return subsets.get(root).getComp()[child];
    }
    
    public ArrayList<Subset> getSubs()
    {
        return subsets;
    }
    
    public void printArray(boolean[] arr)
    {
        for (int i = 0; i<arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}

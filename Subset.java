import java.util.*;

public class Subset
{
    private int base10;
    private boolean[] comp;
    private ArrayList<Integer> antis;
    public Subset(int b10, boolean[] bits)
    {
        base10 = b10;
        comp = new boolean[(int) Math.pow(2, bits.length)-1];
        antis = new ArrayList<Integer>();
        ArrayList<Integer> addVals = new ArrayList<Integer>();
        for (int i = 0; i<bits.length; i++)
        {
            if (!bits[i]) {addVals.add((int) Math.pow(2, i));} 
        }
        for (int i = 1; i<=addVals.size(); i++)
        {
            createComp(addVals, i, 0, b10);
        }
        comp[b10-1] = true;
        for (int i = b10-1; i<comp.length; i++)
        {
            if (!comp[i]) {antis.add(i);}
        }
        
    }
    
    public void createComp(ArrayList<Integer> vals, int length, int start, int base)
    {
        if (length == 0)
        {
            comp[base-1] = true;
            return;
        }
        for (int i = start; i<vals.size(); i++)
        {
            createComp(vals, length-1, i+1, base+vals.get(i));
        }
    }
    
    public boolean[] getComp()
    {
        return comp;
    }
    
    public ArrayList<Integer> getAntis()
    {
        return antis;
    }
}

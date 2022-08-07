import java.util.*;
import java.math.BigInteger;

public class Antichains extends Thread
{
    private BigInteger total = BigInteger.ZERO;
    private int len;
    private Subsets s;
    private int length;
    private int start;
    private ArrayList<Integer> chain;
    private int n;
    
    //For threads
    public Antichains(int start, int length, ArrayList<Integer> chain, int n)
    {
        s = new Subsets();
        s.start(n);
        len = s.getSubs().size();
        this.start = start;
        this.length = length;
        this.chain = chain;
        this.n = n;
    }
    
    public Antichains(int length)
    {
        s = new Subsets();
        s.start(length);
        len = s.getSubs().size();
    }
    
    public BigInteger getTotal()
    {
        return total;
    }
   
    public void run()
    {
        chain.add(start);
        alternateChains(chain, length-1);
        chain.remove(0);
    }
   
    public void generateChains(int length, int n)
    {
        if (length == 0) {total = total.add(BigInteger.ONE);}
        ArrayList<Antichains> threads = new ArrayList<Antichains>();
        
        for (int i = 0; i<len; i++)
        {
            Antichains thread = new Antichains(i, length, new ArrayList<Integer>(), n);
            threads.add(thread);
            thread.start();
        }
        
        for (int i = 0; i<threads.size(); i++)
        {
            while (threads.get(i).isAlive()) {};
            total = total.add(threads.get(i).getTotal());
            System.out.println("Finished Start Of: ("+i+"/"+(threads.size()-1)+")");
        }
    }
    
    public void alternateChains(ArrayList<Integer> chain, int length)
    {
        if (length == 0)
        {
            //printArray(chain);
            total = total.add(BigInteger.ONE);
            return;
        }
        //Much smarter, only choose subsets that are going to be antichains for the smallest element
        
        for (int i : s.getSubs().get(chain.get(chain.size()-1)).getAntis())
        {
            if (!isAnti(chain, i)) {continue;}
            chain.add(i);
            alternateChains(chain, length-1);
            chain.remove(chain.size()-1);
        }
    }
    
    public boolean isAnti(ArrayList<Integer> chain, int newI)
    {
        for (int i : chain)
        {
            if (s.isComp(i, newI) || s.isComp(newI, i))
            {
                return false;
            }
        }
        return true;
    }
    
    public void printArray(ArrayList<Integer> chain)
    {
        System.out.print("{");
        for (int i = 0; i<chain.size(); i++)
        {
            System.out.print("{"+chain.get(i)+"}, ");
        }
        System.out.print("}");
        System.out.println();
    }
}

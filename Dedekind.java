import java.util.*;
import java.math.BigInteger;

public class Dedekind
{
    
    public static void timedRun()
    {
        for (int n = 1; n<6; n++)
        {
            int max = (factorial(n)/(factorial(n/2)*factorial(n - n/2)));
            int times = 10000;
            long time = 0;
            for (int i = 0; i<times; i++)
            {
                time += testTime(n, max);
            }
            System.out.println("n = " + n + " : " + (time/times));
        }
    }
    
    public static void runSpecific()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = scan.nextInt();
        System.out.print("Input length: ");
        int length = scan.nextInt();
        int max = (factorial(n)/(factorial(n/2)*factorial(n - n/2))); //(n [n/2])
        
        Antichains ac = new Antichains(n);
        long start = System.nanoTime();
        
        ac.generateChains(length, n);
        System.out.println("Completed all antichains of length: (" + length + "/" + max + ")");
        System.out.print("--total: " + ac.getTotal() + "\n");
        long end = System.nanoTime();
        
        System.out.println("Time: " + (end-start));      
    }
    
    public static void run()
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int max = (factorial(n)/(factorial(n/2)*factorial(n - n/2))); //(n [n/2])
        
        Antichains ac = new Antichains(n);
        long start = System.nanoTime();
        BigInteger old = new BigInteger("1");
        System.out.println(old);
        for (int i = 1; i<=max; i++)
        {
            ac.generateChains(i, n);
            System.out.println(ac.getTotal().subtract(old));
            old = ac.getTotal();
            //System.out.println("Completed all antichains of length: (" + i + "/" + max + ")");
            //System.out.print("--total: " + ac.getTotal() + "\n");
        }
        long end = System.nanoTime();
        //System.out.println(ac.getTotal().add(new BigInteger("3")));
        //System.out.println("Time: " + (end-start));      
    }
    
    public static long testTime(int n, int max)
    {
        Antichains ac = new Antichains(n);

        long start = System.nanoTime();
        for (int i = 1; i<=max; i++)
        {
            ac.generateChains(i, n);
        }
        long end = System.nanoTime();
         
        return (end-start);
    }
    
    public static int factorial(int n)
    {
        int num = 1;
        for (int i = 2; i<=n; i++) {num *= i;}
        return num;
    }
}

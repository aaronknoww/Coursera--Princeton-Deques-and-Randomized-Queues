import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation 
{

    public static void main(String[] args)
    {
        RandomizedQueue<String> randomQ = new RandomizedQueue<String>();
        String exit = "";
        
        int k = Integer.parseInt(args[0]);
             
        randomQ.enqueue(exit);    
        //Exit with Backtick `
        while(exit.compareTo("`")!=0)
        {            
            randomQ.enqueue(exit);    
            exit = StdIn.readString();
        }        
        
        if(randomQ.size()>=k && k>=0)
         {
            for (int i = 0; i < k; i++)
                StdOut.println(randomQ.sample());
         }      
        
    }
    
}

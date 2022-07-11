import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item>
 {

    //TODO: VERIFICAR LAS EXEPCIONES POR MANDAR Y VER SI SE REVISAN LOS DATOS TIPO NULL

    private Node first;
    private Node seek;
    int count;
    

    // construct an empty randomized queue
       public RandomizedQueue()
       {            
            first=null;
            count=0;
       }
 
    // is the randomized queue empty?
    public boolean isEmpty()
    {
        if(count < 1)
            return true;
        else
            return false;
    }

    // return the number of items on the randomized queue
    public int size()
    {
        return count;
    }

    // add the item
    public void enqueue(Item item)
    {
        if(item==null)
            throw new IllegalArgumentException("An item with a null value is not permitted");
        
        if(isEmpty())
        {
            first = new Node(item);
            count++;
            return;
        }
        else
        {
            first.front=new Node(item);
            first.front.back = first;
            first = first.front;

            count++;
            return;            
        }
    }

    // remove and return a random item
    public Item dequeue()
    {
        if(count<1)
            throw new IllegalArgumentException("No items left");
            
        if(count==1)
        {
            Item it = first.item;
            first = null;
            count = 0;
            return it;
        }
        
        int ind = StdRandom.uniform(0, count-1);
        
        if(ind==0) // This is because when it's going to eliminate the first element of the structure
        {           // it's necessary to update the first pointer
        
            Item it = first.item;
            first = first.back;
            first.front = null;
            count--;
            return it;
        }
        
        seek = first;
        for (int i = 0; i < ind; i++) 
            seek = seek.back;
        
        Item it = seek.item;
        seek = seek.back;
        seek.front = seek.front.front;
        count--;
        return it;
    }

    // return a random item (but do not remove it)
    public Item sample()
    {
        if(count<1)
            throw new IllegalArgumentException("No items left");
            if(count==1)
            {
                return first.item;
            }

        int ind = StdRandom.uniform(0, count-1);
        seek = first;
        for (int i = 0; i <= ind; i++) 
            seek = seek.back;
            
        return seek.item;
    }

    // return an independent iterator over items in random order
      public Iterator<Item> iterator()
    {
        return new RandomizerIterator();
    }

    private class Node
    {
        Item item;
        Node front;
        Node back;

    
        public Node(Item i)
        {
            front = null;
            back = null;
            item = i;
        }

    }
    
    
    private class RandomizerIterator implements Iterator<Item>
    {
        private Node  current; //----->To point a element in the structure.
        private int[] indexes;//------>Array to control all index of elementes in the queue. 
        private int   remainderElm;//->To know the number of elements that remain to be traversed.
        private int   traverseIndex;//-->To traverse the array indexes.  

        RandomizerIterator()
        {
            current = first;
            indexes = new int[count];
            traverseIndex = 0;
            remainderElm =  count;

            for (int i = 0; i < indexes.length; i++)
                indexes[i]=i;            
                StdRandom.shuffle(indexes);

        }

        public boolean hasNext()
        {
            return remainderElm > 0;
        }

        public void remove()
        {
            throw new UnsupportedOperationException("This fuction is not supported");
        }

        public Item next()
        {
            if(!hasNext())
                throw new NoSuchElementException("No exist next elemnt");
           
            return findNext();
        }

        private Item findNext()
        {
            if(traverseIndex==0)
            {
                traverseIndex++;
                remainderElm--;
                return moveToBack(indexes[0]);
            }
            int res = indexes[traverseIndex] - indexes[traverseIndex-1];

            if(res>0)
            {
                traverseIndex++;
                remainderElm--;
                return moveToBack(res);
            }
            res*=-1;
            traverseIndex++;
            remainderElm--;
            return moveToFront(res);
            
        }
        private Item moveToFront(int skip)
        {
            for (int i = 0; i < skip; i++)
                    current = current.front;
            return current.item;           


        }
        private Item moveToBack(int skip)
        {
            for (int i = 0; i < skip; i++)
                    current = current.back;
            return current.item;           
        }


    }

    

    // unit testing (required)
    public static void main(String[] args)
    {
        
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();

        
        if(rq.isEmpty())
        StdOut.println("Vacio");
        
        rq.enqueue(10);
        rq.enqueue(20);
        rq.enqueue(30);
        rq.enqueue(40);
        rq.enqueue(50);

        StdOut.println("Elementos en el primer for");
        for (Integer elemnt : rq)
        {
            StdOut.println(elemnt);
            
        }
        

        StdOut.println("Elementos en el segundo for");
        for (Integer elemnt : rq)
        {
            StdOut.println(elemnt);
            
        }
        
        int a = rq.dequeue();
        int b  = rq.dequeue();
        int c = rq.dequeue();
        rq.dequeue();

        StdOut.println("a: "+ a);
        StdOut.println("b: "+ b);
        StdOut.println("c: "+ c);
        
        StdOut.println("aleatorio " + rq.sample());
        int r = rq.dequeue();
        rq.enqueue(100);
        StdOut.println(r);
        rq.dequeue();
        StdOut.println(rq.size());
      //  rq.dequeue();

            
    }

}

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
public class Deque<Item> implements Iterable<Item>
{
    private int count;
    private Node first;
    private Node last;


    // construct an empty deque
    public Deque()
    {
        count = 0;
        first = null;
        last  = null;
        
    }

    // is the deque empty?
    public boolean isEmpty()
    {
        if(count<1)
            return true;
        else
            return false;
    }

    // return the number of items on the deque
    public int size()
    {
        return count;
    }

    // add the item to the front
    public void addFirst(Item item)
    {
        if(item==null)
            throw new IllegalArgumentException("An item with a null value is not permitted");
        if(isEmpty())
        {
            first=new Node(item);
            last = first;
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

    // add the item to the back
    public void addLast(Item item)
    {
        if(item==null)
            throw new IllegalArgumentException("An item with a null value is not permitted");
        
        if(isEmpty())
        {
            first=new Node(item);
            last = first;
            count++;
            return;
        }
        else
        {
            last.back = new Node(item);
            last.back.front = last;
            last = last.back;           
            
            count++;
            return;            
        }
    }
    // remove and return the item from the front
    public Item removeFirst()
    {
        if(isEmpty())
            throw new NoSuchElementException("There aren't elements");
        if(count == 1)
        {
            Item i = first.item;
            first= null;
            last = null;
            count = 0;
            return i;             
        }
        
        Item i = first.item;
        first = first.back;
        first.front = null;
        count--;
        return i;

        
    }

    // remove and return the item from the back
    public Item removeLast()
    {
        if(isEmpty())
        throw new NoSuchElementException("There aren't elements");
        
        if(count == 1)
        {
            Item i = last.item;
            first= null;
            last = null;
            count = 0;
            return i;             
        }

        Item i = last.item;
        last = last.front;
        last.back = null;       
        count--;
        return i;

    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()
    {
        return new DoubleListIterator();
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
    
    
    private class DoubleListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext()
        {
            return current != null;
        }

        public void remove()
        {
            throw new UnsupportedOperationException("This fuction is not supported");
        }

        public Item next()
        {
            if(current==null)
                throw new NoSuchElementException("No exist next elemnt");
            Item item = current.item;
            current = current.back;
            return item;
        }
    }

    

    // unit testing (required)
    public static void main(String[] args)
    {
        
        Deque<Integer> cola = new Deque<Integer>();
        

        Integer a,b,c,d;
        a=100;
        b=90;
        c=80;
        d=50;
        

        cola.addFirst(a);
        cola.removeFirst();
        cola.addLast(d);
        cola.addFirst(b);
        cola.addLast(a);
        cola.addFirst(c);
              
       for (Integer num: cola)
       {
            StdOut.println(num);
       }

    }

}


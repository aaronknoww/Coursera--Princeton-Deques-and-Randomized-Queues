import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item>
 {

    private Node first;
    // Item[] nodes;
    int count;
    // final int maxLoad;
    // final int minLoad;

    // construct an empty randomized queue
       public RandomizedQueue()
       {
            // maxLoad = 80;
            // minLoad = 25;
            // nodes = (Item[])new Object[5];
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
    //public Item dequeue()

    // return a random item (but do not remove it)
    //public Item sample()

    // return an independent iterator over items in random order
    // public Iterator<Item> iterator()
    // {
    //     return 
    // }

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

    }

}
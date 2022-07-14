# Deques and Randomized Queues

## 1.- Dequeue.

Write a generic data type for a deque and a randomized queue. The goal of this assignment is to implement elementary data structures using arrays and linked lists, and to introduce you to generics and iterators.

Dequeue. A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue that supports adding and removing items from either the front or the back of the data structure.

Corner cases.  Throw the specified exception for the following corner cases:

Throw an IllegalArgumentException if the client calls either addFirst() or addLast() with a null argument.
Throw a java.util.NoSuchElementException if the client calls either removeFirst() or removeLast when the deque is empty.
Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
Throw an UnsupportedOperationException if the client calls the remove() method in the iterator.

## 2.- Randomized queue.

 A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random among items in the data structure. Create a generic data type RandomizedQueu

### Iterator.
  Each iterator must return the items in uniformly random order. The order of two or more iterators to the same randomized queue must be mutually independent; each iterator must maintain its own random order.

### Corner cases.  Throw the specified exception for the following corner cases:

Throw an IllegalArgumentException if the client calls enqueue() with a null argument.
Throw a java.util.NoSuchElementException if the client calls either sample() or dequeue() when the randomized queue is empty.
Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
Throw an UnsupportedOperationException if the client calls the remove() method in the iterator.

## 3.- Permutation

e a client program Permutation.java that takes an integer k as a command-line argument; reads a sequence of strings from standard input using StdIn.readString(); and prints exactly k of them, uniformly at random. Print each item from the sequence at most once.

Command-line argument.  You may assume that 0 ≤ k ≤ n, where n is the number of string on standard input. Note that you are not given n.

Performance requirements.  The running time of Permutation must be linear in the size of the input. You may use only a constant amount of memory plus either one Deque or RandomizedQueue object of maximum size at most n. (For an extra challenge and a small amount of extra credit, use only one Deque or RandomizedQueue object of maximum size at most k.)
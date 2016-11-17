package com.interviewbit.StacksAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.

Example:

Input : A : [4, 5, 2, 10]
Return : [-1, 4, -1, 2]

Example 2:

Input : A : [3, 2, 1]
Return : [-1, -1, -1]
 */
public class MinStack
{
    class Node
    {
        int value;
        int min;
        Node next;

        Node( int x, int min )
        {
            this.value = x;
            this.min = min;
            next = null;
        }
    }

    Node head;

    public void push( int x )
    {
        if ( null == head )
        {
            head = new Node( x, x );
        }
        else
        {
            Node n = new Node( x, Math.min( x, head.min ) );
            n.next = head;
            head = n;
        }
    }

    public void pop()
    {
        if ( head != null )
            head = head.next;
    }

    public int top()
    {
        if ( head != null )
            return head.value;
        return -1;
    }

    public int getMin()
    {
        if ( null != head )
            return head.min;
        return -1;
    }
}

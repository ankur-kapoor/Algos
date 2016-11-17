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
public class Nearest2
{
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) 
    {
        final ArrayList<Integer> res = new ArrayList<>();
        
        final Stack<Integer> s = new Stack<>();
        
        for( int num : arr )
        {
            while( !s.isEmpty() )
            {
                if( s.peek().intValue() >= num )
                {
                    s.pop();
                }
                else
                {
                    break;
                }
            }
            
            if( !s.empty())
            {
                res.add( s.peek());
            }
            else
            {
                res.add( -1 );
            }
            s.push( num );
        }
        
        return res;
    }
    
    public static void main( String[] args )
    {
        final Nearest2 sim = new Nearest2();
        
        Integer[] arr = {4,5,2,10};
        List<Integer> li = Arrays.asList( arr );
        
        ArrayList<Integer> aLi = new ArrayList<>(li);
        System.out.println( "Integer Nearest = " + sim.prevSmaller( aLi ) );
    }
}

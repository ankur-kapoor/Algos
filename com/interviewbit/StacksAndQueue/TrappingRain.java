package com.interviewbit.StacksAndQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.DelayQueue;

public class TrappingRain
{
    public int trap( List<Integer> a) 
    {
        int maxArea = 0;
        
        final Deque<Integer> q = new ArrayDeque<>();
        
        int n = a.size();
        
        if( n == 0 || n == 1) return 0;
        
        int i = 0;
        
        while( i < n )
        {
            if( q.isEmpty() || a.get( q.peek() ) > a.get( i ))
            {
                q.offer( i++ );
            }
            else
            {   
                int p = q.poll();
                maxArea += a.get( p ) * (i-p-1);
                while( !q.isEmpty())
                {
                    p = q.poll();
                    maxArea -= a.get( p );
                }
            }
        }
        
        final ArrayList<Integer> b = new ArrayList<>();
        
        n =0;
        while( !q.isEmpty())
        {
            b.add( a.get( q.pollLast() ) );
            n++;
        }
        
        i = 0;
        
        while( i < n )
        {
            if( q.isEmpty() || b.get( q.peek() ) > b.get( i ))
            {
                q.offer( i++ );
            }
            else
            {   
                int p = q.poll();
                maxArea += b.get( p ) * (i-p-1);
                while( !q.isEmpty())
                {
                    p = q.poll();
                    maxArea -= b.get( p );
                }
            }
        }
        
        return maxArea;
    }
    
    public static void main( String[] args )
    {
        final TrappingRain h = new TrappingRain();
        
        Integer[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        
        final ArrayList<Integer> ai = new ArrayList<>( );
        
        System.out.println( "Max Area = " + h.trap( Arrays.asList( arr ) ) );
        
    }
}

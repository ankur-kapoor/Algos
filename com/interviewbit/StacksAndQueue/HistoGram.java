package com.interviewbit.StacksAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class HistoGram
{
    public int largestRectangleArea(ArrayList<Integer> a) 
    {
        int maxArea = Integer.MIN_VALUE;
        final Stack<Integer> s = new Stack<>();
        
        int n = a.size();
        int i = 0;
        
        while( i < n )
        {
            if( s.isEmpty() || a.get( s.peek() ) <= a.get( i ))
            {
                s.push( i++ );
            }
            else
            {
                int ct = s.pop();
                
                int m = a.get( ct ) * ( s.isEmpty() ? i : i - s.peek() - 1);
                
                if( m > maxArea )
                {
                    maxArea = m;
                }
            }
        }
        
        while( !s.isEmpty())
        {
            int ct = s.pop();
            
            int m = a.get( ct ) * ( s.isEmpty() ? i : i - s.peek() - 1);
            
            if( m > maxArea )
            {
                maxArea = m;
            }
        }
        
        return maxArea;
    }
    
    public static void main( String[] args )
    {
        final HistoGram h = new HistoGram();
        
        Integer[] arr = {1,1};
        
        final ArrayList<Integer> ai = new ArrayList<>( Arrays.asList( arr ));
        
        System.out.println( "Max Area = " + h.largestRectangleArea( ai ) );
        
    }
}

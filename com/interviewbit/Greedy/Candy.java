package com.interviewbit.Greedy;

import java.util.ArrayList;
import java.util.Stack;

/**
 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 *
 */

public class Candy
{
    public int candy(int[] ratings) 
    {
        int n = ratings.length;
        
        final Stack<Integer> candies = new Stack<>();
        candies.push( ratings[0] );
        
        int res = n;
        for( int i=1; i < n; i++ )
        {
            if( ratings[i] == ratings[i-1])
            {
                if( !candies.isEmpty() && candies.peek() == ratings[i] )
                {
                    candies.pop();
                }
                continue;
            }
                
            if( !candies.isEmpty() && ratings[i] > candies.peek() )
            {
                while( !candies.isEmpty())
                {
                    if( candies.pop() < ratings[i]);
                    //res++;
                }
            }
            
            candies.push( ratings[i] );
        }
        
        if(!candies.isEmpty())
        {
            candies.pop();
        }
        
        int k =0;
        while( !candies.isEmpty())
        {
            k++;
            candies.pop();
            res += k;
        }
        
        return res;
    }
    
    public static void main( String[] args )
    {
        int[] ratings = {5,5,2};
        
        final Candy c = new Candy();
        
        System.out.println( " Min Candy = " + c.candy( ratings ) );
    }
}

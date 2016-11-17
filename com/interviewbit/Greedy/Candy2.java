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

public class Candy2
{
    public int candy(ArrayList<Integer> ratings)
    {
        if ( ratings == null || ratings.size() == 0 )
            return 0;
        int total = 1, prev = 1, countDown = 0;
        for ( int i = 1; i < ratings.size(); i++ )
        {
            if ( ratings.get( i ) >= ratings.get( i-1 ) )
            {
                if ( countDown > 0 )
                {
                    total += countDown * ( countDown + 1 ) / 2; // arithmetic progression
                    if ( countDown >= prev )
                        total += countDown - prev + 1;
                    countDown = 0;
                    prev = 1;
                }
                prev = ratings.get( i ) == ratings.get( i-1 ) ? 1 : prev + 1;
                total += prev;
            }
            else
                countDown++;
        }
        if ( countDown > 0 )
        { // if we were descending at the end
            total += countDown * ( countDown + 1 ) / 2;
            if ( countDown >= prev )
                total += countDown - prev + 1;
        }
        return total;
    }
    
    public static void main( String[] args )
    {
        int[] ratings = {5,5,2};
        
        final Candy2 c = new Candy2();
        
        //System.out.println( " Min Candy = " + c.candy( ratings ) );
    }
}

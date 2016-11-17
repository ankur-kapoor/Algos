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

public class Candy3
{
    public int candy( ArrayList<Integer> ratings )
    {
        if ( ratings == null || ratings.size() == 0 )
        {
            return 0;
        }

        int[] candies = new int[ ratings.size() ];
        candies[0] = 1;

        // from let to right
        for ( int i = 1; i < ratings.size(); i++ )
        {
            if ( ratings.get( i ) > ratings.get( i - 1 ) )
            {
                candies[i] = candies[i - 1] + 1;
            }
            else
            {
                // if not ascending, assign 1
                candies[i] = 1;
            }
        }

        int result = candies[ratings.size() - 1];

        // from right to left
        for ( int i = ratings.size() - 2; i >= 0; i-- )
        {
            int cur = 1;
            if ( ratings.get( i ) > ratings.get( i + 1 ) )
            {
                cur = candies[i + 1] + 1;
            }

            result += Math.max( cur, candies[i] );
            candies[i] = cur;
        }

        return result;
    }
    
    public static void main( String[] args )
    {
        int[] ratings = {5,5,2};
        
        final Candy3 c = new Candy3();
        
        //System.out.println( " Min Candy = " + c.candy( ratings ) );
    }
}

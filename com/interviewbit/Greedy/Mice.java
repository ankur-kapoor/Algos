package com.interviewbit.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 *
 */

public class Mice
{
    public int mice( ArrayList<Integer> mouse, ArrayList<Integer> holes )
    {
        if ( mouse == null || holes == null )
        {
            return -1;
        }
        Collections.sort( mouse );
        Collections.sort( holes );
        int lenM = mouse.size();
        int lenH = holes.size();
        if ( lenM == 0 || lenH == 0 || lenM > lenH )
        {
            return -1;
        }
        int result = 0;
        int[] position = new int[ lenM ];
        for ( int i = 0; i < lenM; i++ )
        {
            position[i] = i;
        }

        for ( int i = lenM; i < lenH; i++ )
        {
            if ( !adjust( mouse, holes, position, i, lenM - 1 ) )
            {
                break;
            }
        }

        for ( int i = 0; i < lenM; i++ )
        {
            result = Math.max( result, Math.abs( mouse.get( i ) - holes.get( position[i] ) ) );
        }
        return result;
    }

    private boolean adjust( ArrayList<Integer> mouse, ArrayList<Integer> holes, int[] position, int holeIndex, int lastMouse )
    {
        if ( lastMouse < 0 )
        {
            return false;
        }
        if ( Math.abs( mouse.get( lastMouse ) - holes.get( position[lastMouse] )) > Math.abs( mouse.get( lastMouse )
            - holes.get( holeIndex ) ) )
        {
            position[lastMouse] = holeIndex;
            adjust( mouse, holes, position, holeIndex - 1, lastMouse - 1 );
            return true;
        }

        return false;
    }

    public static void main( String[] args )
    {
        int[] ratings = {5,5,2};
        
        final Mice c = new Mice();
        
        //System.out.println( " Min Candy = " + c.candy( ratings ) );
    }
}

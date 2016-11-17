package com.interviewbit.Greedy;

import java.util.ArrayList;

/**
 * N light bulbs are connected by a wire. Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb. Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs. You can press the same switch multiple times.

Note : 0 represents the bulb is off and 1 represents the bulb is on.

Example:

Input : [0 1 0 1]
Return : 4

Explanation :
    press switch 0 : [1 0 1 0]
    press switch 1 : [1 1 0 1]
    press switch 2 : [1 1 1 0]
    press switch 3 : [1 1 1 1]
 * @author ankurkap
 *
 */

public class Bulbs
{
    public int bulbs(ArrayList<Integer> a) 
    {
        int t = 0;
        
        int res = 0;
        
        for( int i=0; i< a.size(); i++)
        {
            if( a.get( i ) - t == 0 )
            {
                res++;
                t = t == 1 ? 0 : 1;
            }
        }
        
        return res;
    }
}

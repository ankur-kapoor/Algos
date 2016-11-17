package com.interviewbit.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
*/

public class GasStation2
{
    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) 
    {
        int st = 0;
        int rem = 0;
        int sum = 0;
        int total =0;
        for( int i=0; i < gas.size(); i++ )
        {
            rem = gas.get( i ) - cost.get( i );
            if( sum >= 0 )
            {
                sum += rem;
            }
            else
            {
                sum = rem;
                st = i;
            }
            
            total += rem;
        }
        
        if( total >= 0 )
        {
            return st;
        }
        
        return -1;
    }
    
    public static void main( String[] args )
    {
        int[] gas = {1,2,3,3};
        int[] cost = {2,1,5,1};
        
        final GasStation2 c = new GasStation2();
        
        //System.out.println( " Gas Station = " + c.canCompleteCircuit( gas, cost ) );
    }
}

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

public class GasStation
{
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int g=0; 
        int c=0;
        int n = gas.length;
        for( int i =0; i< n; i++ )
        {
            g += gas[i];
            c += cost[i];
        }
        
        if( g < c ) return -1;
        
        int i = 0;
        int g1= g;
        int c1 = c;
        int circuit = 0;
        int startIndex = 0;
        int rem = 0;
        while( true )
        {
            if( gas[i] + rem >= cost[i] )
            {
                c1 -= cost[i];
                g1 -= gas[i];
                rem += (gas[i] - cost[i]);
                g1 += rem; 
                
                if( g1 < c1 )
                {
                    // reset the index
                    g1 = g;
                    c1 = c;
                    i = startIndex;
                    startIndex++;
                    circuit = 0;
                    rem =0;
                }
                else
                {
                    circuit++;
                }
            }
            else
            {
                g1 = g;
                c1 = c;
                i = startIndex;
                startIndex++;
                circuit = 0;
                rem =0;
            }
            
            if( circuit == n ) return startIndex;
            if( startIndex == n ) break;
            
            i++;
            i = i%n;
        }
        
        if( circuit == n ) return startIndex;
        
        return -1;
    }
    
    public static void main( String[] args )
    {
        int[] gas = {1,2,3,3};
        int[] cost = {2,1,5,1};
        
        final GasStation c = new GasStation();
        
        System.out.println( " Gas Station = " + c.canCompleteCircuit( gas, cost ) );
    }
}

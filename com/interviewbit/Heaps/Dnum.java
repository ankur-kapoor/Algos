package com.interviewbit.Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

Note:
- If K > N, return empty array.

For example,

A=[1, 2, 1, 3, 4, 3] and K = 3

All windows of size K are

[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]

So, we return an array [2, 3, 3, 2].
 */
public class Dnum
{

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) 
    {
        int n = A.size();
        
        if( n==0 || B > n )return new ArrayList<>();
        if( n == 1 ) return new ArrayList<>(Arrays.asList( 1 ));
        
        final ArrayList<Integer> res = new ArrayList<>();
        final Map<Integer, Integer> valMap = new HashMap<>();
        
        for( int i =0; i < B; i++)
        {
            Integer v = valMap.get( A.get( i ) );
            if( null != v )
            {
                valMap.put( A.get( i ), v+1 );
            }
            else
            {
                valMap.put( A.get( i ), 1 );
            }
        }
        
        res.add( valMap.size() );
        
        int start = 0;
        for( int i =B; i < n; i++ )
        {
            int v = valMap.get( A.get( start ) );
            v--;
            if( v == 0 )
            {
                valMap.remove( A.get( start ) );
            }
            else
            {
                valMap.put( A.get( start ), v );
            }
            start++;
            
            Integer v1 = valMap.get( A.get( i ) );
            if( null != v1 )
            {
                valMap.put( A.get( i ), v1+1 );
            }
            else
            {
                valMap.put( A.get( i ), 1 );
            }
            
            res.add( valMap.size() );
        }
        
        return res;
    }
    
    public static void main( String[] args )
    {
        Dnum d = new Dnum();
        
        Integer[] li = {1, 2, 1, 3, 4, 3};
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList( li ));
        
        System.out.println( d.dNums( nums, 3 ));
    }
}

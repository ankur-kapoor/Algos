package com.interviewbit.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.interviewbit.LinkedList.ListNode;

/**
 The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 */
public class GrayScale
{
    public ArrayList<Integer> grayCode(int n) 
    {
        Set<Integer> hs = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>( );
        int k = (int)Math.pow( 2, n );
        
        res.add( 0 );
        hs.add( 0 );
        
        combine( res, hs, 1, k-1 );
        
        return res;
    }
    
    private void combine( ArrayList<Integer> res, Set<Integer> hs, int start, int n )
    {
        for( int i = start; i <= n; i++)
        {
            if( isGrayScale( res.get( res.size()-1 ), i ))
            {
                if( hs.add( i ))
                {
                    res.add( i );
                }
            }
            combine( res, hs, i+1, n );
        }
    }
    
    private boolean isGrayScale( int a, int b )
    {
        int k = a ^ b ;
        
        if( Integer.bitCount( k ) == 1 ) return true;
        
        return true;
    }
    
    public static void main( String[] args )
    {
        
        final GrayScale r = new GrayScale();
        Integer[] li = { 8, 10, 6, 11, 1, 16, 8};
        ArrayList<Integer> ai = new ArrayList<>(Arrays.asList( li )); 
        System.out.println( "Gray Code sequence =  " + r.grayCode( 5 ) );
        
    }
}

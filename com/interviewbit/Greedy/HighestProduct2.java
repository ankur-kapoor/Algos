package com.interviewbit.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array of integers, return the highest product possible by multiplying 3 numbers from the array

Input:

array of integers e.g {1, 2, 3}
 */
public class HighestProduct2
{
    public int maxp3(ArrayList<Integer> a) 
    {
        int n = a.size();
        Collections.sort( a );
        //Collections.reverse( a );
        int maxProduct = Integer.MIN_VALUE;
        if( n == 3)
        {
            return a.get( 0 ) * a.get( 1 ) * a.get( 2 );
        }
        else 
        {
            ArrayList<Integer> a1 = new ArrayList<>();
            
            int t1 = a.get( n-1 );
            a1.add( a.get( n-1 ) );
            t1 *= a.get( n-2 );
            a1.add( a.get( n-2 ) );
            
            if( n-3 != 1 )
            {
                t1 *= a.get( n-3 );
                a1.add( a.get( n-3 ) );
            }
            
            maxProduct = Math.max( maxProduct, t1 );
            
            int s1 = a.get( 0 );
            int s2 = a.get( 1 );

            int sm = s1*s2;
            for( int i =0; i < a1.size();i++)
            {
                int t  = sm * a1.get( i );
                if( maxProduct < t )
                {
                    maxProduct = t;
                }
            }
        }
        
        return maxProduct;
    }
    
    
    public static void main( String[] args )
    {
        HighestProduct2 hp = new HighestProduct2();
        
        Integer[] nums ={0, -1, 3, 100, 70, 50};
        
        System.out.println( " Highest Product = " + hp.maxp3( new ArrayList<>(Arrays.asList( nums )) ) );
    }
}

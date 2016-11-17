package com.interviewbit.Bits;

import java.util.Arrays;
import java.util.List;

/**
 * 
 *Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Example:

5 / 2 = 2
Also, consider if there can be overflow cases. For overflow case, return INT_MAX.
 *
 */
public class RevBits
{
    public long reverse(long a) 
    {
        if( a == 0) return 0;
        
        String res = "";
        
        while( a > 0 )
        {
            res += a%2;
            a = a/2;
        }
        long l = 0;
        int k = 31;
        for( int i =0; i < res.length(); i++)
        {
            int c1 = Integer.valueOf( res.charAt( i ) - '0' );
            
            l += c1* Math.pow( 2, k-i );
        }
        
        return l;
    }
    
    public static void main( String[] args )
    {
        RevBits nb = new RevBits();
        
        //Integer[] nums = {1, 2, 4, 4,3, 3, 2, 2, 3, 1, 1};
        
        //final List<Integer> numList = Arrays.asList( nums );
        
        System.out.println( "Reverse= " + nb.reverse( -1 ) );
    }
}

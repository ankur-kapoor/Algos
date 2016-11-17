package com.interviewbit.Bits;
/**
 * 
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.

Example:

The 32-bit integer 11 has binary representation

00000000000000000000000000001011
so the function should return 3.

Note that since Java does not have unsigned int, use long for Java
 *
 */
public class NumOneBits
{
    public int numSetBits(long a) 
    {
        int res = 0;
        
        while( a != 0 )
        {
            System.out.print( Long.toBinaryString( a ) + " & "+ Long.toBinaryString( a-1 ) + " = " );
            a = a & (a-1);
            
            System.out.println(Long.toBinaryString( a ));
            res++;
        }
        
        return res;
    }
    
    public static void main( String[] args )
    {
        NumOneBits nb = new NumOneBits();
        
        System.out.println( "No. of Set bits = " + nb.numSetBits( 29 ) );
    }
}

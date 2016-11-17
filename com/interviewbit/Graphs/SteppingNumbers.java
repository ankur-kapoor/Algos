package com.interviewbit.Graphs;

import java.util.ArrayList;

/**
 *Given N and M find all stepping numbers in range N to M

The stepping number:

A number is called as a stepping number if the adjacent digits have a difference of 1.
e.g 123 is stepping number, but 358 is not a stepping number

Example:

N = 10, M = 20
all stepping numbers are 10 , 12 
Return the numbers in sorted order.
 * @author ankurkap
 *
 */

public class SteppingNumbers
{
    
    public ArrayList<Integer> stepnum( int N, int M )
    {
        final ArrayList<Integer> res = new ArrayList<>();
        if( N > M ) return res;
        
        int sN = N > 0 ? (int)Math.floor( Math.log10( N ) + 1 ) : 1 ;
        int sM = (int)Math.floor( Math.log10( M ) + 1 );
        
        if( N  == 0 ) res.add( 0 );
        for( int i = sN; i <= sM; i++ )
        {
            for( int j = 1; j < 10; j++ )
            {
                dfs( N, M, i, j, res );
            }
        }
        return res;
    }
    
    
    private void dfs( int N, int M, int len, int num, ArrayList<Integer> res )
    {
        if( len == 1 )
        {
            if( num >= N && num <= M )
            {
                res.add( num );
            }
            return;
        }
        
        int lastDigit = num%10;
        
        
        if( lastDigit == 0 )
        {
            dfs( N, M, len-1, num*10+1, res );
        }
        else if( lastDigit == 9 )
        {
            dfs( N, M, len-1, num*10+8, res );
        }
        else
        {
            dfs( N, M, len-1, num*10 + lastDigit - 1, res );
            dfs( N, M, len-1, num*10 + lastDigit + 1, res );
        }
        
    }
    
    public static void main( String[] args )
    {
        final SteppingNumbers bs = new SteppingNumbers();
        
        int n = 0;
        int m = 2000000000;
        System.out.println( "Stepping Numbers between " + n + " and "+ m + " = "+  bs.stepnum( n, m )  );
    }
    
}


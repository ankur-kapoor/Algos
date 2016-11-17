package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
There are n coins in a line. (Assume n is even). Two players take turns to take a coin from one of the ends of the line until there are no more coins left. The player with the larger amount of money wins.

Would you rather go first or second? Does it matter?
Assume that you go first, describe an algorithm to compute the maximum amount of money you can win.

Refer - http://articles.leetcode.com/coins-in-line/ 

Function to be used here : 

Let coins be in an array A - 0-n

For first user to win, he needs to make sure he picks up the coins which would yeild him the max profit: 

let the range of coins be  Ai to Aj  ( 0 <= i,j < n)

if user chooses Ai 

P1 = Ai + min( P(i+2,j), P(i+1,j-1))

similarly if user chooses Aj

P2 = Aj + min( P(i,j-2), P(i+1,j-1))


hence for the first user to choose max between i and j 
P(i,j) = max( P1, P2)

i.e. P(i,j) = max { Ai + min( P(i+2, j),P(i+1,j-1)),
                    Aj + min( P(i, j-2),P(i+1,j-1))                    
                     } 
 */

public class CoinsInALine
{ 
    public int maxcoin( ArrayList<Integer> A )
    {
        int n = A.size();
        Integer[][] T = new Integer[n][n];
        return P( 0, n-1, A, T );
    }
    
    private int P( int i, int j, final ArrayList<Integer> A, final Integer[][] T )
    {
        if( i == j)
        {
            T[i][j] = A.get( i );
            return T[i][j];
        }
        
        if( i == j-1)
        {
            T[i][j] = Math.max( A.get( i ), A.get( j ) );
            return T[i][j];
        }
      
        if( null != T[i][j] )
        {
            return T[i][j];
        }
        
        int a  = i+2 < A.size() ? P(i+2,j,A,T) : 0;
        int b  = i+1 < A.size() && j-1 >= 0 ? P(i+1,j-1,A,T) : 0;
        int c  = j-2 >= 0 ? P(i,j-2,A,T) : 0;
        
        
        T[i][j] = Math.max( A.get( i ) + Math.min( a, b ), 
                            A.get( j ) + Math.min( b, c ));
        
        
        return T[i][j];
    }
    
    private void printMatrix( final Integer[][] T )
    {
        for( int i=0; i < T.length; i++ )
        {
            for( int j=0; j < T[0].length; j++ )
            {
                System.out.print( T[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    
    public static void main( String[] args )
    {
        CoinsInALine hp = new CoinsInALine();
        
        Integer[] nums ={3, 2, 2, 3, 1, 2};
        
        final ArrayList<Integer> a = new ArrayList<>( Arrays.asList( nums ));
        
        System.out.println( " Coin Change = " + hp.maxcoin( a ) );
    }
}

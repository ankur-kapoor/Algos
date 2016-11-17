package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 
 */

public class UniqueBST
{
    /**
     * This number generation pattern is also called as CATALAN numbers 
     * 
     * Presumptions - 
     * 
     * T[0] - 1
     * T[1] - 1  i.e. when n =1 , then only 1 BST is possible.
     *    
     */
    
    public int numTrees(int n) 
    {
        if( n < 1 ) return 1;
        
        int[] T = new int[n+1];
        
        T[0] =1;
        T[1] =1;
        
        for( int i = 2; i <= n; i++ )
        {
            System.out.println( "When i = " + i );
            for( int j = 0; j < i; j++ )
            {
                T[i] += T[j] * T[i-j-1];
                System.out.println( "T["+i+"] = T["+i+"] + (T["+j +"] X T["+ (i-j-1) +"]) -> " + T[i]);
                
            }
        }
        
        return T[n];
    }
    
    public static void main( String[] args )
    {
        UniqueBST hp = new UniqueBST();
        
        int[] nums ={0, -1, 3, 100, 70, 50};
        
        System.out.println( " No. of BSTs possible = " + hp.numTrees( 5 ) );
    }
}

package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example : 
edit distance between
"Anshuman" and "Antihuman" is 2.

Operation 1: Replace s with t.
Operation 2: Insert i.
 */
public class EditDistance
{
    public int minDistance(String a, String b) 
    {
        if( (null == a || a.length() == 0 ) && (null == b || b.length() == 0 ))
        {
            return 0;
        }
        
        if( null == a || a.length() == 0 )
        {
            return b.length();
        }
        
        if( null == b || b.length() == 0 )
        {
            return a.length();
        }
        
        int n = b.length();
        int m = a.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for( int i =0; i <= m ; i++ )
        {
            dp[0][i] = i;
        }
        
        for( int i =0; i <= n ; i++ )
        {
            dp[i][0] = i;
        }
        
        for( int i =1; i <= n ; i++ )
        {
            for( int j =1; j <= m ; j++ )
            {
                dp[i][j] = eval( dp, a, b, i, j );
            }
        }
        
        return dp[n][m];
    }
    
    
    private int eval( int[][] dp, String a, String b, int i, int j )
    {
        if( a.charAt( j-1 ) == b.charAt( i-1 ))
        {
            return dp[i-1][j-1];
        }
        else
        {
            return 1 + Math.min( Math.min( dp[i][j-1], dp[i-1][j] ), dp[i-1][j-1] );
        }
    }
    
    public static void main( String[] args )
    {
        EditDistance hp = new EditDistance();
        
        int[] nums ={2, 5, 3, 6};
        
        System.out.println( " Min Edits = " + hp.minDistance( "Anshuman", "Antihuman" ) );
    }
}

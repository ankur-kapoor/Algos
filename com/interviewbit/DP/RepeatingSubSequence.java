package com.interviewbit.DP;

public class RepeatingSubSequence
{
    public int anytwo( String a )
    {
        if(LCS( a, a ))
        {
            return 1;
        }
        
        return 0;
    }
    
    private boolean LCS( String a, String b)
    {
        int n = a.length();
        int m = b.length();
        
        final int[][] dp = new int[n+1][m+1];
        
        for( int i =1; i <= n; i++ )
        {
            for( int j =1; j <= m; j++ )
            {
                if( i != j)
                {
                    if( a.charAt( i-1 ) == b.charAt( j-1 ) )
                    {
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                    else
                    {
                        dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
                    }
                    
                    if( dp[i][j] >=2 ) return true;
                }
            }
        }
        return false;
    }
    
    public static void main( String[] args )
    {
        RepeatingSubSequence rs = new RepeatingSubSequence();
        
        rs.anytwo( "acbdaghfb" );
    }
}

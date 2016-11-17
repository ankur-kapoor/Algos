package com.interviewbit.DP;

/**
 *Implement wildcard pattern matching with support for '?' and '*'.

'?' : Matches any single character.
'*' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

The function prototype should be:

int isMatch(const char *s, const char *p)
Examples :

isMatch("aa","a") → 0
isMatch("aa","aa") → 1
isMatch("aaa","aa") → 0
isMatch("aa", "*") → 1
isMatch("aa", "a*") → 1
isMatch("ab", "?*") → 1
isMatch("aab", "c*a*b") → 0
Return 1/0 for this problem.
 */

public class WildCardMatching
{
    
    public int isMatch( final String a, final String pattern )
    {
        
        if( a == null || a.length() == 0 || pattern == null || pattern.length() == 0 )
        {
            return 0;
        }
        
        int N = a.length();
        int M = pattern.length();
        
        char[] patrn = pattern.toCharArray();
        char[] str = a.toCharArray();
        
        int k = 0;
        boolean first = true;
        for( int i =0; i < M; i++ )
        {
            if( patrn[i] == '*' )
            {
                if( first )
                {
                    patrn[k++] = patrn[i];
                    first = false;
                }
            }
            else
            {
                patrn[k++] = patrn[i];
                first = true;
            }
        }
        
        final boolean[][] T = new boolean[N+1][k+1];
        T[0][0] = true;
        if( k > 0 && patrn[0]=='*')
        {
            T[0][1] = true;
        }
        
        for( int i =1; i <= N; i++ )
        {
            for( int j =1; j <= k ; j++ )
            {
                if( str[i-1] == patrn[j-1] || patrn[j-1] == '?')
                {
                    T[i][j] = T[i-1][j-1];
                }
                else if( patrn[j-1] == '*' )
                {
                    T[i][j] = T[i-1][j] || T[i][j-1];
                }
            }
        }
        
        return T[N][k] ? 1 : 0;
    }
    
    
    public static void main( String[] args )
    {
        WildCardMatching hp = new WildCardMatching();
        
        //wordDict.add( "code" );
        
        System.out.println( " Is Matching " + hp.isMatch( "bbbcbcb", "**b" ) );
    }
}

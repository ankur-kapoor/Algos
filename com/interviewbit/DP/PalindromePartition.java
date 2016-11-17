package com.interviewbit.DP;


/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartition
{
    /**
     * Taking the DP approach : 
     * 
     * lets take a DP matrix T[n][n], where n = String's length
     * using this condition : 
     * 
     * If substring(i,j) == PALINDROME,
     * Then 
     *      T[i][j] = 0;
     * Else 
     *      T[i][j] = 1 + Min( T[i][k] + T[k+1][j-1]) for all k = i to j-1     
     * 
     */
    public int minCut(String s) 
    {
        if( null == s || s.length() == 0 )
        {
            return 0;
        }
        
        int n = s.length();
        Integer[][] T = new Integer[n][n];
        Boolean[][] B = new Boolean[n][n];
        
        findMin( s, 0, n-1, T, B );
        
        return T[0][n-1];
    }
    
    private int findMin( String s, int i, int j, Integer[][] T, Boolean[][] B )
    {
        if( i > j ) return 0;
        
        if( null != T[i][j])
        {
            return T[i][j];
        }
        
        if( i == j)
        {
            T[i][j] = 0;
            return T[i][j];
        }
        
        String sub = s.substring( i, j+1 );
        
        if( isPalindrome( sub, B, i, j ))
        {
            T[i][j] = 0;
            return T[i][j];
        }
        else
        {
            int minCuts = Integer.MAX_VALUE;
            for( int k = i; k < j; k++)
            {
                minCuts = Math.min( minCuts , findMin( s, i, k, T, B ) + findMin(s, k+1, j, T, B));
            }
            T[i][j] = minCuts+1;
            
            return T[i][j];
        }
    }
    
    private boolean isPalindrome( String st, Boolean[][] B, int a, int b )
    {
        if( null != B[a][b] )
        {
            return B[a][b];
        }
        
        int i = 0;
        int j = st.length()-1;
        
        while( i < j )
        {
            if( st.charAt( i++ ) != st.charAt( j-- ))
            {
                B[a][b] = false;
                return false;
            }
        }
        
        B[a][b]= true;
        return true;
    }
    
    public static void main( String[] args )
    {
        PalindromePartition hp = new PalindromePartition();
        
        System.out.println( " Minimum Paritioning = " + hp.minCut( "adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece" ) );
    }
}

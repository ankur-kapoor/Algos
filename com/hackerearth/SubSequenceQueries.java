package com.hackerearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *You are given a string S and Q query strings (q1, q2, ... , qQ). For each query string, report whether or not it is a subsequence of S.

Input :

The first line contains a string S.

The next line contains a single integer, Q.

The following Q lines each contain 1 query string qi.

Output :

Output Q lines. On the ith line print "Yes" (without quotes) if qi is a sub-sequence of S, otherwise print "No" (without quotes).

Constraints :

1 <= |S|, |q[i]|, Q <= 100,000

Sum of lengths of all query strings <= 1,000,000

All strings consist of lowercase english letters only. ('a'-'z')

SAMPLE INPUT 
hello
5
world
lo
elo
hl
ol
 * @author ankurkap
 *
 */

public class SubSequenceQueries
{
    
    private static boolean isLcs( char[] A, final int[][] T )
    {
        int p =0;
        for( int i =0; i < A.length; i++ )
        {
            if( T[p][A[i]-'a'] >= T.length-1 )
            {
                return false;
            }
            else
            {
                // find next position
                p = T[p][A[i]-'a'] + 1;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String S = in.nextLine();
        
        int Q = in.nextInt();
        in.nextLine();
        char[] sa = S.toCharArray();
        int N = S.length();
        int[][] T = new int[N+1][26];
        
        for( int i = 0; i < 26; i++ )
        {
            T[N][i] = N;
        }
        
        for( int i = N-1; i >=0; i-- )
        {
            for( int j=0; j < 26; j++ )
            {
                T[i][j] = T[i+1][j];
            }
            
            T[i][sa[i]-'a'] = i;
        }
       
        for( int k=0; k < Q; k++ )
        {
            String s = in.nextLine();
            if( isLcs( s.toCharArray(), T ))
            {
                System.out.println( "Yes" );
            }
            else
            {
                System.out.println( "No" );
            }
        }
        
        in.close();
        //System.out.println(cnt) ;
    }
}

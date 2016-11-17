package com.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/hourrank-8/challenges/whats-next
 * @author ankurkap
 *
 */

public class OptimalPath
{
    private static void optimizePath( int[][] a )
    {
        int n = a.length;
        int m = a[0].length;
        
        for( int i =1; i < n; i++ )
        {
            a[i][0] += a[i-1][0];
        }
        
        for( int i =1; i < m; i++ )
        {
            a[0][i] += a[0][i-1];
        }
        
        for( int i=1; i < n ; i++ )
        {
            for( int j=1; j < m ; j++ )
            {
                a[i][j] += Math.min( a[i-1][j], a[i][j-1] );
            }
        }
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][m];
        
        for( int i =0; i <n; i++ )
        {
            for( int j =0; j < m; j++ )
            {
                a[i][j] = in.nextInt();
            }
        }
        
        optimizePath( a );
        
        int Q = in.nextInt();
        
        for( int i = 0; i < Q; i++ )
        {
            int r1 = in.nextInt();
            int c1 = in.nextInt();
            
            int r2 = in.nextInt();
            int c2 = in.nextInt();
            
            int sum = a[r1][c1] + a[r2][c2];
            
            System.out.println( sum );
        }
        
        in.close();
    }
}

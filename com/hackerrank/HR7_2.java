package com.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/hourrank-6/challenges/bear-and-workbook
 * @author ankurkap
 *
 */

public class HR7_2
{
    
    private static int numMoves( long[]nums, int l, int h, long sum )
    {
        if( l >= h)
        {
            return 0;
        }
        
        long s = 0;
        int m = -1;
        for( int i = l; i <= h; i++ )
        {
            s += nums[i];
            
            if( s == sum-s )
            {
                m = i;
                break;
            }
            else if( s > sum-s )
            {
                break;
            }
        }
        
        if( m == -1 )
        {
            return 0;
        }
        else
        {
            return 1 + Math.max( numMoves( nums, l, m, s ), numMoves( nums, m+1, h, s ) );
        }
    }
    
    
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for( int i = 0; i < T; i++ )
        {
            int N = in.nextInt();
            in.nextLine();
            String s = in.nextLine();
            String[] st = s.split( " " );
            
            long[] a = new long[N];
            long sum =0;
            for( int k=0; k < N ; k++ )
            {
                a[k] = Long.valueOf( st[k] );
                sum += a[k];
            }
            
            System.out.println( numMoves( a, 0, N-1, sum ));
        }
        
        in.close();
        //System.out.println(cnt) ;
    }
}

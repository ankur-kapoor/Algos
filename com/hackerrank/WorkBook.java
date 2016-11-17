package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/hourrank-6/challenges/bear-and-workbook
 * @author ankurkap
 *
 */

public class WorkBook
{
    public static int countSpecialPages( List<Integer> pages, int k )
    {
        if( pages.isEmpty())
        {
            return 0;
        }
        
        int page = 0;
        int cnt = 0;
        for( int i =0; i < pages.size(); i++ )
        {
            int pg = pages.get( i );
            if( pg <= k )
            {
                if( page < pg )
                {
                    cnt++;
                }
                page++;
            }
            else
            {
                int t =-1;
                while( pg > 0 )
                {
                    int c = Math.min( t+pg, t+k );
                    if( page > t && page <= c )
                    {
                        cnt++;
                    }
                    t += k;
                    pg -= k;
                    page++;
                }
            }
        }
        
        return cnt;
    }
    
    public static void main( String[] args )
    {
        final Scanner sc = new Scanner( System.in );
        
        final String s2 = sc.nextLine();
        
        final String[] s2A = s2.split( " " );
        
        int n = Integer.valueOf( s2A[0] );
        int k = Integer.valueOf( s2A[1] );
        
        String s = sc.nextLine();
        
        sc.close();
        
        String[] st = s.split( " " );
        
        final List<Integer> a = new ArrayList<>();
        for( int i = 0; i < n; i++ )
        {
            a.add( Integer.valueOf( st[i] ) );
        }
        
        System.out.println( countSpecialPages( a, k ) );
    }
}

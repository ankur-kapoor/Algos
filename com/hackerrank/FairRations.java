package com.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/contests/hourrank-9/challenges/fair-rations
 * @author ankurkap
 *
 */

public class FairRations
{
    private static void solve( final int[] a, final PriorityQueue<Integer> pq )
    {
        int res = 0;
        final boolean[] b = new boolean[a.length];
        while( !pq.isEmpty())
        {
            int i = pq.poll();
            
            if( b[i])
            {
                continue;
            }
            
            b[i] = true;
            
            res += 2;
            a[i]++;
            
            a[i+1]++;
            
            if( a[i+1]%2 != 0 )
            {
                pq.add( i+1 );
            }
            else
            {
                b[i+1] = true;
            }
        }
        
        System.out.println(res);
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        int[] a = new int[N];
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for( int i =0; i < N; i++)
        {
            a[i] = in.nextInt();
            
            if( a[i] % 2 != 0)
            {
                pq.add( i );
            }
        }
        
        if( pq.size() % 2 != 0 )
        {
            System.out.println( "NO" );
        }
        else
        {
            solve( a, pq );
        }
        
        in.close();
        //System.out.println(m) ;
    }
}

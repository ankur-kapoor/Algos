package com.hackerrank;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/contests/w20/challenges/synchronous-shopping
 * @author ankurkap
 *
 */

public class SynchronousShopping
{
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();
        
        final int[][] fishTypes = new int[N+1][K+1];
        final int[][] cityMap = new int[N+1][N+1];
        
        for( int i =1; i <= N; i++ )
        {
            int Ti = in.nextInt();
            
            for( int j =0; j < Ti; j++ )
            {
                int ji = in.nextInt();
                fishTypes[i][ji] = 1;  
            }
        }
        
        for( int i = 0; i < M; i++ )
        {
            int v = in.nextInt();
            int u = in.nextInt();
            int w = in.nextInt();
            cityMap[v][u] = w;
            cityMap[u][v] = w;
        }
        
        int[] parent = new int[N+1];
        int minTime = Integer.MAX_VALUE;
        
        int ki=0;
        
        for( int i =1; i<= K; i++ )
        {
            if(fishTypes[1][i] == 1 )
            {
                ki++;
            }
            if(fishTypes[N][i] == 1 )
            {
                ki++;
            }
        }
        
        final Set<Integer> visited = new HashSet<>();
        while( BFS( cityMap, visited, parent, 1, N ))
        {
            int time =0;
            int v = N;
            int k = ki;
            final Set<Integer> vi = new HashSet<>();
            while( v != 1 )
            {
                int u = parent[v];
                time += cityMap[u][v];
                for(int i = 1; i <= K; i++ )
                {
                    if( fishTypes[u][i] == 1 )
                    {
                        k++;
                    }
                }
                
                //cityMap[u][v] = 0;
                vi.add( u );
                v = u;
            }
            
            int time2 = Integer.MIN_VALUE;
            // For 2nd cat
            if( k < K )
            {
                time2 = 0;
                if( BFS( cityMap, vi, parent, 1, N ))
                {
                    v = N;
                    while( v != 1 )
                    {
                        int u = parent[v];
                        time2 += cityMap[u][v];
                        for(int i = 1; i <= K; i++ )
                        {
                            if( fishTypes[u][i] == 1 )
                            {
                                k++;
                            }
                        }
                        v = u;
                    }
                }
            }
            
            if( k >= K )
            {
                minTime = Math.min( minTime, Math.max( time, time2 ) );
            }
            
            visited.addAll( vi );
        }
        
        System.out.print( minTime );
        in.close();
    }
    
    private static boolean BFS( final int[][] cityMap, final Set<Integer> vi, final int[] parent, int source,
        int dest )
    {
        final Set<Integer> visited = new HashSet<>(vi);
        final Queue<Integer> q = new LinkedList<>();

        q.add( source );

        while ( !q.isEmpty() )
        {
            int v = q.poll();

            for ( int i = 1; i < cityMap.length; i++ )
            {
                if ( cityMap[v][i] > 0 && !visited.contains( i ) )
                {
                    parent[i] = v;
                    if ( i == dest )
                    {
                        return true;
                    }
                    q.add( i );
                    visited.add( i );
                }
            }
        }

        return false;
    }
}

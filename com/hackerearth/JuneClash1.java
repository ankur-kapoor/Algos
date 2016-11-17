package com.hackerearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *https://www.hackerearth.com/june-clash-16/algorithm/requiem-for-a-dream-juneclash/
 ** @author ankurkap
 *
 */

public class JuneClash1
{
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();
        
        final List<Edge> [] edges = new List[N];
        
        for( int i =0; i < N; i++ )
        {
            edges[i] = new ArrayList<>();
        }
        
        for( int i =0; i < N-1; i++ )
        {
            int v = in.nextInt()-1;
            int u = in.nextInt()-1;
            long w = in.nextLong();
            
            edges[v].add( new Edge(u, w) );
            edges[u].add( new Edge(v, w) );
        }
        
        final Map<Integer,GraphData> data = new HashMap<>();
        
        processShortestPath( edges, data, N );
        
        for( int i =0; i < Q; i++ )
        {
            int v = in.nextInt()-1;
            int u = in.nextInt()-1;
            
            if( v == u)
            {
                System.out.println(0);
            }
            else
            {
                final GraphData gData = data.get( v );
                final long[] dist = gData.distances;
                final int[] parent = gData.parentMap;
                
                long maxSum = Long.MIN_VALUE;
                long sum = 0l;
                
                int t = v;
                
                while( t != u )
                {
                    int x = parent[t];
                    for( final Edge edge : edges[x])
                    {
                        if( edge.v == t )
                        {
                            sum += edge.w;
                            break;
                        }
                    }
                    
                    maxSum = Math.max( maxSum, sum );
                    t = x;
                }
                
                System.out.println( maxSum );
            }
        }
            
        in.close();
    }
    
    private static void processShortestPath( final List<Edge>[] edges, final Map<Integer,GraphData> data, int N )
    {
        for( int i =0; i < N; i++ )
        {
            final int[] parentMap = new int[N];
            final long[] distances = bellmanFord( edges, N, parentMap, i );
            
            data.put( i, new GraphData( distances, parentMap ) );
        }
    }
    
    private static long[] bellmanFord( final List<Edge>[] edges, int N, int[] parentMap, int src )
    {
        int source = src;
        final long[] dist = new long[N];
        
        for( int i =0; i < N; i++ )
        {
            dist[i] = Long.MAX_VALUE;
            parentMap[i] = -1;
        }
        
        parentMap[source] = source;
        
        dist[source] = 0l;
        
        for( int k = 1; k < N; k++)
        {
            for( int i = 0; i < N; i++)
            {
                for( Edge edge : edges[i])
                {
                    int v = edge.v;
                    long wt = edge.w;
                    
                    if( dist[i] != Long.MAX_VALUE && dist[i]+ wt < dist[v] )
                    {
                        dist[v] = dist[i]+ wt;
                        parentMap[v] = i;
                    }
                }
            }
        }
        
        return dist;
    }
    
    static class GraphData
    {
        long[] distances;
        int[] parentMap;
        
        GraphData( final long[] dist, final int[] parent )
        {
            distances = dist;
            parentMap = parent;
        }
    }
 
    static class Edge
    {
        int v;
        long w;
        
        Edge( int _v, long _w)
        {
            v = _v;
            w = _w;
        }
        
        @Override
        public String toString()
        {
            return String.valueOf( v );
        }
    }
}

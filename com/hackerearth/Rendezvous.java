package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *https://www.hackerearth.com/IITK-WPC-Summer16/algorithm/rendezvous-3/
 * @author ankurkap
 *
 */

public class Rendezvous
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int N = in.nextInt();
        int M = in.nextInt();
        
        final Graph graph = new Graph( N );
        
        for( int i =0; i < M; i++ )
        {
            int u = in.nextInt()-1;
            int v = in.nextInt()-1;
            long wt = in.nextInt() * 1L;
            
            graph.addEdge( u, v, wt );
        }
        
        out.println( getOptimizedPath( graph ) );
        
        out.close();
        System.exit( 0 );
    }
    
    
    private static long getOptimizedPath( final Graph graph )
    {
        long[] dist = new long[graph.V];
        int[] parent = new int[graph.V];
                        
        dijkstra( graph, dist, parent, 0 );
        
        long sum =0;
        final List<Distance> distances = new ArrayList<>();
        
        for( int i =0; i < dist.length; i++ )
        {
            distances.add( new Distance( i, dist[i]) );
        }
        
        Collections.sort( distances );
        
        Set<Integer> visited = new HashSet<>();
        visited.add( 0 );
        for( final Distance distance : distances )
        {
            if( visited.add( distance.index) )
            {
                sum += distance.weight;
                
                int v = distance.index;
                
                while( v != 0 )
                {
                    v = parent[v];
                    visited.add( v );
                }
            }
        }
        
        return sum;
    }
    
    private static void dijkstra( final Graph graph, long[] dist, int[] parent, int source )
    {
        Arrays.fill( dist, Long.MAX_VALUE );
        dist[source] = 0;
        
        final PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add( new Node( source, 0) );
        parent[source] = -1;
        while( !pq.isEmpty())
        {
            final Node node = pq.poll();
            
            if( node.W != dist[node.V])continue;
            
            final List<Edge> edges = graph.edges[node.V];
            
            for( final Edge edge : edges )
            {
                long newCost = dist[node.V] + edge.w;
                
                if( newCost <= dist[edge.v])
                {
                    parent[edge.v] = node.V;
                    dist[edge.v] = newCost;
                    pq.add( new Node( edge.v, newCost ) );
                }
            }
        }
    }
    
    static class Distance implements Comparable<Distance>
    {
        int index;
        Long weight;
        Distance( int i, long w)
        {
            index = i;
            weight = w;
        }
        @Override
        public int compareTo( Distance o )
        {
            return weight.compareTo( o.weight )*-1;
        }
    }
    
    static class Node implements Comparable<Node>
    {
        int V;
        Long W;
        Node( int v, long w)
        {
            V = v;
            W = w;
        }
        @Override
        public int compareTo( Node o )
        {
            return W.compareTo( o.W );
        }
    }
    
    static class Graph
    {
        int V;
        final List<Edge>[] edges;
        Graph( int n )
        {
            V = n;
            edges = new List[V];
            for( int i =0; i < n; i++ )
            {
                edges[i] = new ArrayList<>();
            }
        }
        
        public void addEdge( int u, int v, long wt )
        {
            edges[u].add( new Edge(v, wt ));
            edges[v].add( new Edge(u, wt ));
        }
    }
    
    static class Edge
    {
        int v;
        long w;
        Edge( int v, long w )
        {
            this.v = v;
            this.w = w;
        }
    }
    
    static class InputReader
    {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader( InputStream stream )
        {
            reader = new BufferedReader( new InputStreamReader( stream ), 32768 );
            tokenizer = null;
        }

        public String next()
        {
            while ( tokenizer == null || !tokenizer.hasMoreTokens() )
            {
                try
                {
                    tokenizer = new StringTokenizer( reader.readLine() );
                }
                catch ( IOException e )
                {
                    throw new RuntimeException( e );
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt()
        {
            return Integer.parseInt( next() );
        }
        
        public long nextLong()
        {
            return Long.parseLong( next() );
        }
    }

}

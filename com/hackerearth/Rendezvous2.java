package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 *https://www.hackerearth.com/IITK-WPC-Summer16/algorithm/rendezvous-3/
 * @author ankurkap
 *
 */

public class Rendezvous2
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
    
    // A utility function to find the subset of an element i
    static int find(int parent[], int i)
    {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }
 
    // A utility function to do union of two subsets
    static void Union(int parent[], int x, int y)
    {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }
    
    // Implementation of Kruskal Algoritm to find the MST
    private static long getOptimizedPath( final Graph graph )
    {
        int[] parent = new int[graph.V];
        Arrays.fill( parent, -1 );
        
        Collections.sort( graph.edges );
        
        int e = 0;
        int i =0;
        
        long sum =0l;
        
        while( e < graph.V-1 )
        {
            final Edge edge = graph.edges.get( i++ );
            
            int x = find( parent, edge.u );
            int y = find( parent, edge.v );
            
            if( x != y )
            {
                sum += edge.w;
                Union( parent, x, y );
                e++;
            }
        }
        
        return sum;
    }
    
    
    static class Graph
    {
        int V;
        final List<Edge> edges;
        Graph( int n )
        {
            V = n;
            edges = new ArrayList<>();
        }
        
        public void addEdge( int u, int v, long wt )
        {
            edges.add( new Edge( u, v, wt ));
        }
    }
    
    static class Edge implements Comparable<Edge>
    {
        int u;
        int v;
        Long w;
        Edge( int u, int v, long w )
        {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo( Edge o )
        {
            return w.compareTo( o.w );
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

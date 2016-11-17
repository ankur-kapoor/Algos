package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 *https://www.hackerearth.com/IITK-WPC-Summer16/algorithm/rendezvous-3/
 * @author ankurkap
 *
 */

public class Rendezvous3
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
    static int find( final Subset subsets[], int i)
    {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
    
    
 
    // A utility function to do union of two subsets
    static void Union( final Subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
 
        // If ranks are same, then make one as root and increment
        // its rank by one
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    
    
    
    // Implementation of Kruskal Algoritm to find the MST
    private static long getOptimizedPath( final Graph graph )
    {
        int V = graph.V;
        Subset subsets[] = new Subset[V];
        for( int i=0; i< V; i++ )
        {
            subsets[i]=new Subset();
            subsets[i].parent = i;
            subsets[i].rank =0;
        }
        
        Collections.sort( graph.edges );
        
        int e = 0;
        int i =0;
        
        long sum =0l;
        
        while( e < graph.V-1 )
        {
            final Edge edge = graph.edges.get( i++ );
            
            int x = find( subsets, edge.u );
            int y = find( subsets, edge.v );
            
            if( x != y )
            {
                sum += edge.w;
                Union( subsets, x, y );
                e++;
            }
        }
        
        return sum;
    }
    
    static class Subset
    {
        int parent, rank;
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

package com.hackerearth.augustCircuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *https://www.hackerearth.com/august-circuits/approximate/petro-and-cycles/
 * @author ankurkap
 *
 */

public class PetroGraph
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int n = in.nextInt();
        int m = in.nextInt();
        
        final Graph g = new Graph(n);
        
        int res = 0;
        int[] map = new int[n];
        for( int i = 1; i <= m; i++ )
        {
            int x = in.nextInt();
            int y = in.nextInt();
            
            g.addEdge( x, y, i );
        }
        
        out.close();
        System.exit( 0 );
    }
    
    static class Graph
    {
        private final int v;
        private final List<List<Edge>> edges;
        
        public Graph( final int V )
        {
            edges = new ArrayList<>();
            v = V;
            
            for( int i=0; i < v; i++ )
            {
                edges.add( new ArrayList<Edge>() );
            }
        }
        
        public void addEdge( int v, int u, int e )
        {
            edges.get( v-1 ).add( new Edge(v,u,e) );
            edges.get( u-1 ).add( new Edge(u,v,e) );
        }
    }
    
    static class Edge
    {
        int e;
        int u;
        int v;
        
        Edge( int x, int y, int edge )
        {
            u = x;
            v = y;
            e = edge;
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

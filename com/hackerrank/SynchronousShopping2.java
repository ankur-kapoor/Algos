package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/contests/w20/challenges/synchronous-shopping
 * @author ankurkap
 *
 */

public class SynchronousShopping2
{
    
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader(System.in);
        final PrintWriter out = new PrintWriter( System.out );
        
        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();
        
        final int[] fishMask = new int[N];
        final List<Edge> edges[] = new List[N];
        
        for( int i =0; i < N; i++ )
        {
            int Ti = in.nextInt();
            
            for( int j =0; j < Ti; j++ )
            {
                int ji = in.nextInt();
                ji--;
                fishMask[i] |= 1<<ji;    
            }
            edges[i] = new ArrayList<Edge>();
        }

        for( int i = 0; i < M; i++ )
        {
            int v = in.nextInt()-1;
            int u = in.nextInt()-1;
            long w = in.nextLong();
            
            edges[v].add( new Edge( u, w ) );
            edges[u].add( new Edge( v, w ) );
        }
        
        final long[][] dist = getShortestPath( 0, edges, fishMask, K );
        
        long res = Long.MAX_VALUE;
        
        for( int i =0; i < 1<<K; i++ )
        {
            int c = (1<<K) -1 - i;
            for( int j =c; j < 1<<K; j= (j+1)|c )
            {
                res = Math.min( res, Math.max( dist[N - 1][i], dist[N - 1][j] ) );
            }
        }
        
        System.out.println( res );
        
        out.close();
    }
    
    private static long[][] getShortestPath( final int source, final List<Edge>[] edges, final int[] fishMask, int K )
    {
        final long[][] dist = new long[edges.length][1<<K];
        
        for( long[] ar : dist )
        {
            Arrays.fill( ar, Long.MAX_VALUE );
        }
        
        final PriorityQueue<Node> pq = new PriorityQueue<>();
        
        final Node sourceNode = new Node( source, fishMask[source], 0 );
        dist[source][fishMask[source]] = 0;
        pq.add( sourceNode );
        
        while( !pq.isEmpty())
        {
            final Node curNode = pq.poll();
            
            if( curNode.weight != dist[curNode.node][curNode.mask])
            {
                continue;
            }
            
            for( final Edge edge : edges[curNode.node])
            {
                long newDist = dist[curNode.node][curNode.mask] + edge.w;
                
                int newMask = curNode.mask | fishMask[edge.v];
                
                if( newDist < dist[edge.v][newMask])
                {
                    dist[edge.v][newMask] =  newDist;
                    pq.add( new Node( edge.v, newMask, newDist ) );
                }
            }
        }
        
        return dist;
    }
    
    
    
    static class Node implements Comparable<Node>
    {
        public int node;
        public int mask;
        public Long weight;
        
        Node( int n, int msk, long wt )
        {
            node = n;
            weight = wt;
            mask = msk;
        }
        
        @Override
        public int compareTo( Node o2 )
        {
            return o2.weight.compareTo( this.weight );
        }
    }
    
    static class Edge 
    {
        int v;
        long w;
        
        Edge( int vertex, long weight )
        {
            this.v = vertex;
            this.w = weight;
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

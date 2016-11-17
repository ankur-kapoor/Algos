package com.hackerearth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


/**
 * Reference - https://www.hackerearth.com/april-clash-16/algorithm/tree-edges-coloring-april-clash/ 
 * 
 * @author ankurkap
 *
 */
public class EdgeColoring
{
    static class SimpleGraph
    {
        final int V;
        final List<List<Node>> m_adjVertex;
        final boolean m_directed;
        
        SimpleGraph( int v, boolean isDirected )
        {
            V = v;
            m_adjVertex = new ArrayList<>();
            m_directed = isDirected;
            
            for( int i=0; i < V; i++ )
            {
                m_adjVertex.add( new ArrayList<Node>() );
            }
        }
        
        public void addEdge( int v, int u, int wt )
        {
            m_adjVertex.get( v-1 ).add( new Node( u-1, wt ) );
            
            if( !m_directed )
            {
                m_adjVertex.get( u-1 ).add( new Node( v-1, wt ) );
            }
        }
    }
    
    static class Node
    {
        int v;
        int wt;
        
        Node( int _v, int _wt )
        {
            v = _v;
            wt = _wt;
        }
    }
    
    private static void solve( SimpleGraph graph, int[] colors )
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for( int num : colors )
        {
            pq.add( num );
        }
        
        int V = graph.V;
        
        int sum = 0;
        int[] map = new int[V];
        boolean[][] v = new boolean[V][V];
        final List<List<Node>> adjVertex = graph.m_adjVertex;
        final Queue<Integer> q = new LinkedList<>();
        q.add( 0 );
        while( !q.isEmpty())
        {
            int i = q.poll();
            int tp = 0;
            if( map[i] != 0 )
            {
                tp = map[i];
                pq.remove( map[i] );
            }
            
            final List<Integer> li = new ArrayList<>();
            if( tp != 0)
            {
                li.add( tp );
            }
            
            for( int j =0; j < adjVertex.get( i ).size(); j++ )
            {
                int u = adjVertex.get( i ).get( j ).v;
                
                if( !v[i][u])
                {
                    v[i][u] = true;
                    v[u][i] = true;
                    int t = pq.poll();
                    map[u] = t;
                    li.add( t );
                    
                    sum += t;
                    q.add( u );
                }
            }
            
            pq.addAll( li );
        }
        
        System.out.println( sum );
    }
    
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for( int i =0; i < T; i++ )
        {
            int N = in.nextInt();
            in.nextLine();
            String s = in.nextLine();
            
            String[] st = s.split( " " );
            int[] colors = new int[N-1];
            for( int k =0; k < N-1; k++ )
            {
                colors[k] = Integer.parseInt( st[k] );
            }
            
            final SimpleGraph graph = new SimpleGraph( N, false );
            for( int k =0; k < N-1; k++ )
            {
                String s1 = in.nextLine();
                String[] st1 = s1.split( " " );
                
                int u = Integer.parseInt( st1[0] );
                int v = Integer.parseInt( st1[1] );
                
                graph.addEdge( u, v, 0 );
            }
            
            solve( graph, colors );
        }
        
        in.close();
    }
}

package com.stockroom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class StockRoom1
{
    public static void main( String args[] )
    {
        final Scanner in = new Scanner( System.in );
        
        int T = in.nextInt();
        
        int N = in.nextInt();
        
        /*final List<Edge>[] edges = new List[T];
        
        for( int i =0; i< T; i++ )
        {
            edges[i] = new ArrayList<>();
        }*/
        
        final List<Set<Integer>> components = new ArrayList<>();
        for( int i =0; i< N; i++ )
        {
            int v = in.nextInt();
            int u = in.nextInt();
            
            Set<Integer> setV = null;
            Set<Integer> setU = null;
                            
            for( final Set<Integer> s : components )
            {
                if( s.contains( v )&& null == setV )
                {
                    setV = s;
                }
                
                if( s.contains( u )&& null == setU )
                {
                    setU = s;
                }
                
                if( null != setV && null != setU )
                {
                    break;
                }
            }
            
            if( null == setV && null == setU )
            {
                final Set<Integer> s = new HashSet<>();
                s.add( v );
                s.add( u );
                components.add( s );
            }
            else if( null == setV )
            {
                setU.add( v );
            }
            else if( null == setU )
            {
                setV.add( u );
            }
            else 
            {
                if( !setV.equals( setU ))
                {
                    setV.addAll( setU );
                    components.remove( setU );
                }
            }
        }
        
        int Q = in.nextInt();
        
        for( int i =0; i< Q; i++ )
        {
            int vx = in.nextInt();
            int vy = in.nextInt();
            
            boolean found = false;
            for( final Set<Integer> s : components )
            {
                if( s.contains( vx ) && s.contains( vy ))
                {
                    found = true;
                    System.out.println(1);
                    break;
                }
            }
            
            if( !found )
            {
                System.out.println(0);
            }
            
        }
        
        in.close();
    }
    
    private static boolean BFS( int v , int u, final List<Edge>[] edges  )
    {
        final Set<Integer> visited = new HashSet<>();
        visited.add( v );
        final Queue<Integer> q = new LinkedList<>();
        q.add( v );
        
        while( !q.isEmpty())
        {
            int cur = q.poll();
            
            for( final Edge edge : edges[cur])
            {
                if( edge.u == u)return true;
                if( visited.add( edge.u ) )
                {
                    q.add( edge.u );
                }
            }
        }
        
        return false;
    }
    
    static class Edge
    {
        int u;
        
        Edge( int _u)
        {
            u = _u;
        }
        
        @Override
        public String toString()
        {
            return String.valueOf( u );
        }
    }
}

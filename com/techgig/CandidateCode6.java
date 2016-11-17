package com.techgig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class CandidateCode6
{
    public static int minRoads( String[] input1 )
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        final Set<Integer> vertexs = new HashSet<>();
        for( String s : input1 )
        {
            String[] st = s.split( "#" );
            
            int v = Integer.valueOf( st[0] );
            int u = Integer.valueOf( st[1] );
            
            min = Math.min( min, Math.min( v, u ) );
            max = Math.max( max, Math.max( v, u ) );
            vertexs.add( v );
            vertexs.add( u );
        }
        
        final List<Integer> vertexList = new ArrayList<>(vertexs);
        
        Collections.sort( vertexList );
        int N = vertexList.size();
        
        int[][] roadGraph = new int[N][N];
        
        
        for( String s : input1 )
        {
            String[] st = s.split( "#" );
            
            int v = vertexList.indexOf(Integer.valueOf( st[0] ));
            int u = vertexList.indexOf(Integer.valueOf( st[1] ));
            
            roadGraph[v][u] = 1;
            roadGraph[u][v] = 1;
            
        }
        
        int source = vertexList.indexOf( min );
        int sink = vertexList.indexOf( max );
        
        Map<Integer, Integer> parent = new HashMap<>();
        
        int res = 0;
        while( BFS( roadGraph, parent, source, sink ))
        {
            int v = sink;
            
            int minFlow = Integer.MAX_VALUE;
            while( v != source )
            {
                int u = parent.get( v );
                
                minFlow = Math.min( roadGraph[u][v], minFlow );
                v = u;
            }
            
            v = sink;
            
            while( v != source )
            {
                int u = parent.get( v );
                
                roadGraph[u][v] -= minFlow;
                roadGraph[v][u] += minFlow;
                
                v = u;
            }
            
            res += minFlow; 
        }
        
        return res;
    }
    
    private static boolean BFS( final int[][] roadGraph, Map<Integer,Integer> parent, int source, int sink )
    {
        final Queue<Integer> q = new LinkedList<>();
        final Set<Integer> visited = new HashSet<>();
        
        q.add( source );
        visited.add( source );
        
        while( !q.isEmpty() )
        {
            int v = q.poll();
            
            for( int i =0; i < roadGraph.length; i++ )
            {
                if( roadGraph[v][i] > 0 && !visited.contains( i ))
                {
                    parent.put( i, v );
                    if( i == sink )
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
    
    
    public static void main( String[] args )
    {
        String[] input1 = {"1#2", "1#5", "2#5", "2#3", "3#4", "4#5", "4#6"};
        System.out.println( minRoads( input1 ));
        
    }
}

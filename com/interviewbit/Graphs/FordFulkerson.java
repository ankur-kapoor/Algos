package com.interviewbit.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Date 04/14/2014
 * @author ankurkap
 *
 * Ford fulkerson method Edmonds Karp algorithm for finding max flow
 *
 * Capacity - Capacity of an edge to carry units from source to destination vertex
 * Flow - Actual flow of units from source to destination vertex of an edge
 * Residual capacity - Remaining capacity on this edge i.e capacity - flow
 * AugmentedPath - Path from source to sink which has residual capacity greater than 0
 *
 * Time complexity is O(VE^2)
 *
 * References:
 * http://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/
 * https://en.wikipedia.org/wiki/Edmonds%E2%80%93Karp_algorithm
 */
public class FordFulkerson
{
    public int maxFlow( int[][] capacity, int source, int sink )
    {
        // Create a residual capacity cost matrix
        
        final int[][] residualCapacity = new int[capacity.length][capacity[0].length];
        
        for( int i =0; i < capacity.length; i++ )
        {
            for( int j =0; j < capacity[0].length; j++ )
            {
                residualCapacity[i][j] = capacity[i][j];
            }
        }
        
        // Parent for a BFS path
        final Map<Integer, Integer> parent = new HashMap<>();
        
        // All agumented paths
        
        final List<List<Integer>> agumentedPaths = new ArrayList<>();
        
        int maxFlow = 0;
        
        while( BFS(residualCapacity, parent, source, sink))
        {
            final List<Integer> agumentedPath = new ArrayList<>();
            
            int v = sink;
            int flow = Integer.MAX_VALUE;
            
            while( v != source )
            {
                agumentedPath.add( v );
                
                int u = parent.get( v );
                
                if( flow > residualCapacity[u][v])
                {
                    flow = residualCapacity[u][v];
                }
                
                v = u;
            }
            
            maxFlow += flow;
            agumentedPath.add( v );
            
            agumentedPaths.add( agumentedPath );
            
            // Adjust the residual capacity 
            
            v = sink;
            
            while( v != source )
            {
                int u = parent.get( v );
                
                residualCapacity[u][v] -= flow;
                residualCapacity[v][u] += flow;
                v =u;
            }
        }
        
        return maxFlow;
    }
    
    private boolean BFS(final int[][] residualCapacity, final Map<Integer,Integer> parent, int source, int sink )
    {
        boolean foundPath = false;
        final Queue<Integer> q = new LinkedList<>();
        final Set<Integer> vi = new HashSet<>();
        
        q.add( source );
        vi.add( source );
        
        while( !q.isEmpty())
        {
            int u = q.poll();
            
            for( int v =0; v< residualCapacity[u].length; v++ )
            {
                if( !vi.contains( v ) && residualCapacity[u][v] > 0 )
                {
                    parent.put( v, u );
                    q.add( v );
                    
                    vi.add( v );
                    
                    if( v == sink )
                    {
                        foundPath = true;
                        break;
                    }
                }
            }
        }
        
        return foundPath;
    }
}

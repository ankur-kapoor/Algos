package com.interviewbit.Graphs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Implementation of Dijkastra on Adjacentcy Matrix Graph Algo
 * Using Priority Queue
 * @author ankurkap
 */

public class FastDijkastra
{

    public Object[] getShortestPath( final int[][] graph, int source )
    {
        int N = graph.length;
        final int[] distances = new int[N];
        final int[] parentMap = new int[N];
        final Set<Integer> visited = new HashSet<>();
        final PriorityQueue<Node> pq = new PriorityQueue<>(N, new Node());
        
        for( int i =1; i <N; i++ )
        {
            distances[i] = Integer.MAX_VALUE;
        }
        
        distances[source] = 0;
        visited.add( source );
        pq.add( new Node(source,0) );
        
        while( !pq.isEmpty())
        {
            final Node currentNode = pq.poll();
            visited.add( currentNode.node );
            evaluateNeighbours( graph, distances, parentMap, visited, currentNode, pq );
        }
        
        final Object[] objects = new Object[2];
        
        objects[0] = distances;
        objects[1] = parentMap;
        
        return objects;
    }
    
    private void evaluateNeighbours( final int[][] graph, final int[] distances, final int[] parentMap,
        final Set<Integer> visited, final Node currentNode, final PriorityQueue<Node> pq )
    {
        int edgeDistance = -1;
        int newDistance = -1;
        
        for( int v = 1; v < graph.length; v++ )
        {
            if( graph[currentNode.node][v] > 0 && !visited.contains( v ))
            {
                edgeDistance = graph[currentNode.node][v];
                newDistance = distances[currentNode.node] + edgeDistance;
                
                if( newDistance < distances[v] )
                {
                    parentMap[v] = currentNode.node;
                    distances[v] = newDistance;
                    pq.add( new Node(v, newDistance) );
                }
            }
        }
    }
    
    public static void main( String[] args )
    {
        final FastDijkastra dij = new FastDijkastra();
        
        int[][] graph = {{0,0,0,0,0,0,0},
                         {0,0,5,0,9,3,0},
                         {0,5,0,2,0,0,0},
                         {0,0,2,0,3,0,0},
                         {0,9,0,3,0,0,2},
                         {0,3,0,0,0,0,2},
                         {0,0,0,0,2,2,0}};
        
        int source = 1;
        final Object[] res = dij.getShortestPath( graph, source );
        
        final int[] distance = (int[])res[0];
        final int[] parentMap = (int[])res[1];
        
        for ( int i = 1; i < distance.length; i++ )
        {
            if ( source != i )
            {
                System.out.println( " Distance of " + i + " from source = " + distance[i] + " Path : "
                    + agumentedPath( parentMap, source, i ) );
            }
        }
    }
    
    private static String agumentedPath( final int[] parentMap, int source, int dest )
    {
        String path = ""+dest;
        
        int v = dest;
        
        while( v != source )
        {
            path = "->"+path;
            int u = parentMap[v];
            path = u + path;
            v = u;
        }
        
        return path;
    }
}

class Node implements Comparator<Node>
{
    public int node;
    public int weight;
    
    Node()
    {
        
    }
    
    Node( int n, int wt )
    {
        node = n;
        weight = wt;
    }
    
    @Override
    public int compare( Node o1, Node o2 )
    {
        if( o1.weight < o2.weight )
        {
            return -1;
        }
        if( o1.weight > o2.weight )
        {
            return 1;
        }
        return 0;
    }
    
}
package com.hackerrank;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/contests/w20/challenges/synchronous-shopping
 * @author ankurkap
 *
 */

public class SynchronousShopping3
{
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();
        
        final int[][] fishTypes = new int[N+1][K+1];
        final int[][] cityMap = new int[N+1][N+1];
        
        for( int i =1; i <= N; i++ )
        {
            int Ti = in.nextInt();
            
            for( int j =0; j < Ti; j++ )
            {
                int ji = in.nextInt();
                fishTypes[i][ji] = 1;  
            }
        }
        
        for( int i = 0; i < M; i++ )
        {
            int v = in.nextInt();
            int u = in.nextInt();
            int w = in.nextInt();
            cityMap[v][u] = w;
            cityMap[u][v] = w;
        }
        
        int ki=0;
        
        for( int i =1; i<= K; i++ )
        {
            if(fishTypes[1][i] == 1 )
            {
                ki++;
            }
            if(fishTypes[N][i] == 1 )
            {
                ki++;
            }
        }
        
        final Object[] res = getShortestPath( cityMap, 1 );
        
        final int[]times = (int[])res[0];
        final int[]parentMap = (int[])res[1];
        
        int minTime = times[N];
        final Set<Integer> visited = new HashSet<>();
        int k = getFishTypes( parentMap, visited, fishTypes, 1, N );
        
        k += ki;
        
        int minTime2 = 0;
        if( k >= K )
        {
            System.out.println( times[N]);
            in.close();
            return;
        }
        else
        {
            minTime2 = Integer.MAX_VALUE;
            for( int v = 2; v < N; v++ )
            {
                k = ki;
                int t1 = times[v];
                
                int k_ = getFishTypes( parentMap, null, fishTypes, 1, v );
                
                final Object[] res2 = getShortestPath( cityMap, v );
                
                final int[]times2 = (int[])res2[0];
                final int[]parentMap2 = (int[])res2[1];
                
                k_ += getFishTypes( parentMap2, null, fishTypes, v, N );
                
                k += k_;
                
                if( k >= K )
                {
                    t1 += times2[N];
                    minTime2 = Math.min( minTime2, t1 );
                }
            }
        }
        
        System.out.print( Math.max( minTime, minTime2 ) );
        in.close();
    }
    
    private static int getFishTypes( final int[]parentMap, final Set<Integer> visited, final int[][] fishTypes, int source, int dest )
    {
        int v = dest;
        
        int types = 0;
        while( v != source )
        {
            int u = parentMap[v];
            
            if( null != visited )
            {
                visited.add( u );
            }
            
            types += getFishTypeCount( fishTypes, u );
            v = u;
        }
        
        return types;
    }
    
    private static int getFishTypeCount( final int[][] fishTypes, int node )
    {
        int cnt = 0;
        
        for( int i =1; i < fishTypes[node].length; i++)
        {
            if( fishTypes[node][i] == 1 )
            {
                cnt++;
            }
        }
        return cnt;
    }
    
    private static Object[] getShortestPath( final int[][] graph, int source )
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
    
    private static void evaluateNeighbours( final int[][] graph, final int[] distances, final int[] parentMap,
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
    
    static class Node implements Comparator<Node>
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
}

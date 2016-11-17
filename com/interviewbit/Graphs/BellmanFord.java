package com.interviewbit.Graphs;

public class BellmanFord
{
    public int[] bellmanFord( final SimpleGraph graph, int src )
    {
        int source = src -1;
        int V = graph.V;
        final int[] dist = new int[V];
        
        for( int i =0; i < V; i++ )
        {
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[source] = 0;
        
        for( int k = 1; k < V; k++)
        {
            for( int i = 0; i < V; i++)
            {
                for( SimpleGraph.Node node : graph.m_adjVertex.get( i ))
                {
                    int v = node.v;
                    int wt = node.wt;
                    
                    if( dist[i] != Integer.MAX_VALUE && dist[i]+ wt < dist[v] )
                    {
                        dist[v] = dist[i]+ wt;
                    }
                }
            }
        }
        
        System.out.println( "After 1st Iteration " );
        printArr( dist, V );
        
        for( int i = 0; i < V; i++)
        {
            for( SimpleGraph.Node node : graph.m_adjVertex.get( i ))
            {
                int v = node.v;
                int wt = node.wt;
                
                if( dist[i] != Integer.MAX_VALUE && dist[i]+ wt < dist[v] )
                {
                    System.out.println( "This graph contains negative cycle" );
                }
            }
        }
        
        System.out.println( "After 1st Iteration " );
        printArr( dist, V );
        
        return dist;
    }
    
    // A utility function used to print the solution
    void printArr( int dist[], int V )
    {
        System.out.println( "Vertex  Distance from Source" );
        for ( int i = 0; i < V; ++i )
            System.out.println( i + "\t\t" + dist[i] );
    }
    
    public static void main( String[] args )
    {
        final BellmanFord bf = new BellmanFord();
        
        final SimpleGraph graph = new SimpleGraph( 5, false );
        graph.addEdge( 1, 2, -1 );
        graph.addEdge( 1, 3, 4 );
        
        graph.addEdge( 2, 3, 3 );
        graph.addEdge( 2, 4, 2 );
        graph.addEdge( 2, 5, 2 );
        
        graph.addEdge( 4, 2, 1 );
        graph.addEdge( 4, 3, 5 );
        
        graph.addEdge( 5, 4, -3 );
        
        bf.bellmanFord( graph, 5 );
        
    }
}

package com.interviewbit.Graphs;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author ankurkap
 *  Find single source shortest path using Dijkstra's algorithm
 *
 * Space complexity - O(E + V)
 * Time complexity - O(ElogV)
 *
 * References
 * https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 *
 */

public class DijkstraShortestPath
{
    public Map<Vertex<Integer>, Integer> shortestPath( Graph<Integer> graph, Vertex<Integer> sourceVertex )
    {
        final Map<Vertex<Integer>, Integer> dist = new HashMap<Vertex<Integer>, Integer>();
        
        final BinaryHeap<Vertex<Integer>> heap = new BinaryHeap<>();
        
        final Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<>();
        
        // Initializing the min heaps with Vertexs with max values
        for( Vertex<Integer> v : graph.getAllVertex())
        {
            heap.add( Integer.MAX_VALUE, v );
        }
        
        heap.update( sourceVertex, 0 );
        
        parent.put( sourceVertex, null );
        
        while( !heap.empty())
        {
            BinaryHeap<Vertex<Integer>>.Node node = heap.extractMinNode();
            
            final Vertex<Integer> current = node.key;
            int distance = node.weight;
            
            dist.put( current, distance );
            
            // Iterate through all the edges 
            
            for( Edge<Integer> edge : current.getEdges())
            {
                final Vertex<Integer> adjacentVertex = getAdjacentVertex( current, edge );
                
                // if adjacent vertex is not in the heap, it means the shortest path has already been recovered.
                if( !heap.containsData( adjacentVertex ))
                {
                    continue;
                }
                
                int newDist = dist.get( current ) + edge.getWeight();
                
                if( heap.getWeight( adjacentVertex ) > newDist )
                {
                    heap.update( adjacentVertex, newDist );
                    parent.put( adjacentVertex, current );
                }
            }
        }
        
        return dist;
    }
    
    private Vertex<Integer> getAdjacentVertex( final Vertex<Integer> v, final Edge<Integer> e )
    {
        return e.getVertex1().equals( v ) ? e.getVertex2() : e.getVertex1();
    }
    
    public static void main( String[] args )
    {
        Graph<Integer> graph = new Graph<>(false);
        /*graph.addEdge(0, 1, 4);
        graph.addEdge(1, 2, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(2, 5, 4);
        graph.addEdge(1, 7, 11);
        graph.addEdge(0, 7, 8);
        graph.addEdge(2, 8, 2);
        graph.addEdge(3, 5, 14);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 8, 6);
        graph.addEdge(6, 7, 1);
        graph.addEdge(7, 8, 7);*/

        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(3, 4, 3);

        DijkstraShortestPath dsp = new DijkstraShortestPath();
        Vertex<Integer> sourceVertex = graph.getVertex(1);
        Map<Vertex<Integer>,Integer> distance = dsp.shortestPath(graph, sourceVertex);
        System.out.print(distance);
    }
}

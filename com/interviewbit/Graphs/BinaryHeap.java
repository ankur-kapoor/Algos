package com.interviewbit.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generic Data Structure which is a combination of both Min Heap and a Map
 * Used extensively in Graphs related algorithms
 *
 * Data structure to support following operations
 * extracMin - O(logn)
 * addToHeap - O(logn)
 * containsKey - O(1)
 * updateKey - O(logn)
 * getKeyWeight - O(1)
 *
 * @author ankurkap
 *
 * @param <T>
 */

public class BinaryHeap<T>
{

    private List<Node> m_nodes = new ArrayList<>();
    private Map<T, Integer> m_nodeMap = new HashMap<>();
    private final boolean m_max;
    
    public BinaryHeap()
    {
        m_max = false;
    }
    
    public BinaryHeap( boolean maxValue )
    {
        m_max = maxValue;
    }
    
    public class Node
    {
        int weight;
        T key;
    }
    
    /**
     * Checks where the key exists in heap or not
     */
    public boolean containsData( T key )
    {
        return m_nodeMap.containsKey( key );
    }

    /**
     * Add key and its weight to they heap
     */
    public void add( int weight, T key )
    {
        Node node = new Node();
        node.weight = weight;
        node.key = key;
        m_nodes.add( node );
        int size = m_nodes.size();
        int current = size - 1;
        int parentIndex = ( current - 1 ) / 2;
        m_nodeMap.put( node.key, current );

        while ( parentIndex >= 0 )
        {
            Node parentNode = m_nodes.get( parentIndex );
            Node currentNode = m_nodes.get( current );
            
            final int diff = m_max ? currentNode.weight - parentNode.weight : parentNode.weight - currentNode.weight; 
            if ( diff > 0 )
            {
                swap( parentNode, currentNode );
                updatePositionMap( parentNode.key, currentNode.key, parentIndex, current );
                current = parentIndex;
                parentIndex = ( parentIndex - 1 ) / 2;
            }
            else
            {
                break;
            }
        }
    }

    /**
     * Get the heap min without extracting the key
     */
    public T min()
    {
        return m_nodes.get( 0 ).key;
    }
    
    /**
     * Get the heap max without extracting the key
     */
    public T max()
    {
        return m_nodes.get( 0 ).key;
    }

    /**
     * Checks with heap is empty or not
     */
    public boolean empty()
    {
        return m_nodes.size() == 0;
    }

    /**
     * Update the weight of given key to newWeight
     */
    public void update( T data, int newWeight )
    {
        Integer position = m_nodeMap.get( data );
        m_nodes.get( position ).weight = newWeight;
        
        int parent = ( position - 1 ) / 2;
        while ( parent >= 0 )
        {
            Node parentNode = m_nodes.get( parent );
            Node childNode = m_nodes.get( position );
            final int diff = m_max ? childNode.weight - parentNode.weight : parentNode.weight - childNode.weight;
            if ( diff > 0 )
            {
                swap( parentNode, childNode );
                updatePositionMap( parentNode.key, childNode.key, parent, position );
                position = parent;
                parent = ( parent - 1 ) / 2;
            }
            else
            {
                break;
            }
        }
    }

    /**
     * Get the weight of given key
     */
    public Integer getWeight( T key )
    {
        Integer position = m_nodeMap.get( key );
        if ( position == null )
        {
            return null;
        }
        else
        {
            return m_nodes.get( position ).weight;
        }
    }

    /**
     * Returns the min node of the heap
     * 
     * Inserts the last node to the top of list and then rearrange the heap  
     */
    public Node extractMinNode()
    {
        int size = m_nodes.size() - 1;
        Node minNode = new Node();
        minNode.key = m_nodes.get( 0 ).key;
        minNode.weight = m_nodes.get( 0 ).weight;

        int lastNodeWeight = m_nodes.get( size ).weight;
        m_nodes.get( 0 ).weight = lastNodeWeight;
        m_nodes.get( 0 ).key = m_nodes.get( size ).key;
        m_nodeMap.remove( minNode.key );
        m_nodeMap.remove( m_nodes.get( 0 ) );
        m_nodeMap.put( m_nodes.get( 0 ).key, 0 );
        m_nodes.remove( size );

        int currentIndex = 0;
        size--;
        while ( true )
        {
            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;
            if ( left > size )
            {
                break;
            }
            if ( right > size )
            {
                right = left;
            }
            int smallerIndex = m_nodes.get( left ).weight <= m_nodes.get( right ).weight ? left : right;
            Node parentNode = m_nodes.get( currentIndex );
            Node childNode = m_nodes.get( smallerIndex );
            
            final int diff = m_max ? childNode.weight - parentNode.weight : parentNode.weight - childNode.weight; 
            if ( diff > 0 )
            {
                swap( m_nodes.get( currentIndex ), m_nodes.get( smallerIndex ) );
                updatePositionMap( parentNode.key, childNode.key, currentIndex,
                                   smallerIndex );
                currentIndex = smallerIndex;
            }
            else
            {
                break;
            }
        }
        return minNode;
    }

    /**
     * Extract min value key from the heap
     */
    public T extractMin()
    {
        Node node = extractMinNode();
        return node.key;
    }
    
    /**
     * Extract max value key from the heap
     */
    public T extractMax()
    {
        Node node = extractMinNode();
        return node.key;
    }


    private void printPositionMap()
    {
        System.out.println( m_nodeMap );
    }

    private void swap( Node node1, Node node2 )
    {
        int weight = node1.weight;
        T data = node1.key;

        node1.key = node2.key;
        node1.weight = node2.weight;

        node2.key = data;
        node2.weight = weight;
    }

    private void updatePositionMap( T data1, T data2, int pos1, int pos2 )
    {
        m_nodeMap.remove( data1 );
        m_nodeMap.remove( data2 );
        m_nodeMap.put( data1, pos1 );
        m_nodeMap.put( data2, pos2 );
    }

    public void printHeap()
    {
        for ( Node n : m_nodes )
        {
            System.out.println( n.weight + " " + n.key );
        }
    }

    public static void main( String args[] )
    {
        BinaryHeap<String> heap = new BinaryHeap<String>( true );
        heap.add( 3, "Ankur" );
        heap.add( 4, "Ulhas" );
        heap.add( 8, "Vijay" );
        heap.add( 10, "Sheoli" );
        heap.add( 5, "Shefali" );
        heap.add( 6, "Hridhan" );
        heap.add( 2, "Shaurya" );
        heap.update( "Shefali", 11 );
        heap.printHeap();
        heap.printPositionMap();
    }
}

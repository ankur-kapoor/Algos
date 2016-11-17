package com.interviewbit.Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple and plain implementation of Graph with Integers as vertex 
 * @author ankurkap
 *
 */
public class SimpleGraph
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
    
    class Node
    {
        int v;
        int wt;
        
        Node( int _v, int _wt )
        {
            v = _v;
            wt = _wt;
        }
    }
}



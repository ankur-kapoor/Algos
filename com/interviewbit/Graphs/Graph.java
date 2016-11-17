package com.interviewbit.Graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generic implementation of Graphs
 * 
 * @author ankurkap
 * @param <T>
 */

public class Graph<T>
{

    private List<Edge<T>> m_allEdges;
    private Map<Long, Vertex<T>> m_allVertex;
    boolean m_isDirected = false;

    public Graph( boolean isDirected )
    {
        m_allEdges = new ArrayList<Edge<T>>();
        m_allVertex = new HashMap<Long, Vertex<T>>();
        this.m_isDirected = isDirected;
    }

    public void addEdge( long id1, long id2 )
    {
        addEdge( id1, id2, 0 );
    }

    public void addVertex( Vertex<T> vertex )
    {
        if ( m_allVertex.containsKey( vertex.getId() ) )
        {
            return;
        }
        m_allVertex.put( vertex.getId(), vertex );
        for ( Edge<T> edge : vertex.getEdges() )
        {
            m_allEdges.add( edge );
        }
    }

    public Vertex<T> addSingleVertex( long id )
    {
        if ( m_allVertex.containsKey( id ) )
        {
            return m_allVertex.get( id );
        }
        Vertex<T> v = new Vertex<T>( id );
        m_allVertex.put( id, v );
        
        return v;
    }

    public Vertex<T> getVertex( long id )
    {
        return m_allVertex.get( id );
    }

    public void addEdge( long id1, long id2, int weight )
    {
        Vertex<T> vertex1 = null;
        if ( m_allVertex.containsKey( id1 ) )
        {
            vertex1 = m_allVertex.get( id1 );
        }
        else
        {
            vertex1 = new Vertex<T>( id1 );
            m_allVertex.put( id1, vertex1 );
        }
        Vertex<T> vertex2 = null;
        if ( m_allVertex.containsKey( id2 ) )
        {
            vertex2 = m_allVertex.get( id2 );
        }
        else
        {
            vertex2 = new Vertex<T>( id2 );
            m_allVertex.put( id2, vertex2 );
        }

        Edge<T> edge = new Edge<T>( vertex1, vertex2, m_isDirected, weight );
        m_allEdges.add( edge );
        vertex1.addAdjacentVertex( edge, vertex2 );
        if ( !m_isDirected )
        {
            vertex2.addAdjacentVertex( edge, vertex1 );
        }
    }

    public List<Edge<T>> getAllEdges()
    {
        return m_allEdges;
    }

    public Collection<Vertex<T>> getAllVertex()
    {
        return m_allVertex.values();
    }

    public void setDataForVertex( long id, T data )
    {
        if ( m_allVertex.containsKey( id ) )
        {
            Vertex<T> vertex = m_allVertex.get( id );
            vertex.setData( data );
        }
    }

    @Override
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        for ( Edge<T> edge : getAllEdges() )
        {
            buffer.append( edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight() );
            buffer.append( "\n" );
        }
        return buffer.toString();
    }
}

class Vertex<T>
{
    long id;
    private T data;
    private List<Edge<T>> edges = new ArrayList<>();
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();

    Vertex( long id )
    {
        this.id = id;
    }

    public long getId()
    {
        return id;
    }

    public void setData( T data )
    {
        this.data = data;
    }

    public T getData()
    {
        return data;
    }

    public void addAdjacentVertex( Edge<T> e, Vertex<T> v )
    {
        edges.add( e );
        adjacentVertex.add( v );
    }

    public String toString()
    {
        return String.valueOf( id );
    }

    public List<Vertex<T>> getAdjacentVertexes()
    {
        return adjacentVertex;
    }

    public List<Edge<T>> getEdges()
    {
        return edges;
    }

    public int getDegree()
    {
        return edges.size();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)( id ^ ( id >>> 32 ) );
        return result;
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Vertex other = (Vertex)obj;
        if ( id != other.id )
            return false;
        return true;
    }
}

class Edge<T>
{
    private boolean isDirected = false;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;

    Edge( Vertex<T> vertex1, Vertex<T> vertex2 )
    {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    Edge( Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected, int weight )
    {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.isDirected = isDirected;
    }

    Edge( Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected )
    {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.isDirected = isDirected;
    }

    Vertex<T> getVertex1()
    {
        return vertex1;
    }

    Vertex<T> getVertex2()
    {
        return vertex2;
    }

    int getWeight()
    {
        return weight;
    }

    public boolean isDirected()
    {
        return isDirected;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( vertex1 == null ) ? 0 : vertex1.hashCode() );
        result = prime * result + ( ( vertex2 == null ) ? 0 : vertex2.hashCode() );
        return result;
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Edge other = (Edge)obj;
        if ( vertex1 == null )
        {
            if ( other.vertex1 != null )
                return false;
        }
        else if ( !vertex1.equals( other.vertex1 ) )
            return false;
        if ( vertex2 == null )
        {
            if ( other.vertex2 != null )
                return false;
        }
        else if ( !vertex2.equals( other.vertex2 ) )
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", weight=" + weight
            + "]";
    }
}

package com.interviewbit.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CloneGraph
{
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
    {
        final Map<UndirectedGraphNode, UndirectedGraphNode> map = new LinkedHashMap<>();
        
        map.put( node, new UndirectedGraphNode( node.label ) );
        
        // Map all adjacent Graphnodes
        for( UndirectedGraphNode gn : node.neighbors )
        {
            cloneIt( gn, map );
        }
        
        for( Entry<UndirectedGraphNode, UndirectedGraphNode>  e : map.entrySet() )
        {
            final UndirectedGraphNode parentNode = e.getKey();
            final UndirectedGraphNode cloneNode = e.getValue();
            
            for( UndirectedGraphNode ug : parentNode.neighbors )
            {
                cloneNode.neighbors.add( map.get( ug ) );
            }
        }
        
        return map.get( node );
    }
    
    private void cloneIt( UndirectedGraphNode node, final Map<UndirectedGraphNode, UndirectedGraphNode> map )
    {
        if( map.containsKey( node ))
        {
            return;
        }
        
        map.put( node, new UndirectedGraphNode( node.label ) );
        
        for( UndirectedGraphNode gn : node.neighbors )
        {
            cloneIt( gn, map );
        }
        
    }
}

class UndirectedGraphNode
{
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode( int x )
    {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

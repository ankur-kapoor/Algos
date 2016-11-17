package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


*/

public class LCA2
{
    
    public int lca(TreeNode root, int p, int q) 
    {
        return parseTree( root, p, q );
    }
    
    private int parseTree( TreeNode node, Integer p, Integer q )
    {
        final Map<Integer, Integer> mapTree = new HashMap<>();
        mapTree.put( node.val, null );
        
        final Stack<TreeNode> st = new Stack<>();
        
        st.push( node );
        
        while( !mapTree.containsKey( p ) || !mapTree.containsKey( q ))
        {
            node = st.pop();

            if( null != node.left )
            {
                mapTree.put( node.left.val, node.val );
                st.push( node.left );
            }
            
            if( null != node.right )
            {
                mapTree.put( node.right.val, node.val );
                st.push( node.right );
            }
            
            if( st.isEmpty() )break;
        }
        
        if( !mapTree.containsKey( p ) || !mapTree.containsKey( q ) )
        {
            return -1;
        }
        
        final Set<Integer> an = new HashSet<>();
        
        while( p != null )
        {
            an.add( p );
            p = mapTree.get( p );
        }
        
        while( !an.contains( q ))
        {
            q = mapTree.get( q );
        }
        
        return q;
    }
    
    public static void main( String[] args )
    {
        final LCA2 tr = new LCA2();
        
        final TreeNode root = new TreeNode( 3 );
        
        root.left = new TreeNode(5);
        
        TreeNode p = root.left;
        
        root.right = new TreeNode(1);
        
       // TreeNode q = root.right;
        
        root.right.left = new TreeNode(0);
        
        root.right.right = new TreeNode(8);
        
        root.left.left = new TreeNode(6); 
        
        root.left.right = new TreeNode(2);
        
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode q = root.left.right.right;
        
        
        System.out.println( tr.lca( root, 5, 4 ) );
        
        
    } 
}

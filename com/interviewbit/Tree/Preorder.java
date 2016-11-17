package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3]. 
*/

public class Preorder
{
    public ArrayList<Integer> preorderTraversal(TreeNode root) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        preorder( root, res );
        return res;
    }
    
    private void preorder( TreeNode node, final ArrayList<Integer> res )
    {
        final Stack<TreeNode> st = new Stack<>();
        
        st.push( node );
        while( !st.isEmpty() )
        {
            TreeNode n = st.pop();
            res.add( n.val );
            
            if( n.right != null )
            {
                st.push( n.right );
            }
            
            if( n.left != null )
            {
                st.push( n.left );
            }
        }
    }
    
    private void preorder2( final TreeNode node, final List<Integer> res )
    {
        if( node == null )
        {
            return;
        }
        res.add( node.val );
        preorder2( node.left, res );
        preorder2( node.right, res );
    }
    
    public static void main( String[] args )
    {
        Integer[] in = {1,3};
        
        List<Integer> li = new ArrayList<>( Arrays.asList( in ));
        final Preorder ab = new Preorder();
        
        //System.out.println( "Given Tree = " + ab.sortedArrayToBST( li ) );
    }
}

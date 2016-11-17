package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2]. 
*/

public class Inorder
{
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        final List<Integer> res = new ArrayList<>();
        
        inorder2( root, res );
        
        return res;
    }
    
    private void inorder2( TreeNode node, final List<Integer> res )
    {
        final Stack<TreeNode> st = new Stack<>();
        
        while( node != null || !st.isEmpty() )
        {
            while( node != null )
            {
                st.push( node );
                node = node.left;
            }
            
            node = st.pop();
            res.add( node.val );
            node = node.right;
        }
    }
    
    private void inorder( final TreeNode node, final List<Integer> res )
    {
        if( node == null )
        {
            return;
        }
        inorder( node.left, res );
        res.add( node.val );
        inorder( node.right, res );
    }
    
    public static void main( String[] args )
    {
        Integer[] in = {1,3};
        
        List<Integer> li = new ArrayList<>( Arrays.asList( in ));
        final Inorder ab = new Inorder();
        
        //System.out.println( "Given Tree = " + ab.sortedArrayToBST( li ) );
    }
}

package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

*/

public class FlattenTree
{
    
    public void flatten(TreeNode root) 
    {
        if( root == null ) return;
        
        final Stack<TreeNode> st = new Stack<>();
        st.push( root );
        
        while( !st.isEmpty() )
        {
            TreeNode n = st.pop();
            
            while( n != null )
            {
                if( null != n.left && null != n.right )
                {
                    st.push( n.right );
                    n.right = n.left;
                    n.left = null;
                    n = n.right;
                }
                else if( null != n.left )
                {
                    n.right = n.left;
                    n.left = null;
                    n = n.right;
                }
                else if( null != n.right)
                {
                    n = n.right;
                }
                else
                {
                    n.right = !st.isEmpty() ? st.pop() : null;
                    n = n.right;
                }
            }
        }
    }
    
    public static void main( String[] args )
    {
        final FlattenTree tr = new FlattenTree();
        
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
        
        System.out.println( "Before " + root );
               //System.out.println( tr.lowestCommonAncestor( root, p, q ) );
        
        tr.flatten( root );
        
        System.out.println( "After " + root );
        
    } 
}

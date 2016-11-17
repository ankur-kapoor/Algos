package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/

public class RootToLeaf
{
    public int sumNumbers(TreeNode root) 
    {
        Stack<TreeNode> st = new Stack<>();
        st.push( root );
        final StringBuilder l = new StringBuilder();
        final StringBuilder r = new StringBuilder();
        
        l.append( root.val );
        r.append( root.val );
        
        int sum = 0;
        
        while( !st.isEmpty())
        {
            TreeNode t = st.pop();
            
            if( null != t.left )
            {
                st.push( t.left );
                l.append( t.left.val );
            }
            else
            {
                sum += Integer.valueOf( l.toString() );
                l.deleteCharAt( l.length()-1 );
            }
            
            if( null != t.right )
            {
                st.push( t.right );
                r.append( t.right.val );
            }
            else
            {
                sum += Integer.valueOf( r.toString() );
                r.deleteCharAt( r.length()-1 );
            }
        }
        
        return sum;
    }
    
    public static void main( String[] args )
    {
        final RootToLeaf tr = new RootToLeaf();
        
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
        
        System.out.println( "Sum = " + tr.sumNumbers( root ) );
        
        System.out.println( "After " + root );
        
    } 
}

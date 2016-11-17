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

public class RootToLeaf2
{
    public int sumNumbers(TreeNode root) 
    {
        return sum(root, 0);
    }
    
    private int sum(TreeNode n, int s)
    {
        if (n == null) return 0;
        if (n.right == null && n.left == null) return (s*10 + n.val)%1003;
        return sum(n.left, (s*10 + n.val)%1003) + sum(n.right, (s*10 + n.val)%1003);
    }
    
    public static void main( String[] args )
    {
        final RootToLeaf2 tr = new RootToLeaf2();
        
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

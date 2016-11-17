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

public class InorderAndPreOrder
{
    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) 
    {
        return helper(0, 0, inorder.size() - 1, preorder, inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        if (preStart > preorder.size() - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder.get( preStart ));
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder.get( i ) == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
    
    public static void main( String[] args )
    {
        final InorderAndPreOrder tr = new InorderAndPreOrder();
        
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
        
        //System.out.println( "Sum = " + tr.sumNumbers( root ) );
        
        System.out.println( "After " + root );
        
    } 
}

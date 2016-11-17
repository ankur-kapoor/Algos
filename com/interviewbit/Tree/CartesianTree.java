package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Generate a Binary tree from Inorder and postorder 
 * */

public class CartesianTree
{
    public TreeNode buildTree( ArrayList<Integer> inOrder ) 
    {
        return build( 0, inOrder.size()-1, inOrder );
    }

    private TreeNode build( int inSt, int inEnd, ArrayList<Integer> inOrder )
    {
        if( inSt > inEnd )
        {
            return null;
        }
        
        // finding index of Max element
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for( int i = inSt; i <= inEnd; i++ )
        {
            if( inOrder.get( i ) > max )
            {
                max = inOrder.get( i );
                maxIndex = i;
            }
        }
        
        final TreeNode root = new TreeNode( max );
        
        root.left = build( inSt, maxIndex-1, inOrder );
        root.right = build( maxIndex+1, inEnd, inOrder );
        
        return root;
    }
    
    public static void main( String[] args )
    {
        final CartesianTree tr = new CartesianTree();
        
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

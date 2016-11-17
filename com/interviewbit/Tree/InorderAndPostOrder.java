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

public class InorderAndPostOrder
{
    public TreeNode buildTree(ArrayList<Integer> postOrder, ArrayList<Integer> inOrder) 
    {
        final Map<Integer, Integer> map = new HashMap<>();
        
        for( int i =0; i < inOrder.size(); i++ )
        {
            map.put( inOrder.get( i ), i );
        }
        
        return build( 0, postOrder.size()-1, 0, inOrder.size()-1, postOrder, inOrder, map );
    }

    private TreeNode build( int postStart, int postEnd, int inSt, int inEnd, ArrayList<Integer> postOrder, ArrayList<Integer> inOrder, final Map<Integer, Integer> map )
    {
        if( postStart > postEnd || inSt > inEnd )
        {
            return null;
        }
        
        int rootVal = postOrder.get( postEnd );
        final TreeNode root = new TreeNode( rootVal );
        
        // finding index of root in inorder
        
        int rootIndex = map.get( rootVal );
        
        root.left = build( postStart, postStart + rootIndex - inSt -1, inSt, rootIndex-1, postOrder, inOrder, map );
        root.right = build( postStart + rootIndex - inSt, postEnd-1, rootIndex+1, inEnd, postOrder, inOrder, map );
        
        return root;
    }
    
    public static void main( String[] args )
    {
        final InorderAndPostOrder tr = new InorderAndPostOrder();
        
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

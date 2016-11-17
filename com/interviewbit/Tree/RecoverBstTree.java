package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
 * @author ankurkap
 *
 */
public class RecoverBstTree
{
    public void recoverTree(TreeNode root) 
    {
        final List<TreeNode> list = new ArrayList<>();
        recover( root, list );
        
        if( list.size() == 2 )
        {
            swap( list.get( 0 ), list.get( 1 ) );
        }
    }
    
    private void recover( TreeNode node, final List<TreeNode> list )
    {
        final Stack<TreeNode> st = new Stack<>();
        TreeNode prev = new TreeNode( Integer.MIN_VALUE );
        
        while( node != null || !st.isEmpty() )
        {
            
            while( node!= null )
            {
                st.push( node );
                node = node.left;
            }
            
            node = st.pop();
            
            if( list.size() == 0 && prev.val >= node.val )
            {
                list.add( prev );
            }
            
            if( list.size() > 0 && prev.val >= node.val )
            {
                if( list.size() == 1 )
                {
                    list.add( node );
                }
                else
                {
                    list.set( 1, node );
                }
            }
            
            prev = node;
            
            node =  node.right;
        }
    }

    private void swap( TreeNode n1, TreeNode n2 )
    {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    public static void main( String[] args )
    {
        final TreeNode root = new TreeNode( 3 );
        
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(1);
        
      /*  root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(15);*/
        
        final RecoverBstTree t = new RecoverBstTree();
        
        System.out.println( " Before recovery = " + root );
        t.recoverTree( root );
        System.out.println( " After recovery = " + root );
        //System.out.println( "Given Tree = " + root );
        
    }
}

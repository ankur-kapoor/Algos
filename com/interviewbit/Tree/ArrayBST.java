package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST. *
 */

public class ArrayBST
{
    public TreeNode sortedArrayToBST( final List<Integer> a ) 
    {
        int n = a.size();
        
        if( n == 0)
        {
            return null;
        }
        
        if( n == 1)
        {
            return new TreeNode( a.get( 0 ));
        }
        
        int l = 0;
        int h = n;
        int mid = l + (h-l)/2;
        
         TreeNode root = new TreeNode( a.get( mid ));
        
        root.left = arrangeBST( a, l, mid-1 );
        root.right = arrangeBST( a, mid+1, h-1 );
        
        return root;
    }
    
    private TreeNode arrangeBST( final List<Integer> a, int l, int h )
    {
        if( l == h )
        {
            return new TreeNode(a.get( l ));
        }
        else if( l < h )
        {
            int mid = l + (h-l)/2;
            TreeNode node = new TreeNode( a.get( mid ));
            node.left = arrangeBST( a, l, mid-1 );
            node.right = arrangeBST( a, mid+1, h );
            
            return node;
        }
        
        return null;
    }
    
    public static void main( String[] args )
    {
        Integer[] in = {1,3};
        
        List<Integer> li = new ArrayList<>( Arrays.asList( in ));
        final ArrayBST ab = new ArrayBST();
        
        System.out.println( "Given Tree = " + ab.sortedArrayToBST( li ) );
    }
}

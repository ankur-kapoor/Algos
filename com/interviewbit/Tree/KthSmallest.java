package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it. *
 */

public class KthSmallest
{
    public int kthSmallest(TreeNode root, int k) 
    {
        int c = countK( root.left );
        
        if( k <= c )
        {
            return kthSmallest( root.left, k );
        }
        else if( k > c+1)
        {
            return kthSmallest( root.right, k-c-1 );
        }
        
        return root.val;
    }
    
    private int countK( final TreeNode node )
    {
        if( node == null )
        {
            return 0;
        }
        
       return 1 + countK( node.left ) + countK( node.right ); 
    }
    
    public static void main( String[] args )
    {
        Integer[] in = {1,3};
        
        List<Integer> li = new ArrayList<>( Arrays.asList( in ));
        final KthSmallest ab = new KthSmallest();
        
        //System.out.println( "Given Tree = " + ab.sortedArrayToBST( li ) );
    }
}

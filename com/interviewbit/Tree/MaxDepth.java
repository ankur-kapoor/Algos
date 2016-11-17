package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class MaxDepth
{
    public int maxDepth(TreeNode root) 
    {
        if( null == root )
        {
            return 0;
        }
        
        int l = maxDepth( root.left );
        int r = maxDepth( root.right );
        
        return  l > r ? l+1 : r+1;
    }
    
    public static void main( String[] args )
    {
        Integer[] in = {1,3};
        
        List<Integer> li = new ArrayList<>( Arrays.asList( in ));
        final MaxDepth ab = new MaxDepth();
        
        //System.out.println( "Given Tree = " + ab.sortedArrayToBST( li ) );
    }
}

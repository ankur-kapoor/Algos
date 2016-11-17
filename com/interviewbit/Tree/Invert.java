package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */

public class Invert
{
    public TreeNode invertTree(TreeNode root) 
    {
        invertNode( root );
        
        return root;
    }
    
    private void invertNode( TreeNode node )
    {
        if( node == null )
        {
            return;
        }
        
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        invertNode( node.left );
        invertNode( node.right );
    }
    
    public static void main( String[] args )
    {
        Integer[] in = {1,3};
        
        List<Integer> li = new ArrayList<>( Arrays.asList( in ));
        final Invert ab = new Invert();
        
        //System.out.println( "Given Tree = " + ab.sortedArrayToBST( li ) );
    }
}

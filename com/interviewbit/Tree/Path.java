package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.*/

public class Path
{
    public boolean hasPathSum(TreeNode root, int sum) 
    {
        if( null == root ) return false;
        
        if( root.left == null && root.right == null)
        {
            if( root.val == sum ) return true;
            
            return false;
        }
        
        if(pathSum( root.left, sum, root.val ))
        {
            return true;
        }
        
        return pathSum( root.right, sum, root.val );
    }
    
    private boolean pathSum( TreeNode node, int target, int c )
    {
        final Stack<TreeNode> st = new Stack<>();
        
        int sum = c;
        while( node != null || !st.isEmpty() )
        {
            while( node != null )
            {
                st.push( node );
                sum += node.val;
                node = node.left;
            }
            
            node = st.pop();
            if( sum == target && node.right == null ) return true;
            
            sum -= node.val;
            node = node.right;
        }
        
        return false;
    }
    
    public static void main( String[] args )
    {
        Integer[] in = {1,3};
        
        List<Integer> li = new ArrayList<>( Arrays.asList( in ));
        final Path ab = new Path();
        TreeNode root = new TreeNode( 2 );
        
        root.add( 1 );
        root.add( 4 );
        root.add( 3 );
        root.add( 5 );
        
        //System.out.println( "Given Tree = " + ab.sortedArrayToBST( li ) );
        
        System.out.println( " Given Path = " + ab.hasPathSum( root, 6 ) );
    }
}

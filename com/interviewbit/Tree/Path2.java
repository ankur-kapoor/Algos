package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example, given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
the method returns the following:

[
   [5,4,11,2],
   [5,8,4,5]
]*/

public class Path2
{
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) 
    {
        final ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if( root == null ) return res;
        
        final ArrayList<Integer> path = new ArrayList<Integer>();
        
        path.add( root.val );
        dfs( root, sum - root.val, path, res );
        
        return res;
    }
    
    private void dfs( TreeNode node, int sum, ArrayList<Integer> path, final ArrayList<ArrayList<Integer>> res )
    {
        if( node == null )
        {
            return;
        }
        
        if( 0 == sum && node.left == null && node.right == null )
        {
            res.add( new ArrayList<>(path) );
            return;
        }
        
        if( null != node.left )
        {
            path.add( node.left.val );
            dfs( node.left, sum-node.left.val, path, res );
            path.remove( path.size()-1 );
        }
        
        if( null != node.right )
        {
            path.add( node.right.val );
            dfs( node.right, sum-node.right.val, path, res );
            path.remove( path.size()-1 );
        }
    }
    
    public static void main( String[] args )
    {
        Integer[] in = {1,3};
        
        List<Integer> li = new ArrayList<>( Arrays.asList( in ));
        final Path2 ab = new Path2();
        TreeNode root = new TreeNode( 1 );
        
        root.add( 0 );
        root.add( 1 );
        
        //System.out.println( "Given Tree = " + ab.sortedArrayToBST( li ) );
        
        System.out.println( " Given Path = " + ab.pathSum( root, 1 ) );
    }
}

package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.interviewbit.Tree.TreeNode;
/**
 * Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 * @author ankurkap
 *
 */
public class MaxSumPath
{
    public int maxPathSum( TreeNode root )
    {
        int[] max = new int[ 1 ];
        max[0] = Integer.MIN_VALUE;
        
        final Map<TreeNode, Integer> m = new HashMap<>();
        maxPathSum( max, root, m );
        return max[0];
    }

    private int maxPathSum( int[] max, TreeNode root, final Map<TreeNode, Integer> m )
    {
        if ( root == null )
            return 0;
        
        if( m.containsKey( root )) return m.get( root );
        
        int leftMax = Math.max( 0, maxPathSum( max, root.left, m ) );
        int rightMax = Math.max( 0, maxPathSum( max, root.right, m ) );
        max[0] = Math.max( max[0], root.val + leftMax + rightMax );
        
        int t = root.val + Math.max( leftMax, rightMax );
        m.put( root, t );
        return t;
    }
    
    public static void main( String[] args )
    {
        ArrayList<ArrayList<Integer>> nums = new ArrayList<>();
        
        ArrayList<Integer> a = new ArrayList<>();
        a.add( 74 );
        a.add( 37 );
        a.add( 82 );
        a.add( 1 );
        
        nums.add( a );
        
        a = new ArrayList<>();
        a.add( 66 );
        a.add( 38 );
        a.add( 16 );
        a.add( 1 );
        
        nums.add( a );
        
        final MaxSumPath ms = new MaxSumPath();
        
        //System.out.println( "Maximum Sum = "+ ms.adjacent( nums ) );
    }
}

package com.interviewbit.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]. 
*/

public class ZigZagTree
{
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        final ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        if( null == root ) return res;
        
        zigZag( root, res );
        
        return res;
    }
    
    private void zigZag( TreeNode node, final ArrayList<ArrayList<Integer>> res )
    {
        final Deque<TreeNode> q = new ArrayDeque<>();
        q.push( node );
        
        final Deque<TreeNode> p = new ArrayDeque<>();
        final ArrayList<Integer> ab = new ArrayList<>();
        ab.add( node.val );
        res.add( ab );
        
        boolean order = false;
        // 0 - left to right
        // 1 - right to left
        while( !q.isEmpty())
        {
            TreeNode n = order ? q.poll() : q.pollLast();
                
            if( null != n.left )
            {
                p.push( n.left );
            }
            
            if( null != n.right )
            {
                p.push( n.right );
            }
            
            if( q.isEmpty() && !p.isEmpty())
            {
                final ArrayList<Integer> a = new ArrayList<>();
                
                while( !p.isEmpty())
                {
                    TreeNode t;
                    if( !order )
                    {
                        t = p.poll();
                    }
                    else
                    {
                        t = p.pollLast();
                    }
                    
                    q.push( t );
                    a.add( t.val );
                    
                }
                res.add( a );
                order = !order;
            }
        }
    }
    
    public static void main( String[] args )
    {
        Integer[] in = {1,3};
        
        List<Integer> li = new ArrayList<>( Arrays.asList( in ));
        final ZigZagTree ab = new ZigZagTree();
        
        TreeNode root = new TreeNode( 3 );
        
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
               
        System.out.println( "ZigZag Traversal Tree = " + ab.zigzagLevelOrder( root ) );
    }
}

package com.interviewbit.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.interviewbit.Tree.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Also think about a version of the question where you are asked to do a level order traversal of the tree when depth of the tree is much greater than number of nodes on a level.
 * @author ankurkap
 *
 */

public class LevelOrder
{
    
    public ArrayList<ArrayList<Integer>> levelOrder( TreeNode node )
    {
        final ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        if( node == null ) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add( node );
        Queue<TreeNode> temp = new LinkedList<>();
        
        ArrayList<Integer> l = new ArrayList<>();
        while( !q.isEmpty())
        {
            final TreeNode t = q.poll();
            l.add( t.val );
            
            if( null != t.left )
            {
                temp.add( t.left );
            }
            
            if( null != t.right )
            {
                temp.add( t.right );
            }
            
            if( q.isEmpty() )
            {
                res.add( l );
                l = new ArrayList<>();
                q = temp;
                temp = new LinkedList<>();
            }
        }
        
        return res;
    }
    
    public static void main( String[] args )
    {
        final LevelOrder bs = new LevelOrder();
        
        final ArrayList<String> grid = new ArrayList<>();
        
        grid.add( "OOOXOOO" );
        grid.add( "OOXXOXO" );
        grid.add( "OXOOOXO" );
        
        //System.out.println( "No. of Black Shapes = " + bs.black( grid )  );
    }
    
}


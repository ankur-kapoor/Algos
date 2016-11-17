package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.

Return 1 to denote that two such nodes exist. Return 0, otherwise.

Notes 
- Your solution should run in linear time and not take memory more than O(height of T).
- Assume all values in BST are distinct.

Example :

Input 1: 

T :       10
         / \
        9   20

K = 19

Return: 1

Input 2: 

T:        10
         / \
        9   20

K = 40

Return: 0
 * @author ankurkap
 *
 */
public class TwoSumBinaryTree
{
    public int t2Sum(TreeNode A, int B) 
    {
        if( resolve( A, B )) return 1;
        
        return 0;
    }
    
    private boolean resolve( TreeNode node, int b )
    {
        final Stack<TreeNode> st = new Stack<>();
        
        List<Integer> nums = new ArrayList<>();
        while( node != null  || !st.isEmpty() )
        {
            while( node!= null )
            {
                st.push( node );
                node = node.left;
            }
            
            node = st.pop();
            
            nums.add( node.val );
            
            if( nums.size() > 1 )
            {
                for( int i =0; i < nums.size()-1; i++ )
                {
                    boolean doBreak = false;
                    
                    if( nums.get( i ) >= b ) return false;
                    for( int j =i+1; j < nums.size(); j++ )
                    {
                        if( nums.get( i ) + nums.get( j ) == b )
                        {
                            return true;
                        }
                        else if( nums.get( i ) + nums.get( j )> b )
                        {
                            doBreak = true;
                            break;
                        }
                    }
                    
                    if( doBreak )
                    {
                        break;
                    }
                }
            }
            
            node = node.right;
        }
        
        return false;
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
        
        final TwoSumBinaryTree t = new TwoSumBinaryTree();
        
        System.out.println( " Before recovery = " + root );
        //t.recoverTree( root );
        System.out.println( " After recovery = " + root );
        //System.out.println( "Given Tree = " + root );
        
    }
}

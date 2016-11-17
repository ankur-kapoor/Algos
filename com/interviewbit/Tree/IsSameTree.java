package com.interviewbit.Tree;

/**
 * Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value. *
 */

public class IsSameTree
{
    public int isSameTree(TreeNode p, TreeNode q) 
    {
        if(isSame( p, q ))
        {
            return 1;
        }
        
        return 0;
    }
    
    private boolean isSame( TreeNode p, TreeNode q )
    {
        if( p == null && q == null )
        {
            return true;
        }
        else if( p == null && q != null ||  p != null && q == null )
        {
            return false;
        }
        
        if( p.val == q.val )
        {
            return isSame( p.left, q.left ) && isSame( p.right, q.right ); 
        }
        else
        {
            return false;
        }
    }

    public static void main( String[] args )
    {
        final TreeNode root = new TreeNode( 9 );
        
        root.add( 10 );
        root.add( 5 );
        root.add( 7 );
        root.add( 11 );
        root.add( 15 );
        root.add( 3 );
        root.add( 4 );
        
        System.out.println( "Given Tree = " + root );
    }
}

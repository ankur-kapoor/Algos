package com.interviewbit.Tree;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
 * @author ankurkap
 *
 */

public class IsSymmetric
{
    public int isSymmetric(TreeNode root) 
    {
        if( root ==  null) return 1;
        if(isSymmetric( root.left, root.right ))
        {
            return 1;
        }
        
        return 0;
    }
    
    private boolean isSymmetric( TreeNode p, TreeNode q )
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
            return isSymmetric( p.left, q.right ) && isSymmetric( p.right, q.left );
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

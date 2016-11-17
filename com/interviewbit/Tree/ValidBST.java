package com.interviewbit.Tree;

public class ValidBST
{
    public int isValidBST(TreeNode a) 
    {
        if( a == null ) return 1;
        
        if( isBST(a, Integer.MIN_VALUE, Integer.MAX_VALUE ))
        {
            return 1;
        }
        return 0;
    }
    
    private boolean isBST( TreeNode a, int minVal, int maxVal )
    {
        if( null == a ) return true;
        
        if( a.val >= maxVal || a.val <= minVal ) return false;
        
        return isBST( a.left, minVal, a.val ) && isBST( a.right, a.val, maxVal );
    }
    
    public static void main( String[] args )
    {
        ValidBST vs = new ValidBST();
        final TreeNode root = new TreeNode( 2 );
        
        root.left = new TreeNode( 1 );
        root.right = new TreeNode( 4 );
        
        root.right.left = new TreeNode( 3 );
        root.right.left.right = new TreeNode( 5 );
        
        
        System.out.println( "is BST = " + vs.isValidBST( root ) );
    }
}

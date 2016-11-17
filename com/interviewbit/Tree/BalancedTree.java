package com.interviewbit.Tree;

public class BalancedTree
{
    private boolean m_result = true;
    public boolean isBalanced(TreeNode root) 
    {
        maxDepth(root);
        
        return m_result;
    }
    
    private int maxDepth( final TreeNode node )
    {
        if( node == null )
        {
            return 0;
        }
        
        int l = maxDepth( node.left );
        
        int r = maxDepth( node.right );
        
        if( Math.abs( l-r ) > 1 ) m_result = false;
        
        return 1 + Math.max( l, r );
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

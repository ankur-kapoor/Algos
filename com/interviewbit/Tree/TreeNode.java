package com.interviewbit.Tree;

public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    static String LEFT = "/";
    static String RIGHT = "\\";
    public TreeNode( int x )
    {
        val = x;
    }
    
    public TreeNode( int h, int c )
    {
        val = h;
    }
    
    public void add( int x )
    {
        addNode( x, this );
    }
    
    private void addNode( int x, TreeNode t)
    {
        if( x <= t.val )
        {
            if( t.left == null )
            {
                TreeNode c = new TreeNode(x);
                t.left = c;
                return;
            }
            else
            {
                addNode( x, t.left );
            }
        }
        else
        {
            if( t.right == null )
            {
                TreeNode c = new TreeNode(x);
                t.right = c;
                return;
            }
            else
            {
                addNode( x, t.right );
            }
        }
    }
    
    public String toString()
    {
        return printTree( this );
    }
    
    private String printTree( TreeNode node )
    {
        if( node.left == null && node.right == null )
        {
            return "|"+node.val+"|";
        }
        else
        {
            String l = "";
            if( null != node.left )
            {
                l = printTree( node.left );
                
            }
            
            String r = "";
            if( null != node.right )
            {
                 r=  printTree( node.right );
            }
            
            String lr = "|" + node.val + "|".concat( "\n" ).concat( this.LEFT ).concat( RIGHT ).concat( "\n" ).concat( l ).concat( "  ").concat(r);
            
            return lr;
        }
        
    }
}

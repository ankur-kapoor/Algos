package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1]. 
*/

public class Postorder
{
    public ArrayList<Integer> postorderTraversal(TreeNode root) 
    {
        final ArrayList<Integer> res = new ArrayList<>();
        
        if( null == root ) return res;
        postorder( root, res );
        
        return res;
    }
    
    private void postorder( TreeNode node, final ArrayList<Integer> res )
    {
        final Stack<TreeNode> stMaster = new Stack<>();
        final Stack<Integer> stSlave = new Stack<>();
        
        stMaster.push( node );
        
        while( !stMaster.isEmpty())
        {
            TreeNode t = stMaster.pop();
            
            if( t.left != null )
            {
                stMaster.push( t.left );
            }
            
            if( t.right != null )
            {
                stMaster.push( t.right );
            }
            
            stSlave.push( t.val );
        }
        
        while( !stSlave.isEmpty())
        {
            res.add( stSlave.pop() );
        }
    }
    
    private void postorder2( final TreeNode node, final List<Integer> res )
    {
        if( node == null )
        {
            return;
        }
        postorder2( node.left, res );
        postorder2( node.right, res );
        res.add( node.val );
    }
    
    
    
    
    
    public static void main( String[] args )
    {
        Integer[] in = {1,3};
        
        List<Integer> li = new ArrayList<>( Arrays.asList( in ));
        final Postorder ab = new Postorder();
        
        //System.out.println( "Given Tree = " + ab.sortedArrayToBST( li ) );
    }
}

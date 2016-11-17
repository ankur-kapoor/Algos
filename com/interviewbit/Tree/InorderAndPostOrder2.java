package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Generate a Binary tree from Inorder and postorder 
 * */

public class InorderAndPostOrder2
{
    public TreeNode buildTree( int[] inorder, int[] postorder ) 
    {
        final Map<Integer, Integer> map = new HashMap<>();
        
        for( int i =0; i < inorder.length; i++ )
        {
            map.put( inorder[i], i );
        }
        
        return build( 0, postorder.length-1, 0, inorder.length-1, postorder, inorder, map );
    }

    private TreeNode build( int postStart, int postEnd, int inSt, int inEnd, int[] postOrder, int[] inOrder, Map<Integer, Integer> map )
    {
        
        if( postStart > postEnd || inSt > inEnd )
        {
            return null;
        }
        
        int rootVal = postOrder[ postEnd ];
        final TreeNode root = new TreeNode( rootVal );
        
        // finding index of root in inorder
        
        int rootIndex = map.get( rootVal );

        root.left = build( postStart, postStart+ rootIndex -inSt -1, inSt, rootIndex-1, postOrder, inOrder, map );
        root.right = build( postStart+ rootIndex -inSt, postEnd-1, rootIndex+1, inEnd, postOrder, inOrder, map );
        
        return root;
    }
}

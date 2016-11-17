package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeApp
{
    public List<Integer> countSmaller( int[] nums )
    {
        if( null == nums || nums.length == 0 )
        {
            return null;
        }
        
        int n = nums.length;
        
        final TreeNode root = new TreeNode( nums[n-1] );
        final List<Integer> res = new ArrayList<Integer>();
        res.add( 0 );
        for( int i = n-2; i >=0 ; i-- )
        {
            res.add( insertNode( root, nums[i] ) );
        }
        
        Collections.reverse( res );
        
        return res;
    }
    
    private int insertNode( TreeNode root, int value )
    {
        int cnt = 0;
        
        while( true )
        {
            if( value <= root.val )
            {
                root.weight++;
                
                if( root.left == null )
                {
                    root.left = new TreeNode( value );
                    break;
                }
                else
                {
                    root = root.left;
                }
            }
            else
            {
                cnt += root.weight;
                
                if( root.right == null )
                {
                    root.right = new TreeNode( value );
                    break;
                }
                else
                {
                    root = root.right;
                }
            }
        }
        
        return cnt;
    }
    
    static class TreeNode
    {
        TreeNode left;
        TreeNode right;
        
        int val;
        int weight = 1;
        
        TreeNode( int value )
        {
            val = value;
        }
    }
    
    public static void main( String[] args )
    {
        final TreeApp treeApp = new TreeApp();
        
        final int[] nums = {5, 2, 6, 1};
        
        System.out.println( treeApp.countSmaller( nums ));
    }
}

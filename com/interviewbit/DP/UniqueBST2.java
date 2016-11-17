package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.interviewbit.Tree.TreeNode;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 
 */

public class UniqueBST2
{
    /**
     * This number generation pattern is also called as CATALAN numbers 
     * 
     * Presumptions - 
     * 
     * T[0] - 1
     * T[1] - 1  i.e. when n =1 , then only 1 BST is possible.
     *    
     */
    
    public static ArrayList<TreeNode> generateTrees(int n) 
    {
        if( n == 0 )
        {
            return new ArrayList<TreeNode>();
        }
        
        ArrayList<TreeNode>[] result = new ArrayList[n+1];
        result[0] = new ArrayList<TreeNode>();
        result[0].add(null);

        for(int len = 1; len <= n; len++){
            result[len] = new ArrayList<TreeNode>();
            for(int j=0; j<len; j++){
                for(TreeNode nodeL : result[j]){
                    for(TreeNode nodeR : result[len-j-1]){
                        TreeNode node = new TreeNode(j+1);
 //                       node.left = nodeL;
 //                       node.right = clone(nodeR, j+1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private static TreeNode clone(TreeNode n, int offset){
        if(n == null)
            return null;
     //   TreeNode node = new TreeNode(n.val + offset);
   //     node.left = clone(n.left, offset);
   //     node.right = clone(n.right, offset);
     //   return node;
        return null;
    }
    
    public static void main( String[] args )
    {
        UniqueBST2 hp = new UniqueBST2();
        
        int[] nums ={0, -1, 3, 100, 70, 50};
        
     //   System.out.println( " No. of BSTs possible = " + hp.numTrees( 5 ) );
    }
}

package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 * @author ankurkap
 *
 */

public class SkyLine
{
    public List<int[]> getSkyline(int[][] buildings)
    {
        final List<int[]> res = new ArrayList<>();
        
        final List<Building> builds = new ArrayList<>();
        for( int[] b : buildings )
        {
            builds.add( new Building( b[0], b[1], b[2] ) );
        }
        
        Collections.sort( builds );
        
        
        final TreeNode root = createIntervalTree( builds, 0, builds.size()-1 );
        
        
        return res;
    }
    
    private TreeNode createIntervalTree(  final List<Building> buildings, int low, int high )
    {
        if( low > high )
        {
            return null;
        }
        
        int mid = low + (high-low)/2;
        
        TreeNode root = new TreeNode( buildings.get( mid ) );
        
        root.left = createIntervalTree( buildings, low, mid-1 );
        root.right = createIntervalTree( buildings, mid+1, high );
        
        return root;
    }
    
    static class TreeNode
    {
        final Building build;
        TreeNode left;
        TreeNode right;
        
        TreeNode( final Building building )
        {
            build = building;
        }
    }
    
    static class Building implements Comparable<Building>
    {
        Integer li;
        Integer ri;
        Integer hi;
        
        Building( int l, int r, int h )
        {
            li = l;
            ri = r;
            hi = h;
        }

        @Override
        public int compareTo( Building o )
        {
            if( li.compareTo( o.li ) == 0 )
            {
                return o.hi.compareTo( hi );
            }
            else
            {
                return li.compareTo( o.li );
            }
        }
    }
    
    public static void main( String[] args )
    {
        final SkyLine treeApp = new SkyLine();
        
        final int[] nums = {5, 2, 6, 1};
        
        //System.out.println( treeApp.countSmaller( nums ));
    }
}

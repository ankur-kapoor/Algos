package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)  -3  3
-5  -10 1
10  30  -5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class DungeonPrincess
{
    class DungeonPath
    {
        int pathSum;
        int health;
        
        DungeonPath( int path, int helth )
        {
            pathSum = path;
            health = helth;
        }
    }
    
    public int calculateMinimumHP(int[][] dungeon) 
    {
        if( null == dungeon || dungeon.length == 0 )
        {
            return 0;
        }
        
        int n = dungeon.length;
        int m = dungeon[0].length;
        
        DungeonPath[][] dp = new DungeonPath[n][m];
        
        int a1 = dungeon[0][0];
        
        final DungeonPath first;
        if( a1 < 1 )
        {
            first = new DungeonPath( 1, Math.abs( a1 )+1 );
        }
        else
        {
            first = new DungeonPath( a1, 1 );
        }
        
        final DungeonPath s;
        if( dungeon[0].length == 1 && dungeon.length == 1 )
        {
            s = first;
        }
        else if( dungeon[0].length == 1  )
        {
            s = evaluateMin( first, findMin( dungeon, 1, 0, dp ) );
        }
        else if( dungeon.length == 1 )
        {
            s = evaluateMin( first, findMin( dungeon, 0, 1, dp ) );
        }
        else
        {
            s = evaluateMin( first, findMin( dungeon, 1, 0, dp ), findMin( dungeon, 0, 1, dp ));
        }
        
        return s.health;
    }
    
    private DungeonPath findMin( int[][] dungeon, int r, int c, DungeonPath[][] dp )
    {
        if( dungeon.length-1 == r && dungeon[0].length-1== c )
        {
            dp[r][c] = new DungeonPath( dungeon[r][c], dungeon[r][c]);
            return dp[r][c];
        }
        
        if( r == dungeon.length-1 )
        {
            dp[r][c] = evaluateMin( new DungeonPath( dungeon[r][c], dungeon[r][c] ), findMin( dungeon, r, c+1, dp ) );
            return dp[r][c]; 
        }
        
        if( c == dungeon[0].length-1 )
        {
            dp[r][c] = evaluateMin( new DungeonPath( dungeon[r][c], dungeon[r][c] ), findMin( dungeon, r+1, c, dp ) );
            return dp[r][c];
        }
        
        if( null != dp[r][c])
        {
            return dp[r][c];
        }
        
        dp[r][c] = evaluateMin( new DungeonPath(dungeon[r][c], dungeon[r][c]), findMin( dungeon, r+1, c, dp ), findMin( dungeon, r, c+1, dp ) );
        
        return dp[r][c];
    }
    
    private DungeonPath evaluateMin( final DungeonPath dg, final DungeonPath c  )
    {
        dg.pathSum += c.pathSum;
        
        if( dg.pathSum <= dg.health )
        {
            int t = dg.health - Math.abs( dg.pathSum -1);
            dg.health += Math.abs( t )+1;
        }
       
        return dg;
    }
    
    private DungeonPath evaluateMin( final DungeonPath dg, final DungeonPath a, final DungeonPath b  )
    {
        DungeonPath c = choosePath( a, b );
        dg.pathSum += c.pathSum;
        
        if( dg.pathSum <= dg.health )
        {
            int t = dg.health - Math.abs( dg.pathSum -1);
            dg.health += Math.abs( t )+1;
        }
        
        return dg;
    }
    
    private DungeonPath choosePath( final DungeonPath a, final DungeonPath b  )
    {
        if( a.pathSum >=0 && b.pathSum >= 0 )
        {
            if( a.pathSum < b.pathSum )
            {
                return a;
            }
            return b;
        }
        else if( a.pathSum >=0 && b.pathSum < 0 )
        {
            return a;
        }
        else if( a.pathSum < 0  && b.pathSum >= 0 )
        {
            return b;
        }
        else 
        {
            if( Math.abs( a.pathSum ) < Math.abs( b.pathSum ))
            {
                return a;
            }
            
            return b;
        }
    }
    
    public static void main( String[] args )
    {
        DungeonPrincess hp = new DungeonPrincess();
        
        int[][] nums ={{1,-3,3},{0,-2,0},{-3,-3,-3}};
        
        //final ArrayList<Integer> a = new ArrayList<>(Arrays.asList( nums ));
        System.out.println( " Min Path = " + hp.calculateMinimumHP( nums ) );
    }
}

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
public class DungeonPrincess2
{
    
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> dungeon) 
    {
        if( null == dungeon || dungeon.size() == 0 )
        {
            return 0;
        }
        
        int n = dungeon.size();
        int m = dungeon.get( 0 ).size();
        
        int[] dp = new int[n+1];
        
        for( int i=0; i <= n; i++ )
        {
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[n-1] =1;
        for( int i = m-1; i >= 0; i-- )
        {
            for( int j = n-1; j >= 0; j-- )
            {
                dp[j] = Math.min( dp[j], dp[j+1] ) - dungeon.get( j ).get( i );
                dp[j] = Math.max( 1, dp[j] );
            }
        }
        
        return dp[0];
    }
    
    
    public static void main( String[] args )
    {
        DungeonPrincess2 hp = new DungeonPrincess2();
        
        int[][] nums ={{0,-3}};
        
        //final ArrayList<Integer> a = new ArrayList<>(Arrays.asList( nums ));
       // System.out.println( " Min Path = " + hp.calculateMinimumHP( nums ) );
    }
}

package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GYou are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs
{
    public int climbStairs(int n) 
    {
        final List<Integer> memo = new ArrayList<>();
        memo.add( 1 );
        memo.add( 1 );
        
        for( int i = 2; i<= n; i++ )
        {
            memo.add( memo.get( i-2 ) + memo.get( i-1 ) );
        }
        
        return memo.get( memo.size()-1 );
    }
    
    public static void main( String[] args )
    {
        ClimbingStairs hp = new ClimbingStairs();
        
        int[] nums ={0, -1, 3, 100, 70, 50};
        
        System.out.println( " Climbing Stairs " + hp.climbStairs( 4 ) );
    }
}

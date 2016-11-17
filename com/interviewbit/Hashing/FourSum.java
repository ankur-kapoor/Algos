package com.interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2) */

public class FourSum
{
    public ArrayList<ArrayList<Integer>> fourSum( ArrayList<Integer> num, int target )
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if ( num.size() < 4 )
            return ans;
        Collections.sort( num );
        for ( int i = 0; i < num.size() - 3; i++ )
        {
            if ( i > 0 && num.get( i ) == num.get( i-1 ) )
                continue;
            for ( int j = i + 1; j < num.size() - 2; j++ )
            {
                if ( j > i + 1 && num.get( j ) == num.get( j-1 ) )
                    continue;
                int low = j + 1, high = num.size() - 1;
                while ( low < high )
                {
                    int sum = num.get( i ) + num.get( j ) + num.get( low ) + num.get( high );
                    if ( sum == target )
                    {
                        ans.add( new ArrayList<Integer>( Arrays.asList( num.get( i ) , num.get( j ) , num.get( low ) , num.get( high ) )) );
                        while ( low < high && num.get( low ) == num.get( low+1 ) )
                            low++;
                        while ( low < high && num.get( high ) == num.get( high - 1 ) )
                            high--;
                        low++;
                        high--;
                    }
                    else if ( sum < target )
                        low++;
                    else
                        high--;
                }
            }
        }
        return ans;
    }    
    public static void main( String[] args )
    {
        FourSum t = new FourSum();
        
        Integer[] li = { 1, 0, -1, 0, -2, 2};
        
        ArrayList<Integer> ai = new ArrayList<>( Arrays.asList( li ));
        
        System.out.println( " Two Sum indicies = "+ t.fourSum( ai, 0 ) );
    }
}

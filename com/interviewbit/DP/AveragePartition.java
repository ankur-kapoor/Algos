package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class AveragePartition
{
    
    public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) 
    {
        /* 
         * SUM_of_Set1 / size_of_set1 = SUM_of_Set2 / size_of_set2 
         * SUM_of_Set1 = SUM_of_Set2 * (size_of_set1 / size_of_set2)
         *
         * total_sum = Sum_of_Set1 + Sum_of_Set2
         * and size_of_set2 = total_size - size_of_set1 
         *
         * Sum_of_Set1 = (total_sum - Sum_of_Set1) * (size_of_set1 / (total_size - size_of_set1))
         * OR on simplifying, 
         *   total_sum / Sum_of_Set1 - 1 = (total_size - size_of_set1) / size_of_set1 
         *   total_sum / Sum_of_Set1 = total_size / size_of_set1 
         *   Sum_of_Set1 / size_of_set1 = total_sum / total_size 
         *
         *   Now we can just iterate on size_of_set1, and we would know the required Sum_of_Set1 
         *   
         *   So, just iterate on size_of_set1. 
            Based on size_of_set1, you can determine the value of Sum_of_Set1. 

            Then after you can memoise this relation -

            isPossible(ind, current_sum, current_size) = 

            isPossible(ind + 1, current_sum, current_size)  [ Do not include current element ] 
            OR                                                  
            isPossible(ind + 1, current_sum - value_at(ind), current_size - 1)
         */
        
        Collections.sort( A );
        final ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        final ArrayList<Integer> path = new ArrayList<>();
        
        int N = A.size();
        
        int totalSum = 0;
        
        for( int a : A )
        {
            totalSum += a;
        }
        
        final boolean T[][][] = new boolean[N][totalSum+1][N];
        
        for( int i =0; i < N; i++)
        {
            for( int j =0; j <= totalSum; j++)
            {
                for( int k =0; k < N; k++)
                {
                    T[i][j][k] = true;
                }
            }
        }
        
        for( int i = 1; i < N; i++ )
        {
            if((totalSum*i)%N != 0)
            {
                continue;
            }
            
            final int sumOfSet_i = (totalSum*i)/N;
            
            if( isPossible( 0, sumOfSet_i, i, A, T, path ))
            {
                int i1=0;
                int i2=0;
                final ArrayList<Integer> res2 = new ArrayList<>();
                while( i2 < path.size() || i1 < N )
                {
                    if( i2 < path.size() && path.get( i2 ) == A.get( i1 ))
                    {
                        i2++;
                        i1++;
                        continue;
                    }
                    
                    res2.add( A.get( i1++ ) );
                }
                
                if( path.size() > res2.size())
                {
                    res.add( res2 );
                    res.add( path );
                }
                else
                {
                    res.add( path );
                    res.add( res2 );
                }
                
                return res;
            }
        }
        
        return res;
    }
    
    private boolean isPossible( int index, int currentSum, int len, ArrayList<Integer> A, final boolean [][][] T, final ArrayList<Integer> path  )
    {
        if( len == 0)
        {
            return currentSum == 0;
        }
        
        if( index >= A.size())
        {
            return false;
        }
        
        if( !T[index][currentSum][len])
        {
            return false;
        }
        
        if( currentSum >= A.get( index ))
        {
            path.add( A.get( index ) );
            if( isPossible( index+1, currentSum-A.get( index ), len-1, A, T, path ))
            {
                return true;
            }
            path.remove( path.size()-1 );
        }
        
        if( isPossible( index+1, currentSum, len, A, T, path ))
        {
            return true;
        }
        
        T[index][currentSum][len] = false;
        
        return false;
    }

    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(47);
        A.add(14);
        A.add(30);
        A.add(19);
        A.add(30);
        A.add(4);
        A.add(32);
        A.add(32);
        A.add(15);
        A.add(2);
        A.add(6);
        A.add(24);
        
        System.out.println("Original List: \n" + A); 
        
        final AveragePartition avg = new AveragePartition();
        
        System.out.println( "Result = " + avg.avgset( A ));
        
        //ArrayList<ArrayList<Integer>> result = avgset(A);
      /*  for(ArrayList<Integer> list : result)
            System.out.println(list);*/
        
    }
}

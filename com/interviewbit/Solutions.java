package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutions {
    // DO NOT MODIFY THE LIST
    public ArrayList<ArrayList<Integer>> prettyPrint(int a) 
    {
        final ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int N = (2*a-1);
        int k =0;
        for( int i = 0; i <N ; i++ )
        {
            final ArrayList<Integer> col = new ArrayList<>();
            
            if( k <= N%a )
            {
                for( int j = 0; j < k%a; j++ )
                {
                    col.add( (( N- j) % a )+1 );
                }
                
                for( int j = 0; j< N-(2*(k%a)); j++ )
                {
                    col.add( ( (N-k) % a)+1 );
                }
                
                for( int j = k%a; j>0  ; j-- )
                {
                    col.add( ((N-j+1) % a)+1 );
                }
                k++;
                res.add( col );
                
            }
            else
            {
                break;
            }
        }
        k = k-1;
        for( int i = k-1 ; i < N; i++ )
        {
            k--;
            if( k >=0 )
            {
                res.add( res.get( k ) );
            }
        }
                
        return res;
    } 
    
    public static void main( String[] args )
    {
        final Solutions s = new Solutions();
        
        Integer[] numArr = {1};
        final List<Integer> nums = Arrays.asList( numArr );
        final ArrayList<Integer> nums1 = new ArrayList<>(nums);
                        /*nums.add( 3 );
        nums.add( 1 );
        nums.add( 2 );
        nums.add( 3 );
        nums.add( 5 );*/
        
        //System.out.println( "Repeated m = " + s.repeatedNumber( nums ) );
        
        //System.out.println( " First Positive Number " + s.firstMissingPositive( nums1 ) );
        
        System.out.println( " rotated matrix = " + s.prettyPrint( 7 ));
    }
}
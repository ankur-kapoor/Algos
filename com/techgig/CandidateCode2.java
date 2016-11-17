package com.techgig;

import java.util.HashMap;
import java.util.Map;

public class CandidateCode2
{
    public static int passCount(int N, int M, int L )
    {
        if( N < 3 || N > 1000 ) return -1;
        if( M < 3 || M > 1000 ) return -1;
        
        int[] T = new int[N];
        
        int i = 0;
        int count = 0;
        while( true )
        {
            T[i]++;
            if( T[i] == M )
            {
                return count;
            }
            else if( T[i] % 2 != 0 )
            {
                i = (i + L + 1)%N;
            }
            else
            {
                i = (i + N + L )%N;
            }
            
            count++;
        }
    }
    
    public static void main( String[] args )
    {
        System.out.println( passCount( 5, 3, 2 ));
    }
}

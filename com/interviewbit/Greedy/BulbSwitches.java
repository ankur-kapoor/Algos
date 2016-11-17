package com.interviewbit.Greedy;

public class BulbSwitches
{
    public int bulbSwitch(int n) 
    {
        final int bulbs[] = new int[n];
        
        for( int j =0; j < n; j++ )
        {
            bulbs[j] =1;
        }
        
        int res = 0;
        for( int i =1; i < n; i++)
        {
            for( int j =i; j < n; j+=i )
            {
                if( bulbs[j] == 1)
                {
                    res++;
                }
                bulbs[j] =0;
            }
        }
        
        return n-res;
    }
}

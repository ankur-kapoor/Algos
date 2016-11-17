package com.interviewbit.Maths;

public class Factorial
{
    public int trailingZeroes(int a) 
    {
        if( a< 5) return 0;
        
        int l = a;
        
        int res = 0;
        int i =1;
        while( l > 1 )
        {
            int f = (int)Math.pow( 5, i++ );
            
            l = a/f;
            res += l;
        }
        
        return res;
    }

        
    public static void main(String[] args )
    {
        Factorial p = new Factorial();
        System.out.println("Trailing Zeros = " + p.trailingZeroes( 4617 ) );
    }
}

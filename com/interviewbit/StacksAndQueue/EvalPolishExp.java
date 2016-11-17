package com.interviewbit.StacksAndQueue;

import java.util.ArrayList;
import java.util.Stack;

public class EvalPolishExp
{
    public int evalRPN( ArrayList<String> tokens )
    {
        int a, b;
        Stack<Integer> S = new Stack<Integer>();
        for ( String s : tokens )
        {
            if ( s.equals( "+" ) )
            {
                S.add( S.pop() + S.pop() );
            }
            else if ( s.equals( "/" ) )
            {
                b = S.pop();
                a = S.pop();
                S.add( a / b );
            }
            else if ( s.equals( "*" ) )
            {
                S.add( S.pop() * S.pop() );
            }
            else if ( s.equals( "-" ) )
            {
                b = S.pop();
                a = S.pop();
                S.add( a - b );
            }
            else
            {
                S.add( Integer.parseInt( s ) );
            }
        }
        return S.pop();
    }
    
    public static void main( String[] args )
    {
        final EvalPolishExp evalExpr = new EvalPolishExp();
        
        
    }
}

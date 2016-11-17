package com.interviewbit.StacksAndQueue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Write a program to validate if the input string has redundant braces?
Return 0/1 
 0 -> NO 1 -> YES 

Input will be always a valid expression

and operators allowed are only + , * , - , /

Example:

((a+b)) has redundant braces so answer will be 1
(a + (a + b)) doesn't have have any redundant braces so answer will be 0

 * @author ankurkap
 *
 */

public class Braces
{
    
    public int braces(String a) 
    {
        Stack<Character> vStack = new Stack<>();
        Stack<Character> oStack = new Stack<>();
        
        final char[] charArr = a.toCharArray();
        
        for( int i =0; i < charArr.length; i++ )
        {
            if( charArr[i] == '(')
            {
                oStack.push( charArr[i] );
            }
            else if( charArr[i] == ')')
            {
                if( oStack.peek() == '(' )
                {
                    return 0;
                }
                
                while( !vStack.isEmpty() && !oStack.isEmpty() && oStack.peek() != '(' )
                {
                    vStack.pop();
                    vStack.pop();
                    oStack.pop();
                    vStack.push( 'v' );
                }
                oStack.pop();
            }
            else if( charArr[i] == '+' || charArr[i] == '-' || charArr[i] == '*' || charArr[i] == '/')
            {
                while( !oStack.isEmpty() && !vStack.isEmpty() && hasPrecedence( charArr[i], oStack.peek() ))
                {
                    vStack.pop();
                    vStack.pop();
                    oStack.pop();
                    vStack.push( 'v' );
                }
                
                oStack.push( charArr[i] );
            }
            else if( (charArr[i] >= 'a' && charArr[i] <= 'z' ) || (charArr[i] >= 'A' && charArr[i] <= 'Z' ))
            {
                vStack.push( charArr[i] );
            }
        }
        
        return 1;
    }
    
    private boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    
    public static void main( String[] args )
    {
        final Braces evalExpr = new Braces();
        
        System.out.println( " Is Redundant Braces  = " + evalExpr.braces( "(a + (a + b))" ) );
    }
}

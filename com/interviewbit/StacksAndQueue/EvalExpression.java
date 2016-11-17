package com.interviewbit.StacksAndQueue;

import java.util.Stack;

public class EvalExpression
{
    public int evaluateExpression( String expression )
    {
        final Stack<Integer> valueStack = new Stack<>();
        final Stack<Character> opStack = new Stack<>();
        
        final char[] charArr = expression.toCharArray();
        
        for( int i=0; i < charArr.length; i++ )
        {
            if( charArr[i] >= '0' && charArr[i] <= '9' )
            {
                StringBuilder strBuilder = new StringBuilder();
                while( i < charArr.length && charArr[i] >= '0' && charArr[i] <= '9')
                {
                    strBuilder.append( charArr[i++] );
                }
                valueStack.push( Integer.valueOf( strBuilder.toString() ) );
            }
            else if( charArr[i] == '(')
            {
                opStack.push( charArr[i] );
            }
            else if( charArr[i] == ')')
            {
                while( !valueStack.isEmpty() && opStack.peek() != '(')
                {
                    valueStack.push( applyOperation( opStack.pop(), valueStack.pop(), valueStack.pop() ) );
                }
                opStack.pop();
            }
            else if( charArr[i] == '+' || charArr[i] == '-' || charArr[i] == '*' || charArr[i] == '/')
            {
                while( !opStack.isEmpty() && hasPrecedence( charArr[i], opStack.peek() ) && !valueStack.empty())
                {
                    valueStack.push( applyOperation( opStack.pop(), valueStack.pop(), valueStack.pop() ) );
                }
                opStack.push( charArr[i] );
            }
        }
        
        while( !opStack.isEmpty() )
        {
            valueStack.push( applyOperation( opStack.pop(), valueStack.pop(), valueStack.pop() ) );
        }
        
        return valueStack.pop();
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
 
    private int applyOperation(char op, int b, int a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }
    
    public static void main( String[] args )
    {
        final EvalExpression evalExpr = new EvalExpression();
        
        System.out.println( evalExpr.evaluateExpression( "10 + 2 * 6" ) );
        System.out.println( evalExpr.evaluateExpression( "100 * 2 + 12" ) );
        System.out.println( evalExpr.evaluateExpression( "100 * ( 2 + 12 )" ) );
        System.out.println( evalExpr.evaluateExpression( "100 * ( 2 + 12 ) / 14" ) );
        
    }
}

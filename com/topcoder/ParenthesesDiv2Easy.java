package com.topcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author ankurkap
 *
 */
public class ParenthesesDiv2Easy
{
    public int getDepth(String s)
    {
        final Stack<Character> st = new Stack<>();
        
        char[] sa = s.toCharArray();
        int max = 0;
        int c = 0;
        for( int i=0; i < sa.length; i++ )
        {
            
            if( sa[i] == '(')
            { 
                c =0;
                st.push( '(' );
            }
            else if( sa[i] == ')')
            {
                if( !st.isEmpty())
                {
                    st.pop();
                    c++;
                }
                max = Math.max( c, max );
            }
        }
        
        return max;
    }
  
}

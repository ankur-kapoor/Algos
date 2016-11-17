package com.interviewbit.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTIterator
{
    private Queue<Integer> m_nodeQueue;
    public BSTIterator(TreeNode root) 
    {
        m_nodeQueue = new LinkedList<>();
        initialize( root );
    }
    
    private void initialize( TreeNode node )
    {
        final Stack<TreeNode> st = new Stack<>();
        
        while( node != null || !st.isEmpty() )
        {
            while( node != null )
            {
                st.push( node );
                node = node.left;
            }
            
            node = st.pop();
            m_nodeQueue.offer( node.val );
            
            node = node.right;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() 
    {
        return !m_nodeQueue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() 
    {
        return m_nodeQueue.poll();
    }
    
}

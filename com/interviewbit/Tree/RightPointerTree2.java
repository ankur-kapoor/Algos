package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */



public class RightPointerTree2
{
    public void connect(TreeLinkNode root) 
    {
        build( root );
    }
    
    private void build( TreeLinkNode root )
    {
        TreeLinkNode node = root;
        
        while( node != null )
        {
            TreeLinkNode current = node;
            
            while( current != null )
            {
                if( null != current.left )
                {
                    if( null != current.right )
                    {
                        current.left.next = current.right;
                    }
                    else if( null != current.next  )
                    {
                        if( null != current.next.left )
                        {
                            current.left.next = current.next.left;
                        }
                        else if( null != current.next.right  )
                        {
                            current.left.next = current.next.right;
                        }
                    }
                }
                
                if( null != current.right && null != current.next )
                {
                    if( null != current.next.left )
                    {
                        current.right.next = current.next.left;
                    }
                    else if( null != current.next.right  )
                    {
                        current.right.next = current.next.right;
                    }
                }
                
                current = current.next;
            }
            
            if( null == node.left )
            {
                node = node.right;
            }
            else
            {
                node = node.left;
            }
                
        }
        
    }
    
    public static void main( String[] args )
    {
        Integer[] in = {1,3};
        
        List<Integer> li = new ArrayList<>( Arrays.asList( in ));
        final RightPointerTree2 ab = new RightPointerTree2();
        
        //System.out.println( "Given Tree = " + ab.sortedArrayToBST( li ) );
    }
}

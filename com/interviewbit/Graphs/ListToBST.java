package com.interviewbit.Graphs;

import com.interviewbit.LinkedList.ListNode;
import com.interviewbit.Tree.TreeNode;

/**
 * 
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author ankurkap
 *
 */

public class ListToBST
{
    public TreeNode sortedListToBST(ListNode head) 
    {
        if( head == null )
        {
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        
        while( null != fast && null != fast.next )
        {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
        final TreeNode root = new TreeNode( slow.val );
        
        if( null != prev )
        {
            prev.next = null;
            root.left = sortedListToBST( head );
        }
        root.right = sortedListToBST( slow.next );
        
        return root;
    }
}

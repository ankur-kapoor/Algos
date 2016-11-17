package com.interviewbit.LinkedList;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 *
 */

public class AddTwoNumbers
{
    public ListNode addTwoNumbers( ListNode l1, ListNode l2 )
    {
        ListNode prev = new ListNode( 0 );
        ListNode head = prev;
        int carry = 0;
        while ( l1 != null || l2 != null || carry != 0 )
        {
            ListNode cur = new ListNode( 0 );
            int sum = ( ( l2 == null ) ? 0 : l2.val ) + ( ( l1 == null ) ? 0 : l1.val ) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = ( l1 == null ) ? l1 : l1.next;
            l2 = ( l2 == null ) ? l2 : l2.next;
        }
        return head.next;
    }

    public static void main( String[] args )
    {
        
    }
}

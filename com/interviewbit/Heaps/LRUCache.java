package com.interviewbit.Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.interviewbit.LinkedList.ListNode;

/**
 * 
 * Implementing LRU using a HashMap and Doubly Linked List
 * 
 */
public class LRUCache
{

    class DLinkedNode 
    {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node)
    {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node)
    {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node)
    {
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail. 
    private DLinkedNode popTail()
    {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private HashMap<Integer, DLinkedNode> 
        m_cache = new HashMap<Integer, DLinkedNode>();
    
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) 
    {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) 
    {

        DLinkedNode node = m_cache.get(key);
        if(node == null)
        {
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }


    public void set(int key, int value) 
    {
        DLinkedNode node = m_cache.get(key);

        if(node == null)
        {

            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.m_cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if(count > capacity)
            {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.m_cache.remove(tail.key);
                --count;
            }
        }
        else
        {
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }

    }
}

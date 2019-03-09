package com.example.travelhacking;
// Class for creating the Linked List of Credit Cards from nodes.
public class LLCC
{
    private CCNode head;
    private int count;
// Default node.
    public LLCC()
    {
       this.init();
    }
    private void init()
    {
        this.head = null;
        this.count = 0;
    }
    public void removeAll()
    {
        this.init();
    }
// Returns the length of the LLCC
    public int length()
    {
        return this.count;
    }
// Returns payload from the specified node.
    public Card getAtIndex(int index)
    {
        CCNode currNode = this.head;
        for(int i = 0; i < index; i++)
        {
            currNode = currNode.getNextNode();
        }
        return currNode.getPayload();
    }
// Adds a new node to the end of the Linked List.
    public void addEnd(Card payload)
    {
        CCNode n = new CCNode(payload);

        if(this.head == null)
        {
            this.head = n;
        }
        else
        {
            CCNode currNode = this.head;

            while(currNode.getNextNode() != null)
            {
                currNode = currNode.getNextNode();
            }
            currNode.setNextNode(n);
        }
        this.count++;
    }
}
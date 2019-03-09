package com.example.travelhacking;
// Class for creating a Linked List of Loyalty Programs.
public class LLP
{
    private PNode head;
    private int count;
// Default Node
    public LLP()
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
// Returns length of the Linked List.
    public int length()
    {
        return this.count;
    }
// Returns payload from the specified node.
    public Program getAtIndex(int index)
    {
        PNode currNode = this.head;
        for(int i = 0; i < index; i++)
        {
            currNode = currNode.getNextNode();
        }
        return currNode.getPayload();
    }
// Adds a new node to the end of the Linked List.
    public void addEnd(Program payload)
    {
        PNode n = new PNode(payload);

        if(this.head == null)
        {
            this.head = n;
        }
        else
        {
            PNode currNode = this.head;

            while(currNode.getNextNode() != null)
            {
                currNode = currNode.getNextNode();
            }
            currNode.setNextNode(n);
        }
        this.count++;
    }
}
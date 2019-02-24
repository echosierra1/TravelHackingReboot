package com.example.travelhacking;

public class LLP
{
    private PNode head;
    private int count;

    public LLP()
    {
        this.head = null;
        this.count = 0;
    }

    public int length()
    {
        return this.count;
    }

    public Program getAtIndex(int index)
    {
        PNode currNode = this.head;
        for(int i = 0; i < index; i++)
        {
            currNode = currNode.getNextNode();
        }
        return currNode.getPayload();
    }

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
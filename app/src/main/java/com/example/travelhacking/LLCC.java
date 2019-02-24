package com.example.travelhacking;

public class LLCC
{
    private CCNode head;
    private int count;

    public LLCC()
    {
        this.head = null;
        this.count = 0;
    }

    public int length()
    {
        return this.count;
    }

    public Card getAtIndex(int index)
    {
        CCNode currNode = this.head;
        for(int i = 0; i < index; i++)
        {
            currNode = currNode.getNextNode();
        }
        return currNode.getPayload();
    }

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
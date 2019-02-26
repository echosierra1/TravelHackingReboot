package com.example.travelhacking;

// The node creator for the Credit Card Linked List (LLCC).
public class CCNode
{
    private Card payload;
    private CCNode nextNode;

    public CCNode(Card payload)
    {
        this.payload = payload;
        this.nextNode = null;
    }

    public void setNextNode(CCNode nextNode) {

        this.nextNode = nextNode;
    }

    public Card getPayload() {
        return payload;
    }

    public CCNode getNextNode() {
        return nextNode;
    }
}
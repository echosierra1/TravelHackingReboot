package com.example.travelhacking;


public class PNode
{
    private Program payload;
    private PNode nextNode;

    public PNode(Program payload)
    {
        this.payload = payload;
        this.nextNode = null;
    }

    public void setNextNode(PNode nextNode) {

        this.nextNode = nextNode;
    }

    public Program getPayload() {
        return payload;
    }

    public PNode getNextNode() {
        return nextNode;
    }
}
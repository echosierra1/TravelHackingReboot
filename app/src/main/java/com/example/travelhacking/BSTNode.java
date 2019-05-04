package com.example.travelhacking;

public class BSTNode
{
    public Airport payload;
    public BSTNode leftChild;
    public BSTNode rightChild;


    public BSTNode (Airport payload)
    {
        this.payload = payload;
        this.leftChild = null;
        this.rightChild = null;

    }

    public String visitLeftChild()
    {
        String airportcode = "";
        airportcode = leftChild.visitRoot();
        return (airportcode);
    }
    public String visitRightChild()
    {
        String airportcode = "";
        airportcode = rightChild.visitRoot();
        return(airportcode);
    }
    public String visitRoot()
    {
        return payload.airportCode;
    }

    public void addNode(BSTNode n)
    {

        if(n.getPayload().compareTo(this.payload.airportCode)>= 0)
        {
            if(this.leftChild == null)
            {
                this.leftChild = n;
            }
            else
            {
                this.leftChild.addNode(n);
            }
        }
        else
        {
            if(this.rightChild == null)
            {
                this.rightChild = n;
            }
            else
            {
                this.rightChild.addNode(n);
            }
        }
    }

    public String getPayload() {
        return payload.airportCode;
    }

    public BSTNode getLeftChild() {
        return leftChild;
    }

    public BSTNode getRightChild() {
        return rightChild;
    }

    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
    }

}

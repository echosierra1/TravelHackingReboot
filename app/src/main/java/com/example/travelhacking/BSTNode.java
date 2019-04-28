package com.example.travelhacking;

public class BSTNode
{
    private String payload;
    private BSTNode leftChild;
    private BSTNode rightChild;


    public BSTNode (String payload)
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
        return payload;
    }

    public void addNode(BSTNode n)
    {

        if(n.getPayload().compareTo(this.payload)>= 0)
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
        return payload;
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

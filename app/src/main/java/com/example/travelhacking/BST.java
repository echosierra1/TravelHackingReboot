package com.example.travelhacking;

public class BST
{
    public BSTNode root;

    public BST()
    {
        this.root = null;
    }

    public String visitLeftChild()
    {
        String temp  = "";

        if(this.root != null)
            this.root.visitLeftChild();
        return temp;

    }
    public String visitRightChild()
    {
        String temp  = "";
        if(this.root != null)
            this.root.visitRightChild();
        return temp
        ;

    }
    public String visitRoot()
    {
        String temp  = "";
        if(this.root !=null);
       temp =  this.root.visitRoot();
        return temp;
   }


    public void addValue(Airport payload)
    {
        BSTNode n = new BSTNode(payload);
        if(this.root == null)
        {
            this.root = n;
            System.out.println ("***root" +root);
        }
        else
        {
            this.root.addNode(n);
        }


    }
}




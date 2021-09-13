package org.java8.part4.thinkinfunction;

public class Tree {
    public String key;
    public int val;
    public Tree left, right;

    public Tree(String key, int val, Tree left, Tree right) {
        this.key = key;
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

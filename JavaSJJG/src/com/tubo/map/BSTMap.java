package com.tubo.map;


import java.nio.file.NotDirectoryException;
import java.util.EmptyStackException;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left=null;
            right=null;
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }
    private  Node root;
    private int size;
      //添加新元素
    @Override
    public void add(K key, V value) {
         root=add(root,key,value);
    }

    /**
     * 返回插入新节点的根
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node, K key,V value) {
        if (node == null) {
            size++;
            return new Node(key,value);
        }
        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key,value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right,key,value);
        else
            node.value=value;
        return node;
    }
    @Override
    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node==null?null:node.value;
    }
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node==null)
            throw  new IllegalArgumentException(key+"doesnot exist");
        node.value=newValue;
    }

    //返回以node为根节点的二分查找树中,key所在的节点
    public Node getNode(Node node,K key){
        if (node==null)
            return  null;
        if (key.compareTo(node.key)==0)
            return  node;
        else if(key.compareTo(node.key)<0)
            return  getNode(node.left,key);
        else
            return getNode(node.right,key);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node!=null){
            root=remove(root,key);
            return  node.value;
        }
        return null;
    }

    /**
     * 返回删除后的树的根
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node, K key) {
        if (node==null)
            return null;
        if (key.compareTo(node.key)<0){
               node.left=remove(node.left,key);
               return  node;
        }
        if (key.compareTo(node.key)<0){
              node.right=remove(node.right,key);
              return  node;
        }else{
            //待删除节点左子树为空
            if (node.left==null){
                Node rightNode = node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空
            if (node.right==null){
                Node leftNode = node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            /**
             * 待删除节点左右子树都不为空的情况
             * 找到待删除节点的最小节点,即删除节点右子树的最小节点
             * 用这个节点顶期待删除节点的位置
             */
            Node successor=minmum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.left=node.right=null;
            return  successor;
        }
    }


    private Node maxnum(Node node) {
        if (node.right == null)
            return node;
        return maxnum(node.right);
    }



    private Node minmum(Node node) {
        if (node.left == null)
            return node;
        return minmum(node.left);
    }


    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }



    //删除以node为根的二分搜索树的最大节点
    //返回新二分搜索树的根
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }
}

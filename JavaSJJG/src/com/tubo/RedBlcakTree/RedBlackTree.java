package com.tubo.RedBlcakTree;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree<K extends Comparable<K>, V> {

  private  static  final  boolean RED=true;
  private  static  final  boolean BLACK=false;
    public class Node {

        public K key;
        public V value;
        public Node left, right;
        public boolean  color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color=RED;
        }

    }

    private Node root;
    private int size;

    public RedBlackTree() {
        this.root = null;
        this.size = 0;
    }
  private  boolean isRed(Node node){
        if (node==null)
            return BLACK;
        return node.color;
  }
    //判断该二叉树是否是一棵二分搜索树
    public boolean isBST() {
        List<K> key = new ArrayList<>();
        inOrder(root, key);
        for (int i = 1; i < key.size(); i++) {
            if (key.get(i - 1).compareTo(key.get(i)) > 0)
                return false;
            return true;
        }
        return true;
    }

    private void inOrder(Node node, List<K> key) {
        if (node == null)
            return;
        inOrder(node.left, key);
        key.add(node.key);
        inOrder(node.right, key);
    }

   private  Node leftRotate(Node node){
        Node x=node.right;
        node.right=x.left;
        x.color=node.color;
        node.color=RED;
        return x;
   }
   //颜色反转
   private  void filpColors(Node node){
        node.color=RED;
        node.left.color=BLACK;
        node.right.color=BLACK;
   }
    private  Node rightRotate(Node node){
        Node x=node.left;
        //右旋转
        node.left=x.right;
        x.right=node;
        x.color=node.color;
        node.color=RED;
        return x;
    }
    //添加新元素
    public void add(K key, V value) {
        root = add(root, key, value);
        root.color=BLACK;//最终根节点为黑色节点
    }

    /**
     * 返回插入新节点的根
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else
            node.value = value;
        if (isRed(node.right)&&!isRed(node.left))
            node=leftRotate(node);
        if (isRed(node.left)&&isRed(node.left.left))
            node=rightRotate(node);
        if (isRed(node.left)&&isRed(node.right))
            filpColors(node);
        return node;


    }
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }


    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + "doesnot exist");
        node.value = newValue;
    }

    //返回以node为根节点的二分查找树中,key所在的节点
    public Node getNode(Node node, K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) == 0)
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    /**
     * 返回删除后的树的根
     *
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node, K key) {
        if (node == null)
            return null;
        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        }
        if (key.compareTo(node.key) < 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            //待删除节点左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            }
            //待删除节点右子树为空
            else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                /**
                 * 待删除节点左右子树都不为空的情况
                 * 找到待删除节点的最小节点,即删除节点右子树的最小节点
                 * 用这个节点顶期待删除节点的位置
                 */
                Node successor = minmum(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                retNode = successor;
            }
        }

        return retNode;
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

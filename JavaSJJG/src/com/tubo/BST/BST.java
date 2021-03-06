package com.tubo.BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {


    public class Node {

        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜搜索树中添加新的元素
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    /*
     向以node为根的二分搜索树中插入元素E,递归算法
     返回插入新节点的二分查找树的根
 */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    //看二叉树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    //看以nodel为根的二分搜索树中是否元素e,递归算法
    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    //二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    //前序遍历以node为根的二分搜索树,递归算法
    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);

        }
    }

    //二分查找树的中序遍历
    public void inOder() {
        inOrder(root);
    }

    //中序遍历以node为根的二分搜索树,递归算法
    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    //后序遍历以node为根的二分搜索树,递归算法
    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二分查找树的层序遍历
    public void levelOrder() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }

    }

    //寻找二分搜索树的最大元素
    public E maxnum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maxnum(root).e;

    }

    private Node maxnum(Node node) {
        if (node.right == null)
            return node;
        return maxnum(node.right);
    }

    //寻找二分搜索树的最小元素
    public E minmum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return minmum(root).e;

    }

    private Node minmum(Node node) {
        if (node.left == null)
            return node;
        return minmum(node.left);
    }

    //从二分搜索树中删除最小值所在节点,返回最小值
    public E removeMin() {
        E ret = minmum();
        root = removeMin(root);
        return ret;
    }

    //删除以node为根的二分搜索树的最小节点
    //返回新二分搜索树的根
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

    //从二分搜索树中删除最小值所在节点,返回最大值
    public E removeMax() {
        E ret = maxnum();
        root = removeMax(root);
        return ret;
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
    //删除二分查找树的元素e
    public void remove(E e){
       root= remove(root,e);
    }
    //删除以node为根的的二分搜索树的e的节点,递归算法
    //返回删除节点的二分搜索树的根
    private Node remove(Node node,E e){
        if (node==null)
            return  null;
        if (e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
            return  node;
        }else if (e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
            return node;
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
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    //生成以node为根的节点,深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");

        }
        return res.toString();
    }
}

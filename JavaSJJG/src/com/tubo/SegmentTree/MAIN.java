package com.tubo.SegmentTree;

public class MAIN {
    public static void main(String[] args){
        Integer[] nums={9,8,5,7,6,3,4};
        SegmentTree<Integer> segTree=new SegmentTree<>(nums,(a,b)->a+b);
        System.out.println(segTree);
    }
}

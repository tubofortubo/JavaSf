package com.tubo.map;

public class Main {
    public static void main(String[] args){
        Map map=new BSTMap<Integer,String>();
        map.add("1" ,"11");
        System.out.println(map.get("1"));
        map.remove("1");
        System.out.println(map.get("1"));
    }
}

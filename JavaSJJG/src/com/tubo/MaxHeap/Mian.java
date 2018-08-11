package com.tubo.MaxHeap;



import com.sun.istack.internal.FinalArrayList;

import java.util.*;

public class Mian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字");
        int a = 2;
        int z = 2;
        int c = 2;
        char[] arr=new char[a+z];
        int i;
        for ( i = 0; i < a; i++) {
           arr[i]='a';
        }
        for (int j = i; j < z+i; j++) {
            arr[j]='z';
        }
      //  List<String> list=new ArrayList();
        TreeSet<String> hs=new TreeSet<>();
        Set<String> strings = perm(arr, 0, arr.length - 1,hs);
        strings.forEach(e->System.out.println(e));


    }

    public static Set<String> perm(char[] buf, int start, int end,Set<String> list) {

        if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
            String s="";
            for (int i = 0; i <= end; i++) {

                s+=buf[i];

            }
      //    System.out.println(s);
            list.add(s);
        } else {// 多个字母全排列

            for (int i = start; i <= end; i++) {

                char temp = buf[start];// 交换数组第一个元素与后续的元素

                buf[start] = buf[i];

                buf[i] = temp;


                perm(buf, start + 1, end, list);// 后续元素递归全排列


                temp = buf[start];// 将交换后的数组还原

                buf[start] = buf[i];

                buf[i] = temp;

            }

        }
        return  list;
    }
}

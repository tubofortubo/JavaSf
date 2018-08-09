package com.tubo.stack;

import java.util.Stack;

public class Main {
    public  static  void  main(String[] args){
       /* ArrsyStack<Integer> stack = new ArrsyStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);*/
        Main main = new Main();
        System.out.println(main.isVaild("()[]{}{[()]}"));
    }

    public boolean isVaild(String s){

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch=='{'||ch=='['||ch=='('){
                stack.push(ch);
            }else {
                if (stack.isEmpty())
                    return  false;
                char pop = stack.pop();
                if (ch==')'&&pop!='(')
                    return false;
                if (ch==']'&&pop!='[')
                    return false;
                if (ch=='}'&&pop!='{')
                    return false;
            }
        }
        return  stack.isEmpty();

    }


}

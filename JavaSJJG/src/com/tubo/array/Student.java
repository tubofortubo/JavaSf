package com.tubo.array;



public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public java.lang.String toString() {
        return "Student{" +
                "name=" + name +
                ", score=" + score +
                '}';
    }

    public static  void main(String[] args){
        Array<Student> studentArray = new Array<Student>();

        studentArray.addLast(new Student("alice",100));
        studentArray.addLast(new Student("bob",90));
        studentArray.addLast(new Student("tom",100));
        System.out.println(studentArray);

    }
}


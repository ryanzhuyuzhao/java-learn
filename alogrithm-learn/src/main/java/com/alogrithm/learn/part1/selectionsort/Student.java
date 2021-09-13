package com.alogrithm.learn.part1.selectionsort;

import com.alogrithm.learn.part1.datastructure.array.Array;

/**
 * @ClassName Student
 * @Description
 * @Author Administrator
 * @Date 2021/8/18 0018 20:18
 * @Version 1.0
 */
public class Student implements Comparable<Student>{

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object student) {
        if (student == null) {
            return false;
        }
        if (this.getClass() != student.getClass()) {
            return false;
        }
        if (this == student) {
            return true;
        }
        Student another = (Student) student;
        return this.name.equals(another.name);
    }


    @Override
    public int compareTo(Student another) {
        return this.score - another.score;
    }

    @Override
    public String toString() {
        return String.format("student name:%s,score:%d",this.name,this.score);
    }

    public static void main(String[] args) {
        Array<Student> array = new Array<>();
        array.addLast(new Student("Ryan",100));
        array.addLast(new Student("Natsu",80));
        System.out.println(array);
        array.removeElement(new Student("Natsu",80));
        System.out.println(array);
    }
}

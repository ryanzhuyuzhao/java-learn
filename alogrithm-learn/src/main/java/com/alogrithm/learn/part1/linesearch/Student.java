package com.alogrithm.learn.part1.linesearch;

/**
 * @ClassName Student
 * @Description
 * @Author Administrator
 * @Date 2021/8/18 0018 20:18
 * @Version 1.0
 */
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
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
}

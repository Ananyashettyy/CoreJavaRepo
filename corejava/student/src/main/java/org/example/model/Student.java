package org.example.model;

public class Student {
    String name;
    int rollNo;
    int marks;
    int branch_id;

    Student( String name, int rollNo, int marks,int branch_id) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        this.branch_id=branch_id;
    }
}

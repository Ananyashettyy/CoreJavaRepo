package com.example.model;

public class Department {
    private int deptId;
    private String dept_name;

    // Constructor
    public Department(int deptId, String dept_name) {
        this.deptId = deptId;
        this.dept_name = dept_name;
    }

    // Getters and Setters
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return dept_name;
    }

    public void setDeptName(String deptName) {
        this.dept_name = dept_name;
    }

    // Display Method (Optional)
    public void displayDepartmentDetails() {
        System.out.println("Department ID: " + deptId + ", Department Name: " + dept_name);
    }
}
package org.example;

import org.example.service.StudentDetail;

import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        int option;
        Scanner sc = new Scanner(System.in);
        StudentDetail stud = new StudentDetail();

        do {
            System.out.println("Enter your choice\n1. Add student\n2. Read students\n3. delete student\n4. Exit");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    stud.addStudent();
                    break;
                case 2:
                    stud.readStudent();
                    break;
                case 3:
                    stud.deleteStudent();
                    break;
                case 4:
                    System.out.println("Exited");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (option != 4);
    }
}
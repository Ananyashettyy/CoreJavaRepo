import java.util.ArrayList;
import java.util.Scanner;

class Student{
    int id;
    String name;
    int rollNo;
    int marks;

    public Student(int id, String name, int rollNo, int marks){
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }
//    public void display()
//    {
//        System.out.println("student id:"+id+"\nStudent name:"+name+"\nStudent rollNo:"+rollNo+"\nStudents marks:"+marks);
//    }
}
class StudentDetail{
   private Student[] students;
    int size = 0;
    int i;
    Scanner sc = new Scanner(System.in);

    public void addStudent(Student[] students) {
        if (size >= students.length) {
            System.out.println("Array is full");
            return;
        }
        System.out.println("Enter the id of the student: ");
        int id = sc.nextInt();
        System.out.println("Enter the name of the student: ");
        String name = sc.next();
        System.out.println("Enter the roll number of the student: ");
        int rollNo = sc.nextInt();
        System.out.println("Enter the marks of the student: ");
        int marks = sc.nextInt();
        students[size] = new Student(id, name, rollNo, marks);
        size++;
        System.out.println("Students added");
    }

    public void deleteStudent(Student[] students) {
        System.out.println("enter the student to be deleted");
        int del = sc.nextInt();
        boolean flag = false;
        if (size == 0) {
            System.out.println("the rollno to delete");
            return;
        }
        for (i = 0; i < size; i++) {

            if (students[i].rollNo == del) {
               // students[i] = null;
               // size--;
                flag = true;
                for(int j=i;j<size - 1;j++) {

                    students[j] = students[j+1];
                    students[j+1]=null;
                }
                students[size - 1]=null;
                size--;
                System.out.println("student deleted");
            }
        }
    }
    public void readStudent(Student[] students){
        if (size==0){
            System.out.println("No students to display");
        }else{
            System.out.println("List of Students"+size);
            for(i=0;i<size;i++){
                System.out.println("student id:"+students[i].id+"\nStudent name:"+students[i].name+"\nStudent rollNo:"+students[i].rollNo+"\nStudents marks:"+students[i].marks);
            }
        }
    }
}
public class MenuDriven {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        Scanner sc = new Scanner(System.in);
        StudentDetail studentDetail= new StudentDetail();
        int option;
        do {
            System.out.println("1. Add student");
            System.out.println("2. Read student");
            System.out.println("3. Remove student");
            System.out.println("4. Exit");
            option = sc.nextInt();
            switch(option){
                case 1: studentDetail.addStudent(students);
                    break;
                case 2: studentDetail.readStudent(students);
                    break;
                case 3:studentDetail.deleteStudent(students);
                    break;
                case 4: System.out.println("exit");
                    break;
                default:System.out.println("Invalid option please try again");
                    break;
            }
        }while(option!=4);
    }
}
import java.util.ArrayList;
import java.util.Scanner;

class Student{
    int id;
    String name;
    int rollNo;
    int marks;

    Student(int id, String name, int rollNo, int marks){
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }
}
class StudentDetail{
    ArrayList<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void addStudent(){
        System.out.println("Enter the id of the student: ");
        int id = sc.nextInt();
        System.out.println("Enter the name of the student: ");
        String name = sc.next();
        System.out.println("Enter the roll number of the number: ");
        int rollNo = sc.nextInt();
        System.out.println("Enter the marks of the student: ");
        int marks = sc.nextInt();
        students.add(new Student(id, name, rollNo, marks));
        System.out.println("Student added. ");
    }
    public void deleteStudent() {
        System.out.println("enter the roll number");
        int rollDelete = sc.nextInt();
        boolean flag=false;
        for(int i=0;i<students.size();i++){
            if(students.get(i).rollNo==rollDelete){
                students.remove(i);
                flag=true;
                System.out.println("student deleted ");
                break;
            }
        }
        if(!flag){
            System.out.println("student not found");
        }
    }
    public void readStudent(){
        if(students.isEmpty()){
            System.out.println("Array list is empty");
        }
        else{
            for(Student student : students){
                System.out.println("ID:"+student.id+"\nName: "+student.name+"\nRollNo: "+student.rollNo+"\nMarks: "+student.marks);
            }
        }
    }
}
public class MenuDriven {
    public static void main(String[] args) {
        int option;
        Scanner sc = new Scanner(System.in);
        StudentDetail stud = new StudentDetail();
        do {
            System.out.println("Enter your choice\n 1. Add student\n 2. Read student\n 3. Remove student\n 4. Exit");
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
                    System.out.println("Invalid.");
            }
        }while(option != 4);

    }
}
import java.util.*;
import java.util.stream.Collectors;

class Student {
    int id;
    String name;
    int rollNo;
    int marks;

    Student(int id, String name, int rollNo, int marks) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }
}
class StudentDetail {
    List<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.println("Enter the id of the student: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.println("Enter the name of the student: ");
        String name = sc.nextLine();
        System.out.println("Enter the roll number of the student: ");
        int rollNo = sc.nextInt();
        System.out.println("Enter the marks of the student: ");
        int marks = sc.nextInt();
        students.add(new Student(id, name, rollNo, marks));
        System.out.println("Student added.");
    }
    public void deleteStudent() {
        System.out.println("Enter the roll number to delete:");
        int rollDelete = sc.nextInt();
        List<Student> updatedList=students.stream().filter(student->student.rollNo!=rollDelete).collect(Collectors.toList());

        if (updatedList.size() == students.size()) {
            System.out.println("Students not deleted");
        } else {
            students = updatedList;
            System.out.println("Student deleted successfully");
        }
    }
    public void readStudent() {
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
            System.out.println("Enter your choice\n1. Add student\n2. Read students\n3. Remove student\n4. Exit");
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

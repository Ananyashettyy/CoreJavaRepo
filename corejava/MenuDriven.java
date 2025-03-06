import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Student {
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
class StudentDetail {
    Scanner sc = new Scanner(System.in);
    private Connection con;

    StudentDetail() {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to MySQL Database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "root");
            System.out.println("Database Connected");
        } catch (SQLException e) {
            System.out.println("error in retrieving the student");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void addStudent() throws SQLException {
        try {
            System.out.println("Enter the name of the student: ");
            String name = sc.nextLine();
            System.out.println("Enter the roll number of the student: ");
            int rollNo = sc.nextInt();
            System.out.println("Enter the marks of the student: ");
            int marks = sc.nextInt();
            System.out.println("enter the branch id of the student:");
            int branch_id = sc.nextInt();

            String query = "INSERT INTO school.student( NAME, ROLL_NO, MARKS,BRANCH_ID) VALUES ( ?, ?, ?,?);";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setInt(2, rollNo);
            pst.setInt(3, marks);
            pst.setInt(4, branch_id);
            int rows = pst.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("error in retrieving the student" + e.getMessage());
        }
    }
    public void readStudent() throws SQLException {
        try {
            String query = "SELECT * FROM student";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") + " Name: " + rs.getString("NAME") +
                        " RollNo: " + rs.getInt("ROLL_NO") + " Marks: " + rs.getInt("MARKS") +
                        " Branchid:" + rs.getInt("BRANCH_ID"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteStudent() throws SQLException {
        try {
            System.out.println("Enter the roll number to delete:");
            int rollDelete = sc.nextInt();

            String query = "DELETE FROM student WHERE ROLL_NO = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, rollDelete);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
public class MenuDriven {
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




package student_database_system;

import java.io.*;
import java.util.*;

class Student{
    private String name;
    private int roll_no;
    private String grade;
    
    public Student(String name , int roll_no , String grade){
        this.name = name;
        this.roll_no = roll_no;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    @Override
    public String toString(){
        return "Name: "+name+" , Roll_Number: "+roll_no+" , Grade: "+grade;
    }
}

class Student_Management_System{
    private List<Student> students;
    
    public Student_Management_System(){
        students = new ArrayList<>();
    }
    
    public void addStudent(String name , int roll_no , String grade){
        Student student = new Student(name , roll_no , grade);
        students.add(student);
        System.out.println("Student added successfully.");
    }
    
    public void removeStudent(int removeRoll_no){
        for(Student student : students){
            if(student.getRoll_no() == removeRoll_no){
                students.remove(student);
                System.out.println("Student removed successfully");
                return;
            }         
        }
        System.out.println("Student not found");
    }
    
    public void searchStudent(int searchRoll_no){
        for(Student student : students){
            if(student.getRoll_no() == searchRoll_no){
                System.out.println("Student Found: ");
                System.out.println("Name: "+student.getName());
                System.out.println("Roll Number: "+student.getRoll_no());
                System.out.println("Grade: "+student.getGrade());
                return;
            }
        }
        System.out.println("Student not Found");
    }
    
    public void displayAllStudents(){
        System.out.println("ALL STUDENTS: ");
        System.out.println("    Name      Roll_no     Grade");
        for(Student student : students){
            System.out.println("   "+student.getName()+"       "+student.getRoll_no()+"       "+student.getGrade());
        }
    }
    
    public void saveToFile(String filename){
        try(PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\HP\\Desktop\\students.txt"))) {
            writer.println("Name , Roll_Number , Grade");
            for(Student student : students){
                writer.println(student.getName()+" , "+student.getRoll_no()+" , "+student.getGrade());
            }
            System.out.println("Data saved to File Successfully.");
        }catch(Exception e){
            System.out.println("Error occured while saving data to file.");
            e.printStackTrace();
        }
    }
    
    public void loadFromFile(String filename){
        try(Scanner sc = new Scanner(new File("C:\\Users\\HP\\Desktop\\students.txt"))){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data = line.split(",");
                if(data.length == 3){
                    String name = data[0];
                    int roll_no = Integer.parseInt(data[1]);
                    String grade = data[2];
                    Student student = new Student(name , roll_no , grade);
                    students.add(student);
                }        
            }
            System.out.println("Data loaded from file successfully.");
        }catch(Exception e){
            System.out.println("Error occured while loading data from file.");
            e.printStackTrace();
        }
    }
}

class Student_Database_System {

    public static void main(String[] args) {
        Student_Management_System sms = new Student_Management_System();
        Scanner sc = new Scanner(System.in);
        
        sms.loadFromFile("students.txt");
        
        int choice = 0;
        while(choice != 5){
            System.out.print("\n");
            System.out.println("Welcome to the Student Management System!!");
            System.out.print("\n");
            System.out.println("1. Add a new Student");
            System.out.println("2. Search an existing Student");
            System.out.println("3. Display all Students");
            System.out.println("4. Remove a Student");
            System.out.println("5. Exit");
            
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            System.out.print("\n");
            sc.nextLine();
            
            switch(choice){
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int roll_no = sc.nextInt();
                    sms.addStudent(name, roll_no, grade);
                    break;
                    
                case 2:
                    System.out.print("Enter the Roll Number to search: ");
                    int searchRoll_no = sc.nextInt();
                    sms.searchStudent(searchRoll_no);
                    break;
                    
                case 3:
                    sms.displayAllStudents();
                    break;
                    
                case 4:
                    System.out.print("Enter the Roll Number to remove: ");
                    int removeRoll_no = sc.nextInt();
                    sms.removeStudent(removeRoll_no);
                    break;
                  
                case 5:
                    System.out.println("Exiting Student Management System. Saving Students...");
                    sms.saveToFile("students.txt");
                    break;
                    
                default:
                    System.out.println("Invalid Choice. Please Try Again!!");
            }
        }
        sc.close();
    }
}

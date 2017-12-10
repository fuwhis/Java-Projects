
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Quy Nguyen
 */
public class StudentManager extends ArrayList<Student> {

    public StudentManager() {
    }

    /**
     * Create student and add students to list
     *
     * @return true if creating successfully
     */
    public void create() {
        System.out.println("--Enter information of student--");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student's ID:       ");
        String ID = sc.nextLine().trim();
        System.out.print("Enter student's name:      ");
        String name = sc.nextLine().trim();
        System.out.print("Semester:         ");
        int semester = Integer.parseInt(sc.nextLine());
        System.out.println("Course (JAVA || C/C++ || .NET)");
        Course course = null; 
        while (true) {
            String c = sc.nextLine().trim().toUpperCase();
            switch (c) {
                case "JAVA":
                    course = Course.Java;
                    break;
                case "C/C++":
                    course = Course.C;
                    break;
                case ".NET":
                    course = Course.NET;
                    break;
                default:
                    System.out.println("Invalid input!");
                    continue;
            }
            break;
        }
        Student st = new Student(ID, name, semester, course);
        this.add(st);
    }

    /**
     * Find student by ID
     * @param ID Student ID
     * @return Student found
     */
    public Student findID(String ID) {
        for (Student s : this) {  //Duyệt list của Object Student qua từng phần tử để so sánh ID
            if (ID.equals(s.getID())) {
                return s;
            }
        }
        return null;
    }

    /**
     * Find student by Student's name
     * @param name Student name
     * @return Student found
     */
    public Student findName(String name) {
        for (Student s: this) {
            if (name.equals(s.getName())) {
                return s;
            }
        }
        return null;
    }

    public void findSort() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student's name to find: ");
        String name = sc.nextLine();
        Student st = findName(name);
        if (st == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println(st.getName() + ", " + st.getSemester() + ", " + st.getCourseName().getCourse());
            // implementing Sort 
            Collections.sort(this); // Collections là interfaces đại diện cho nhiều lớp như (Queue,HashMap,...)
            for (Student s : this) {
                System.out.println(s.getName() + ", " + s.getSemester() + ", " + s.getCourseName().getCourse());
            }
        }
    }

    /**
     * Update Student information by Student ID
     * @param st Student parse from Find method
     */
    public void update(Student st){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter updated information:");
        System.out.print("Student's Name: ");
        String name = sc.nextLine().trim();
        st.setName(name);
        System.out.print("Semester: ");
        int semester = checkvalid.CheckValid.validPositive();
        st.setSemester(semester);
        System.out.println("Update student information completed!");
    }
    
    /**
     * Delete Student by Student ID
     * @param st Student parse from Find method
     */
    public void delete(Student st){
        this.remove(st);
        System.out.println("Delete student completed!");
    }
    
    public void report(){
        for(Student s: this){
            System.out.println(s.getID() + " || " + s.getName() + " || " + s.getCourseName().getCourse());
        }
    }
    
    /**
     * Find student by ID If existed, parse value to Update or Delete method
     */
    public void updateDelete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student's ID to find: ");
        String ID = sc.nextLine().trim();
        Student st = findID(ID);
        if (st == null) {
            System.out.println("Student " + ID + " not found!");
            return;
        }
        System.out.println("Do you want to Update(u) or Delete(d) this student?");
        String c = sc.nextLine().toUpperCase();
        switch (c) {
            case "U":
                update(st);
                break;
            case "D":
                delete(st);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
}

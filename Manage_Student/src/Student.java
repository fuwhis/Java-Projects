/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quy Nguyen
 */
public class Student implements Comparable<Student>{
    private String ID; 
    private String name; 
    private int semester;
    private Course courseName; 
    
    public Student(){}

    public Student(String ID, String name, int semester, Course courseName) {
        this.ID = ID;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Course getCourseName() {
        return courseName;
    }

    public void setCourseName(Course courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "ID=" + ID + ", name=" + name + ", semester=" + semester + ", courseName=" + courseName;
    }
    
    @Override
    public int compareTo(Student s){
        return this.getName().compareTo(s.getName());
    }
}

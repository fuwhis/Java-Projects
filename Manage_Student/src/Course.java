/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quy Nguyen
 */
public enum Course{
    Java("JAVA"), NET(".NET"), C("C/C++");
    
    String Course; 

    private Course(String Course) {
        this.Course = Course;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }
    
    
    
    
}

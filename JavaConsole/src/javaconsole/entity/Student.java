/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.entity;

/**
 *
 * @author daolinh
 */
public class Student {

    private long id;
    private String name;
    private String email;
    private String rollNumber;
    private String className;
    private int status;

    public Student() {
       
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Student(long id, String name, String email, String rollNumber, String className, int status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rollNumber = rollNumber;
        this.className = className;
        this.status = status;
    }

   
    
   
 
  
}

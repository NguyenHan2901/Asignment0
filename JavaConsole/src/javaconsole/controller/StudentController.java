/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.controller;

import java.util.ArrayList;
import java.util.Scanner;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;

/**
 *
 * @author admin
 */
public class StudentController {
    // 1. getList.
    // 2. add.
    // 3. edit.
    // 4. delete.
    
    private StudentModel studentModel = new StudentModel();

    // Hàm này sẽ phải trả về danh sách sinh viên.
    // 1.list student
    public void getList() {
       StudentModel studentModel = new StudentModel();
       ArrayList<Student> listStudent = studentModel.getListStudent();
       for (Student student :listStudent){
           System.out.println("ID:" + student.getId());
           System.out.println("Name:" + student.getName());
           System.out.println("Email" + student.getEmail());
           System.out.println("Roll number" + student.getRollNumber());
           System.out.println("Class name" + student.getClassName());
           System.out.println("Status" + student.getStatus());
           System.out.println("---------------------------------------");
       } 
    }
    // 2. add student
    // Thêm mới sinh viên, thực hiện việc lấy dữ liệu từ người dùng,
    // validate dữ liệu đó, tiến hành lưu thông tin.
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter student information.");
        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter email: ");
        String email = scanner.nextLine();
        System.out.println("Please enter roll number");
        String rollNumber = scanner.nextLine();
        System.out.println("Please enter class name");
        String className = scanner.nextLine();
        System.out.println("Please enter roll status");
        int status = scanner.nextInt();
        System.out.println("Name: " + name + ", email: " + email + ",rollNumber" + rollNumber + ",className" + className + ",status" + status);
        
        // Validate dữ liệu ở đây.
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setRollNumber(rollNumber);
        student.setClassName(className);
        student.setStatus(status);
        student.setId(System.currentTimeMillis());
        // Lưu thông tin sinh viên vào db.
        studentModel.insert(student);
    }
    // 3. edit student
    public void editStudent() {
        Scanner scanner = new Scanner(System.in);
        int editID;
        while (true) {            
            System.out.println("Please enter student ID");
            String streditID = scanner.nextLine();
            try {
                editID = Integer.parseInt(streditID);
                break;
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Please enter a number.");
                continue;
            }
        }
        Student es = studentModel.getById(editID);
        if (es != null) {
            System.out.println("ID          :" + es.getId());
            System.out.println("Name        :" + es.getName());
            System.out.println("Email       :" + es.getEmail());
            System.out.println("Roll number :" + es.getRollNumber());
            System.out.println("Class name  :" + es.getClassName());
            System.out.println("Status      :" + es.getStatus());

            Student studentx = new Student();
            System.out.println("Enter new name:");
            scanner.nextLine();
            String newName = scanner.nextLine();
            System.out.println("Enter new email:");
            String newMail = scanner.nextLine();
            System.out.println("Enter new roll number:");
            String newRollNumber = scanner.nextLine();
            System.out.println("Enter new class name:");
            String newClassName = scanner.nextLine();
            System.out.println("Enter new status:");
            int newStatus = scanner.nextInt();

            studentx.setId(editID);
            studentx.setName(newName);
            studentx.setEmail(newMail);
            studentx.setRollNumber(newRollNumber);
            studentx.setClassName(newClassName);
            studentx.setStatus(newStatus);

            studentModel.update2(studentx);

        } else {
            System.err.println("studen not found");
        }

    }

    public void deleteStudent() {
        while (true) {            
            System.out.println("Please enter student ID");
            System.out.println("Enter 0 exit.");
            Scanner scanner = new Scanner(System.in);
            int dltID = scanner.nextInt();
            if (dltID == 0) {
                break;
            }
            Student ds = studentModel.getById(dltID);
            if (ds != null) {
                studentModel.delete(ds);
            } else {
                System.out.println("student not found");
            }
        }
    }
}

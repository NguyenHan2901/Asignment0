/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.filehandle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javaconsole.entity.Student;
/**
 *
 * @author Admin
 */
public class FileHandleDemo {
    public void importFile(){
        FileReader fr = null;
        BufferedReader br = null;
        try {
            String str;
            fr = new FileReader("test.txt");
            br = new BufferedReader(fr);
            while ((str = br.readLine()) != null) {                
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch(IOException ex){
            System.out.println(ex);
        } finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args){
    // lấy danh sách sinh viên trong database
        Student student = new Student(1,"han","nguyenhan@gmail.com","sadsad","c1702g",12);
        Student student1 = new Student(2,"ngoc","nguyentrang@gmail.com","sadsadsd","c1702g",13);
        Student student2 = new Student(3,"han","nguyenhan@gmail.com","sadsad","c1702g",12);
        ArrayList<Student> listStudent = new ArrayList<>();
        listStudent.add(student);
        listStudent.add(student1);
        listStudent.add(student2);
                
    //Export to file
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("test.txt");
            bw = new BufferedWriter(fw);
           
            for (Student studentTest : listStudent){
                bw.write("ID/:" + studentTest.getId());
                bw.newLine();
                bw.write("Name:" + studentTest.getName());
                bw.newLine();
                bw.write("Email:" + studentTest.getEmail());
                bw.newLine();
                bw.write("Roll_number:" + studentTest.getRollNumber());
                bw.newLine();
                bw.write("Class_Name" + studentTest.getClassName());
                bw.newLine();
                bw.write("status" + studentTest.getStatus());
                bw.newLine();
            }
        } catch (IOException e) {
        } finally{
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
            }
    
        }
    }
    
}

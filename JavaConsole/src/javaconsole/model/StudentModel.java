/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javaconsole.entity.Student;

/**
 *
 * @author nguyenhan
 */
public class StudentModel {
  //  private StudentModel studentModel = new StudentModel();
    private static ArrayList<Student> listStudent;
    
    public  void getList(){
    
    }
    // Insert thoong tin sinh viên vào bảng student trong database studentmanager
    public void insert(Student student){
        try {
            Connection cnn = DAO.getConnection();
            Statement stt = cnn.createStatement();
            StringBuilder sqlQueryBuilder = new StringBuilder();
            sqlQueryBuilder.append("INSERT INTO");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append(" student");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("(name, email, roll_number, class_name, status)");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("VALUES");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("(");
            sqlQueryBuilder.append("'" + student.getName() + "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append("'" + student.getEmail() + "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append("'" + student.getRollNumber()+ "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append("'" + student.getClassName()+ "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append( + student.getStatus()+")" );
            
         //  System.out.println(" ---Câu lệnh SQL---");
           System.out.println(sqlQueryBuilder.toString());
        //   System.out.println(" ---Kết thúc câu lệnh SQL---");
            stt.execute(sqlQueryBuilder.toString());
            System.out.println("Thành Công.");
            
            /*String query = "INSERT INTO "
                  + "student"
                  + "(name,email,roll_number,class_name,status)"
                  + "VALUES"
                  + " ('"
                    +student.getName()+"'"+','
                    +"'"+student.getEmail()+"'"
                    +','+"'"+student.getRoll_number()+"'"
                    +','+"'"+student.getClass_name()+"'"
                    +","+"'"+student.getStatus()+"')";
            stt.execute(query);*/
        }catch (SQLException e){
           System.err.println("Lỗi trong quá trình truy xuât dữ liệu." + e.getMessage());
           }
        
    }
 /*   public static void main(String[] args){
        
        StudentModel studentModel = new StudentModel();
        
        Student student = new Student();
        student.setName("Nguyễn Hân");
        student.setEmail("nguyenhan@gmail.com");
        student.setRoll_number("hnt");
        student.setClass_name("C1702G");
        student.setStatus(1);
    
        studentModel.insert(student);
        
    }*/
    //truy vấn dữ liệu
    public ArrayList<Student> getListStudent(){
        ArrayList<Student> listStudent = new ArrayList<>();
        try{
           Statement stt = DAO.getConnection().createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM student;");
           while (rs.next()){
           Student student = new Student();
           student.setId(rs.getInt("id"));
           student.setName(rs.getString("name"));
           student.setEmail(rs.getString("email"));
           student.setRollNumber(rs.getString("roll_number"));
           student.setClassName(rs.getString("class_name"));
           student.setStatus(rs.getInt("status"));
           listStudent.add(student);
           }
        }catch(SQLException e){
        }
        return listStudent;
    }
    
public void delete(String name) {
        try {
            String sqlQuery = "delete from student where id=?";
            PreparedStatement stm = DAO.getConnection().prepareStatement(sqlQuery);
            stm.setString(1, name);
            int rowsDeleted = stm.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Đã xóa thành công một sinh viên!");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình xóa dữ liệu" + e.getMessage());
        }

    }


    /**
     *
     * @param
     */
  /*  public static void main(String[] args){
    
  
        
        Student student01 = new Student();
        student01.setName("Nguyễn Hân");
        student01.setEmail("nguyenhan@gmail.com");
        student01.setRoll_number("29011008");
        student01.setClass_name("C1702G");
        student01.setStatus(1);
        
        StudentModel studentModel = new StudentModel();
        studentModel.insert(student01);    
    }*/
    public void update(Student student){
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("UPDATE student set name = ?, email = ?, roll_Name = ?, class_Name = ?, status = ?, where id = ?");
            preStt.setString(1, student.getName());
            preStt.setString(2, student.getEmail());
            preStt.setString(3, student.getRollNumber());
            preStt.setString(4, student.getClassName());
            preStt.setInt(5, student.getStatus());
            preStt.setLong(6, student.getId());
            
            
        } catch (Exception e) {
        }
    }
    public Student getById(int id){
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("SELECT * FROM student WHERE id = ?;");
            preStt.setInt(1, id);
            ResultSet rs = preStt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong(id));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setRollNumber(rs.getString("roll_Number"));
                student.setClassName(rs.getString("class_Name"));
                student.setStatus(rs.getInt("status"));
                return student;
            }
                
            
        } catch (Exception e) {
        }
        return null;
    }

    public void update2(Student student) {
       try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("UPDATE student SET name=?, email=? ,roll_Number=?, class_Name=?, status=? where id=?");
            preStt.setString(1, student.getName());
            preStt.setString(2, student.getEmail());
            preStt.setString(3, student.getRollNumber());
            preStt.setString(4, student.getClassName());
            preStt.setInt(5, student.getStatus());
            preStt.setLong(6, student.getId());
            
            preStt.execute();
            
        } catch (SQLException e) {
            System.err.println(e);
        }
    }


    public void delete2(Student student){
        try {
            String sqlQuery = "delete from student where id=?";
            PreparedStatement stm = DAO.getConnection().prepareStatement(sqlQuery);
            stm.setLong(1, student.getId());
            int rowsDeleted = stm.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Đã xóa sinh viên!");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình xóa dl" + e.getMessage());
        }

    }

    public void delete(Student ds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

package com.comp;

import com.mysql.cj.log.Log;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Students {

    public static void main(String[] args) {
        
        Students obj= new Students();
        
        obj.GreaterThan();
     
        obj.info();
        
        obj.Rollno();
    }

    void GreaterThan(){
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            // at port 8080 where schema is mydb1 and username and password are both root
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/mydb", "admin", "admin");
            System.out.println("Connection to mydb1 success!");

            
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery("SELECT NAME, ROLLNO, CGPA FROM STUDENT_INFO WHERE CGPA>8");
            System.out.println("PART - 1 :-");
            System.out.println("ROLLNO"+"\t|\t "+"NAME"+"\t\t\t|\t "+"CGPA");
            System.out.println(("_________________________________________\n"));
            while(set.next()){
                int id = set.getInt("ROLLNO");
                String name = set.getString("NAME");
                float cgpa = set.getFloat("CGPA");
                System.out.println(id+"\t\t|\t "+name+"\t\t|\t "+cgpa);
            }

        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    void Info(){
        try{
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/mydb", "admin", "admin");
            System.out.println("Connection to mydb1 success!");

            
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery("SELECT NAME, ROLLNO, COMPANY FROM STUDENT_INFO WHERE COMPANY='Infosys'");
            System.out.println("\n\nPART - 2 :-");
            System.out.println("ROLLNO"+"\t|\t "+"NAME"+"\t\t\t|\t "+"COMPANY");
            System.out.println(("____________________________________________\n"));
            while(set.next()){
                int id = set.getInt("ROLLNO");
                String name = set.getString("NAME");
                String company = set.getString("COMPANY");
                System.out.println(id+"\t\t|\t "+name+"\t\t|\t "+company);
            }

        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    void Rollno(){
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/mydb", "admin", "admin");
            System.out.println("Connection to mydb success!");

            
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery("SELECT NAME, ROLLNO FROM STUDENT_INFO ORDER BY ROLLNO ASC");
            System.out.println("\n\nPART - 3 :-");
            System.out.println("ROLLNO"+"\t|\t "+"NAME");
            System.out.println(("_____________________\n"));
            while(set.next()){
                int id = set.getInt("ROLLNO");
                String name = set.getString("NAME");
                System.out.println(id+"\t\t|\t "+name);
            }

        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

}
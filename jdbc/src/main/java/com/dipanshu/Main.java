package com.dipanshu;
/*
 * THEORY
 * 
 * - Steps:
 * 0. Import packages.
 * 1. Add the driver.
 * 2. Load the driver.
 * 3. Establish a connection (registration).
 * # After java6, loading and registring are done automatically.
 * 4. Create statements or whatever.
 * 5. Execute the statement.
 * 6. Close the connection.
 * 
 * import package
 * load and register
 * creat connection
 * create and execute statements
 * process the result
 * close the connection
 * 
 * 
 */
import java.sql.*;  //import
/*
 * CRUD : Create,Read,Update,Delete
 */

import com.mysql.cj.xdevapi.Result;
public class Main {
    public static void main(String[] args) throws Exception{

        //load and register the driver (optional)
        Class.forName("org.postgresql.Driver");

        //connecting the application to the database
        String url = "jdbc:postgresql://localhost:5432/students";
        String usr = "postgres";
        String passwd = "1234";
        Connection postConnection = DriverManager.getConnection(url,usr,passwd);

        Connection mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","dipanshu","1234");
        System.out.println("Connections Established!");

        //creating statements
        Statement postStatement = postConnection.createStatement();
        Statement myStatement = mysqlConnection.createStatement();

        //READ
        // ResultSet resulSet = postStatement.executeQuery("select * from student");

        // postStatement.executeQuery("insert into student values(2,'tikku')");

        // System.out.println(resulSet.next());   //false if no output, true if got some row is there and move the pointer to that row

        //Fetch single data
        // resulSet.next(); //move to the first row
        // System.out.println(resulSet.getString("sname"));

        //Fetch all
        // while(resulSet.next()){ //if next row exist move to it
        //     System.out.println((resulSet.getInt("sid"))+" "+resulSet.getString("sname"));
        // }

        //CREATE
        //SQL injection issue, if input is coming from user
        //How to cache the querry? (if one querry is being repeated)
        // System.out.println(postStatement.execute("insert into student values(4,'mitthu')"));

        //UPDATE
        // postStatement.execute("update student set sname='meow' where sid=1");

        //DELETE
        // postStatement.execute("delete from student where sid = 2");

        //PREPARED STATEMENT
        String sql = "insert into student values(?,?)";
        PreparedStatement postPreparedStatement = postConnection.prepareStatement(sql);         //this will be cached
        //sql injection proof
        postPreparedStatement.setInt(1, 9); // column number 1 (sid), with data sid = 9
        postPreparedStatement.setString(2, "chikku");   //column number 2 (sname), with data sname = "chikku" 
        postPreparedStatement.execute();


        mysqlConnection.close();
        postConnection.close();
        System.out.println("Connections closed!");
        
    }
}

package ch08.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReportDAO {

    public ResultSet getPdf() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.137.128:3306/jsptest", "moving33", "1234");
            String query = "SELECT NAME, email, mobile, college, course, skills, marks1, marks2, marks3 FROM pdfreport";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}

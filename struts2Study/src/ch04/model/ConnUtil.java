package ch04.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnUtil {
    private static DataSource dataSource;
    static {
        try{
            Context init = new InitialContext();
            dataSource = (DataSource) init.lookup("java:comp/env/jdbc/mySQL");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    private ConnUtil(){}

    public static Connection getConnection()throws SQLException{
        return dataSource.getConnection();
    }
}

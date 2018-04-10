package ch04.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyUserDAO {
    private static MyUserDAO ourInstance = new MyUserDAO();

    public static MyUserDAO getInstance() {
        return ourInstance;
    }

    private MyUserDAO() {
    }

    public void insertMember(MyUserVO myUserVO){
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnUtil.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO mytempuser(ID, PASS, NAME) values (?,?,?)");
            pstmt.setString(1,myUserVO.getId());
            pstmt.setString(2,myUserVO.getPass());
            pstmt.setString(3,myUserVO.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pstmt != null){try{pstmt.close();}catch (SQLException sq){}}
            if(pstmt != null){try{conn.close();}catch (SQLException sq){}}
        }
    }
}

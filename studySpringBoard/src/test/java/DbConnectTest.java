

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DbConnectTest {
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.137.128/jsptest";
    private static final String User = "moving33";
    private static final String PW = "1234";

    /**
     *  Java to MySql testConnection.
     *  SQL sample ) select count(*) from SampleTable
     */
    @Test
    public void testConnection()throws Exception{
        Class.forName(Driver);

        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(URL,User,PW);
            System.out.println(conn);
            stmt = conn.createStatement();
            int count = 0;
            rs = stmt.executeQuery("SELECT count(*) FROM boardmvc");
            if(rs.next()) {
                count = rs.getInt(1);
            }
            System.out.println("select count(*) from SampleTable :"+count);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(rs != null){
                try{
                    rs.close();
                }catch (Exception e){}
            }if(stmt != null){
                try{
                    stmt.close();
                }catch (Exception e){}
            }
            if(conn != null){
                try{
                    conn.close();
                }catch (Exception e){}
            }
        }
    }


    /**
     *  Spring to Mybatis3 testConnection.
     *
     */

    @Test
    public void testMyBatisConnection()throws Exception{
        try{
            SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
            sqlSessionFactory.setDataSource(dataSource());
            SqlSessionTemplate sqlSessionTemplate
            = new SqlSessionTemplate((SqlSessionFactory) sqlSessionFactory.getObject());
            System.out.println("Get SqlSessionTemplate success !! this class : "+sqlSessionTemplate.getClass());
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    public DataSource dataSource()throws Exception{
        DriverManagerDataSource ds =
                new DriverManagerDataSource();
        ds.setDriverClassName(Driver);
        ds.setUrl(URL);
        ds.setUsername(User);
        ds.setPassword(PW);
        return ds;
    }
}

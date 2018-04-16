import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.j.ibatis.MyUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserTest {

    private final static String selectUserById = "com.j.ibatis.MyUser.selectUserById";
    private final static String insertUser = "com.j.ibatis.MyUser.insertUser";
    private final static String updateUser = "com.j.ibatis.MyUser.updateUser";
    private final static String deleteUserById = "com.j.ibatis.MyUser.deleteUserById";

   /*  V2.3
   private static SqlMapClient sqlMapper;

    static {
        try {*//*

            Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
            sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
            reader.close();*//*

        } catch (IOException e) {
            throw new RuntimeException("SqlMapClient 생성 실패", e);
        }

    }*/

    // V 3.~
    private static SqlSessionFactory getSqlSessionFactory() {

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = org.apache.ibatis.io.Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new SqlSessionFactoryBuilder().build(inputStream);
    }
    //모든 유저
    /*public static List<MyUser> selectAllUsers() throws SQLException {
        return (List<MyUser>) sqlMapper.queryForList("selectAllUsers");
    }*/

    public static List<MyUser> selectAllUsers() {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        String k = "com.j.ibatis.MyUser.selectAllUsers";
        try {
            return sqlSession.selectList(k);
        } finally {
            sqlSession.close();
        }
    }

    //선택 유저
    /*public static MyUser selectUserById(String id) throws SQLException {
        return (MyUser)sqlMapper.queryForObject("selectUserById",id);
    }*/
    public static MyUser selectUserById(String id) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        try {
            return sqlSession.selectOne(selectUserById, id);
        } finally {
            sqlSession.close();
        }

    }

    //유저 등록
    /*public static void insertUser(MyUser user) throws SQLException {
        sqlMapper.insert("insertUser", user);
    }*/

    public static Integer insertUser(MyUser user) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        try {
            int result = sqlSession.insert(insertUser,user);

            if(result>0){
                sqlSession.commit();
            }
            return result;
        }finally {
            sqlSession.close();
        }

    }

    //유저 업데이트
    /*public static void updateUser(MyUser user) throws SQLException {
        sqlMapper.update("updateUser", user);
    }*/

    public static Integer updateUser(MyUser user){
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        try{
            int result = sqlSession.update(updateUser,user);
            if(result>0){
                sqlSession.commit();
            }
            return result;
        }finally {
            sqlSession.close();
        }
    }

    //delete
/*
    public static void delete(String id) throws SQLException {
        sqlMapper.delete("deleteUserById", id);
    }
*/
    public static Integer delete(String id){
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        try{
            int result = sqlSession.delete(deleteUserById,id);
            if(result>0){
                sqlSession.commit();
            }
            return  result;
        }finally {
            sqlSession.close();
        }
    }

    public static void main(String[] ar) throws IOException, SQLException {

        UserTest test = new UserTest();
        int menu = -1;
        String id = "";
        String pass = "";
        String name = "";
        int age = 0;
        MyUser myUser1 = null;
        int r = 0;

        Scanner scan = new Scanner(System.in);

        while (menu != 0) {
            r = 0 ;
            System.out.println("1.전체목록");
            System.out.println("2.회원검색");
            System.out.println("3.회원등록");
            System.out.println("4.정수정");
            System.out.println("5.회원탈퇴");
            System.out.println("0.프로그램 종료");
            System.out.print("메뉴선택 :");

            try {
                menu = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("숫자를 입력 해주세요");
                continue;
            }

            switch (menu) {
                case 1:
                    List<MyUser> list = selectAllUsers();

                    for (MyUser myUser : list) {
                        System.out.println(myUser.toString());
                    }
                    break;

                case 2:
                    System.out.print("찾으시는 ID :");
                    id = scan.nextLine().trim();
                    myUser1 = selectUserById(id);
                    System.out.println(myUser1.toString());
                    break;

                case 3:
                    System.out.print("ID = ");
                    id = scan.nextLine().trim();
                    System.out.print("PASS = ");
                    pass = scan.nextLine().trim();
                    System.out.print("NAME = ");
                    name = scan.nextLine().trim();
                    System.out.print("AGE = ");
                    age = Integer.parseInt(scan.nextLine());

                    myUser1 = new MyUser(id, pass, name, age);
                    r = test.insertUser(myUser1);
                    if(r>0)System.out.println("신규 회원등록 성공");
                    else System.out.println("회원 등록 실패");
                    break;

                case 4:
                    System.out.print("수정할 회원의 ID = ");
                    id = scan.nextLine();
                    System.out.print("PASS = ");
                    pass = scan.nextLine().trim();
                    System.out.print("NAME = ");
                    name = scan.nextLine().trim();
                    System.out.print("AGE = ");
                    age = Integer.parseInt(scan.nextLine());

                    myUser1 = new MyUser(id, pass, name, age);
                    r = updateUser(myUser1);
                    if(r>0)System.out.println(id + "님의 회원정보 수정 성공");
                    else System.out.println(id + "님의 회원정보 수정 실패");
                    break;

                case 5:
                    System.out.print("삭제할 회원 ID = ");
                    id = scan.nextLine();
                    test.delete(id);
                    System.out.println(id + "님의 회원정보 삭제 성공");
                    break;

                case 0:

                    System.out.println("프로그램을 종료 합니다.");
                    menu = 0;
                    break;


            }

        }


    }

}

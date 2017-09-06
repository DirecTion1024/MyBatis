package MyBatis.MyBatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import MyBatis.MyBatis.User;

public class TestSelect {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static{
        try{
            reader    = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
   
    public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
        User user = (User) session.selectOne("MyBatis.MyBatis.UserMapper.selectUserByID",1);
        System.out.println(user.getUserAge());
        System.out.println(user.getUserGender());
        System.out.println(user.getUserPhone());
        System.out.println(user.getUserAddress());
        System.out.println(user.getUserName());
        } finally {
        session.close();
        }
    }
}

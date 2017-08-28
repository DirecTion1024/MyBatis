package MyBatis.MyBatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestUpdate {


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
        	System.out.println(user.getUserName());
        	user.setUserName("xiangfang_update");
        	session.insert("MyBatis.MyBatis.UserMapper.updateHomework", user);
        	session.commit();
        
        } finally {
        session.close();
        }
    }




}

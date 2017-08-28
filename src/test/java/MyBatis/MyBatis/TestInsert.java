package MyBatis.MyBatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestInsert {

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
        	User user = new User();
        	user.setId(3);
        	user.setUserName("xiangfang3");
        	user.setUserGender("man");
        	user.setUserPhone("18358196138");
        	user.setUserAddress("Hefei3");
        	user.setUserAge("23");
        	session.insert("MyBatis.MyBatis.UserMapper.addHomework", user);
        	session.commit();
        
        } finally {
        session.close();
        }
    }


}

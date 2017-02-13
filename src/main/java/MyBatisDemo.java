
import com.domain.Student;
import com.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Created by 16440 on 2017/2/13.
 */
public class MyBatisDemo {
    public static SqlSessionFactory sessionFactory;

    static {
        org.apache.ibatis.logging.LogFactory.useStdOutLogging();
        try {
            //使用MyBatis提供的Resources类加载mybatis的配置文件
            Reader reader = Resources.getResourceAsReader("config.xml");
            //构建sqlSession的工厂
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //创建能执行映射文件中sql的sqlSession
    public static SqlSession getSession() {
        return sessionFactory.openSession();
    }

    @Test
    public void test() {
        SqlSession session = getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student1 = new Student(1, "第一個", null);
        Student result = studentMapper.findBySomeThing(student1);
        System.out.println(result.toString());
        test2();
        test3();
    }

    public void test2() {
        SqlSession session = getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student1 = new Student(1, null, 10);
        Student result = studentMapper.findBySomeThing(student1);
        System.out.println(result.toString());

    }

    public void test3() {
        SqlSession session = getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student1 = new Student(1, "第一個", 10);
        Student result = studentMapper.findBySomeThing(student1);
        System.out.println(result.toString());

    }
}

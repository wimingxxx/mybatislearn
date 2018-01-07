package test;

import com.qwm.mybatis.mapper.UserMapper;
import com.qwm.mybatis.pojo.User;
import com.qwm.mybatis.pojo.UserCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author：qiwenming
 * @date：2018/1/8 0008
 * @description：
 * 用户相关的测试
 */
public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws Exception{
        //1 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //2 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        //3 创建SqlSessionFactory对象
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testFindUserOrDetails() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findUserOrDetails();
        System.out.println(list);
    }

    /**
     *多对多查询：查询显示字段：用户账号、用户名称、用户性别、商品名称、商品价格(最常见
     * @throws Exception
     */
    @Test
    public void testFindUserOrItems() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserCustom> list = userMapper.findUserOrItems();
        System.out.println(list);
    }
}

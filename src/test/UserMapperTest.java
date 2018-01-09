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

    /**
     *多对多查询：查询显示字段：用户账号、用户名称、购买商品数量、商品明细
     * @throws Exception
     */
    @Test
    public void findUserOrItemsDetail() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findUserOrItemsDetail();
        System.out.println(list);
    }

    /**
     * 一级缓存测试
     * @throws Exception
     */
    @Test
    public void testCahce1() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //第一次查询用户id为1的用户
        User user= userMapper.findUserById(1);
        System.out.println(user);

        System.out.println("------------华丽的分割线--------------");

        //第二次查询用户id为1的用户
        User user1= userMapper.findUserById(1);
        System.out.println(user1);
    }

    /**
     * 二级缓存
     * @throws Exception
     */
    @Test
    public void testCache2() throws Exception{
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);

        //第一次查询用户为1的用户
        User user1 = userMapper1.findUserById(1);
        System.out.println(user1);
        sqlSession1.close();

        System.out.println("-----------------");

        //第二次查询用户为1的用户
        User user2 = userMapper2.findUserById(1);
        System.out.println(user2);

        System.out.println("-----------------");

        //修改数据，修改数据
        user2.setUsername("测试用户明哥哥");
        userMapper2.updateUser(user2);
        sqlSession2.commit();
        sqlSession2.close();

        System.out.println("-----------------");

        //第三次查询用户为1的用户
        User user3 = userMapper3.findUserById(1);
        System.out.println(user3);
        sqlSession3.close();
    }
}

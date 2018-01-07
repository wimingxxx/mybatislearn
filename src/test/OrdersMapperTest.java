package test;

import com.qwm.mybatis.mapper.OrdersMapper;
import com.qwm.mybatis.pojo.Orders;
import com.qwm.mybatis.pojo.OrdersCustom;
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
 * @date：2018/1/7 0007
 * @description：
 * 订单相关的测试
 */
public class OrdersMapperTest {
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
     *一对一查询，查询订单关联查询用户
     */
    @Test
    public void testFindOrderUserList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<OrdersCustom> list = ordersMapper.findOrderUserList();
        System.out.println(list);
    }

    /**
     *一对一查询，查询订单关联查询用户(resultMap实现)
     */
    @Test
    public void testFindOrderUserListResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<OrdersCustom> list = ordersMapper.findOrderUserListResultMap();
        System.out.println(list);
    }

    /**
     *一对多查询，查询订单关联查询订单明细(resultMap实现)
     */
    @Test
    public void testFindOderAndOrderDetails() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> list = ordersMapper.findOderAndOrderDetails();
        System.out.println(list);
    }
}

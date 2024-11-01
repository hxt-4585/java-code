import com.powernode.pojo.Car;
import com.powernode.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MyBatisIntroductionTest {
    @Test
    public void testInsert(){
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml");
//            InputStream is = new FileInputStream("E:\\Users\\IdeaProjects\\mybatis\\mybatis-001\\src\\main\\resources\\mybatis-config.xml");

            // 这种方式只能从类路径当中获取资源，也就是说mybatis-config.xml文件需要在类路径下。
            // 类路径指的是编译以后classes目录
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            sqlSession = sqlSessionFactory.openSession();

            int count = sqlSession.insert("insertCar");
            System.out.println(count);
            sqlSession.commit();
        }catch (Exception e){
            if (sqlSession != null){
                sqlSession.rollback();
            }
            e.printStackTrace();
        }finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }

    @Test
    public void testInsertCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.insert("insertCar");
        sqlSession.close();
    }

    @Test
    public void testInsertCarByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("k1", "103");
        map.put("k2", "奔驰E300L");
        map.put("k3", 50.3);
        map.put("k4", "2020-10-01");
        map.put("k5", "燃油车");
        // 如果是map集合中不存在的key，会返回null，即数据库中该值为空
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.insert("insertCar", map);
    }

    @Test
    public void testInsertCarByPOJO(){
        Car car = new Car();
        car.setCarNum("103");
        car.setBrand("奔驰C200");
        car.setGuidePrice(33.23);
        car.setProduceTime("2020-10-11");
        car.setCarType("燃油车");

        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL，传数据
        int count = sqlSession.insert("insertCarByPOJO", car);
        System.out.println("插入了几条记录" + count);
    }

    @Test
    public void testDeleteByCarNum(){
        Map<String, Object> map = new HashMap<>();
        map.put("k1", 103);
        map.put("k2", 33.23);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("deleteByCarNum", map);
        System.out.println("删除了几条记录：" + count);
    }

    @Test
    public void testUpdateCarByPOJO(){
        // 准备数据
        Car car = new Car();
        car.setId(165L);
        car.setCarNum("102");
        car.setBrand("比亚迪汉");
        car.setGuidePrice(30.23);
        car.setProduceTime("2018-09-10");
        car.setCarType("电车");
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL语句
        int count = sqlSession.update("updateCarByPOJO", car);
        System.out.println("更新了几条记录：" + count);
    }

    @Test
    public void testSelectCarById(){
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL语句
        Object car = sqlSession.selectOne("selectCarById", 165L);
        System.out.println(car);
    }

    @Test
    public void testSelectCarAll(){
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL语句
        List<Object> cars = sqlSession.selectList("selectCarAll");
        // 输出结果
        cars.forEach(car -> System.out.println(car));
    }
}

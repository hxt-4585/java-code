package com.powernode;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class CarMapperTest {
    @Test
    public void testSelectByCarType(){
        CarMapper mapper = (CarMapper) SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByCarType("燃油车");
        cars.forEach(car -> System.out.println(car));
    }

    @Test
    public void testInsertUseGeneratedKeys(){
        Car car = new Car(null, "10", "比亚迪", 11.11, "2022-11-11", "燃油车");
        CarMapper mapper = (CarMapper) SqlSessionUtil.openSession().getMapper(CarMapper.class);
        int count = mapper.insertUseGeneratedKeys(car);
        System.out.println(count);
        SqlSessionUtil.openSession().commit();
        System.out.println(car.getId());
    }

    @Test
    public void testSelectByIdRetMap(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Map<String, Object> map = mapper.selectByIdRetMap(165L);
        System.out.println(map);
    }

    @Test
    public void testSelectAllRetListMap(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Map<String, Object>> maps = mapper.selectAllRetListMap();
        maps.forEach(map -> System.out.println(map));
    }

    @Test
    public void testSelectAllRetMap(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Map<Long,Map<String,Object>> cars = mapper.selectAllRetMap();
        System.out.println(cars);
    }

    @Test
    public void testSelectAllByResultMap(){
        CarMapper carMapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectAllByResultMap();
        System.out.println(cars);
    }

    @Test
    public void testSelectTotal(){
        CarMapper carMapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Long total = carMapper.selectTotal();
        System.out.println(total);
    }

    @Test
    public void testSelectByMultiConditionWithWhere(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiConditionWithWhere(null, 20.0, "燃油车");
        System.out.println(cars);
    }

    @Test
    public void testSelectByCache(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String, Object> car1 = mapper.selectByIdRetMap(165L);
        System.out.println(car1);

        Map<String, Object> car2 = mapper.selectByIdRetMap(165L);
        System.out.println(car2);
    }

    @Test
    public void testSelectById2() throws Exception{
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        Map car1 = mapper1.selectByIdRetMap(165L);
        System.out.println(car1);

        // 关键一步
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CarMapper mapper2 = sqlSession2.getMapper(CarMapper.class);
        Map car2 = mapper2.selectByIdRetMap(165L);
        System.out.println(car2);
    }
}

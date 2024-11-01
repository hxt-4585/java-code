package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Car的sql映射对象
 * @author 老杜
 * @version 1.0
 * @since 1.0
 */
public interface CarMapper {

    /**
     * 根据car_num获取Car
     * @param carType
     * @return
     */
    List<Car> selectByCarType(String carType);

    /**
     * 自动生成主键并返回
     * @param car
     * @return
     */
    int insertUseGeneratedKeys(Car car);

    /**
     * 通过id查询一条记录，返回Map集合
     * @param id
     * @return
     */
    Map<String, Object> selectByIdRetMap(Long id);

    /**
     * 查询所有的Car，返回一个List集合。List集合中存储的是Map集合。
     * @return
     */
    List<Map<String,Object>> selectAllRetListMap();

    /**
     * 获取所有的Car，返回一个Map集合。
     * Map集合的key是Car的id。
     * @return
     */
    @MapKey("id")
    Map<Long,Map<String,Object>> selectAllRetMap();

    /**
     * 查询所有Car，使用resultMap进行结果映射
     * @return
     */
    List<Car> selectAllByResultMap();

    /**
     * 返回总记录条数
     * @return
     */
    Long selectTotal();

    /**
     * 根据多条件查询Car，使用where标签
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithWhere(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);
}

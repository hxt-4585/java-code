package com.powernode.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 普通实体类：汽车
 * @author 老杜
 * @version 1.0
 * @since 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car implements Serializable {
    private Long id;
    private String carNum;
    private String brand;
    private Double guidePrice;
    private String produceTime;
    private String carType;
    // 构造方法
    // set get方法
    // toString方法
}
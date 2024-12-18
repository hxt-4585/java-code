package com.hxt.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.hxt.cloud.entities.Pay;
import com.hxt.cloud.entities.PayDTO;
import com.hxt.cloud.resp.ResultData;
import com.hxt.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Tag(name ="支付模块", description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    public ResultData<String> addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("添加成功"+ i +"条记录");
    }

    @DeleteMapping("/pay/del/{id}")
    public ResultData<String> deletePay(@PathVariable("id") Integer id){
        int i = payService.delete(id);
        return ResultData.success("删除成功"+ i +"条记录");
    }

    @PutMapping("/pay/update")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO,pay);
        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值： " + i);
    }

    @GetMapping("/pay/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id){
        return ResultData.success(payService.getById(id));
    }

    @Operation(summary="查询所有订单")
    @GetMapping("/pay/getAll")
    public ResultData<List<Pay>> getAll(){
        return ResultData.success(payService.getAll());
    }
}

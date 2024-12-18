package com.hxt.cloud.exception;

import com.hxt.cloud.resp.ResultData;
import com.hxt.cloud.resp.ReturnCodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler()
    public ResultData<String> globalExceptionHandler(Exception e){
        e.printStackTrace();
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),ReturnCodeEnum.RC500.getMessage());
    }                               
}

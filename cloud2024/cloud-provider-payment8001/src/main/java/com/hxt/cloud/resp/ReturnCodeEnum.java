package com.hxt.cloud.resp;

import lombok.Getter;

@Getter
public enum ReturnCodeEnum {
    //1.举值
    RC999("999", "操作XXX失败"),
    RC200("200", "success"),
    RC201("201", "服务开启降级保护,请稍后再试!"),
    RC202("202", "热点参数限流,请稍后再试!"),
    RC203("203", "系统规则不满足要求,请稍后再试!"),
    RC204("204", "授权规则不通过,请稍后再试!"),
    RC403("403", "无访问权限,请联系管理员授予权限"),
    RC401("401", "匿名用户访问无权限资源时的异常"),
    RC404("404", "404页面找不到的异常"),
    RC500("500", "系统异常，请稍后重试"),
    RC375("375", "数学运算异常，请稍后重试"),
    INVALID_TOKEN("2001", "访问令牌不合法"),
    ACCESS_DENIED("2003", "没有权限访问该资源"),
    CLIENT_AUTHENTICATION_FAILED("1001", "客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR("1002", "用户名或密码错误"),
    BUSINESS_ERROR("1004", "业务逻辑异常"),
    UNSUPPORTED_GRANT_TYPE("1003", "不支持的认证模式");

    // 2.构造
    private final String code; // 自定义状态码，对应前面枚举的第一个参数
    private final String message; // 自定义信息，对应前面枚举的第二个参数
    ReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // 3.遍历
    public static ReturnCodeEnum getReturnCodeEnum(String code) {
        for (ReturnCodeEnum e : ReturnCodeEnum.values()) {
            if(e.getCode().equalsIgnoreCase(code)){
                return e;
            }
        }
        return null;
    }
}
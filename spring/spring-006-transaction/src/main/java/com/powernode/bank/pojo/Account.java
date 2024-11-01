package com.powernode.bank.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 动力节点
 * @version 1.0
 * @className Account
 * @since 1.0
 **/
@Data
@NoArgsConstructor
public class Account {
    private String actno;
    private Double balance;
}

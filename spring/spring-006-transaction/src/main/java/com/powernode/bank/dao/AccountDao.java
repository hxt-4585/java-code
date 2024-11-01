package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

/**
 * @author 动力节点
 * @version 1.0
 * @className AccountDao
 * @since 1.0
 **/
public interface AccountDao {

    /**
     * 根据账号查询余额
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户
     * @param act
     * @return
     */
    int update(Account act);

}

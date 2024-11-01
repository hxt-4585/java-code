package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

public interface AccountDao {
    /**
     * 根据账号获取账户信息
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户信息
     * @param act
     * @return
     */
    int update(Account act);
}

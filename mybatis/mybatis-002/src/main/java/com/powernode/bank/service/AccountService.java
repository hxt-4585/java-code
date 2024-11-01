package com.powernode.bank.service;

import com.powernode.bank.exception.AppException;
import com.powernode.bank.exception.MoneyNotEnoughException;

public interface AccountService {
    /**
     * 银行账户转账
     * @param fromActno
     * @param toActno
     * @param money
     * @throws MoneyNotEnoughException
     * @throws AppException
     */
    void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, AppException;
}

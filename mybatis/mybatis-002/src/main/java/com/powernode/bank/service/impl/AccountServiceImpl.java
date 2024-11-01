package com.powernode.bank.service.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.dao.impl.AccountDaoImpl;
import com.powernode.bank.exception.AppException;
import com.powernode.bank.exception.MoneyNotEnoughException;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, AppException {
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money){
            throw new MoneyNotEnoughException("您的余额不足");
        }
        try {
            Account toAct = accountDao.selectByActno(toActno);
            fromAct.setBalance(fromAct.getBalance() - money);
            toAct.setBalance(toAct.getBalance() + money);
            accountDao.update(fromAct);
            accountDao.update(toAct);
        }catch (Exception e){
            throw new AppException("未知错误");
        }
    }
}

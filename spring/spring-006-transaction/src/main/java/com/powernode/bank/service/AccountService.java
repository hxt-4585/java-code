package com.powernode.bank.service;

public interface AccountService {
    public void transfer(String fromActno, String toActno, double money);
}

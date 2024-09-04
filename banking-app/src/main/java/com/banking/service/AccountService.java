package com.banking.service;

import java.util.List;

import com.banking.dto.AccountDto;

public interface AccountService {

		AccountDto createAccount(AccountDto accountDto);
		AccountDto getAccountById(long Id);
		AccountDto deposit(long id,double amount);
		AccountDto withdraw(long id,double amount);
		List<AccountDto> getAllAcounts();
		void deleteAccount(long Id);
		
}

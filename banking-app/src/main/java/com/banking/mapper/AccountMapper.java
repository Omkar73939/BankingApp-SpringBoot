package com.banking.mapper;

import com.banking.dto.AccountDto;
import com.banking.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountDto) {
		
		//converting account dto to account jpa entity
		Account account = new Account(
				accountDto.getId(),
				accountDto.getAccountHolderName(),
				accountDto.getBalance());
		
		return account; 
	}
	
	//account jpa to account dto
	public static AccountDto mapToAccountDto(Account account) {
		 AccountDto accountDto = new AccountDto(
				 account.getId(),
				 account.getAccountHolderName(),
				 account.getBalance());
		 
		 return accountDto;
	}
	
}

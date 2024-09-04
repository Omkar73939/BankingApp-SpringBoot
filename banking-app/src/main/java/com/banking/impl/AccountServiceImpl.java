package com.banking.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dto.AccountDto;
import com.banking.entity.Account;
import com.banking.mapper.AccountMapper;
import com.banking.repository.AccountRepository;
import com.banking.service.AccountService;

// to ccreate the spring beean
@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
		
	}

	@Override
	public AccountDto getAccountById(long Id) {
		
		Account account = accountRepository.findById(Id).
				orElseThrow(()-> new RuntimeException("Account Does Not Exist"));
		
		// for getting all the account details
//		List<Account> acnt = accountRepository.findAll();	
		return AccountMapper.mapToAccountDto(account);
		
	}

	@Override
	public AccountDto deposit(long id, double amount) {
		
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Account Does not Exists"));
		
		double total=account.getBalance() + amount;
		account.setBalance(total);
		Account saveAccount = accountRepository.save(account);	
		return AccountMapper.mapToAccountDto(saveAccount);
	}

	@Override
	public AccountDto withdraw(long id,double amount) {
		
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Account Does not exist"));
		
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insufficient Balance ");
		}
		
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account saveAccount = accountRepository.save(account);
		
		
		return AccountMapper.mapToAccountDto(saveAccount);
	}

	@Override
	public List<AccountDto> getAllAcounts() {
		
	 List<Account> accountList =	accountRepository.findAll();
	
	 return accountList.stream()
			 .map((account)-> AccountMapper
			 .mapToAccountDto(account))
			 .collect(Collectors.toList());
 
	}

	@Override
	public void deleteAccount(long Id) {
		
		Account account =accountRepository.findById(Id).orElseThrow(()-> new RuntimeException("Account Does Not Exist"));
		
//		accountRepository.deleteById(Id);
		accountRepository.delete(account);
	}

}

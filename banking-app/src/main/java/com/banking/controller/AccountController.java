package com.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.dto.AccountDto;
import com.banking.service.AccountService;

@RestController    //makes spring mvc rest controller class
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	// Add Account Rest API
	@PostMapping					// req. body maps the json to java object
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){ 
		
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	//Get Account Rest API
	@GetMapping("/{Id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable long Id){
		AccountDto accountDto =	accountService.getAccountById(Id);
		return ResponseEntity.ok(accountDto);
	}
	
	//Deposit Money Rest API
	@PutMapping("/{Id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long Id
			,@RequestBody Map<String,Double> request){  
		
		Double amount = request.get("amount");
		
		AccountDto accountDto = accountService.deposit(Id,amount);
		
		return ResponseEntity.ok(accountDto);
	}
	
	// withdraw rest api
	@PutMapping("/{Id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable long Id
			,@RequestBody Map<String,Double> request){
		
		Double amount = request.get("amount");
		
	AccountDto accountDto = accountService.withdraw(Id,amount);
	return ResponseEntity.ok(accountDto);
		
	}
	
	// get all accounts
	@GetMapping("/allAccounts")
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accountDtoList = accountService.getAllAcounts();
		return ResponseEntity.ok(accountDtoList);
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<String> deleteAccount(@PathVariable long Id) {
	
		accountService.deleteAccount(Id);
		
		return ResponseEntity.ok("Account is deleted Successfully");
		
		
	}
}


package com.softwareseni.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softwareseni.entities.Transaction;
import com.softwareseni.repo.TransactionRepository;

@RestController
@RequestMapping("/transactionservice")
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@PutMapping(path = "/transaction/{transactionId}")
	public HttpStatus addTransaction(@PathVariable(value = "transactionId") Long transactionId, @RequestBody Transaction reqTran) {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(transactionId);
		transaction.setAmount(reqTran.getAmount());
		transaction.setType(reqTran.getType());
		transaction.setParentId(reqTran.getParentId());
		transactionRepository.save(transaction);
		return HttpStatus.OK;
	}
	
	@GetMapping(path = "/transaction/{transactionId}")
	public Optional<Transaction> getTransaction(@PathVariable(value = "transactionId") Long transactionId) {
		return transactionRepository.findById(transactionId);
	}
	
	@GetMapping("/types/{type}") 
	public List<Long> getListTransaction(@PathVariable(value = "type") String type) { 
		return transactionRepository.getTransactionIdByType(type); 
	}
	
	@GetMapping(path = "/sum/{transactionId}")
	public Double sumTransaction(@PathVariable(value = "transactionId") Long transactionId) {
		Transaction transaction;
		Double sum = 0.0;
		transaction = transactionRepository.getOne(transactionId);
		System.out.println(transaction.getParentId());
		if (transaction.getParentId() == null) {
			Double amountParent = transactionRepository.getAmountByParentId(transactionId);
			sum = transaction.getAmount()+amountParent;
			return sum;
		} else {
			sum = transaction.getAmount();
			return sum;
		}
	}
}

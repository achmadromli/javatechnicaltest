package com.softwareseni.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.softwareseni.entities.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query(value ="select transaction_id as transactionId from transaction where type = :type", nativeQuery = true)
	public List<Long> findTransactionIdByType(String type);
	
}

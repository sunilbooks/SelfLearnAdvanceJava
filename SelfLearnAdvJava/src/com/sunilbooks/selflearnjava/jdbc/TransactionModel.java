package com.sunilbooks.selflearnjava.jdbc;

import java.util.List;

import com.sun.jmx.snmp.Timestamp;

public class TransactionModel {

	private long id = 0;
	private long accountId = 0;
	private long amount = 0;
	private Timestamp dateTime = null;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public long add() {
		return 0;
	}

	public long delete() {
		return 0;
	}

	public long update() {
		return 0;
	}

	public TransactionModel findByPk() {
		return null;
	}

	public TransactionModel findByAccount() {
		return null;
	}

	public List<TransactionModel> search() {
		return null;
	}

	public List<TransactionModel> search(int page, int size) {
		return null;
	}

}

package com.sunilbooks.selflearnjava.jdbc;

import java.util.List;

public class AccountModel {

	private long id = 0;
	private String type = null;
	private long balance = 0;
	private long customerId = 0;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public AccountModel findByPk() {
		return null;
	}

	public List<AccountModel> search() {
		return null;
	}

	public List<AccountModel> search(int page, int size) {
		return null;
	}

	public long diposit(long amount) {
		return 0;
	}

	public long withdrawal(long amount) {
		return 0;
	}

	public long fundTransfer(long amount, long accountId) {
		return 0;
	}

}

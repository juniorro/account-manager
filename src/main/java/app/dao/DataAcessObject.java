package app.dao;
import org.springframework.data.domain.Page;

import app.model.Account;
import app.model.Transaction;

public interface DataAcessObject {
	
	public Account checkAccount(String accountcode);
	public void makeDeposit(String accountcode, double theAmount);
	public void makeWithdraw(String accountcode, double theAmount);
	public void Transfer(String accountcode1, String accountcode2, double theAmount);
	public Page<Transaction> TransactionsList(String accountcode, int page, int pagesize);

}

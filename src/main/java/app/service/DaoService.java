package app.service;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.*;
import app.model.*;
import app.repository.*;
import app.service.*;

@Service
@Transactional
public class DaoService implements DataAcessObject {

	@Autowired
	private AccountRepository AccountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public Account checkAccount(String accountcode) {
		Account ac = AccountRepository.findOne(accountcode);
		if(ac==null) throw new RuntimeException("Account code doesn't exist. Please search again.");
		
		return ac;
	}

	@Override
	public void makeDeposit(String accountcode, double theAmount) {
		Account ac = checkAccount(accountcode);
		Deposit deposit = new Deposit(new Date(), theAmount, ac);
		transactionRepository.save(deposit);
		ac.setBalance(ac.getBalance() + theAmount);
		AccountRepository.save(ac);
		
	}

	@Override
	public void makeWithdraw(String accountcode, double theAmount) {
		Account ac = checkAccount(accountcode);
		double availaleBalance = 0;
		if(ac instanceof Checking)
			availaleBalance = ((Checking) ac).getDiscover();
		if(ac.getBalance() + availaleBalance< theAmount)
			throw new RuntimeException("Insufficient funds. Please try a lower amount.");
		Withdraw withdraw = new Withdraw(new Date(), theAmount, ac);
		transactionRepository.save(withdraw);
		ac.setBalance(ac.getBalance() - theAmount);
		AccountRepository.save(ac);
		
	}

	@Override
	public void Transfer(String accountcode1, String accountcode2, double theAmount) {
		if(accountcode1.equals(accountcode2)){
			throw new RuntimeException("Cannot transfer into the same account.");
		}
		else if(String.class.isInstance(theAmount)){
			throw new RuntimeException("Please enter an interger");
		}
		makeWithdraw(accountcode1, theAmount);
		makeDeposit(accountcode2, theAmount);
		
	}

	@Override
	public Page<Transaction> TransactionsList(String accountcode, int page, int pagesize) {
		
		return transactionRepository.TransactionList(accountcode, new PageRequest(page, pagesize));
	}

}


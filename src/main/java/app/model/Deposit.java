package app.model;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class Deposit extends Transaction {

	public Deposit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Deposit(Date transactionDate, Double amount, Account account) {
		super(transactionDate, amount, account);
		// TODO Auto-generated constructor stub
	}
	
	

}

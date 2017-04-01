package app.model;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("W")
public class Withdraw extends Transaction {

	public Withdraw() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Withdraw(Date transactionDate, Double amount, Account account) {
		super(transactionDate, amount, account);
		// TODO Auto-generated constructor stub
	}
	
	
	

}


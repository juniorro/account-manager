package app.model;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="OPERATION_TYPE", discriminatorType=DiscriminatorType.STRING, length=1)
public abstract class Transaction implements Serializable {
	
	@Id	@GeneratedValue
	private Long transactionNumber;
	private Date transactionDate;
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name="ACCNT_CODE")
	private Account account;
	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Transaction(Date transactionDate, Double amount, Account account) {
		super();
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.account = account;
	}
	
	
	public Long getTransactionNumber() {
		return transactionNumber;
	}
	
	
	public void setTransactionNumber(Long transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	
	
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
	public Double getAmount() {
		return amount;
	}
	
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	public Account getAccount() {
		return account;
	}
	
	
	public void setAccount(Account account) {
		this.account = account;
	}	

}

package app.model;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ACNT_TYPE", discriminatorType=DiscriminatorType.STRING, length=2)
public abstract class Account implements Serializable {

	@Id
	private String AccountCode;
	private Date creationDate;
	private double balance;

	@ManyToOne
	@JoinColumn(name="CLIENT_CODE")
	private Client client;

	@OneToMany(mappedBy="account")
	private Collection<Transaction> transanctions;



	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Account(String accountCode, Date creationDate, double balance, Client client) {
		super();
		AccountCode = accountCode;
		this.creationDate = creationDate;
		this.balance = balance;
		this.client = client;
	}



	public String getAccountCode() {
		return AccountCode;
	}



	public void setAccountCode(String accountCode) {
		AccountCode = accountCode;
	}



	public Date getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public Collection<Transaction> getTransanctions() {
		return transanctions;
	}



	public void setTransanctions(Collection<Transaction> transanctions) {
		this.transanctions = transanctions;
	}


}

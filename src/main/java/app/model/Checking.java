package app.model;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("CA")
public class Checking extends Account {

	private double discover;

	public Checking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Checking(String accountCode, Date creationDate, double balance, Client client, double discover) {
		super(accountCode, creationDate, balance, client);
		this.discover = discover;
	}

	public double getDiscover() {
		return discover;
	}

	public void setDiscover(double discover) {
		this.discover = discover;
	}



}

package dari.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SurveillanceCommand implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idCommand;
	
	@Temporal(TemporalType.DATE)
	private Date dateCammand;
	
	private double priceCommand;
	
	private boolean stateCommand;
	
	@ManyToOne
	private Client client;
	
	@ManyToMany(cascade = CascadeType.ALL , mappedBy="SurveillanceCommands")
	private Collection<Surveillance> Surveillances;
	
	public SurveillanceCommand() {
		super();
	}

	public SurveillanceCommand(Long idCommand, Date dateCammand, double priceCommand, boolean stateCommand,
			Client client, Collection<Surveillance> surveillances) {
		super();
		this.idCommand = idCommand;
		this.dateCammand = dateCammand;
		this.priceCommand = priceCommand;
		this.stateCommand = stateCommand;
		this.client = client;
		Surveillances = surveillances;
	}

	public Long getIdCommand() {
		return idCommand;
	}

	public void setIdCommand(Long idCommand) {
		this.idCommand = idCommand;
	}

	public Date getDateCammand() {
		return dateCammand;
	}

	public void setDateCammand(Date dateCammand) {
		this.dateCammand = dateCammand;
	}

	public double getPriceCommand() {
		return priceCommand;
	}

	public void setPriceCommand(double priceCommand) {
		this.priceCommand = priceCommand;
	}

	public boolean isStateCommand() {
		return stateCommand;
	}

	public void setStateCommand(boolean stateCommand) {
		this.stateCommand = stateCommand;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<Surveillance> getSurveillances() {
		return Surveillances;
	}

	public void setSurveillances(Collection<Surveillance> surveillances) {
		Surveillances = surveillances;
	}
	
	
	

}

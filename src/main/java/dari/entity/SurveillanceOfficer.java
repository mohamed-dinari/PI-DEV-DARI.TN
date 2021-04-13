package dari.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SurveillanceOfficer implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idSurveillanceOfficer;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	@Temporal(TemporalType.DATE)
	private Date dateActivation;
	
	private boolean state;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="agent")
	private Collection<Surveillance> Surveillances;

	public SurveillanceOfficer() {
		super();
	}

	public SurveillanceOfficer(Long idSurveillanceOfficer, String firstName, String lastName, String password,
			Date dateActivation, boolean state, Collection<Surveillance> surveillances) {
		super();
		this.idSurveillanceOfficer = idSurveillanceOfficer;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dateActivation = dateActivation;
		this.state = state;
		Surveillances = surveillances;
	}

	public Long getIdSurveillanceOfficer() {
		return idSurveillanceOfficer;
	}

	public void setIdSurveillanceOfficer(Long idSurveillanceOfficer) {
		this.idSurveillanceOfficer = idSurveillanceOfficer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateActivation() {
		return dateActivation;
	}

	public void setDateActivation(Date dateActivation) {
		this.dateActivation = dateActivation;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Collection<Surveillance> getSurveillances() {
		return Surveillances;
	}

	public void setSurveillances(Collection<Surveillance> surveillances) {
		Surveillances = surveillances;
	}
	
	

}

package dari.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SurveillanceNotice implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idNotice;
	
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date dateNotice;
	
	@ManyToOne
	private Surveillance surveillance;
	
	public SurveillanceNotice() {
		super();
	}

	public SurveillanceNotice(Long idNotice, String description, Date dateNotice, Surveillance surveillance) {
		super();
		this.idNotice = idNotice;
		this.description = description;
		this.dateNotice = dateNotice;
		this.surveillance = surveillance;
	}

	public Long getIdNotice() {
		return idNotice;
	}

	public void setIdNotice(Long idNotice) {
		this.idNotice = idNotice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateNotice() {
		return dateNotice;
	}

	public void setDateNotice(Date dateNotice) {
		this.dateNotice = dateNotice;
	}

	public Surveillance getSurveillance() {
		return surveillance;
	}

	public void setSurveillance(Surveillance surveillance) {
		this.surveillance = surveillance;
	}
	
	
	

}

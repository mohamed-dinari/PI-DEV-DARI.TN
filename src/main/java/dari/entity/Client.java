package dari.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Client implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idClient;
	@Column(name="ADRESSE_EMAIL")
	private String adresseEmail;
	@Column(name="tel")
	private String tel;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<AnnonceImmobilier> AnnoncesImmobiliers;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private List<Feedback> feedbacks;
	
	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getAdresseEmail() {
		return adresseEmail;
	}
	

	public Client(long idClient) {
		super();
		this.idClient = idClient;
	}

	public void setAdresseEmail(String adresseEmail) {
		this.adresseEmail = adresseEmail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	//@JsonManagedReference
	public Set<AnnonceImmobilier> getAnnoncesImmobiliers() {
		return AnnoncesImmobiliers;
	}

	public void setAnnoncesImmobiliers(Set<AnnonceImmobilier> annoncesImmobiliers) {
		AnnoncesImmobiliers = annoncesImmobiliers;
	}

	public Client(long idClient, String adresseEmail, String tel, Set<AnnonceImmobilier> annoncesImmobiliers,
			List<Feedback> feedbacks) {
		super();
		this.idClient = idClient;
		this.adresseEmail = adresseEmail;
		this.tel = tel;
		AnnoncesImmobiliers = annoncesImmobiliers;
		this.feedbacks = feedbacks;
	}

	public Client() {
		super();
	}
	
	
}

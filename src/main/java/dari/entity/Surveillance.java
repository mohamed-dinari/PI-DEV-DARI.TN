package dari.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.JoinColumn;

import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dari.service.ISurveillanceService;

@Entity
public class Surveillance implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idSurveillance")
	private Long idSurveillance ; 
	
	private String productName;
	
	private String capteur;
	
	private String codeSurveillance;
	
	private int resolution ;
	
	private int indiceProtection;
	
	private int porteeInfrarouge;
	
	private double price;
	
	private CategorySurveillance categorySurveillance;
	
	@Temporal(TemporalType.DATE)
	private Date dateAdd;
	
	private int jaime;
	
	private int jaimeplus;
	
	@ManyToOne
	private SurveillanceOfficer surveillanceOfficer;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="surveillance")
	private List<SurveillanceNotice> SurveillanceNotices;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="surveillance")
	private List<LigneCommand> LigneCommands;
	
	@Column
    @ElementCollection(targetClass=Long.class)
	private List<Long> idClientsLike;
	
	@Column
    @ElementCollection(targetClass=Long.class)
	private List<Long> idClientsDeslike;	
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
    		name = "map", 
    		joinColumns = {@JoinColumn( referencedColumnName = "idSurveillance")},
    		inverseJoinColumns = {@JoinColumn( referencedColumnName = "idValeur")})
    @MapKeyColumn(name = "Client")
	@ElementCollection
	private Map<Long,Valeurs> avisClients;
	
	public Surveillance(String providerName, String capteur,int resolution, int indiceProtection, int porteeInfrarouge, double price,
			CategorySurveillance categorySurveillance) {
		super();
		this.productName = providerName;
		this.capteur = capteur;
		this.resolution = resolution;
		this.indiceProtection = indiceProtection;
		this.porteeInfrarouge = porteeInfrarouge;
		this.price = price;
		this.categorySurveillance = categorySurveillance;
		this.avisClients=new HashMap<>();
	}
	
	public Surveillance() {
		super();
		this.dateAdd=new Date();
		this.codeSurveillance=UUID.randomUUID().toString().toUpperCase().substring(0, 18);
		this.avisClients=new HashMap<>();
	}

	public Long getIdSurveillance() {
		return idSurveillance;
	}

	public void setIdSurveillance(Long idSurveillance) {
		this.idSurveillance = idSurveillance;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String providerName) {
		this.productName = providerName;
	}

	public String getCapteur() {
		return capteur;
	}

	public void setCapteur(String capteur) {
		this.capteur = capteur;
	}

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	public int getIndiceProtection() {
		return indiceProtection;
	}

	public void setIndiceProtection(int indiceProtection) {
		this.indiceProtection = indiceProtection;
	}

	public int getPorteeInfrarouge() {
		return porteeInfrarouge;
	}

	public void setPorteeInfrarouge(int porteeInfrarouge) {
		this.porteeInfrarouge = porteeInfrarouge;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CategorySurveillance getCategorySurveillance() {
		return categorySurveillance;
	}

	public void setCategorySurveillance(CategorySurveillance categorySurveillance) {
		this.categorySurveillance = categorySurveillance;
	}

	public Date getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}
	
	public String getCodeSurveillance() {
		return codeSurveillance;
	}

	public void setCodeSurveillance(String codeSurveillance) {
		this.codeSurveillance = codeSurveillance;
	}

	public int getJaime() {
		return jaime;
	}

	public void setJaime(int jaime) {
		this.jaime = jaime;
	}

	public int getJaimeplus() {
		return jaimeplus;
	}

	public void setJaimeplus(int jaimeplus) {
		this.jaimeplus = jaimeplus;
	}
	
	@JsonIgnore
	public List<Long> getIdClientsLike() {
		return idClientsLike;
	}

	public void setIdClientsLike(List<Long> idClients) {
		this.idClientsLike = idClients;
	}
	
	@JsonIgnore
	public List<Long> getIdClientsDeslike() {
		return idClientsDeslike;
	}

	public void setIdClientsDeslike(List<Long> idClientsDeslike) {
		this.idClientsDeslike = idClientsDeslike;
	}
	
	@JsonIgnore
	public SurveillanceOfficer getSurveillanceOfficer() {
		return surveillanceOfficer;
	}

	@JsonIgnore
	public Map<Long, Valeurs> getAvisClients() {
		return avisClients;
	}

	public void setAvisClients(Map<Long, Valeurs> avisClients) {
		this.avisClients = avisClients;
	}

	public void setSurveillanceOfficer(SurveillanceOfficer surveillanceOfficer) {
		this.surveillanceOfficer = surveillanceOfficer;
	}
	
	@JsonIgnore
	public List<SurveillanceNotice> getSurveillanceNotices() {
		return SurveillanceNotices;
	}

	public void setSurveillanceNotices(List<SurveillanceNotice> surveillanceNotices) {
		SurveillanceNotices = surveillanceNotices;
	}
	
	@JsonIgnore
	public List<LigneCommand> getLigneCommands() {
		return LigneCommands;
	}

	public void setLigneCommands(List<LigneCommand> ligneCommands) {
		LigneCommands = ligneCommands;
	}
	
}

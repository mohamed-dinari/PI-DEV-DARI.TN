package dari.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import dari.entity.Client;
import dari.entity.Feedback;

@Entity
public class AnnonceImmobilier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ANNONCE_REF")
	private long annonce_ref;
	
	@Column(name="ANNONCE_TYPE_TRANS")
	@Enumerated(EnumType.STRING)
	private TypeTransaction annonce_type_trans;
	
	@Column(name="ANNONCE_TYPE")
	@Enumerated(EnumType.STRING)
	private AnnonceType annonce_type;
	
	@Column(name="ANNONCE_PRIX")
	private long annonce_prix ;
	
	@Column(name="ANNONCE_REGION")
	@Enumerated(EnumType.STRING)
	private AnnonceRegion annonce_region;
	
	@Column(name="ANNONCE_NBR_CHAMBRES")
	private int annonce_nbr_chambres;
	
	@Column(name="ANNONCE_NBR_SALON")
	private int annonce_nbr_salon;
	
	@Column(name="ANNONCE_NBR_SBAIN")
	private int annonce_nbr_sbain;
	
	@Column(name="ANNONCE_SUPERFICIE")
	private int annonce_superficie;
	
	@Column(name="ANNONCE_DESC")
	private String annonce_description;
	
	@Temporal(TemporalType.DATE)
	private Date date_Publication;
	
	@ManyToOne
	private Client client;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="annonce")
	
	private List<Feedback> feedbacks;
	
	
	public long getAnnonce_ref() {
		return annonce_ref;
	}
	public void setAnnonce_ref(long annonce_ref) {
		this.annonce_ref = annonce_ref;
	}
	public TypeTransaction getAnnonce_type_trans() {
		return annonce_type_trans;
	}
	public void setAnnonce_type_trans(TypeTransaction annonce_type_trans) {
		this.annonce_type_trans = annonce_type_trans;
	}
	public AnnonceType getAnnonce_type() {
		return annonce_type;
	}
	public void setAnnonce_type(AnnonceType annonce_type) {
		this.annonce_type = annonce_type;
	}
	public long getAnnonce_prix() {
		return annonce_prix;
	}
	public void setAnnonce_prix(long annonce_prix) {
		this.annonce_prix = annonce_prix;
	}
	public AnnonceRegion getAnnonce_region() {
		return annonce_region;
	}
	public void setAnnonce_region(AnnonceRegion annonce_region) {
		this.annonce_region = annonce_region;
	}
	public int getAnnonce_nbr_chambres() {
		return annonce_nbr_chambres;
	}
	public void setAnnonce_nbr_chambres(int annonce_nbr_chambres) {
		this.annonce_nbr_chambres = annonce_nbr_chambres;
	}
	public int getAnnonce_nbr_salon() {
		return annonce_nbr_salon;
	}
	public void setAnnonce_nbr_salon(int annonce_nbr_salon) {
		this.annonce_nbr_salon = annonce_nbr_salon;
	}
	public int getAnnonce_nbr_sbain() {
		return annonce_nbr_sbain;
	}
	public void setAnnonce_nbr_sbain(int annonce_nbr_sbain) {
		this.annonce_nbr_sbain = annonce_nbr_sbain;
	}
	public int getAnnonce_superficie() {
		return annonce_superficie;
	}
	public void setAnnonce_superficie(int annonce_superficie) {
		this.annonce_superficie = annonce_superficie;
	}
	public String getAnnonce_description() {
		return annonce_description;
	}
	public void setAnnonce_description(String annonce_description) {
		this.annonce_description = annonce_description;
	}
	public Date getDate_Publication() {
		return date_Publication;
	}
	public void setDate_Publication(Date date_Publication) {
		this.date_Publication = date_Publication;
	}
	@JsonBackReference
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	//@JsonManagedReference
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}
	//@JsonManagedReference
	public void setFeedbacks(Feedback feedbacks) {
		this.feedbacks.add(feedbacks); 
	}
	
	
	public AnnonceImmobilier() {
		super();
	}
	public AnnonceImmobilier(long annonce_ref, TypeTransaction annonce_type_trans, AnnonceType annonce_type,
			long annonce_prix, AnnonceRegion annonce_region, int annonce_nbr_chambres, int annonce_nbr_salon,
			int annonce_nbr_sbain, int annonce_superficie, String annonce_description, Date date_Publication) {
		super();
		this.annonce_ref = annonce_ref;
		this.annonce_type_trans = annonce_type_trans;
		this.annonce_type = annonce_type;
		this.annonce_prix = annonce_prix;
		this.annonce_region = annonce_region;
		this.annonce_nbr_chambres = annonce_nbr_chambres;
		this.annonce_nbr_salon = annonce_nbr_salon;
		this.annonce_nbr_sbain = annonce_nbr_sbain;
		this.annonce_superficie = annonce_superficie;
		this.annonce_description = annonce_description;
		this.date_Publication = date_Publication;
	}
	public AnnonceImmobilier(TypeTransaction annonce_type_trans, AnnonceType annonce_type, long annonce_prix,
			AnnonceRegion annonce_region, int annonce_nbr_chambres, int annonce_nbr_salon, int annonce_nbr_sbain,
			int annonce_superficie, String annonce_description, Date date_Publication) {
		super();
		this.annonce_type_trans = annonce_type_trans;
		this.annonce_type = annonce_type;
		this.annonce_prix = annonce_prix;
		this.annonce_region = annonce_region;
		this.annonce_nbr_chambres = annonce_nbr_chambres;
		this.annonce_nbr_salon = annonce_nbr_salon;
		this.annonce_nbr_sbain = annonce_nbr_sbain;
		this.annonce_superficie = annonce_superficie;
		this.annonce_description = annonce_description;
		this.date_Publication = date_Publication;
	}
	public AnnonceImmobilier(long annonce_ref, TypeTransaction annonce_type_trans, AnnonceType annonce_type,
			long annonce_prix, AnnonceRegion annonce_region, int annonce_nbr_chambres, int annonce_nbr_salon,
			int annonce_nbr_sbain, int annonce_superficie, String annonce_description, Date date_Publication,
			Client client, List<Feedback> feedbacks) {
		super();
		this.annonce_ref = annonce_ref;
		this.annonce_type_trans = annonce_type_trans;
		this.annonce_type = annonce_type;
		this.annonce_prix = annonce_prix;
		this.annonce_region = annonce_region;
		this.annonce_nbr_chambres = annonce_nbr_chambres;
		this.annonce_nbr_salon = annonce_nbr_salon;
		this.annonce_nbr_sbain = annonce_nbr_sbain;
		this.annonce_superficie = annonce_superficie;
		this.annonce_description = annonce_description;
		this.date_Publication = date_Publication;
		this.client = client;
		this.feedbacks = feedbacks;
	}
	public AnnonceImmobilier(TypeTransaction annonce_type_trans, AnnonceType annonce_type, long annonce_prix,
			AnnonceRegion annonce_region, int annonce_nbr_chambres, int annonce_nbr_salon, int annonce_nbr_sbain,
			int annonce_superficie, String annonce_description, Date date_Publication, Client client,
			List<Feedback> feedbacks) {
		super();
		this.annonce_type_trans = annonce_type_trans;
		this.annonce_type = annonce_type;
		this.annonce_prix = annonce_prix;
		this.annonce_region = annonce_region;
		this.annonce_nbr_chambres = annonce_nbr_chambres;
		this.annonce_nbr_salon = annonce_nbr_salon;
		this.annonce_nbr_sbain = annonce_nbr_sbain;
		this.annonce_superficie = annonce_superficie;
		this.annonce_description = annonce_description;
		this.date_Publication = date_Publication;
		this.client = client;
		this.feedbacks = feedbacks;
	}
	
	
	
	
	
	
	
	
	
	}

package dari.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import dari.entity.AnnonceImmobilier;
import dari.entity.Client;

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Feedback implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="commentaire")
	private String commentaire;
	
	@ManyToOne
	@JsonBackReference 
	private Client client;
	@ManyToOne 
	@JsonBackReference 
	private AnnonceImmobilier annonce;
	
	
	public Feedback(long id, String commentaire, Client client, AnnonceImmobilier annonce) {
		super();
		this.id = id;
		this.commentaire = commentaire;
		this.client = client;
		this.annonce = annonce;
	}
	public Feedback() {
		super();
	}
	public Feedback(String commentaire, Client client, AnnonceImmobilier annonce) {
		super();
		this.commentaire = commentaire;
		this.client = client;
		this.annonce = annonce;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public AnnonceImmobilier getAnnonce() {
		return annonce;
	}
	public void setAnnonce(AnnonceImmobilier annonce) {
		this.annonce = annonce;
	}
	

}

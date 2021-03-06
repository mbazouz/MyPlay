package com.model;
// Generated 9 d�c. 2015 19:54:35 by Hibernate Tools 3.4.0.CR1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Chanson generated by hbm2java
 */
@Entity
@Table(name = "CHANSON")
public class Chanson implements java.io.Serializable {

	private int idChanson;
	private String titre;
	private String chanteur;
	private int anneeProd;
	private Date dateAjout;
	private String chemin;
	private Set<Ucg> ucgs = new HashSet<Ucg>(0);

	public Chanson() {
	}

	public Chanson(int idChanson, String titre, Date dateAjout, String chemin) {
		this.idChanson = idChanson;
		this.titre = titre;
		this.dateAjout = dateAjout;
		this.chemin = chemin;
	}

	public Chanson(int idChanson, String titre, String chanteur, int anneeProd, Date dateAjout,
			String chemin, Set<Ucg> ucgs) {
		this.idChanson = idChanson;
		this.titre = titre;
		this.chanteur = chanteur;
		this.anneeProd = anneeProd;
		this.dateAjout = dateAjout;
		this.chemin = chemin;
		this.ucgs = ucgs;
	}

	@Id

	@Column(name = "ID_CHANSON", unique = true, nullable = false, precision = 22, scale = 0)
	public int getIdChanson() {
		return this.idChanson;
	}

	public void setIdChanson(int idChanson) {
		this.idChanson = idChanson;
	}

	@Column(name = "TITRE", nullable = false, length = 20)
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Column(name = "CHANTEUR", length = 20)
	public String getChanteur() {
		return this.chanteur;
	}

	public void setChanteur(String chanteur) {
		this.chanteur = chanteur;
	}

	@Column(name = "CHEMIN", length = 2000)
	public String getChemin() {
		return this.chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	
	@Column(name = "ANNEE_PROD", length = 20)
	public int getAnneeProd() {
		return this.anneeProd;
	}

	public void setAnneeProd(int anneeProd) {
		this.anneeProd = anneeProd;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_AJOUT", nullable = false, length = 7)
	public Date getDateAjout() {
		return this.dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chanson")
	public Set<Ucg> getUcgs() {
		return this.ucgs;
	}

	public void setUcgs(Set<Ucg> ucgs) {
		this.ucgs = ucgs;
	}
	public Date takeDate()
	{
			Date date = new Date();
			return date;
	}

}

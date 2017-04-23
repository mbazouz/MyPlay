package com.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Chanson;
import com.model.Genre;
import com.model.Utilisateur;

public class TestMiseEnPlaceHibernate {

	public static void main(String[] args) {
		
		//Instanciation
		Utilisateur utilisateur = new Utilisateur();
		
		//Initialisation
		utilisateur.setIdUser(1);
		utilisateur.setDateAjout(utilisateur.takeDate());
		utilisateur.setEmail("mum");
		utilisateur.setMotDePasse("M1");
		utilisateur.setNom("Ben Azouz");
		utilisateur.setPrenom("Mohamed");
		utilisateur.setPseudo("test");
//		
//		Genre genre = new Genre();
//		genre.setDateAjout(utilisateur.takeDate());
//		genre.setIdGenre(0212);
//		genre.setNbrChansons(0);
//		genre.setNom("Tarab");
//		genre.setUtilisateur(utilisateur);
//		
//		Chanson chanson = new Chanson();
//		//chanson.setAnneeProd(1970);
//		chanson.setDateAjout(utilisateur.takeDate());
//		chanson.setIdChanson(014);
//		chanson.setTitre("Enta Omri");
//		chanson.setChanteur("Om Kalthoum");
//		chanson.setUtilisateur(utilisateur);
//		chanson.setGenre(genre);
		
		
	

		
		//Ouverture de la session
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		//Sauvgarde de l'objet code postal
		session.save(utilisateur);

		transaction.commit();
		
		//Fermiture de la session
		HibernateUtil.closeSession();
	}

}

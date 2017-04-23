package com.business;

import java.util.List;

import com.dao.UCGIDao;
import com.dao.UtilisateurIDao;
import com.dao.impl.UCGDaoImpl;
import com.dao.impl.UtilisateurDaoImpl;
import com.model.*;

public class UCGBusiness {

	private UCGIDao ucgIdao = new UCGDaoImpl();
	Utilisateur utilisateur = new Utilisateur();
	Genre genre = new Genre();
	Chanson chanson = new Chanson();
	
	public List<Ucg> ListeUCGUtilisateur(Utilisateur utilisateur) {

		return ucgIdao.findUCGByUser(utilisateur);
	}
	
	public List<Ucg> ListeUCGGenre(Genre genre) {

		return ucgIdao.findUCGByGenre(genre);
	}
	
	public List<Ucg> ListeUCGChanson(Chanson chanson) {

		return ucgIdao.findUCGByChanson(chanson);
	}
	
	public List<Ucg> ListeUCGChansonID(int id){
		return ucgIdao.findUCGChansonById(id);
	}
}

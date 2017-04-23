package com.dao;

import java.util.List;

import com.model.*;


public interface UCGIDao extends GenericIDao {
	List<Ucg> findUCGByUser(Utilisateur utilisateur);
	List<Ucg> findUCGByGenre(Genre genre);
	List<Ucg> findUCGByChanson(Chanson chanson);	
	List<Ucg> findUCGChansonById(int id);
	List<Ucg> findAllUCG();
}

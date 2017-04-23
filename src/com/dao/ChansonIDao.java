package com.dao;

import java.util.List;


import com.model.Chanson;

public interface ChansonIDao extends GenericIDao {
	List<Chanson> findChansonByTitre(String titre);
	List<Chanson> findChansonById(int id);
	List<Chanson> findAllChanson();


}

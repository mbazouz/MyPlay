package com.dao;

import java.util.List;

import com.model.Chanson;
import com.model.Genre;
import com.model.Utilisateur;

public interface GenreIDao extends GenericIDao {
	List<Genre> findGenreByName(String nom);
	List<Genre> findGenreById(int id);
	List<Genre> findGenreByUser(Utilisateur utilisateur);
	List<Genre> findAllGenre();
	

}

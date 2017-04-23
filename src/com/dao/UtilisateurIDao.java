package com.dao;

import java.io.Serializable;
import java.util.List;


import com.model.Utilisateur;

public interface UtilisateurIDao extends GenericIDao {
	List<Utilisateur> findUtilisateurByLogin(String pseudo);
	List<Utilisateur> findUtilisateurByMail(String mail);
	List<Utilisateur> findUtilisateurById(int id);
	List<Utilisateur> findAllUtilisateur();

}

package com.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.UtilisateurIDao;
import com.model.Utilisateur;
import com.util.HibernateUtil;

public  class UtilisateurDaoImpl extends GenericDaoImpl implements UtilisateurIDao{
	
	
	private Session hibernateSession;
	


	@Override
	public List<Utilisateur> findUtilisateurByLogin(String pseudo) {
		
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			objects = hibernateSession
					.createQuery("from Utilisateur where Pseudo=?")
					.setParameter(0, pseudo).list();

		} catch (HibernateException e) {
			handleException(e);
		} 
		finally {
			hibernateSession.close();
		}
		return objects;
	}

	@Override
	public List<Utilisateur> findUtilisateurByMail(String mail) {
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			objects = hibernateSession
					.createQuery("from Utilisateur where Email=?")
					.setParameter(0, mail).list();

		} catch (HibernateException e) {
			handleException(e);
		} 
		finally {
			hibernateSession.close();
		}
		return objects;
	}

	@Override
	public List<Utilisateur> findUtilisateurById(int id) {
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			objects = hibernateSession
					.createQuery("from Utilisateur where idUser=?")
					.setParameter(0, id).list();

		} catch (HibernateException e) {
			handleException(e);
		} 
		finally {
			hibernateSession.close();
		}
		return objects;
	}

	@Override
	public List<Utilisateur> findAllUtilisateur() {
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			Query query = hibernateSession
					.createQuery("from Utilisateur order by idUser DESC")
					;
			objects = query.list();

		} catch (HibernateException e) {
			handleException(e);
		} 
		finally {
			hibernateSession.close();
		}
		return objects;
	}

	

	
	
	
	

}

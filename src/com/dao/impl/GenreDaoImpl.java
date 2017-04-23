package com.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.GenreIDao;
import com.model.Genre;
import com.model.Utilisateur;
import com.util.HibernateUtil;

public class GenreDaoImpl extends GenericDaoImpl implements GenreIDao {
	private Session hibernateSession;

	@Override
	public List<Genre> findGenreByName(String nom) {
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			objects = hibernateSession.createQuery("from Genre where nom=?").setParameter(0, nom).list();

		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}
		return objects;

	}

	@Override
	public List<Genre> findGenreById(int id) {
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			objects = hibernateSession.createQuery("from Genre where idGenre=?").setParameter(0, id).list();

		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}
		return objects;
	}

	@Override
	public List<Genre> findGenreByUser(Utilisateur utilisateur) {
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			objects = hibernateSession.createQuery("from Genre where utilisateur=?").setParameter(0, utilisateur).list();

		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}
		return objects;
	}

	@Override
	public List<Genre> findAllGenre() {
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			Query query = hibernateSession
					.createQuery("from Genre order by idGenre DESC")
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

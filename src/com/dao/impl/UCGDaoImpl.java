package com.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.dao.UCGIDao;
import com.model.*;
import com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class UCGDaoImpl extends GenericDaoImpl implements UCGIDao {
	private Session hibernateSession;

	@Override
	public List<Ucg> findUCGByUser(Utilisateur utilisateur) {
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			objects = hibernateSession.createQuery("from Ucg where utilisateur=?").setParameter(0, utilisateur).list();

		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}
		return objects;
	}

	@Override
	public List<Ucg> findUCGByGenre(Genre genre) {
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			objects = hibernateSession.createQuery("from Ucg where genre=?").setParameter(0, genre).list();

		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}
		return objects;	}

	@Override
	public List<Ucg> findUCGByChanson(Chanson chanson) {
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			objects = hibernateSession.createQuery("from Ucg where chanson=?").setParameter(0, chanson).list();

		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}
		return objects;	}

	@Override
	public List<Ucg> findUCGChansonById(int id) {
		List objects = null;
//		try {
//			hibernateSession = HibernateUtil.currentSession();
//			objects = hibernateSession.createQuery("from Ucg where chanson=?").setParameter(0, utilisateur).list();
//
//		} catch (HibernateException e) {
//			handleException(e);
//		} finally {
//			hibernateSession.close();
//		}
		return objects;
	}

	@Override
	public List<Ucg> findAllUCG() {
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			Query query = hibernateSession
					.createQuery("from UCG order by idUcg DESC")
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

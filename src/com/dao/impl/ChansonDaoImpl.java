package com.dao.impl;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.ChansonIDao;
import com.model.Chanson;
import com.util.HibernateUtil;

public class ChansonDaoImpl extends GenericDaoImpl implements ChansonIDao{
			
	private Session hibernateSession;
	
	
	@Override
	public List<Chanson> findChansonByTitre(String titre) {
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			objects = hibernateSession
					.createQuery("from Chanson where titre=?")
					.setParameter(0, titre).list();

		} catch (HibernateException e) {
			handleException(e);
		} 
		finally {
			hibernateSession.close();
		}
		return objects;
		
	}


	@Override
	public List<Chanson> findChansonById(int id) {
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			objects = hibernateSession
					.createQuery("from Chanson where idChanson=?")
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
	public List<Chanson> findAllChanson() {
		List objects = null;
		try {
			hibernateSession = HibernateUtil.currentSession();
			Query query = hibernateSession
					.createQuery("from Chanson order by idChanson DESC")
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

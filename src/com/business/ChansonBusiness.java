package com.business;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.dao.ChansonIDao;
import com.dao.GenreIDao;
import com.dao.UCGIDao;
import com.dao.impl.ChansonDaoImpl;
import com.dao.impl.GenreDaoImpl;
import com.dao.impl.UCGDaoImpl;
import com.model.Chanson;
import com.model.Genre;
import com.model.Ucg;
import com.model.Utilisateur;
import com.util.SessionBean;

public class ChansonBusiness {
	
	ChansonIDao chansonIdao  = new ChansonDaoImpl();
	GenreIDao genreIdao = new GenreDaoImpl();
	
	Chanson chanson = new Chanson();
	
	GenreBusiness genreB = new GenreBusiness();
	Genre genre =new Genre();
	
	UtilisateurBusiness utilisateurB = new UtilisateurBusiness();
	Utilisateur utilisateur = new Utilisateur();
	
	
	private int iDChanson=15;
	private int iDGenre=15;
	UCGIDao ucgIdao = new UCGDaoImpl();
	UCGBusiness ucgBusiness = new UCGBusiness();
	Ucg ucg = new Ucg();
	private String text = "";
	private int idGenre;
	private int idChanson;
	public ChansonBusiness(){
	//	System.out.println("ChansonBusiness*************************");
	}
	
	public String ajouterChanson(){
		
		this.setText("");
		int test = 0;
		HttpSession session = SessionBean.getSession(); //récupération de la session
		int idUtilisateur = (int)session.getAttribute("userid"); // l'id de l'utilisateur actuel
	//	int idUtilisateur = 2;
		utilisateur = utilisateurB.ListeUtilisateurId(idUtilisateur).get(0);
		
		List<Chanson> tabChanson = listeChansonById(chanson.getIdChanson());
//		
//		
		if (tabChanson.isEmpty()== false)
		{
//			//la chanson existe dans la table
//			//on verifie l'existence dans la table UCG
//			
//			//chanson=tabChanson.get(0);
		
		List<Ucg> tabUcg = ListeUCGChanson(chanson);
		if (tabUcg.isEmpty()==false){
			//la chanson existe dans la table ucg
			//on vérifie lappartenece du genre
			for (int i=0; i<tabChanson.size(); i++){
				if (tabUcg.get(i).getGenre().getIdGenre()==idGenre){
					this.setText("Chanson existe déja");
					
					return "Chanson existe déja";
					
				}
			}
				test=1;
		}
		}
//		List<Ucg> tabUcg = ucgBusiness.ListeUCGChansonId(chanson.getIdChanson());
//			for (int i=0; i<tabChanson.size(); i++){
//				if (tabUcg.get(i).getGenre().getIdGenre()==idGenre){
//					this.setText("Chanson existe déja");
//					
//					return "Chanson existe déja";
//					
//				}
//			}
//			test = 1;
//			
//			
//				}
		
		chanson.setDateAjout(chanson.takeDate());
		chanson.setIdChanson(1);
		
		genre = genreB.ListeGenreId(idGenre).get(0);
		
		ucg.setIdUcg(1);
		ucg.setChanson(chanson);
		ucg.setGenre(genre);
		ucg.setUtilisateur(utilisateur);
		ucgIdao.saveOrUpdate(ucg);

		if (test == 0) {
			//la chanson n'existe pas dans la table chanson
			chansonIdao.saveOrUpdate(chanson);
		}
		chanson = new Chanson();
		genre = new Genre();
		utilisateur = new Utilisateur();
		return "success";

		

}
	
	
	
	
	
public String ajouterChanson1(){
		
		this.setText("");
		int test = 0;
		HttpSession session = SessionBean.getSession(); //récupération de la session
		int idUtilisateur = (int)session.getAttribute("userid"); // l'id de l'utilisateur actuel
	//	int idUtilisateur = 2;
		utilisateur = utilisateurB.ListeUtilisateurId(idUtilisateur).get(0);
		
		
//		List<Chanson> tabChanson = listeChansonById(chanson.getIdChanson());
		
//		
//		if (tabChanson.isEmpty()== false)
//		{
////			//la chanson existe dans la table
////			//on verifie l'existence dans la table UCG
////			
////			//chanson=tabChanson.get(0);
//		
//		List<Ucg> tabUcg = ListeUCGChanson(chanson);
//		if (tabUcg.isEmpty()==false){
//			//la chanson existe dans la table ucg
//			//on vérifie lappartenece du genre
//			for (int i=0; i<tabChanson.size(); i++){
//				if (tabUcg.get(i).getGenre().getIdGenre()==idGenre){
//					this.setText("Chanson existe déja");
//					
//					return "Chanson existe déja";
//					
//				}
//			}
//				test=1;
//		}
//		}		
//		List<Ucg> tabUcg = ucgBusiness.ListeUCGChansonId(chanson.getIdChanson());
//			for (int i=0; i<tabChanson.size(); i++){
//				if (tabUcg.get(i).getGenre().getIdGenre()==idGenre){
//					this.setText("Chanson existe déja");
//					
//					return "Chanson existe déja";
//					
//				}
//			}
//			test = 1;
//			
//			
//				}
		
		chanson.setDateAjout(chanson.takeDate());
		chanson.setIdChanson(1);
		
		genre = genreB.ListeGenreId(1).get(0);
		
//		ucg.setIdUcg(1);
//		ucg.setChanson(chanson);
//		ucg.setGenre(genre);
//		ucg.setUtilisateur(utilisateur);
//		ucgIdao.saveOrUpdate(ucg);

		if (test == 0) {
			//la chanson n'existe pas dans la table chanson
			chansonIdao.saveOrUpdate(chanson);
		}
		chanson = new Chanson();
		genre = new Genre();
		utilisateur = new Utilisateur();
		return "success";

		

}	

	
	
	
	public List<Ucg> ListeUCGChanson(Chanson chanson){
		return ucgIdao.findUCGByChanson(chanson);
	}
	
	public String capturerIdGenre(int idGenre){
		this.idGenre = idGenre;
		
		return "success";
	}
	
	
	public String capturerIdChanson(int idChanson){
		this.idChanson = idChanson;
		chanson = ListeChansonId(idChanson).get(0);
		return "success";
	}
	
	
	public String capturerIdChanson1(int idChanson){
		this.idChanson = idChanson;
		chanson = ListeChansonId(idChanson).get(0);
		return "success";
	}
	
	
	
	public String modifierChanson (){
		chansonIdao.saveOrUpdate(chanson);
		chanson = new Chanson();
		return "success";
		
		}
	
	public List<Chanson> ListeChansonTitre(String titre) {

		return chansonIdao.findChansonByTitre(titre);
	}
	
	public List<Chanson> ListeChansonId(int idChanson){
		return chansonIdao.findChansonById(idChanson);
	}
	
	public List<Ucg> ListeUCGUtilisateur(Utilisateur utilisateur){
		return ucgIdao.findUCGByUser(utilisateur);
	}
	
	public List<Chanson> listeChansonById(int id){
		return chansonIdao.findChansonById(id);
	}
	
	
	public List<Chanson> ListeChanson(){
		return chansonIdao.findAllChanson();
	}
	
	public List<Chanson> ListeChansonGenre(Genre genre){
		List<Chanson> tabChanson = null;
		HttpSession session = SessionBean.getSession(); //récupération de la session
		int idUtilisateur = (int)session.getAttribute("userid"); // l'id de l'utilisateur actuel
		List<Utilisateur> tabUtilisateur = utilisateurB.ListeUtilisateurId(idUtilisateur);
		List<Ucg> tabUcg = ListeUCGUtilisateur(tabUtilisateur.get(0));
		for (int i=0; i<tabUcg.size(); i++){
			if (tabUcg.get(i).getGenre()== genre){
				tabChanson.add(tabUcg.get(i).getChanson());
				
			}
		}
	return tabChanson;
	}
	
	public String supprimerChanson(){
		List<Ucg> tabUcg = ListeUCGChanson(chanson);
		for (int i = 0; i<tabUcg.size(); i++){
			ucgIdao.delete(tabUcg.get(i));
		}
		
		
		return  "success";
	}
	
	public void testId (Chanson chanson, int id)
	{
			//Chanson chans= chanIdao.findById(chanson, id);
	}
	
	public void listerChanson(){
	}
	
	
	public void setChanson(Chanson chanson)
	{
		this.chanson=chanson;
	}
	
	public Chanson getChanson(){
		return this.chanson;
	}
	
	

	public void setGenre(Genre genre)
	{
		this.genre=genre;
	}
	
	public Genre getGenre(){
		return this.genre;
	}
	
	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public int getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}
	
	public int getIdChanson() {
		return idChanson;
	}

	public void setIdChanson(int idChanson) {
		this.idChanson = idChanson;
	}
	

	
	
	public int getIDGenre() {
		return iDGenre;
	}

	public void setIDGenre(int iDGenre) {
		this.iDGenre = iDGenre;
	}
	
	public int getIDChanson() {
		return iDChanson;
	}

	public void setIDChanson(int iDChanson) {
		this.iDChanson = iDChanson;
	}
	public int maxIdChanson(){
		List<Chanson> tabChanson = ListeChanson();
		if (!tabChanson.isEmpty()){
			int max = tabChanson.get(0).getIdChanson();
			for (int i=1; i<tabChanson.size(); i++){
				if (tabChanson.get(i).getIdChanson()>max) max=tabChanson.get(i).getIdChanson();
			}
			return max;
		}
		return 1;
	}
	
	public List<Ucg> ListeUCG(){
		return ucgIdao.findAllUCG();
	}

	public int maxIdUCG(){
		List<Ucg> tabUCG = ListeUCG();
		if (!tabUCG.isEmpty()){
			int max = tabUCG.get(0).getIdUcg();
			for (int i=1; i<tabUCG.size(); i++){
				if (tabUCG.get(i).getIdUcg()>max) max=tabUCG.get(i).getIdUcg();
			}
			return max;
		}
		return 1;
	}
	
	
	public String annuler (){
		chanson = new Chanson();
		return "success";
	}
	
	public String pont(){
		return "success";
	}
	public String pont1(){
		return "success";
	}
}
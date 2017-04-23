package com.business;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpSession;

import java.util.List;
import com.dao.GenreIDao;
import com.dao.UCGIDao;
import com.dao.impl.GenreDaoImpl;
import com.dao.impl.UCGDaoImpl;
import com.model.Chanson;
import com.model.Genre;
import com.model.Utilisateur;
import com.model.Ucg;
import com.util.SessionBean;
import com.business.*;



public class GenreBusiness {

	GenreIDao genreIdao  = new GenreDaoImpl();
	UCGIDao ucgIdao = new UCGDaoImpl();
	private String message = null;
	
	UCGBusiness ucgBusiness = new UCGBusiness();
	UtilisateurBusiness utilisateurB = new UtilisateurBusiness();
	
	Utilisateur utilisateur = new Utilisateur();
	Genre genre = new Genre();
	Ucg ucg = new Ucg();
	private String text="";
	private int idGenre,idGenre1;
	public GenreBusiness(){
	//	System.out.println("GenreBusiness*************************");
	}
	/*
	public String ajouterGenre(){
		this.setText("");
		
			
			//on teste lexistence dans la table UCG
			//suivant l'id du genre et l'id de l'utilisateur actuel
			int idGenre = genre.getIdGenre();
			HttpSession session = SessionBean.getSession();
			int idUtilisateur = (int)session.getAttribute("userid");
			utilisateur = utilisateurB.ListeUtilisateurId(idUtilisateur).get(0);
			List<Ucg> tabUcg = ucgBusiness.ListeUCGUtilisateur(utilisateur);
			if (tabUcg.isEmpty() == false){
			//l'utilisateur existe dans la table UCG
			
			for (int i=0; i<tabUcg.size();i++){
				if (ListeGenreId(tabUcg.get(i).getGenre().getIdGenre()).isEmpty()==false)
				{
					//le genre existe 
					this.setText("Genre existe déja");
					return "Genre existe déja";
				}
			}
			genre.setDateAjout(genre.takeDate());
			genre.setIdGenre(5);
			genre.setNbrChansons(0);
			genreIdao.saveOrUpdate(genre);
			ucg.setGenre(genre);
			ucg.setUtilisateur(utilisateur);
			ucg.setIdUcg(4);
			ucgIdao.saveOrUpdate(ucg);
			ucg = new Ucg();
			genre = new Genre();
			return "success";
			}
						
		
		return "";
	}
*/
	public String ajouterGenre(){
		this.setText("");
		HttpSession session = SessionBean.getSession(); //récupération de la session
		int idUtilisateur = (int)session.getAttribute("userid"); // l'id de l'utilisateur actuel
		utilisateur = utilisateurB.ListeUtilisateurId(idUtilisateur).get(0);
		List<Genre> tabGenre = ListeGenreNom(genre.getNom());
		System.out.println("+++++++++++++++++++++++++++++++\n"+idUtilisateur+ "+++++++++++++++++++++++++++++++\n");
		if (tabGenre.isEmpty()==false){
			//il existe un genre portant le meme nom
			//on teste sur l'id de l'utlisateur
			for (int i =0; i<tabGenre.size(); i++){
				if (tabGenre.get(i).getUtilisateur().getIdUser()==idUtilisateur){
					this.setText("Genre existe déja");
					return "Genre existe déja";
				}
			}
			
		}
		genre.setDateAjout(genre.takeDate());
//		int id = maxIdGenre();
//		genre.setIdGenre(id++);
		genre.setIdGenre(9);
		genre.setNbrChansons(0);
		genre.setUtilisateur(utilisateur);
		genreIdao.saveOrUpdate(genre);
		genre = new Genre();
		utilisateur = new Utilisateur();
		message = " Ajout faite avec succes";
		return "success";
		
	}
	
	
//	public String rennomerGenre(){
//		this.setText("");
//		HttpSession session = SessionBean.getSession(); //récupération de la session
//		int idUtilisateur = (int)session.getAttribute("userid"); // l'id de l'utilisateur actuel
//		utilisateur = utilisateurB.ListeUtilisateurId(idUtilisateur).get(0);
//		List<Genre> tabGenre = ListeGenreNom(genre.getNom());
//		System.out.println("+++++++++++++++++++++++++++++++\n"+idUtilisateur+ "+++++++++++++++++++++++++++++++\n");
//		if (tabGenre.isEmpty()==false){
//			//il existe un genre portant le meme nom
//			//on teste sur l'id de l'utlisateur
//			for (int i =0; i<tabGenre.size(); i++){
//				if (tabGenre.get(i).getUtilisateur().getIdUser()==idUtilisateur){
//					this.setText("Genre existe déja");
//					return "Genre existe déja";
//				}
//			}
//			
//		}
//		genre.setDateAjout(genre.takeDate());
//		genre.setIdGenre(5);
//		genre.setNbrChansons(0);
//		genre.setUtilisateur(utilisateur);
//		genreIdao.saveOrUpdate(genre);
//		genre = new Genre();
//		utilisateur = new Utilisateur();
//		
//		return "success";
//		
//	}
	
	
	public String supprimerGenre(){
	List<Ucg> tabUcg = ListeUCGGenre(genre);
	for (int i = 0; i<tabUcg.size(); i++){
		ucgIdao.delete(tabUcg.get(i));
	}
	
	genreIdao.delete(genre);
	return  "success";
	}
	
	
	public List<Genre> ListeGenreNom(String Nom) {

		return genreIdao.findGenreByName(Nom);
	}
	
	public List<Genre> ListeGenreId(int id) {

		return genreIdao.findGenreById(id);
	}
	public String pont(){
		return "success";
	}
	
	public String pont1(){
		return "success";
	}
	
	public String pont2(){
		return "success";
	}
	
//	public List<Genre> ListeGenreId(int id) {
//
//		return genreIdao.findGenreById(id);
//	}
	public List<Genre> listeGenre(){
		HttpSession session = SessionBean.getSession(); //récupération de la session
		int idUtilisateur = (int)session.getAttribute("userid"); // l'id de l'utilisateur actuel
		utilisateur = utilisateurB.ListeUtilisateurId(idUtilisateur).get(0);
		return genreIdao.findGenreByUser(utilisateur);
		
	}
	
	
	
	public void setGenre (Genre genre){
		this.genre = genre;
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
	
	
	
	public String capturerIdGenre(int idGenre){
		this.idGenre = idGenre;
		genre = ListeGenreId(idGenre).get(0);
		return "success";
	}
	
	
	public String capturerIdGenre1(int idGenre){
		this.idGenre = idGenre;
		genre = ListeGenreId(idGenre).get(0);
		return "success";
	}
	
	
	
	public String modifierGenre (){
	genreIdao.saveOrUpdate(genre);
	genre = new Genre();
	return "success";
	
	}
	
	public List<Ucg> ListeUCGGenre (Genre genre){
		return ucgIdao.findUCGByGenre(genre);
	}
	
	public List<Genre> ListeGenre(){
		return genreIdao.findAllGenre();
	}
	
	public String annuler (){
		genre = new Genre();
		return "success";
	}
	
	public int maxIdGenre(){
		List<Genre> tabGenre = ListeGenre();
		if (tabGenre.isEmpty()== false){
			int max = tabGenre.get(0).getIdGenre();
			for (int i=1; i<tabGenre.size(); i++){
				if (tabGenre.get(i).getIdGenre()>max) max=tabGenre.get(i).getIdGenre();
			}
			return max;
		}
		return 1;
	}
	public GenreIDao getGenreIdao() {
		return genreIdao;
	}
	public void setGenreIdao(GenreIDao genreIdao) {
		this.genreIdao = genreIdao;
	}
	public UCGIDao getUcgIdao() {
		return ucgIdao;
	}
	public void setUcgIdao(UCGIDao ucgIdao) {
		this.ucgIdao = ucgIdao;
	}
	public UCGBusiness getUcgBusiness() {
		return ucgBusiness;
	}
	public void setUcgBusiness(UCGBusiness ucgBusiness) {
		this.ucgBusiness = ucgBusiness;
	}
	public UtilisateurBusiness getUtilisateurB() {
		return utilisateurB;
	}
	public void setUtilisateurB(UtilisateurBusiness utilisateurB) {
		this.utilisateurB = utilisateurB;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Ucg getUcg() {
		return ucg;
	}
	public void setUcg(Ucg ucg) {
		this.ucg = ucg;
	}
	public int getIdGenre1() {
		return idGenre1;
	}
	public void setIdGenre1(int idGenre1) {
		this.idGenre1 = idGenre1;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
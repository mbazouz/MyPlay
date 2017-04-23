package com.business;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.dao.UtilisateurIDao;
import com.dao.impl.UtilisateurDaoImpl;
import com.model.Chanson;
import com.model.Genre;
import com.model.Ucg;
import com.model.Utilisateur;
import com.util.SessionBean;

public class UtilisateurBusiness {

	private UtilisateurIDao utilisateurIdao = new UtilisateurDaoImpl();

	Utilisateur utilisateur = new Utilisateur();
	Utilisateur utilisateurActuel = new Utilisateur();
	private String testMotDePasse;
	private String text = "";

	public UtilisateurBusiness() {
		// System.out.println("UtilisateurBusiness*************************");
	}

	/*
	 * public void ajouterUtilisateur(int idUser, String nom, String prenom,
	 * String email, String pseudo, String motDePasse, Date dateAjout){
	 * 
	 * utilisateur.setIdUser(idUser); utilisateur.setNom(nom);
	 * utilisateur.setPrenom(prenom); utilisateur.setEmail(email);
	 * utilisateur.setPseudo(pseudo); utilisateur.setMotDePasse(motDePasse);
	 * utilisateur.setDateAjout(dateAjout);
	 * 
	 * utilisateurIdao.saveOrUpdate(utilisateur); }
	 */

	public String ajouterUtilisateur() {
		this.setText("");
		if (ListeUtilisateurPseudo(utilisateur.getPseudo()).isEmpty() == false) {
			this.setText("Pseudo existe déja");
			return "Pseudo existe déja";
		} else if (ListeUtilisateurMail(utilisateur.getEmail()).isEmpty() == false) {
			this.setText("Email existe déja");
			return "Email existe déja";
		} else if (utilisateur.getMotDePasse().equals(this.testMotDePasse)) {
			int id = maxIdUtilisateur();
			utilisateur.setIdUser(id++);
//			utilisateur.setIdUser(8);
			utilisateur.setDateAjout(utilisateur.takeDate());
			utilisateurIdao.saveOrUpdate(utilisateur);
			utilisateurActuel=utilisateur;
			HttpSession session = SessionBean.getSession();
			session.setAttribute("userid", utilisateur.getIdUser());
			utilisateur=new Utilisateur();
			return "success";
		} else {
//			utilisateur = new Utilisateur();
			utilisateur.setMotDePasse("");
			this.setTestMotDePasse("");
			this.setText("Mot de passe non identique !");
			return "testMotDePasseIncorrecte";
		}
	}
	
	public String modifierUtilisateur (){
		HttpSession session = SessionBean.getSession();
		utilisateur.setIdUser((int)session.getAttribute("userid"));
		utilisateurIdao.saveOrUpdate(utilisateur);
		utilisateur = new Utilisateur();
		return "success";
	}
	public String testLogin() {
		String valRetour = "";
		if (ListeUtilisateurPseudo(utilisateur.getPseudo()).isEmpty() == false)
			if (ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getMotDePasse()
					.equals(utilisateur.getMotDePasse())){
				utilisateurActuel.setDateAjout(ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getDateAjout())  ;
				utilisateurActuel.setEmail(ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getEmail());
				utilisateurActuel.setIdUser(ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getIdUser());
				utilisateurActuel.setMotDePasse(ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getMotDePasse());
				utilisateurActuel.setNom(ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getNom());
				utilisateurActuel.setPrenom(ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getPrenom());
				utilisateurActuel.setPseudo(ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getPseudo());

//				Date date = ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getDateAjout()  ;
//				String mail=ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getEmail();
//				int id = ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getIdUser();
//				String mp = ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getMotDePasse();
//				String nom = ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getNom();
//				String prenom = ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getPrenom();
//				String pseudo = ListeUtilisateurPseudo(utilisateur.getPseudo()).get(0).getPseudo();
//
//				
//				utilisateurActuel = new Utilisateur(id,  nom,  prenom, mail,  pseudo, mp,
//						 date);
				HttpSession session = SessionBean.getSession();
				session.setAttribute("userid", utilisateurActuel.getIdUser());
				utilisateur = new Utilisateur(); 
				valRetour = "success";}
			else {
				utilisateur = new Utilisateur();
				this.setText("Pseudo ou Mot de passe est incorrecte !");

				valRetour = "false";
			}
		return valRetour;
	}

	public List<Utilisateur> ListeUtilisateurPseudo(String Pseudo) {

		return utilisateurIdao.findUtilisateurByLogin(Pseudo);
	}
	
	public List<Utilisateur> ListeUtilisateurId(int id) {

		return utilisateurIdao.findUtilisateurById(id);
	}

	public void AfficheListeUtilisateur(String Pseudo) {
		for (int i = 0; i < ListeUtilisateurPseudo(Pseudo).size(); i++) {
			System.out.println((Utilisateur) ListeUtilisateurPseudo(Pseudo).get(i));

		}
	}

	public List<Utilisateur> ListeUtilisateurMail(String Mail) {

		return utilisateurIdao.findUtilisateurByMail(Mail);
	}

	public void AfficheLoginUtilisateur(String Pseudo) {

		System.out.println((Utilisateur) ListeUtilisateurPseudo(Pseudo).get(0));

	}



	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTestMotDePasse() {
		return testMotDePasse;
	}

	public void setTestMotDePasse(String testMotDePasse) {
		this.testMotDePasse = testMotDePasse;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	public Utilisateur getUtilisateurActuel() {
		return utilisateurActuel;
	}

	public void setUtilisateurActuel(Utilisateur utilisateurActuel) {
		this.utilisateurActuel = utilisateurActuel;
	}

	public UtilisateurIDao getUtilisateurIdao() {
		return utilisateurIdao;
	}

	public void setUtilisateurIdao(UtilisateurIDao utilisateurIdao) {
		this.utilisateurIdao = utilisateurIdao;
	}
	
	

	public List<Utilisateur> ListeUtilisateur(){
		return utilisateurIdao.findAllUtilisateur();
	}

	public int maxIdUtilisateur(){
		List<Utilisateur> tabUtilisateur = ListeUtilisateur();
		if (tabUtilisateur.isEmpty()== false){
			int max = tabUtilisateur.get(0).getIdUser();
			for (int i=1; i<tabUtilisateur.size(); i++){
				if (tabUtilisateur.get(i).getIdUser()>max) max=tabUtilisateur.get(i).getIdUser();
			}
			return max;
		}
		return 1;
	}
	public String pont(){
		return "success";
	}
	
	public String pont1(){
		return "success";
	}
	
	public String logOut(){
		utilisateur = new Utilisateur();
		utilisateurActuel = new Utilisateur();
		return "success";
	}
}
package com.inscription.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inscription.beans.Administration;
import com.inscription.beans.Etudiant;
import com.inscription.beans.EtudiantProgress;
import com.inscription.beans.Inscription;
import com.inscription.database.inscriptionDataBase;
import com.inscription.database.ProgressDataBase;
import com.inscription.session.SessionManager;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ETUDIANT_INSCRIT_MESSAGE = "l'etudiant a ete bien inscrit";
	private static final String ETUDIANT_INSCRIT_KEY = "message";
	private static final String ETUDIANT_INSCRIT_MESSAGE_ERR = " une erreur lors de l'inscription ";
	private static final String NOT_FOUND_ETUDIANT_KEY = "noetudiant";
	private static final String FOUND_ETUDIANT_KEY = "etudiant";
	private static final String ETUDIANT = "etudiant";
	private static final String ETUDIANT_INSCRIT_DEJA_MESSAGE = "étudiant dèja inscrit dans cette annèe";
       
    
    public InscriptionServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idS = request.getParameter("id_cherche");
		
		int id = Integer.parseInt(idS);
		
		ProgressDataBase progress;
		try {
			progress = new ProgressDataBase();
			EtudiantProgress etudiant = progress.ChercherEtudiant(id);
			if(etudiant==null) {
				
				request.setAttribute(NOT_FOUND_ETUDIANT_KEY, "l'étudiant cherché n'existe pas ");
				
				this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
				
			}
			
			else {
				
				request.setAttribute(FOUND_ETUDIANT_KEY, "etudiant trouvé");	
				request.setAttribute(ETUDIANT, etudiant);
				this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt( request.getParameter("id"));
		//verfication etudiant deja inscrit 
		
		try {
			inscriptionDataBase verifier = new inscriptionDataBase() ;
			boolean etudiantExist = verifier.verifierDejaInscrit(id);
			if(etudiantExist) {
				
				request.setAttribute(ETUDIANT_INSCRIT_KEY, ETUDIANT_INSCRIT_DEJA_MESSAGE);
				this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
				
			}
			
			else {
				
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String date_naissance = request.getParameter("date_naissance");
				String lieu_naissance = request.getParameter("lieu_naissance");
				String sexe = request.getParameter("sexe");
				String telephone = request.getParameter("telephone");
				String adresse = request.getParameter("adresse");
				String filiere = request.getParameter("filiere");
				String niveau = request.getParameter("niveau");
				
				HttpSession session = request.getSession();
				
				int idAgent = (int) session.getAttribute(SessionManager.AGENT_ID);
				
				Etudiant etudiant = new Etudiant(id, nom, prenom, date_naissance, lieu_naissance, sexe, telephone, adresse, filiere);
				Administration agent = new Administration();
				agent.setId(idAgent);
				Inscription inscription = new Inscription();
				inscription.setEtudiant(etudiant);
				inscription.setAgent(agent);
				inscription.setNiveau(niveau);
				
				inscriptionDataBase database;
				try {
					database = new inscriptionDataBase();
					boolean result = database.FaireInscription(inscription);
					
					if(result) {
						
						request.setAttribute(ETUDIANT_INSCRIT_KEY, ETUDIANT_INSCRIT_MESSAGE);
						this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
						
					}
					
					else {
						
						request.setAttribute(ETUDIANT_INSCRIT_KEY, ETUDIANT_INSCRIT_MESSAGE_ERR);
						this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
						
					}
				} catch (ClassNotFoundException | SQLException e) {
					request.setAttribute(ETUDIANT_INSCRIT_KEY, ETUDIANT_INSCRIT_MESSAGE_ERR);
					this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
					e.printStackTrace();
				}
				
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

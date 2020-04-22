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
import com.inscription.beans.Inscription;
import com.inscription.database.inscriptionDataBase;
import com.inscription.session.SessionManager;


@WebServlet("/ReinscriptionServlet")
public class ReinscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FOUND_ETUDIANT_KEY = "etudiant";
	private static final String NOT_FOUND_ETUDIANT_KEY = "noetudiant";
	private static final String ETUDIANT = "etudiant";
	private static final String REINSCRIPTION_KEY = "reinscription";
	private static final String REINSCRIPTION_MESSAGE_SUCESS = "étudiant inscrit a nouveau avec succès ";
	private static final String REINSCRIPTION_MESSAGE_ERROR = " erreur lors de l'inscription de l'etudiant ";
	private static final String ETUDIANT_DEJA_INSCRIT = "étudiant dèja inscrit";
	private Etudiant etudiant ;
	
	
       
    
    public ReinscriptionServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		
		
		String chercher_btn = request.getParameter("chercher_btn");
		String reinscrire_btn = request.getParameter("reinscrire_btn");
		
		
		if(chercher_btn!=null) {
			
			  String id_chercher =request.getParameter("id_cherche");
			  
			  int id = Integer.parseInt(id_chercher);
			  
			  inscriptionDataBase database;
			try {
				database = new inscriptionDataBase();
				 etudiant = database.chercherEtudiant(id);
				if(etudiant!=null) {
					
					request.setAttribute(FOUND_ETUDIANT_KEY, "etudiant trouvé");
					
					request.setAttribute(ETUDIANT, etudiant);
					chercher_btn=null;
					this.getServletContext().getRequestDispatcher("/reinscription.jsp").forward(request, response);
				}
				
				else if (etudiant==null) {
					
					request.setAttribute(NOT_FOUND_ETUDIANT_KEY, "l'étudiant cherché n'existe pas ");
					chercher_btn=null;
					this.getServletContext().getRequestDispatcher("/reinscription.jsp").forward(request, response);
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute(NOT_FOUND_ETUDIANT_KEY, " erreur base de donnée");
				chercher_btn=null;
				this.getServletContext().getRequestDispatcher("/reinscription.jsp").forward(request, response);
				e.printStackTrace();
			}
			
			
				
			}
		
		else {
			 
			  
			  int id = etudiant.getId();
			
			inscriptionDataBase verifier;
			try {
				verifier = new inscriptionDataBase();
				boolean etudiantExist = verifier.verifierDejaInscrit(id);
				if(etudiantExist) {
					
					request.setAttribute(REINSCRIPTION_KEY, ETUDIANT_DEJA_INSCRIT);
					this.getServletContext().getRequestDispatcher("/reinscription.jsp").forward(request, response);

					
					
				}
				
				else {
					
					HttpSession session = request.getSession();
					int idAgent = (int) session.getAttribute(SessionManager.AGENT_ID);
					String niveau = request.getParameter("niveau");
					
					Administration agent = new Administration();
					agent.setId(idAgent);
					Inscription inscription = new Inscription();
					inscription.setEtudiant(etudiant);
					inscription.setAgent(agent);
					inscription.setNiveau(niveau);
					
					try {
						inscriptionDataBase database = new inscriptionDataBase();
						boolean result = database.ReInscription(inscription);
						if(result) {
							
							request.setAttribute(REINSCRIPTION_KEY, REINSCRIPTION_MESSAGE_SUCESS);
							reinscrire_btn=null;
							this.getServletContext().getRequestDispatcher("/reinscription.jsp").forward(request, response);
						}
						
						else {
							
							request.setAttribute(REINSCRIPTION_KEY, REINSCRIPTION_MESSAGE_ERROR);
							reinscrire_btn=null;
							this.getServletContext().getRequestDispatcher("/reinscription.jsp").forward(request, response);
							
						}
					} catch (SQLException e) {
						request.setAttribute(REINSCRIPTION_KEY, REINSCRIPTION_MESSAGE_ERROR);
						reinscrire_btn=null;
						this.getServletContext().getRequestDispatcher("/reinscription.jsp").forward(request, response);
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						request.setAttribute(REINSCRIPTION_KEY, REINSCRIPTION_MESSAGE_ERROR);
						this.getServletContext().getRequestDispatcher("/reinscription.jsp").forward(request, response);
						e.printStackTrace();
					}
					
					
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			
		
		
			
			
			
			  
			  
			
			
			
			
		}
		
	}

}

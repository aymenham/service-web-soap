package com.adhesion.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adhesion.beans.Adhesion;
import com.adhesion.database.AdhesionDataBase;
import com.adhesion.session.SessionManager;
import com.scolarite.webservice.ScolariteServiceStub.Etudiant;

/**
 * Servlet implementation class AdhesionServlet
 */
@WebServlet("/AdhesionServlet")
public class AdhesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String KEY = "message";
	
	private final String USER_NOT_FOUND = "désolé etudiant non inscrit  dans le département";
	
	private final String PROBLEME_DATA_BASE = "un problème lors de l'opération d'adhésion";
	
	private final String SUCESS_ADHESION = "Adhésion avec succès";
	
	private final String ETUDIANT_DEJA_ADHESION = "cet étudiant a dèja fait une adhésion";
       
  
    public AdhesionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("id_cherche");
		int idEtudint = Integer.parseInt(parameter);
		
		try {
			AdhesionDataBase add = new AdhesionDataBase();
			boolean etudiantDejaInscrit = add.verifierDejaAdhesion(idEtudint);
			if(etudiantDejaInscrit) {
				
				request.setAttribute(KEY, ETUDIANT_DEJA_ADHESION);
				this.getServletContext().getRequestDispatcher("/adhesion.jsp").forward(request, response);
				
			}
			
			else {
				
				HttpSession session = request.getSession();
				int idAgent = (int) session.getAttribute(SessionManager.AGENT_ID);
				
				Etudiant etudiant = new Etudiant();
				etudiant.setId(idEtudint);
				
				Adhesion adhesion = new Adhesion(0, etudiant, idAgent, AdhesionDataBase.getAnneeActuel());
				
				try {
					AdhesionDataBase database = new AdhesionDataBase();
					int result = database.FaireAdhesion(adhesion);
					//etudiant n'existe pas
					if(result==-1) {
						
						request.setAttribute(KEY, USER_NOT_FOUND);
						this.getServletContext().getRequestDispatcher("/adhesion.jsp").forward(request, response);
					}
					
					if(result==0) {
						request.setAttribute(KEY, PROBLEME_DATA_BASE);
						this.getServletContext().getRequestDispatcher("/adhesion.jsp").forward(request, response);
					}
					
					if(result>0) {
						
						request.setAttribute(KEY, SUCESS_ADHESION);
						this.getServletContext().getRequestDispatcher("/adhesion.jsp").forward(request, response);
						
						
					}
				} catch (ClassNotFoundException | SQLException e) {
					request.setAttribute(KEY, PROBLEME_DATA_BASE);
					this.getServletContext().getRequestDispatcher("/adhesion.jsp").forward(request, response);
					e.printStackTrace();
				}
				
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
	}

}

package com.adhesion.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adhesion.database.AdhesionDataBase;
import com.adhesion.database.ChefDataBase;



@WebServlet("/ConservateurServlet")
public class ConservateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final String KEY = "message";
	private final String Ouvrir_annee_Message = " adhésion  année "+AdhesionDataBase.getAnneeActuel()
	+"ouverte";
	
	private final String Ouvrir_annee_Message_Err = "une erreur lors de l'ouverture d'adhésion";
	
	
	private final String Fermer_annee_Message = " année  adhésion "+AdhesionDataBase.getAnneeActuel() +"fermée";
    
	private final String Fermer_annee_Message_Err = "une erreur lors de la fermeture d'adhésion";
  
    public ConservateurServlet() {
        super();
        
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String ActionOuvrir = request.getParameter("ouvrir_annee");
		
		String ActionFermer= request.getParameter("fermer_annee");
		
		if(ActionOuvrir!=null) {
			
			ActionOuvrir = null;
			
			try {
				ChefDataBase gereranne = new ChefDataBase();
				boolean result = gereranne.ouvirAdhesion();
				if(result) {
					
					request.setAttribute(KEY, Ouvrir_annee_Message);
					this.getServletContext().getRequestDispatcher("/chef.jsp").forward(request, response);
					
				}
				
				else {
					
					request.setAttribute(KEY, Ouvrir_annee_Message_Err);
					this.getServletContext().getRequestDispatcher("/chef.jsp").forward(request, response);
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute(KEY, Ouvrir_annee_Message_Err);
				this.getServletContext().getRequestDispatcher("/chef.jsp").forward(request, response);
				e.printStackTrace();
			}
			
		}
		
		else if(ActionFermer!=null) {
			
			ActionFermer = null; 
			
			try {
				ChefDataBase gereranne = new ChefDataBase();
				boolean result = gereranne.fermerAdhesion();
				if(result) {
					
					request.setAttribute(KEY, Fermer_annee_Message);
					this.getServletContext().getRequestDispatcher("/chef.jsp").forward(request, response);
					
				}
				
				else {
					
					request.setAttribute(KEY, Fermer_annee_Message_Err);
					this.getServletContext().getRequestDispatcher("/chef.jsp").forward(request, response);
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute(KEY, Fermer_annee_Message_Err);
				this.getServletContext().getRequestDispatcher("/chef.jsp").forward(request, response);
				e.printStackTrace();
			}
			
		}
		
	}

}

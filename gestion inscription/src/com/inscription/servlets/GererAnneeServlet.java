package com.inscription.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inscription.database.ChefDatabase;
import com.inscription.database.inscriptionDataBase;


@WebServlet("/GererAnneeServlet")
public class GererAnneeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String KEY = "message";
	private final String Ouvrir_annee_Message = " année "+inscriptionDataBase.GenerateAnneUniversitaire()
	+"ouverte";
	
	private final String Ouvrir_annee_Message_Err = "une erreur lors de l'ouverture de l'année";
	
	
	private final String Fermer_annee_Message = " année "+inscriptionDataBase.GenerateAnneUniversitaire() +"fermée";
    
	private final String Fermer_annee_Message_Err = "une erreur lors de la fermeture de l'année";
   
    public GererAnneeServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ActionOuvrir = request.getParameter("ouvrir_annee");
		
		String ActionFermer= request.getParameter("fermer_annee");
		
		if(ActionOuvrir!=null) {
			
			ActionOuvrir = null;
			
			try {
				ChefDatabase gereranne = new ChefDatabase();
				boolean result = gereranne.OuvrirAnnee();
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
				ChefDatabase gereranne = new ChefDatabase();
				boolean result = gereranne.FermerAnnee();
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

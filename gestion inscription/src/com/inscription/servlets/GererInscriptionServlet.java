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


@WebServlet("/GererInscriptionServlet")
public class GererInscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String KEY = "message";
	private final String Ouvrir_Inscription_Message = " année inscription  "+inscriptionDataBase.GenerateAnneUniversitaire()
	+"ouverte";
	private final String Ouvrir_Inscription_Message_ERR = "une erreur lors de l'ouverture des inscriptions";
	
	private final String Fermer_Inscription_Message = "année inscription "+inscriptionDataBase.GenerateAnneUniversitaire() + 
			"fermée";
	
	private final String Fermer_Inscription_Message_ERR = "une erreur lors de la fermiture des inscriptions";
       
    
    public GererInscriptionServlet() {
        super();
       
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ActionOuvrir = request.getParameter("ouvrir_inscription");	
		String ActionFermer= request.getParameter("fermer_inscription");
		
		if(ActionOuvrir!=null) {
			ActionOuvrir = null;
			try {
				ChefDatabase gereranne = new ChefDatabase();
				boolean result = gereranne.OuvrirInscription();
				if(result) {
					
					request.setAttribute(KEY, Ouvrir_Inscription_Message);
					this.getServletContext().getRequestDispatcher("/chef.jsp").forward(request, response);
					
				}
				
				else {
					
					request.setAttribute(KEY, Ouvrir_Inscription_Message_ERR);
					this.getServletContext().getRequestDispatcher("/chef.jsp").forward(request, response);
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute(KEY, Ouvrir_Inscription_Message_ERR);
				this.getServletContext().getRequestDispatcher("/chef.jsp").forward(request, response);
				e.printStackTrace();
			}
		}
		
		else if (ActionFermer!=null) {
			
			ActionFermer = null;
			
			try {
				ChefDatabase gereranne = new ChefDatabase();
				boolean result = gereranne.FermerInscription();
				if(result) {
					
					request.setAttribute(KEY, Fermer_Inscription_Message);
					this.getServletContext().getRequestDispatcher("/chef.jsp").forward(request, response);
					
				}
				
				else {
					
					request.setAttribute(KEY, Fermer_Inscription_Message_ERR);
					this.getServletContext().getRequestDispatcher("/chef.jsp").forward(request, response);
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute(KEY, Fermer_Inscription_Message_ERR);
				this.getServletContext().getRequestDispatcher("/chef.jsp").forward(request, response);
				e.printStackTrace();
			}
		}
		
		
	}

}

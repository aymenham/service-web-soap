package com.inscription.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inscription.beans.Administration;
import com.inscription.beans.Departement;
import com.inscription.database.inscriptionDataBase;
import com.inscription.session.SessionManager;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static final String DATA_BASE_ERROR_MESSAGE = "probleme de la base de donne";
	private static final String USER_NOT_FOUND_ERROR = "erreur";
	private static final String USER_NOT_FOUND_MESSAGE = "username ou password incorrecte";
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			inscriptionDataBase database = new inscriptionDataBase();
			
			Administration admin = database.Login(username, password);
			
			if(admin!=null) {
				
				if(admin.getRole().equals("agent")) {
					
					SessionManager session = new SessionManager();
					session.saveSessionAgent(request, admin);
					//verification l'etat de l'annee et l'inscription 
					
					Departement departement = new inscriptionDataBase().getStatDepartement();
					
					if(departement.getStatutAnne().equals("fermer") || 
					departement.getStatutInscription().equals("fermer")) {
						
						this.getServletContext().getRequestDispatcher("/anne_ferme.html").forward(request, response);
						
					}
					
					else if(departement.getStatutAnne().equals("ouvert") || 
					departement.getStatutInscription().equals("ouvert")) {
						
						this.getServletContext().getRequestDispatcher("/agent.jsp").forward(request, response);
						
					}
					
					
				}
				
				else if(admin.getRole().equals("chef")) {
					
					this.getServletContext().getRequestDispatcher("/chef.jsp").forward(request, response);
					
				}
				
				
			}
			
			else {
				request.setAttribute(USER_NOT_FOUND_ERROR, USER_NOT_FOUND_MESSAGE);
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute(USER_NOT_FOUND_ERROR, DATA_BASE_ERROR_MESSAGE);
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			e.printStackTrace();
		}
		
		
		
	
		
		
		
	}

}

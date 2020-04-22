package com.inscription.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inscription.session.SessionManager;

/**
 * Servlet implementation class DisconnectServlet
 */
@WebServlet("/DisconnectServlet")
public class DisconnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DisconnectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			SessionManager session = new SessionManager();
			
			session.DeleteSession(request);
			
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

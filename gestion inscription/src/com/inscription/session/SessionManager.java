package com.inscription.session;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.inscription.beans.Administration;

public class SessionManager {
	
	public static  String  AGENT_ID = "id" ;
	public static  String  AGENT_NOM = "nom" ;
	public static  String  AGENT_PRENOM = "prenom" ;
	public static  String  AGENT_PSEUDO = "pseudo" ;
	public static  String  AGENT_ROLE = "role" ;
	public void saveSessionAgent(HttpServletRequest request , Administration agent) {
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute(AGENT_ID, agent.getId());	
		session.setAttribute(AGENT_NOM, agent.getNom());	
		session.setAttribute(AGENT_PRENOM, agent.getPrenom());	
		session.setAttribute(AGENT_PSEUDO, agent.getPseudo());
		session.setAttribute(AGENT_ROLE, agent.getRole());
		
	}
	
	
	public void DeleteSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
	}
	


}

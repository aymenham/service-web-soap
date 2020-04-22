package com.scolarite.webservice;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.scolarite.webservice.ScolariteServiceStub.Etudiant;

public class WebServiceClient {
	
	
	public Etudiant getEtudiant(int id) throws RemoteException {
		
		 ScolariteServiceStub stub = new ScolariteServiceStub();

	        // Create the request
		 	ScolariteServiceStub.ChercherEtudiant request = new ScolariteServiceStub.ChercherEtudiant();

	        // Set the parameters
	        request.setId(id);

	        // Invoke the service
	        ScolariteServiceStub.ChercherEtudiantResponse response = stub.chercherEtudiant(request);
	        Etudiant res = response.get_return(); // Hello Gobinath
	        
	        return res;
	}
	
	
	public boolean getStatAnnee() {
		
		try {
			
			 ScolariteServiceStub stub = new ScolariteServiceStub();

		        // Create the request
			 ScolariteServiceStub.VerifierStatAnnee request = new ScolariteServiceStub.VerifierStatAnnee();

		        // Set the parameters
		        

		        // Invoke the service
		        ScolariteServiceStub.VerifierStatAnneeResponse response = stub.verifierStatAnnee(request);
		        boolean res = response.get_return(); // Hello Gobinath
		        return res;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("message :"+e.getMessage());
		}
		
		return false;
	}

}

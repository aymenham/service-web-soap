
/**
 * ScolariteServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */

    package com.scolarite.webservice;

    /**
     *  ScolariteServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ScolariteServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ScolariteServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ScolariteServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for chercherEtudiant method
            * override this method for handling normal response from chercherEtudiant operation
            */
           public void receiveResultchercherEtudiant(
                    com.scolarite.webservice.ScolariteServiceStub.ChercherEtudiantResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from chercherEtudiant operation
           */
            public void receiveErrorchercherEtudiant(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for verifierStatAnnee method
            * override this method for handling normal response from verifierStatAnnee operation
            */
           public void receiveResultverifierStatAnnee(
                    com.scolarite.webservice.ScolariteServiceStub.VerifierStatAnneeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from verifierStatAnnee operation
           */
            public void receiveErrorverifierStatAnnee(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCurrentAnnee method
            * override this method for handling normal response from getCurrentAnnee operation
            */
           public void receiveResultgetCurrentAnnee(
                    com.scolarite.webservice.ScolariteServiceStub.GetCurrentAnneeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCurrentAnnee operation
           */
            public void receiveErrorgetCurrentAnnee(java.lang.Exception e) {
            }
                


    }
    
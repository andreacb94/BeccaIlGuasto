/*
 **************************************************************
 *                     2015(c) Project by                     *
 *                                                            *
 *                      Andrea  Petrella                      *
 *                                                            *
 *  Gioco creato per l'esame di Programmazione e Laboratorio  *
 **************************************************************
 */
package finestre;

import helpers.Finestra;

/**
 *
 * @author Andrea
 */

/*La classe Start ha il compito di creare il menù di gioco
  e avviarlo all'apertura dell'applicazione tramite il metodo main().*/
public class Start {
    
    //***VARIABILI, COSTANTI E OGGETTI DI CLASSE***
    //***VARIABILI, COSTANTI E OGGETTI DI ISTANZA***
    private Finestra finestra = null; //Un oggetto per gestire la finestra
    
    //Metodo costruttore
    public Start(){
        
        //***1. CREAZIONE DELLA FINESTRA***
        //Inizializzo un oggetto Finestra per creare la finestra principale
        finestra = new Finestra();
        Finestra.creaFinestraPrincipale(finestra);
        
        //***2. POPOLAZIONE DELLA FINESTRA***
        //Aggiungo i componenti del menù alla finestra appena creata
        Finestra.aggiungiComponentiMenu(finestra);
        
        //***3. VISUALIZZAZIONE DELLA FINESTRA***
        //Apro la finestra
        Finestra.apriFinestra(finestra);
        
    }   /* 
    
    //Metodo Main dell'applicazione
    public static void main(String[] args) {
        
        /*Creo un oggetto app della classe Start nel metodo main per avviare il
          gioco con il menù start*/
        Start app = new Start();
        
    //}

}

// *** COMMENTI ULTIMATI ***
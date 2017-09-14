/*
 **************************************************************
 *                     2015(c) Project by                     *
 *                                                            *
 *                      Andrea  Petrella                      *
 *                                                            *
 *  Gioco creato per l'esame di Programmazione e Laboratorio  *
 **************************************************************
 */
package helpers;

import personaggi.*;

/**
 *
 * @author Andrea
 */

/*La classe GestoreIncroci, di seguito scritta, è una classe "helper" ovvero
  aiuta ad ottenere un codice più ordinato riducendo la scrittura dello stesso
  codice più volte.
  Il compito di GestoreIncroci è quello di verificare:
  - se il Giocatore e l'Antagonista condividono una delle due coordinate. Quando
    questo è vero, l'Antagonista corre verso il Giocatore.
  - se il Giocatore e l'Aiutante condividono una delle due coordinate. Quando
    questo è vero, l'Aiutante evita di andare verso il Giocatore.*/
public class GestoreIncroci {
    
    //Metodo per verificare l'incrocio tra Giocatore e Antagonista
    public static int controllaIncrocioAntagonista(Giocatore g, Antagonista a){
        
        /*Codifico il controllo in 5 situazioni con un intero:
          - x e y diverse tra Giocatore e Antagonista,          controllo = 0
          - x uguali e Giocatore sopra dell'Antagonista,        controllo = 1
          - x uguali e Giocatore sotto dell'Antagonista,        controllo = 2
          - y uguali e Giocatore a sinistra l'Antagonista,      controllo = 3
          - y uguali e Giocatore a destra l'Antagonista,        controllo = 4*/
        int controllo = 0;
        
        if(g.getPunto().x == a.getPunto().x){
            
            if(g.getPunto().y + 120 < a.getPunto().y)          
                controllo = 1;
            else if(g.getPunto().y > a.getPunto().y + 120)       
                controllo = 2;
            
        }
        else if(g.getPunto().y == a.getPunto().y){
            
            if(g.getPunto().x + 80 < a.getPunto().x)            
                controllo = 3;
            else if(g.getPunto().x > a.getPunto().x + 80)
                controllo = 4;
            
        }
        
        //Restituisco il controllo codificato
        return controllo;
        
    }
    
    //Metodo per verificare l'incrocio tra Giocatore e Aiutante
    public static int controllaIncrocioAiutante(Giocatore g, Aiutante a){
        
        /*Codifico il controllo in 5 situazioni con un intero:
          - x e y diverse tra Giocatore e Aiutante,             controllo = 5
          - x uguali e Giocatore sopra dell'Aiutante,           controllo = 1
          - x uguali e Giocatore sotto dell'Aiutante,           controllo = 2
          - y uguali e Giocatore a sinistra l'Aiutante,         controllo = 3
          - y uguali e Giocatore a destra l'Aiutante,           controllo = 4*/
        int controllo = 5;
        
        if(g.getPunto().x == a.getPunto().x){
            
            if(g.getPunto().y + 120 < a.getPunto().y)          
                controllo = 1;
            else if(g.getPunto().y > a.getPunto().y + 120)       
                controllo = 2;
            
        }
        else if(g.getPunto().y == a.getPunto().y){
            
            if(g.getPunto().x + 80 < a.getPunto().x)            
                controllo = 3;
            else if(g.getPunto().x > a.getPunto().x + 80)
                controllo = 4;
            
        }
        
        //Restituisco il controllo codificato
        return controllo;
        
    }
    
}

// *** COMMENTI ULTIMATI ***
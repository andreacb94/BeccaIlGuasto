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

import finestre.Gioco;
import personaggi.Aiutante;
import personaggi.Antagonista;
import personaggi.Giocatore;

/**
 *
 * @author Andrea
 */

//UscitaDiScena gestisce le uscite di scena dell'Aiutante e dell'Antagonista
public class UscitaDiScena {
    
    int cont = 0;
    
    /*Metodo per controllare se l'Antagonista si trova sopra o sotto il
      giocatore. Decodifico l'informazione nella variabile interazione.*/
    public static void controllaUscitaAntagonista(Giocatore g, Antagonista a){
        
        //L'antagonista è sopra il giocatore
        if(g.getPunto().y < a.getPunto().y) a.setInterazione(1);
        //L'antagonista è sotto il giocatore
        else a.setInterazione(2);
        
    }
    
    /*Metodo per controllare se l'Aiutante si trova sopra o sotto il
      giocatore. Decodifico l'informazione nella variabile interazione.*/
    public static void controllaUscitaAiutante(Giocatore g, Aiutante a){
        
        //L'aiutante è sopra il giocatore
        if(g.getPunto().y < a.getPunto().y) a.setInterazione(1);
        //L'aiutante è sotto il giocatore
        else a.setInterazione(2);
        
    }
    
    //Metodi che effettuano l'uscita di scena
    
    public static void uscitaAntagonista(Antagonista a, int velocita){
        
        //Se il giocatore è sopra l'antagonista esco giu
        if(a.getInterazione() == 1){
            //Sposto
            if(a.getPunto().y <= Gioco.finestra.getHeight() + velocita){
                
                a.scegliImgGiu();
                a.spostaGiu(velocita);
                
            }
            //Elimino dal gioco l'oggetto
            else{
                
                a.setInterazione(0);
                a.nonInGioco();            
                
            }
            
        }
        //Altrimenti sopra
        else{
            //Sposto
            if(a.getPunto().y + 120 >= -velocita){
                
                a.scegliImgSu();
                a.spostaSu(velocita);
                
            }
            //Elimino dal gioco l'oggetto
            else{
                
                a.setInterazione(0);
                a.nonInGioco();            
                
            }
            
        }
            
    }
    
    public static void uscitaAiutante (Aiutante a, int velocita){
            
        
        //Se il giocatore è sopra l'aiutante esco giu
        if(a.getInterazione() == 1){
            
            //Sposto
            if(a.getPunto().y <= Gioco.finestra.getHeight()+ 40){
                
                a.scegliImgGiu();
                a.spostaGiu(velocita);
                
            }
            //Elimino dal gioco l'oggetto
            else{
                
                a.setInterazione(0);
                a.nonInGioco();            
                
            }
            
        }
        //Altrimenti sopra
        else{
            
            //Sposto
            if(a.getPunto().y + 120 >= -40){
                
                a.scegliImgSu();
                a.spostaSu(velocita);
                
            }
            
            //Elimino dal gioco l'oggetto
            else{
                
                a.setInterazione(0);
                a.nonInGioco();            
                
            }
            
        }
        
    }
    
}

// *** COMMENTI ULTIMATI ***
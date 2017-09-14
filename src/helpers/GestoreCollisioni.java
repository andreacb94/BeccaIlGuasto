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

import java.awt.Rectangle;
import personaggi.*;

/**
 *
 * @author Andrea
 */

/*La classe GestoreCollisioni, di seguito scritta, è una classe "helper" ovvero
  aiuta ad ottenere un codice più ordinato riducendo la scrittura dello stesso
  codice più volte. Il compito di GestoreCollisioni è quello verificare se il
  Giocatore è adiacente ad un altro oggetto, questo per permettere di avere
  l'interazione desiderata.*/
public class GestoreCollisioni {
    
    //Metodo che controlla la collisione tra Giocatore e Traliccio
    public static boolean controllaCollisioneTraliccio2(Giocatore g, Traliccio t){
        
        /*Creo due rettangoli per verificare la collisione tra i due elementi.
          I due rettangoli formano una "croce" attorno al giocatore in modo da
          farlo interagire solo se sono adiacenti i lati ma non gli angoli.
          Creo altri 2 rettangoli analoghi attorno al traliccio*/
        
        int asse_x = 80/2;
        int asse_y = 120/2;
        
        Rectangle r1 = new Rectangle(g.getBordi().x - 1, g.getBordi().y + asse_y - 1, 82, 2);
        Rectangle r2 = new Rectangle(g.getBordi().x + asse_x - 1, g.getBordi().y - 1, 2, 122);
        
        Rectangle t1 = new Rectangle(t.getBordi().x - 1, t.getBordi().y + asse_y - 1, 82, 2);
        Rectangle t2 = new Rectangle(t.getBordi().x + asse_x - 1, t.getBordi().y - 1, 2, 122);
        
        //Restituisco l'interazione
        return ((r1.getBounds().intersects(t1.getBounds())) || (r2.getBounds().intersects(t2.getBounds())));
        
    }
    
    //Metodo che controlla la collisione tra Giocatore e Aiutante
    public static boolean controllaCollisioneAntagonista2(Giocatore g, Antagonista a){
        
        
        /*Creo due rettangoli per verificare la collisione tra i due elementi.
          I due rettangoli formano una "croce" attorno al giocatore in modo da
          farlo interagire solo se sono adiacenti i lati ma non gli angoli.
          Creo altri 2 rettangoli analoghi attorno all'antagonista*/
        
        int asse_x = 80/2;
        int asse_y = 120/2;
        
        Rectangle r1 = new Rectangle(g.getBordi().x - 1, g.getBordi().y + asse_y - 1, 82, 2);
        Rectangle r2 = new Rectangle(g.getBordi().x + asse_x - 1, g.getBordi().y - 1, 2, 122);
        
        Rectangle t1 = new Rectangle(a.getBordi().x - 1, a.getBordi().y + asse_y - 1, 82, 2);
        Rectangle t2 = new Rectangle(a.getBordi().x + asse_x - 1, a.getBordi().y - 1, 2, 122);
     
        /*Gestisco l'intersezione solo se l'antagonista è attivo nel gioco.
          Questo per evitare finestre di dialogo con oggetti fantasma*/
        if(a.getIn_gioco()){
            
            return ((r1.getBounds().intersects(t1.getBounds())) || (r2.getBounds().intersects(t2.getBounds())));
            
        }
        
        else return false;
        
    }
    
    //Metodo che controlla la collisione tra Giocatore e Aiutante
    public static boolean controllaCollisioneAiutante2(Giocatore g, Aiutante a){
        
        
        /*Creo due rettangoli per verificare la collisione tra i due elementi.
          I due rettangoli formano una "croce" attorno al giocatore in modo da
          farlo interagire solo se sono adiacenti i lati ma non gli angoli.
          Creo altri 2 rettangoli analoghi attorno all'aiutante*/
        int asse_x = 80/2;
        int asse_y = 120/2;
        
        Rectangle r1 = new Rectangle(g.getBordi().x - 1, g.getBordi().y + asse_y - 1, 82, 2);
        Rectangle r2 = new Rectangle(g.getBordi().x + asse_x - 1, g.getBordi().y - 1, 2, 122);
        
        Rectangle t1 = new Rectangle(a.getBordi().x - 1, a.getBordi().y + asse_y - 1, 82, 2);
        Rectangle t2 = new Rectangle(a.getBordi().x + asse_x - 1, a.getBordi().y - 1, 2, 122);
     
        /*Gestisco l'intersezione solo se l'aiutante è attivo nel gioco.
          Questo per evitare finestre di dialogo con oggetti fantasma*/
        if(a.getIn_gioco()){
            
            return ((r1.getBounds().intersects(t1.getBounds())) || (r2.getBounds().intersects(t2.getBounds())));
            
        }
        
        else return false;
        
    }
    
    /*Di seguito controllo se il giocatore rischia di sovrapporsi ad altri
      oggetti grafici in fase di spostamento, in modo da evitarlo.*/
    
    public static boolean controllaSovrapposizioneSu(Giocatore g, Traliccio t, Aiutante ai, Antagonista an, Albero[] al, int n_al){
        
        boolean risultato = false;
        
        //Creo un rettangolo per simulare lo spostamento
        Rectangle r = new Rectangle(g.getBordi().x, g.getBordi().y - 40, 80, 120);
        
        //Controllo con tutti gli oggetti grafici
        if(r.intersects(t.getBordi())) risultato = true;
        if(ai.getIn_gioco() && r.intersects(ai.getBordi())) risultato = true;
        if(an.getIn_gioco() && r.intersects(an.getBordi())) risultato = true;
        
        int i = 0;
        while(!risultato && i < n_al){
            
            if(r.intersects(al[i].getBordi())) risultato = true;
            i++;
        }
        
        //Restituisco l'eventuale sovrapposizione
        return risultato;
        
    }
    
    public static boolean controllaSovrapposizioneGiu(Giocatore g, Traliccio t, Aiutante ai, Antagonista an, Albero[] al, int n_al){
        
        boolean risultato = false;
        
        //Creo un rettangolo per simulare lo spostamento
        Rectangle r = new Rectangle(g.getBordi().x, g.getBordi().y + 40, 80, 120);
        
        //Controllo con tutti gli oggetti grafici
        if(r.intersects(t.getBordi())) risultato = true;
        if(ai.getIn_gioco() && r.intersects(ai.getBordi())) risultato = true;
        if(an.getIn_gioco() && r.intersects(an.getBordi())) risultato = true;
        
        int i = 0;
        while(!risultato && i < n_al){
            
            if(r.intersects(al[i].getBordi())) risultato = true;
            i++;
        }
        
        //Restituisco l'eventuale sovrapposizione
        return risultato;
        
    }
    
    public static boolean controllaSovrapposizioneDx(Giocatore g, Traliccio t, Aiutante ai, Antagonista an, Albero[] al, int n_al){
        
        boolean risultato = false;
        
        //Creo un rettangolo per simulare lo spostamento
        Rectangle r = new Rectangle(g.getBordi().x + 40, g.getBordi().y, 80, 120);
        
        //Controllo con tutti gli oggetti grafici
        if(r.intersects(t.getBordi())) risultato = true;
        if(ai.getIn_gioco() && r.intersects(ai.getBordi())) risultato = true;
        if(an.getIn_gioco() && r.intersects(an.getBordi())) risultato = true;
        
        int i = 0;
        while(!risultato && i < n_al){
            
            if(r.intersects(al[i].getBordi())) risultato = true;
            i++;
        }
        
        //Restituisco l'eventuale sovrapposizione
        return risultato;
        
    }
    
    public static boolean controllaSovrapposizioneSx(Giocatore g, Traliccio t, Aiutante ai, Antagonista an, Albero[] al, int n_al){
        
        boolean risultato = false;
        
        //Creo un rettangolo per simulare lo spostamento
        Rectangle r = new Rectangle(g.getBordi().x - 40, g.getBordi().y, 80, 120);
        
        //Controllo con tutti gli oggetti grafici
        if(r.intersects(t.getBordi())) risultato = true;
        if(ai.getIn_gioco() && r.intersects(ai.getBordi())) risultato = true;
        if(an.getIn_gioco() && r.intersects(an.getBordi())) risultato = true;
        
        int i = 0;
        while(!risultato && i < n_al){
            
            if(r.intersects(al[i].getBordi())) risultato = true;
            i++;
        }
        
        //Restituisco l'eventuale sovrapposizione
        return risultato;
        
    }
    
    /*Di seguito controllo se l'aiutante rischia di sovrapporsi ad altri
      oggetti grafici in fase di spostamento, in modo da evitarlo.*/
    public static void controllaSovrapposizioneAiutante(Giocatore g, Traliccio t, Aiutante ai, Antagonista an, Albero[] al, int n_al){
        
        boolean risultato = false;
        /*Nel frattempo che eseguo i vari controlli, metto in pausa l'Aiutante
          per evitare che si sposti nel frattempo*/
        ai.setIn_Pausa(true);
        
        //Creo un rettangolo per simulare lo spostamento
        Rectangle r = new Rectangle(ai.getBordi().x - 40, ai.getBordi().y - 40, 80 + 80, 120 + 80);
             
        //Controllo con tutti gli oggetti grafici
        if(r.intersects(g.getBordi())) risultato = true;
        else if(r.intersects(t.getBordi())) risultato = true;
        else if(an.getIn_gioco() && r.intersects(an.getBordi())) risultato = true;
        
        int i = 0;
        while(!risultato && i < n_al){
            
            if(r.intersects(al[i].getBordi())) risultato = true;
            i++;
        }
        
        //Rimane in pausa se ci fosse una sovrapposizione
        ai.setIn_Pausa(risultato);
        
    }
    
    public static void controllaSovrapposizioneAntagonista(Giocatore g, Traliccio t, Aiutante ai, Antagonista an, Albero[] al, int n_al){
        
        boolean risultato = false;
        /*Nel frattempo che eseguo i vari controlli, metto in pausa
          l'Antagonista per evitare che si sposti nel frattempo*/
        an.setIn_Pausa(true);
        
        //Creo un rettangolo per simulare lo spostamento
        Rectangle r = new Rectangle(an.getBordi().x - 40, an.getBordi().y - 40, 80 + 80, 120 + 80);
        
        //Controllo con tutti gli oggetti grafici
        if(r.intersects(g.getBordi())) risultato = true;
        else if(r.intersects(t.getBordi())) risultato = true;
        else if(ai.getIn_gioco() && r.intersects(ai.getBordi())) risultato = true;
        
        int i = 0;
        while(!risultato && i < n_al){
            
            if(r.intersects(al[i].getBordi())) risultato = true;
            i++;
        }
        
        //Rimane in pausa se ci fosse una sovrapposizione
        an.setIn_Pausa(risultato);
        
    }
    
}

// *** COMMENTI ULTIMATI ***

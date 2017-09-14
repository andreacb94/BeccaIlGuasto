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
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;
import personaggi.Albero;

/**
 *
 * @author Andrea
 */

/*La classe CoordinateCasuali è una classe "helper", ovvero aiuta ad ottenere un
  codice più ordinato riducendo la scrittura dello stesso codice più volte.
  Il compito di CoordinateCasuali è quello di generare, in
  maniera casuale, le coordinate di un oggetto grafico*/

/*ERRORI:
    - Il range delle coordinate va da 0 a maxVal, non va bene perché la mappa è negativa
*/

public class CoordinateCasuali{
    
    //***VARIABILI, COSTANTI E OGGETTI DI ISTANZA***
    //Un oggetto Random per generare interi casuali
    private Random r = new Random();
    //Un oggetto Point da restituire
    private Point p = new Point();
    /*Acquisisco il point_mappa della classe Gioco per definire il range di
      valori validi per generare il punto da restituire*/
    private final Point point_mappa = Gioco.getPoint_mappa();
    /*Acquisisco il point_giocatore della classe Gioco per evitare di
      sovrapporre il nuovo oggetto al gicatore*/
    private final Point point_giocatore = Gioco.getPoint_giocatore();
    //Acquisisco altezza e larghezza della mappa e della finestra
    private final int larghezza_mappa = Gioco.getLarghezza_mappa();
    private final int altezza_mappa = Gioco.getAltezza_mappa();
    private final int larghezza_finestra = Finestra.larghezza;
    private final int altezza_finestra = Finestra.altezza;
    /*Le coordinate saranno modulo 40 per le x e per le y, in modo da creare
      spostamenti omogenei con le dimensioni dei personaggi*/
    private final int modulo_x = 40;
    private final int modulo_y = 40;
    
    //Metodo per restituire il punto creato
    public Point puntoCasuale(int larghezza, int altezza, Albero[] alberi, int num_alberi){
        
        //Genero casualmente le coordinate
        
        /*Calcolo almeno una volta, ricalcolo se il nuovo oggetto capita nella
          schermata iniziale o se si trova sovrapposto ad un albero*/
        do{
            
            p.x = xCasuale(larghezza);
            p.y = yCasuale(altezza);
            
        }while( ((((p.x+larghezza) > 0) && (p.x < larghezza_finestra)) && (((p.y+altezza) > 0) && (p.y < altezza_finestra))) || controlloSovrapposizione(p, alberi, num_alberi) );
        
        return p;
        
    }
    
    //Metodo per generare casualmente la coordinata x
    private int xCasuale(int larghezza){
        
        //Variabile da restituire
        int x = 0;
        //Variabile per il bordo
        int offset = 80;
        //Delta della coordinata
        int delta = point_mappa.x;
        //Calcolo il range massimo per la x
        /*xMax è compreso nel range quindi aggiungo 1
          ( r.nextInt(val) restituisce un intero da 0 a (val-1) )*/
        int xMax = larghezza_mappa - larghezza + 1;
        
        /*Continuo a cercare un nuovo valore della x se:
          - controlloX(x) = -1. X è in comune con il Giocatore
          - controlloX(x) non è divisibile per 40. In questo caso avrei degli
            spostamenti non omogenei nel gioco.
            ("controlloX(x)%40" e non "x%40" perchè è la distanza tra l'oggetto
            e il giocatore a dover essere modulo 40.)*/
        
        //Calcolo almeno una volta
        do{
            
            //La mappa ha una x negativa => devo estendere il range di delta
            x = r.nextInt(xMax - (2*offset)) + delta + offset;
            
        }while((controlloX(x) < 0) || (((controlloX(x))%modulo_x) != 0));
        
        //Restituisco il valore calcolato
        return x;
        
    }
    
    //Metodo per generare casualmente la coordinata y
    private int yCasuale(int altezza){
        
        //Variabile da restituire
        int y = 0;
        //Variabile per il bordo
        int offset = 80;
        //Delta della coordinata
        int delta = point_mappa.y;
        //Calcolo il range massimo per la y
        /*yMax è compreso nel range quindi aggiungo 1
          ( r.nextInt(val) restituisce un intero da 0 a (val-1) )*/
        int yMax = altezza_mappa - altezza + 1;
        
        /*Continuo a cercare un nuovo valore della y se:
          - controlloY(y) = -1. X è in comune con il Giocatore
          - controlloY(y) non è divisibile per 40. In questo caso avrei degli
            spostamenti non omogenei nel gioco.
            ("controlloY(y)%40" e non "y%40" perchè è la distanza tra l'oggetto
            e il giocatore a dover essere modulo 40)*/
        
        //Calcolo almeno una volta
        do{
        
            //La mappa ha una y negativa => devo estendere il range di delta
            y = r.nextInt(yMax - (2*offset)) + delta + offset;
        
        }while((controlloY(y) < 0) || (((controlloY(y))%modulo_y) != 0));
        
        //Restituisco il valore calcolato
        return y;
        
    }
    
    //Metodo per controllare se il giocatore sarà a destra o sinistra dell'oggetto.   
    /*Se la x calcolata coincide con quella del Giocatore restituisco -1 per
      ricalcolarla in quanto il nuovo oggetto potrebbe essere sovrapposto al
      giocatore (dipende anche dalla y). */
    private int controlloX(int x){
        
        //Giocatore a dx dell'oggetto
        if((x + 80) <= point_giocatore.x) return (point_giocatore.x - (x + 80));
        //Giocatore a sx dell'oggetto
        else if ((point_giocatore.x + 80) <= x) return (x - (point_giocatore.x + 80));
        //Giocatore e l'oggetto hanno la stessa x
        else return -1;
        
    }
    
    //Metodo per controllare se il giocatore sarà sopra o sotto l'oggetto.   
    /*Se la y calcolata coincide con quella del Giocatore restituisco -1 per
      ricalcolarla in quanto il nuovo oggetto potrebbe essere sovrapposto al
      giocatore (dipende anche dalla x). */
    private int controlloY(int y){
        
        //Giocatore sotto l'oggetto
        if((y + 120) <= point_giocatore.y) return (point_giocatore.y - (y + 120));          
        //Giocatore sopra l'oggetto
        else if ((point_giocatore.y + 120) <= y) return (y - (point_giocatore.y + 120));
        //Giocatore e l'oggetto hanno la stessa y
        else return -1;
    }
    
    //Metodo per controllare le sovrapposizioni
    private boolean controlloSovrapposizione(Point p, Albero[] alberi, int num_alberi){
        
        //Risultato da restituire
        boolean risultato = false;
        
        /*Ipotizzo il bordo del personaggio con le coordinate calcolate e
          l'eventuale spostamento*/
        Rectangle r = new Rectangle(p.x - 40, p.y - 40, 120, 160);
        
        //Ciclo cercando almeno una sovrapposizione con un albero
        int i = 0;
        while(!risultato && i < num_alberi){
            
            risultato = r.intersects(alberi[i].getBordi());
            i++;
            
        }
        
        return risultato;
        
    }
    
}

// *** COMMENTI ULTIMATI ***
/*
 **************************************************************
 *                     2015(c) Project by                     *
 *                                                            *
 *                      Andrea  Petrella                      *
 *                                                            *
 *  Gioco creato per l'esame di Programmazione e Laboratorio  *
 **************************************************************
 */
package personaggi;

import helpers.Finestra;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Andrea
 */

/*Traliccio è la classe che gestisce gli oggetti grafici di tipo traliccio.
  Estende la classe OggettoGrafico perché gli oggetti della classe vanno
  disegnati nel Canvas principale.*/
public class Traliccio extends OggettoGrafico {
    
    //Metodo costruttore
    public Traliccio(BufferedImage img, BufferedImage ombra, Albero[] alberi, int num_alberi){
        
        //Inizializzo i punti e le immagini dell'oggetto e della sua ombra
        this.punto = new Point();
        this.punto_ombra = new Point();
        this.immagine = img;
        this.immagine_ombra = ombra;
        //Creo le coordinate del Traliccio
        CreaCoordinate(alberi, num_alberi);
        //Dal momento che viene creato, attivo l'oggetto
        this.attivo = true;
        
    }
    
    /*Metodo per ricevere la direzione del traliccio. Serve all'aiutante per
      dare indicazioni sulla posizione del traliccio.*/
    public String getDirezione(Point point_giocatore){
        
        String direzione = new String();
        int scarto_x = Finestra.larghezza - (Finestra.larghezza / 10);
        int scarto_y = Finestra.altezza - (Finestra.altezza / 10);
        
        //Nord
        if(this.punto.y + scarto_y < point_giocatore.y){ 
            if(this.punto.x + scarto_x < point_giocatore.x) direzione = "a Nord-Ovest rispetto a noi.";
            else if(this.punto.x > point_giocatore.x + scarto_x) direzione = "a Nord-Est rispetto a noi.";
            else direzione = "a Nord rispetto a noi.";
        }
        //Sud
        else if(this.punto.y > point_giocatore.y + scarto_y){
            if(this.punto.x + scarto_x < point_giocatore.x) direzione = "a Sud-Ovest rispetto a noi.";
            else if(this.punto.x > point_giocatore.x + scarto_x) direzione = "a Sud-Est rispetto a noi.";
            else direzione = "a Sud rispetto a noi.";            
        }
        //Centro
        else{
            if(this.punto.x + scarto_x < point_giocatore.x) direzione = "a Ovest rispetto a noi.";
            else if(this.punto.x > point_giocatore.x + scarto_x) direzione = "a Est rispetto a noi.";
            else direzione = "qui vicino.";                 
        }
        
        return direzione;
        
    }
    
}

// *** COMMENTI ULTIMATI ***
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

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Andrea
 */

/*Albero2 è la classe che gestisce gli oggetti riguardanti gli alberi.
  Estende la classe OggettoGrafico perché gli oggetti della classe vanno
  disegnati nel Canvas principale.*/
public class Albero extends OggettoGrafico{
    
    //Metodo costruttore
    public Albero(BufferedImage img, BufferedImage ombra, int x, int y){
        
        //Inizializzo i punti e le immagini dell'oggetto e della sua ombra
        this.punto = new Point();
        this.punto_ombra = new Point();
        this.punto.x = x;
        this.punto.y = y;
        this.immagine = img;
        this.immagine_ombra = ombra;
        //Dal momento che viene creato, attivo l'oggetto
        this.attivo = true;
        
    }
    
}

// *** COMMENTI ULTIMATI ***
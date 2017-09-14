/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaggi;

import helpers.CoordinateCasuali;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author andre
 */

/*OggettoGrafico è la classe responsabile di delineare tutte le costanti,
  le variabili e i metodi tipici di tutti gli oggetti disegnabile nel gioco.*/
public class OggettoGrafico {
    
    //Definisco larghezza e altezza degli oggetti grafici
    static final int larghezza = 80;
    static final int altezza = 120;
    /*Per ogni oggetto grafico è definiti:
      - un punto con due coordinate (x, y)*/
    Point punto = null;
    //- un punto per l'ombra con due coordinate (x, y)
    Point punto_ombra = null;
    //- un'immagine
    BufferedImage immagine = null;
    //- l'immagine dell'ombra
    BufferedImage immagine_ombra = null;
    //Costante per l'altezza dell'immagine dell'ombra
    static final int altezza_ombra = 22;
    //Ogni oggetto grafico ai fini del gioco ha una varibile per il suo stato
    boolean attivo = false;
    
    //Metodo per disegnare un oggetto grafico
    public void disegna(Graphics g){
        
        //L'oggetto è disegnato solo se attivo
        if(attivo){
            
            //Calcolo le coordinate dell'ombra
            this.punto_ombra.x = punto.x;
            this.punto_ombra.y = punto.y + altezza - altezza_ombra/2;
        
            //Disegno oggetto grafico la relativa ombra
            g.drawImage(immagine_ombra, punto_ombra.x, punto_ombra.y, larghezza, altezza_ombra, null);
            g.drawImage(immagine, this.punto.x, this.punto.y, larghezza, altezza, null);
            
        }
        
    }
    
    //Metodo per creare le coordinate dell'oggetto in modo casuale
    public void CreaCoordinate(Albero[] alberi, int num_alberi){
        
        /*Utilizzo un oggetto CoordinateCasuali per generare un punto e
          assegnarlo con il metodo puntoCasuale*/
        CoordinateCasuali rand = new CoordinateCasuali();
        
        this.punto = rand.puntoCasuale(this.larghezza, this.altezza, alberi, num_alberi);
        
    }
    
    //Metodo per attivare l'oggetto
    public void attiva(){
        
        this.attivo = true;
        
    }
    
    //Metodo per disattivare l'oggetto
    public void disattiva(){
        
        this.attivo = false;
        
    }
    
    //Metodo per spostare gli oggetti grafici verso l'alto
    public void spostaSu(int velocita){
        
        punto.y -= velocita;
        
    }
    
    //Metodo per spostare gli oggetti grafici verso destra
    public void spostaDestra(int velocita){
        
        punto.x += velocita;
        
    }
    
    //Metodo per spostare gli oggetti grafici verso il basso
    public void spostaGiu(int velocita){
        
        punto.y += velocita;
        
    }
    
    //Metodo per spostare gli oggetti grafici verso sinistra
    public void spostaSinistra(int velocita){
        
        punto.x -= velocita;
        
    }
    
    //Metodo Getter per la variabile larghezza
    public static int getAltezza(){
        
        return altezza;
        
    }
    
    //Metodo Getter per la variabile larghezza
    public static int getLarghezza(){
        
        return larghezza;
        
    }    
    
    //Metodo Getter per la variabile punto
    public Point getPunto(){
        
        return this.punto;
        
    }
    
    //Metodo Getter per la variabile x
    public int getX(){
        
        return this.punto.x;
        
    }
    
    //Metodo Getter per la variabile Y
    public int getY(){
        
        return this.punto.y;
        
    }
    
    //Metodo per restituire un Rectangle rappresentativo dei bordi dell'oggetto
    public Rectangle getBordi(){
        
        return new Rectangle(this.punto.x, this.punto.y, larghezza, altezza);
        
    }
    
}

// *** COMMENTI ULTIMATI ***
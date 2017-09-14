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

/*Giocatore è la classe che gestisce gli oggetti grafici di tipo giocatore.
  Estende la classe Personaggio perché è un oggetto grafico che si muove nel
  gioco cambiando la sua immagine in funzione dello spostamento.*/
public class Giocatore extends Personaggio {
    
    //Metodo costruttore
    public Giocatore(BufferedImage[] img_array, BufferedImage ombra, int x, int y){
        
        //Inizializzo gli array delle immagini direzionali
        int i;
        
        for(i = 0; i < 3; i++){
            
            this.img_array_giu[i] = img_array[i];
            
        }
        
        for(; i < 6; i++){
            
            this.img_array_sx[i - 3] = img_array[i];
            
        }
        
        for(; i < 9; i++){
            
            this.img_array_dx[i - 6] = img_array[i];
            
        }
        
        for(; i < 12; i++){
            
            this.img_array_su[i - 9] = img_array[i];
            
        }
        
        //Richiamo il metodo per settare l'immagine iniziale
        setImgDefoult();
        //Setto l'immagine dell'ombra
        this.immagine_ombra = ombra;
        //Setto i punti del giocatore e della sua ombra
        this.punto = new Point();
        this.punto_ombra = new Point();
        this.punto.x = x;
        this.punto.y = y;
        //Dal momento che viene creato, attivo l'oggetto
        attiva();
        
    }
    
    //Metodo Setter per la variabile X
    public void setPointX(int x){
        this.punto.x = x;
    }
    
    //Metodo Setter per la variabile Y
    public void setPointY(int y){
        this.punto.y = y;
    }
        
    /*Qui di seguito gli Override servono a far cambiare l'immagine del
      giocatore anche quando la schermata rimane ferma
      (vicino ai bordi della mappa)*/
    
    //Metodo per spostare gli oggetti Giocatore verso l'alto
    @Override
    public void spostaSu(int velocita){
               
        scegliImgSu();
        punto.y -= velocita;
        
    }
    
    //Metodo per spostare gli oggetti Giocatore verso destra
    @Override
    public void spostaDestra(int velocita){
                
        scegliImgDx();
        punto.x += velocita;
        
    }
    
    //Metodo per spostare gli oggetti Giocatore verso il basso
    @Override
    public void spostaGiu(int velocita){
                
        scegliImgGiu();
        punto.y += velocita;
        
    }
    
    //Metodo per spostare gli oggetti Giocatore verso sinistra
    @Override
    public void spostaSinistra(int velocita){
                
        scegliImgSx();
        punto.x -= velocita;
        
    }
    
}

// *** COMMENTI ULTIMATI ***
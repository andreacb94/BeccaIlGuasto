/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaggi;

import java.awt.image.BufferedImage;

/**
 *
 * @author andre
 */

/*Personaggio è la classe che gestisce gli oggetti grafici che si muovono nel
  gioco cambiando la loro immagine in funzione dello spostamento.
  Estende la classe OggettoGrafico perchè gestisce degli oggetti grafici.*/
public class Personaggio extends OggettoGrafico {
    
    //Array per le immagini direzionali
    BufferedImage[] img_array_su = new BufferedImage[3];
    BufferedImage[] img_array_giu = new BufferedImage[3];
    BufferedImage[] img_array_sx = new BufferedImage[3];
    BufferedImage[] img_array_dx = new BufferedImage[3];
    //Puntatori per gli array direzionali
    int pos_su = 2;
    int pos_giu = 2;
    int pos_dx = 2;
    int pos_sx = 2;
    //Variabili per controllare il verso di rotaizone delle immagini
    boolean verso_su = false;
    boolean verso_giu = false;
    boolean verso_dx = false;
    boolean verso_sx = false;
    
    //Metodo per effettuare una rotazione delle immaggini in base al movimento
    public int scegliImmagine(int pos, boolean verso, BufferedImage[] img_array){
        
        this.immagine = img_array[pos];
        if(verso) pos++;
        else pos--;
        
        return pos;
    }
    
    /*Metodi per discernere l'immagine da passare al metodo scegliImmagine e per
      evitare underflow e overflow dei puntatori.*/
    public void scegliImgSx(){
                
        if(this.pos_sx == 3){
            this.verso_sx = false;
            this.pos_sx-= 2;
        }
        else if(this.pos_sx == -1){
            this.verso_sx = true;
            this.pos_sx+=2;
        }
        
        this.pos_sx = scegliImmagine(this.pos_sx, this.verso_sx, this.img_array_sx);
                
    }
    public void scegliImgSu(){
        
        if(this.pos_su == 3){
            this.verso_su = false;
            this.pos_su-=2;
        }
        else if(this.pos_su == -1){
            this.verso_su = true;
            this.pos_su+=2;
        }
        
        this.pos_su = scegliImmagine(this.pos_su, this.verso_su, this.img_array_su);
        
    }
    public void scegliImgDx(){
        
        if(this.pos_dx == 3){
            this.verso_dx = false;
            this.pos_dx-=2;
        }
        else if(this.pos_dx == -1){
            this.verso_dx = true;
            this.pos_dx+=2;
        }
        
        this.pos_dx = scegliImmagine(this.pos_dx, this.verso_dx, this.img_array_dx);
        
    }
    public void scegliImgGiu(){
        
        if(this.pos_giu == 3){
            this.verso_giu = false;
            this.pos_giu-=2;
        }
        else if(this.pos_giu == -1){
            this.verso_giu = true;
            this.pos_giu+=2;
        }
        
        this.pos_giu = scegliImmagine(this.pos_giu, this.verso_giu, this.img_array_giu);
        
    }
    
    //Metodo per settare l'immagine di defoult
    public void setImgDefoult(){
        
        this.immagine = img_array_giu[1];
        
    }
    
}

// *** COMMENTI ULTIMATI ***
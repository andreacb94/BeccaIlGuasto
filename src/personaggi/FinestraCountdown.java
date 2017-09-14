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

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Andrea
 */

/*FinestraCountdown è la classe che gestisce gli oggetti grafici che
  visualizzano lo scorrere del tempo del timer.
  Estende la classe OggettoGrafico perché gli oggetti della classe vanno
  disegnati nel Canvas principale.*/
public class FinestraCountdown extends OggettoGrafico {
    
    //***VARIABILI, COSTANTI E OGGETTI DI ISTANZA***
    //Setto la larghezza e l'altezza del rettangolo del timer
    private int larghezza_countdown = 170, altezza_countdown = 50;
    //Variabile per il testo da stampare
    private String testo = "", livello = "";
    //Variabili per la codifica del tempo in modalità "timer"
    private int min = 0, sec = 0, deci = 0;
    
    //Metodo costruttore
    public FinestraCountdown(String l){
        
        //Setto le coordinate della finestra del countdown
        this.punto = new Point();
        CreaCoordinate();
        this.livello = l;
        //Dal momento che viene creato, attivo l'oggetto
        attiva();
        
    }
    
    //Metodo per creare le coordinate dell'oggetto
    private void CreaCoordinate(){
        
        this.punto = new Point(80, 80);
        
    }
            
    //Metodo per disegnare l'oggetto FinestraCountdown
    @Override
    public void disegna(Graphics g){
        
        //Disegna solo se l'oggetto è attivo
        if(attivo){
            
            //Scelgo il font
            g.setFont(new Font("German", Font.BOLD, 50));
            //Disegno una cornice con triplo rettangolo
            g.setColor(Color.white);
            g.drawRect(this.punto.x - 10, this.punto.y - 44, larghezza_countdown, altezza_countdown);
            g.setColor(Color.black);
            g.drawRect(this.punto.x - 11, this.punto.y - 45, larghezza_countdown+2, altezza_countdown+2);
            g.setColor(Color.white);
            g.drawRect(this.punto.x - 12, this.punto.y - 46, larghezza_countdown+4, altezza_countdown+4);
            
            //Setto il testo nel formato "timer"
            setTesto();
            
            //Disegno il testo
            g.drawString(this.testo, this.punto.x, this.punto.y);
            
            //Scelgo il font
            g.setFont(new Font("German", Font.BOLD, 50));
            //Disegno una cornice con triplo rettangolo
            g.setColor(Color.white);
            g.drawRect(this.punto.x - 10 + 450, this.punto.y - 44, larghezza_countdown + 98, altezza_countdown);
            g.setColor(Color.black);
            g.drawRect(this.punto.x - 11 + 450, this.punto.y - 45, larghezza_countdown+2 + 98, altezza_countdown+2);
            g.setColor(Color.white);
            g.drawRect(this.punto.x - 12 + 450, this.punto.y - 46, larghezza_countdown+4 + 98, altezza_countdown+4);
            
            //Disegno il testo
            g.drawString(this.livello, this.punto.x + 450, this.punto.y);
            
        }
        
    }
    
    //Metodo per creare il testo in formato "timer"
    public void setTesto(){
        
        if(sec < 10){
            this.testo = min + ":0" + sec + ":" + deci;
        }
        else{
            this.testo = min + ":" + sec + ":" + deci;
        }
                
    }
    
    //Setto i minuti
    public void setMin(int m){
        this.min = m;
    }
    
    //Setto i secondi
    public void setSec(int s){
        this.sec = s;
    }
    
    //Setto i decimi di secondo
    public void setDeci(int c){
        this.deci = c;
    }
    
    //Metodo per creare il testo in formato "timer"
    public void setLivello(String l){
        
        this.livello = l;
                
    }
    
}

// *** COMMENTI ULTIMATI ***
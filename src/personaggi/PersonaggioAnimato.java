/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaggi;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */

/*PersonaggioAnimato è la classe che gestisce i personaggi che si muovono nel
  gioco in maniera indipendente.
  Estende la classe Personaggio perchè gestisce sempre personaggi in movimento.
  implementa l'interfaccia Runnable per definire Thread indipendenti nel gioco.*/
public abstract class PersonaggioAnimato extends Personaggio implements Runnable {
    
    //Variabile per verificare se l'oggetto è ancora presente nel gioco
    boolean in_gioco = false;
    //Variabile per verificare se l'oggetto è in pausa
    boolean in_pausa = true;
    //Variabile per verificare l'avvenuta interazione col giocatore
    int interazione = 0;
    //Costante per la variazione di posizione negli spostamenti
    final int velocita = 40;
    //Variabile per il bordo
    int offset = 80;
    //Variabile per gestire l'animazione
    int animazione = 1;
    //Contatore per usare il primo ciclo dopo l'interazione con il giocatore
    int cont = 0;
    
    //Oggetti per verificare le interazioni
    Giocatore giocatore;
    Traliccio traliccio;
    Albero[] alberi;
    int num_alberi;
    
    //Metodo per attivare l'oggetto
    public void inGioco(){
        
        this.in_gioco = true;
        
    }
    
    //Metodo per disattivare l'oggetto
    public void nonInGioco(){
        
        this.in_gioco = false;
        
    }
    
    //Metodo per gestire la pausa del Thread
    void pausa(int n){
        
        //Costante contenente il valore di ms di pausa
        final int tempo = 20;
        
        //Effettuo n pause da 20 ms
        for(int i = 0; i < n; i++){
            
            //Gestisco l'eccezione
            try {
                Thread.sleep(tempo);//Rallento l'aggiornamento del Thread
            }
            catch (InterruptedException ex) {
                System.out.println("ERRORE! Thread.sleep() non eseguito");
                Logger.getLogger(Giocatore.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    //Metodo Setter per la variabile animazione
    public void setAnimazione(int s){
        
        this.animazione = s;
        
    }
    
    //Getter per la variabile in_gioco
    public boolean getIn_gioco(){
        
        return this.in_gioco;
        
    }
    
    //Setter per la variabile interazione
    public void setInterazione(int b){
        
        this.interazione = b;
        
    }
    
    //Getter per la variabile interazione
    public int getInterazione(){
        
        return this.interazione;
        
    }
    
    //Getter per la variabile in_pausa
    public boolean getIn_Pausa(){
        return this.in_pausa;
    }
    
    //Setter per la variabile in_pausa
    public void setIn_Pausa(boolean b){
        
        this.in_pausa = b;
        
    }    
    
    //Metodo per far ripartire un PersonaggioAnimato
    public void restart(){
        
        setInterazione(0);
        inGioco();
        setIn_Pausa(false);
        setImgDefoult();
        this.cont = 0;
        
    }
    
    /*Sovrascrivo il metodo disegna() della superclasse perché gli oggetti
      PersonaggioAnimato spariscono dal gioco dopo l'interazione e quindi non
      devono essere disegnati sempre.*/
    @Override
    public void disegna(Graphics g){
        
        //Disegna solo se l'oggetto è in_gioco
        if(in_gioco){
            
            this.punto_ombra.x = punto.x;
            this.punto_ombra.y = punto.y + altezza - altezza_ombra/2;
        
            g.drawImage(immagine_ombra, punto_ombra.x, punto_ombra.y, larghezza, altezza_ombra, null);
            g.drawImage(immagine, this.punto.x, this.punto.y, larghezza, altezza, null);
            
        }
        
    }
    
}

// *** COMMENTI ULTIMATI ***
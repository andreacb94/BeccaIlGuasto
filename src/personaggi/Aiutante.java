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

import finestre.Gioco;
import helpers.GestoreCollisioni;
import helpers.UscitaDiScena;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Andrea
 */

/*Aiutante è la classe che gestisce i personaggi di tipo aiutante.
  Estende la classe PersonaggioAnimato perché gli oggetti della classe sono
  Thread che godono di un'animazione propria e indipendente.*/
public class Aiutante extends PersonaggioAnimato {
    
    Antagonista antagonista;
    
    //Metodo costruttore
    public Aiutante(BufferedImage[] img_array, Giocatore giocatore, Antagonista antagonista, Traliccio traliccio, BufferedImage ombra, Albero[] alberi, int num_alberi){
        
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
        //Acquisisco gli altri oggetti grafici per poter gestire le interazioni
        this.giocatore = giocatore;
        this.antagonista = antagonista;
        this.traliccio = traliccio;
        this.alberi = alberi;
        this.num_alberi = num_alberi;
        
        //Creo casualmente le coordinate dell'oggetto
        this.punto = new Point();
        this.punto_ombra = new Point();
        CreaCoordinate(alberi, num_alberi);
        //Dal momento che viene creato, in_gioco l'oggetto
        inGioco();
        this.in_pausa = false;
        this.attivo = true;
        
        this.interazione = 0;
                
    }
    
    /*Sovrascrivo il metodo run() della superclasse Thread per gestire
      l'interattività di ogni oggetto*/
    @Override
    public void run(){
        
        //Aggiorno le caratteristiche dell'oggetto fino a quando è in_gioco
        while(attivo){
            
            /*Controllo se gli oggetti grafici possano compenetrarsi a seguito
              dello spostamento dell'ogetto Antagonista in modo da evitarlo*/
            if(in_gioco) GestoreCollisioni.controllaSovrapposizioneAiutante(giocatore, traliccio, this, antagonista, alberi, num_alberi);

            
            /*Richiamo il metodo aggiorna() per eseguire l'animazione
              dell'oggetto solo se non è in pausa*/
            if(!in_pausa) aggiorna();
            else pausa(1);
            
        }
    }
    
    //Metodo aggiorna() per creare l'animazione degli oggetti Aiutante
    private void aggiorna(){
        
        //Controllo se c'è stata un'interazione con il Giocatore
        if(interazione != 0){
            
            //Metto in pausa solo al primo ciclo dopo l'interazione
            if(cont == 0){
                
                pausa(300);
                cont++;
                
            }
            
            //Richiamo il metodo per far uscire di scena l'antagonista
            UscitaDiScena.uscitaAiutante(this, velocita);
            
            pausa(15);
            
        }
        
        //Caso in cui non c'è stata un'interazione con il Giocatore
        else{
               
            /*Creo un intero casuale da 0 a 5 per far spostare l'aiutante in una
              delle 4 direzioni in maniera casuale o farlo stare fermo*/
            Random rand = new Random();
            int r = 0;
            r = rand.nextInt(6);
                
            /*Controllo il numero casuale in modo da scegliere la direzione
              dello spostamento*/
            switch(r){
            
                /*Faccio spostare in una direzione solo se:
                  - non si trova allineato con il Giocatore in quella direzione
                  - non esce dal bordo della mappa*/            
                case 1:
                
                    if((animazione != 4) && ((this.punto.x + 80) < (Gioco.getLarghezza_mappa() + Gioco.getPoint_mappa().x - offset))){
                        
                        scegliImgDx();
                        this.spostaDestra(velocita);
                    }
                    break;
                
                case 2:
                
                    if((animazione != 3) && ((this.punto.x) > Gioco.getPoint_mappa().x + offset)){
                        
                        scegliImgSx();
                        this.spostaSinistra(velocita);
                    }
                    break;
                
                case 3:
                
                    if((animazione != 1) && ((this.punto.y) > Gioco.getPoint_mappa().y + offset)){
                        
                        scegliImgSu();
                        this.spostaSu(velocita);
                    }
                    break;
                
                case 4:
                
                    if((animazione != 2) && ((this.punto.y + 120) < (Gioco.getAltezza_mappa() + Gioco.getPoint_mappa().y - offset))){
                        
                        scegliImgGiu();
                        this.spostaGiu(velocita);
                    }
                    break;
                
                //Altrimenti sta fermo
                default: break;
            
            
            }
            
            /*Ad ogni aggiornamento faccio stare fermo l'aiutante per qualche
              secondo. La pausa è qui perché così ho il tempo di cambiare le
              impostazioni in caso di contatto con il giocatore prima che
              l'aiutante si sposti di nuovo*/
            pausa(40);
            
        }
                        
    }
    
}

// *** COMMENTI ULTIMATI ***
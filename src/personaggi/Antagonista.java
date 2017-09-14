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

import helpers.GestoreCollisioni;
import helpers.UscitaDiScena;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Andrea
 */

/*Antagonista è la classe che gestisce i personaggi di tipo antagonista.
  Estende la classe PersonaggioAnimato perché gli oggetti della classe sono
  Thread che godono di un'animazione propria e indipendente.*/
public class Antagonista extends PersonaggioAnimato {
    
    Aiutante aiutante;
    
    //Metodo costruttore
    public Antagonista(BufferedImage[] img_array, Giocatore giocatore, Traliccio traliccio, BufferedImage ombra, Albero[] alberi, int num_alberi){
        
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
        this.traliccio = traliccio;
        this.alberi = alberi;
        this.num_alberi = num_alberi;
        
        //Creo casualmente le coordinate dell'oggetto
        this.punto = new Point();
        this.punto_ombra = new Point();
        CreaCoordinate(alberi, num_alberi);
        //Dal momento che viene creato, abilito l'oggetto
        inGioco();
        in_pausa = false;
        attivo = true;
        
        this.animazione = 0; //ERRORE DI CODIFICA DA RISOLVERE TRA ANTAGONISTA E AIUTANTE
        this.interazione = 0;
        
    }
    
    //Sovrascrivo il metodo run() per gestire l'interattività del Thread
    @Override
    public void run(){
        
        //Aggiorno le caratteristiche dell'oggetto fino a quando è attivo
        while(attivo){
            
            /*Controllo se gli oggetti grafici possano compenetrarsi a seguito
              dello spostamento dell'ogetto Antagonista in modo da evitarlo*/
            if(in_gioco) GestoreCollisioni.controllaSovrapposizioneAntagonista(giocatore, traliccio, aiutante, this, alberi, num_alberi);
            /*Richiamo il metodo aggiorna() per eseguire l'animazione
              dell'oggetto solo se non è in pausa*/
            if(!in_pausa) aggiorna();
            else pausa(1);
            
        }
        
    }
    
    //Metodo aggiorna() per creare l'animazione degli oggetti Antagonista
    private void aggiorna(){
        
        //Controllo se c'è stata un'interazione con il Giocatore
        if(interazione != 0){
            
            //Richiamo il metodo per far uscire di scena l'antagonista
            UscitaDiScena.uscitaAntagonista(this, velocita);
            
            pausa(15);
            
        }
        
        //Caso in cui non c'è stata un'interazione con il Giocatore
        else{
        
            /*In base al valore della variabile animazione, sposto l'oggetto
              Antagonista in una delle 4 direzioni oppure sta fermo.
              Se il Giocatore ha una coordinata in comune con l'Antagonista,
              quest'ultimo lo insegue.*/
            switch (animazione){
            
                //In tutti i casi scelgo l'immagine adatta allo spostamento
                
                //Giocatore sopra l'Antagonista
                case 1:
                    
                    scegliImgSu();
                    this.spostaSu(velocita);
                    break;
                
                //Giocatore sotto l'Antagonista
                case 2:
                
                    scegliImgGiu();
                    this.spostaGiu(velocita);
                    break;
                
                    //Giocatore a sinistra dell'Antagonista
                case 3:
                
                    scegliImgSx();
                    this.spostaSinistra(velocita);
                    break;
                
                //Giocatore a destra dell'Antagonista
                case 4:
                
                    scegliImgDx();
                    this.spostaDestra(velocita);
                    break;
                
                //case 0: non fa niente e sta fermo
                default: break;
        
            }       
            
            /*Ad ogni aggiornamento faccio stare fermo l'antagonista per qualche
              secondo. La pausa è qui perché così ho il tempo di cambiare le
              impostazioni in caso di contatto con il giocatore prima che
              l'antagonista si sposti di nuovo*/
            pausa(4);
            
        }
        
    }
    
    //Setter per l'Aiutante
    public void setAiutante(Aiutante a) {
        
        this.aiutante = a;
        
    }
    
}

// *** COMMENTI ULTIMATI ***
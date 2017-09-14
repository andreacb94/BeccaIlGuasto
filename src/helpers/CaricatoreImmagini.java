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

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Andrea
 */

/*La classe CaricatoreImmagini, di seguito scritta, è una classe "helper" ovvero
  aiuta ad ottenere un codice più ordinato riducendo la scrittura dello stesso
  codice più volte.
  Il compito di CaricatoreImmagini è quello di caricare un'immagine da file,
  essendo questa una risorsa esterna.*/
public class CaricatoreImmagini {
    
    //Creo una variabile di Istanza BufferedImage per acquisire un'immagine
    BufferedImage immagine;
    /*Creo una stringa contenete l'indirizzo della cartella dove trovare le
      immagini*/
    String ind_cartella_img = "/immagini/";
    
    /*Il metodo caricaImmagine si occupa dell'effettiva lettura del file che
      salva nella variabile immagine*/
    public BufferedImage caricaImmagine(String nome_file){
        
        /*Gestisco l'eccezzione
          (potrebbe essere inserito un nome di file non corretto)*/
        try {
            
            //Leggo il contenuto del file e lo salvo nella variabile di Istanza
            immagine = ImageIO.read(getClass().getResource(ind_cartella_img + nome_file));
            
        }
        
        //Nel caso in cui c'è stato un errore nella lettura del file
        catch (IOException ex) {
            
            //Stampo sul terminale una frase di errore e lo aggiungo al Log
            System.out.println("ERRORE! Immagine " + nome_file + " non caricata correttamente!");
            Logger.getLogger(CaricatoreImmagini.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        //Restituisco l'immagine appena caricata
        return immagine;
        
    }
    
}

// *** COMMENTI ULTIMATI ***
/*
 **************************************************************
 *                     2015(c) Project by                     *
 *                                                            *
 *                      Andrea  Petrella                      *
 *                                                            *
 *  Gioco creato per l'esame di Programmazione e Laboratorio  *
 **************************************************************
 */
package finestre;

import finestre.pannelli.PannelloMenuStart;
import javax.swing.JFrame;

/**
 *
 * @author Andrea
 */

/*La classe Start ha il compito di creare il menù di gioco
  e avviarlo all'apertura dell'applicazione tramite il metodo main().
  Adesso estende la classe JFrame perché è una finestra di fatto.*/
public class Start2 extends JFrame{
    
    /*Di seguito definisco le costanti di classe riguardanti le dimensioni
      della finestra di gioco, impostata a 1320x720*/
    public static int larghezza = 1320;
    public static int altezza = 720;
    //Di seguito definisco il nome del gioco come una costante static
    private static final String nome_gioco = "Becca il guasto!";
    
    //Metodo costruttore
    public Start2(){
        
        //Creo la finestra
        creaFinestraStart();
        
        //Creo il pannello del menù e lo aggiungo alla finestra
        PannelloMenuStart menu = new PannelloMenuStart(this);
        add(menu);
        
        //Rendo visibile la finestra
        visualizzaFinestra();
        
    }    
    private void creaFinestraStart(){
        
        //Setto il titolo
        setTitle(nome_gioco);
        
        //Setto le dimensioni e blocco il ridimensionamento
        setSize(larghezza, altezza);
        setResizable(false);
        
    }
    private void visualizzaFinestra(){
        //Rendo visibile la finestra
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    //Metodo Main dell'applicazione
    public static void main(String[] args) {
        
        /*Creo un oggetto app della classe Start nel metodo main per avviare il
          gioco con il menù start*/
        Start2 app = new Start2();
        
    }

}
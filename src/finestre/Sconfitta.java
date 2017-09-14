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

import finestre.pannelli.PannelloMenuPausa;
import finestre.pannelli.PannelloMenuSconfitta;
import finestre.pannelli.PannelloMenuStart;
import static helpers.Finestra.altezza;
import static helpers.Finestra.larghezza;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Andrea
 */

/*La classe Start ha il compito di creare il menù di gioco
  e avviarlo all'apertura dell'applicazione tramite il metodo main().
  Adesso estende la classe JFrame perché è una finestra di fatto.*/
public class Sconfitta extends JFrame{
    
    /*Di seguito definisco le costanti di classe riguardanti le dimensioni
      della finestra di gioco, impostata a 1320x720*/
    public static int larghezza = 1320;
    public static int altezza = 720;
    //Di seguito definisco il nome del gioco come una costante static
    private static final String nome_gioco = "Pausa";
    
    //Metodo costruttore
    public Sconfitta(Gioco gioco, JFrame master){
        
        //Creo la finestra
        creaFinestraSconfitta();
        
        //Creo il pannello del menù e lo aggiungo alla finestra
        PannelloMenuSconfitta pannello = new PannelloMenuSconfitta(gioco, master, this);
        add(pannello);
        
        //Rendo visibile la finestra
        visualizzaFinestra();
        
    }    
    private void creaFinestraSconfitta(){
        
        //Setto il nome della pagina, simile al costruttore della superclasse
        setTitle("Hai perso!");        
        /*La finestra ha bisogno di 2 dimensioni, allora utilizzo un oggetto
          della classe Dimension per assegnare questi valori.*/
        Dimension dimensioni_finestra = new Dimension(larghezza, altezza);
        /*Setto le dimensioni del ContentPane della finestra in quanto volgio
          che la parte "visuale" della finestra sia ben definita in modo da
          avere il valore dei bordi in modo esplicito*/
        getContentPane().setPreferredSize(dimensioni_finestra);
        //La finestra non può essere ridimensionata
        setResizable(false);
        /*Gestisco la chiusura della finestra tramite il tasto X richiamando il
          metodo setDefaultCloseOperation() della superclasse.
          Qui chiudo solo la finestra senza chiudere l'applicazione.*/
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    private void visualizzaFinestra(){
        
        //Suggerische la guida, da controllare
        //Senza il metodo pack() non si estende, occhio!
        pack();
        setLocationRelativeTo(null); //Centro la finestra rispetto allo schermo
        setVisible(true); //Rendo visibile la finestra
                
    }
    
}
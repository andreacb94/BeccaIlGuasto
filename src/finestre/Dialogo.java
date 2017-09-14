/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finestre;

import finestre.pannelli.PannelloFinestraDialogo;
import finestre.pannelli.PannelloMenuStart;
import static finestre.pannelli.PannelloMenuStart.altezza;
import static finestre.pannelli.PannelloMenuStart.larghezza;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author andre
 */
public class Dialogo extends JDialog{
    
    public Dialogo(String text, JFrame finestra, String titolo){
        
        //Creo la finestra di dialogo
        creaFinestraDialogo(finestra, titolo);
        
        //Creo il pannello del menù e lo aggiungo alla finestra
        PannelloFinestraDialogo pannello = new PannelloFinestraDialogo(text, finestra, this);
        finestra.add(pannello);
        
        //Rendo visibile la finestra
        visualizzaFinestra(finestra);
        
    }
    
    //Metodo per la creazione di una finestra di dialogo dei personaggi
    private void creaFinestraDialogo(JFrame finestra, String titolo){
        
        larghezza = 1320;
        altezza = 720;
        
        //Setto il nome della pagina, simile al costruttore della superclasse
        finestra.setTitle(titolo);        
        /*La finestra ha bisogno di 2 dimensioni, allora utilizzo un oggetto
          della classe Dimension per assegnare questi valori.*/
        Dimension dimensioni_finestra = new Dimension(larghezza/4, altezza/4);
        /*Setto le dimensioni del ContentPane della finestra in quanto volgio
          che la parte "visuale" della finestra sia ben definita in modo da
          avere il valore dei bordi in modo esplicito*/
        finestra.getContentPane().setPreferredSize(dimensioni_finestra);
        finestra.setResizable(false); //La finestra non può essere ridimensionata
        /*Gestisco la chiusura della finestra tramite il tasto X richiamando il
          metodo setDefaultCloseOperation() della superclasse.
          Qui chiudo solo la finestra senza chiudere l'applicazione.*/
        finestra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
    }
    
    private void visualizzaFinestra(JFrame finestra){
        
        //Suggerische la guida, da controllare
        //Senza il metodo pack() non si estende, occhio!
        finestra.pack();
        finestra.setLocationRelativeTo(null); //Centro la finestra rispetto allo schermo
        finestra.setVisible(true); //Rendo visibile la finestra
                
    }
    
}

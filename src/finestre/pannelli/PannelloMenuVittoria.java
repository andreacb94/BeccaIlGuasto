/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finestre.pannelli;

import finestre.Crediti;
import finestre.Gioco;
import finestre.Impostazioni;
import helpers.CustomButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author andre
 */

/*Nuovo Helper per le finestre del gioco*/
public class PannelloMenuVittoria extends JPanel {
    /*Di seguito definisco le costanti di classe riguardanti le dimensioni
      della finestra di gioco, impostata a 1320x720*/
    public static int larghezza;
    public static int altezza;
    //Di seguito definisco il nome del gioco come una costante static
    private static final String nome_gioco = "Becca il guasto!";

    public PannelloMenuVittoria(Gioco gioco, JFrame master, JFrame finestra){
        
        aggiungiComponenti(gioco, master, finestra);
        
    }
    
    //Metodo per la finestra del menù start
    private void aggiungiComponenti(Gioco gioco, JFrame master, JFrame finestra){
        
        larghezza = 1320;
        altezza = 720;
        
        //Setto i margini
        ((FlowLayout)this.getLayout()).setVgap(altezza - 200);
        ((FlowLayout)this.getLayout()).setHgap((larghezza - (50*5*3))/5);
                
        //Creo i vari button
        /* *** CONTROLLARE I LISTENER CON IL VECCHIO HELPER *** */
        /*Creo 3 pulsanti per:
          - Giocare di nuovo
          - Tornare al menù principale
          - Uscire dal gioco e chiudere l'applicazione.*/
        CustomButton esci_bt = creaCustomButton(gioco, master, finestra, "ESCI");
        CustomButton gioca_bt = creaCustomButton(gioco, master, finestra, "GIOCA DI NUOVO");
        CustomButton next_bt = creaCustomButton(gioco, master, finestra, "NEXT LEVEL");
               
        
        //Aggiungo la casella di testo e i 3 pulsanti al pannello
        add(gioca_bt);
        add(next_bt);
        add(esci_bt);
        
        
    }
    
    //Metodo per creare un CustomButton
    private CustomButton creaCustomButton(Gioco gioco, JFrame master, JFrame finestra, String nome){
        
        CustomButton button = new CustomButton(nome);
        
        button.setAlignmentY(BOTTOM_ALIGNMENT);
        button.addActionListener(new AbstractAction() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                switch(nome){
                    
                    case "GIOCA DI NUOVO":
                        master.setEnabled(true);
                        finestra.dispose();//Chiudo la finestra attuale
                        /*Avvio un oggetto della classe Gioco per far partire la
                          schermata di gioco effettiva*/
                        gioco.restart();
                        break;
                    
                    case "ESCI":
                        System.exit(0);
                        break;
                        
                    case "NEXT LEVEL":
                        master.setEnabled(true);
                        finestra.dispose();//Chiudo la finestra attuale
                        /*Avvio un oggetto della classe Gioco per far partire la
                          schermata di gioco effettiva*/
                        gioco.nextLivel();
                        break;
                        
                    default: break;                       
                    
                }
            }
        });
        
        return button;
        
    }
    
    //Metodo per disegnare lo sfondo del menù
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon(Menu.class.getResource("/immagini/finestre/vittoria.png")).getImage(), 0, 0, larghezza, altezza, this);
    }
    
}

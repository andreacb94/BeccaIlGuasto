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
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */

/*Nuovo Helper per le finestre del gioco*/
public class PannelloMenuStart extends JPanel {
    /*Di seguito definisco le costanti di classe riguardanti le dimensioni
      della finestra di gioco, impostata a 1320x720*/
    public static int larghezza;
    public static int altezza;
    //Di seguito definisco il nome del gioco come una costante static
    private static final String nome_gioco = "Becca il guasto!";

    public PannelloMenuStart(JFrame finestra) {
        
        aggiungiComponenti(finestra);
        
    }
    
    //Metodo per la finestra del menù start
    private void aggiungiComponenti(JFrame finestra){
        
        larghezza = 1320;
        altezza = 720;
        
        //Setto i margini
        ((FlowLayout)this.getLayout()).setVgap(altezza - 200);
        ((FlowLayout)this.getLayout()).setHgap((larghezza - (50*5*3))/5);
                
        //Creo i vari button
        /* *** CONTROLLARE I LISTENER CON IL VECCHIO HELPER *** */
        
        CustomButton button_impostazioni = creaCustomButton("IMPOSTAZIONI", finestra);
        add(button_impostazioni);
        
        CustomButton button_gioca = creaCustomButton("GIOCA", finestra);
        add(button_gioca);
        
        CustomButton button_crediti = creaCustomButton("CREDITI", finestra);
        add(button_crediti);
        
    }
    
    //Metodo per creare un CustomButton
    private CustomButton creaCustomButton(String nome, JFrame finestra){
        
        CustomButton button = new CustomButton(nome);
        
        button.setAlignmentY(BOTTOM_ALIGNMENT);
        button.addActionListener(new AbstractAction() {
            
            Gioco gioco;
            @Override
            public void actionPerformed(ActionEvent e) {
                
                switch(nome){
                    
                    case "GIOCA":
                        finestra.dispose();//Chiudo la finestra attuale
                        /*Avvio un oggetto della classe Gioco per far partire la
                          schermata di gioco effettiva*/
                        gioco = new Gioco();
                        break;
                        
                        //Scrivo sulla riga di comando momentaneamente                        
                    case "IMPOSTAZIONI":
                        Impostazioni impostazioni = new Impostazioni();
                        break;
                        
                    case "CREDITI":
                        Crediti crediti = new Crediti();
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
        g.drawImage(new ImageIcon(Menu.class.getResource("/immagini/finestre/start.png")).getImage(), 0, 0, larghezza, altezza, this);
    }
    
}

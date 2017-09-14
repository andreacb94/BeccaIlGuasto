/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finestre.pannelli;

import finestre.Crediti;
import finestre.Dialogo;
import finestre.Gioco;
import finestre.Impostazioni;
import finestre.Start;
import helpers.CustomButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author andre
 */

/*Nuovo Helper per le finestre del gioco*/
public class PannelloFinestraDialogo extends JPanel {
    /*Di seguito definisco le costanti di classe riguardanti le dimensioni
      della finestra di gioco, impostata a 1320x720*/
    public static int larghezza;
    public static int altezza;
    
    public PannelloFinestraDialogo(String text, JFrame master, Dialogo finestra){
        
        aggiungiComponenti(text, master, finestra);
        
    }
    
    //Metodo per la finestra del menù start
    public void aggiungiComponenti(String text, JFrame master, Dialogo finestra){
        
        setLayout(new GridLayout(1,1,0,10));
        //Creo una casella di testo a più righe
        //Creo il font per il testo
        Font font1 = new Font(null, Font.BOLD, 18);
        JTextArea testo = new JTextArea();
        /* *** NON HO IDEA DEL PERCHE' HO MESSO QUESTE 2 COSE QUI SOTTO. CI STANNO O NO FA SEMPRE LO STESSO *** */
        DefaultCaret caret = (DefaultCaret)testo.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        /* *** */
        testo.setEditable(false); //Non è possibile scrivere qui
	testo.setFont(font1); //Setto il font alla casella di testo
	testo.setAlignmentX(JTextArea.LEFT_ALIGNMENT); //Setto l'allineamento
        testo.setLineWrap(true); //Il testo va a capo per non superare il bordo della finestra
        testo.setWrapStyleWord(true); //Non spezza la parola se quest'utima deve andare a capo
        testo.append(text); //Aggiungo il testo
        //Aggiungo la casella di testo al pannello
        add(testo);
        
    }
    
}

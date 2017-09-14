/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author andre
 */

/*Metodo Helper per i JButton personalizzati*/
public class CustomButton extends JButton implements MouseListener{
    
    //Dimensione
    Dimension size = new Dimension(250,150);
        
        //Unità per le varie misure
        int unit = 50;
        //Altezza e base massima dei button
        int h_max = 3 * unit;
        int b_max = 5 * unit;
        //Margine
        int margin = 7;
        //Grandezza del carattere
        int font_val = unit/2;
    
    //variabili per sfioramento e click
    boolean sfioramento = false;
    boolean click = false;
    
    //Testo del Button
    String testo = "";
    
    //Costruttore
    public CustomButton(String text){
        
        //Varie impostazioni di visualizzazione
        setVisible(true);
        setFocusable(true);
        setContentAreaFilled(false);
        setBorderPainted(false);
        
        //Aggiungo il testo
        this.testo = text;
        
        //Ovviamente ha il MouseListener per il click e lo sfioramento
        addMouseListener(this);
        
    }
    
    //Metodo per disegnare il button
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        //Se c'è il click
        if(click){
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, b_max, h_max);
        }
        
        //Se viene sfiorato il bordo è più chiaro
        g.setColor(new Color(255, 255, sfioramento ? 100 : 240));
        
        //4 rettangoli per fare i bordi
        g.fillRect(0, 0, b_max, margin);
        g.fillRect(0, h_max - margin, b_max, margin);
        g.fillRect(0, 0, margin, h_max);
        g.fillRect(b_max - margin, 0, margin, h_max);
        
        //Quadrato di sfondo
        g.setColor(new Color(255, 255, 240));
        g.fillRect((margin * 2), (margin * 2), (b_max - 28), (h_max - 28));
        
        //Impostazioni per il testo
        //Colore
        g.setColor(Color.DARK_GRAY);
        //Font
        g.setFont(Font.decode("arial-BOLD-" + font_val));
        //Posiziono al centro
        FontMetrics matrice = g.getFontMetrics();
        int larghezza_testo = matrice.stringWidth(testo);
        int altezza_testo = matrice.getHeight();
        g.drawString(testo, (b_max/2) - larghezza_testo/2, (h_max/2) + (altezza_testo/4));
    
    }
    
    //Forse non serviranno
    @Override
    public Dimension getPreferredSize(){
        return size;
    }
    
    @Override
    public Dimension getMaximumSize(){
        return size;
    }
    
    @Override
    public Dimension getMinimumSize(){
        return size;
    }
    
    public void setButtonText(String s){
        this.testo = s;
    }
    
    public String getButtonText(){
        return testo;        
    }
    
    //Listener per lo sfioramento
    @Override
    public void mouseEntered(MouseEvent e){
        this.sfioramento = true;
    }
    
    @Override
    public void mouseExited(MouseEvent e){
        this.sfioramento = false;
    }
    
    //Listener per il click
    @Override
    public void mousePressed(MouseEvent e){
        this.click = true;
    }
    
    @Override
    public void mouseReleased(MouseEvent e){
        this.click = false;
    }
    
    @Override
    public void mouseClicked(MouseEvent e){}
    
    public int getB_max(){
        return b_max;
    }
    
}

























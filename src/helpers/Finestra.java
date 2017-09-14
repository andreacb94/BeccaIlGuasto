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

import finestre.Gioco;
import finestre.Start;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Andrea
 */

/*La classe Finestra è stata creata per facilitare la gestione delle finestre
  del videogioco. Finestra è una sottoclasse di JFrame.
  Comprende sia le costanti caratteristiche di ogni finestra del programma, sia
  i vari metodi utili per creare, personalizzare e visualizzare le finestre.
  Finestra è una classe "helper" ovvero aiuta ad ottenere un codice più ordinato
  riducendo la scrittura dello stesso codice più volte.*/
public class Finestra extends JFrame{
    
    //***VARIABILI, COSTANTI E OGGETTI DI CLASSE***
    /*Di seguito definisco le costanti di classe riguardanti le dimensioni
      della finestra di gioco, impostata a 1320x720*/
    public static int larghezza = 1320;
    public static int altezza = 720;
    //Di seguito definisco il nome del gioco come una costante static
    private static final String nome_gioco = "Becca il guasto!";
    //Di seguito assegno i nomi descrittivi delle schermate principali del gioco
    private static final String gioco_nome_pulsante = "Gioca";
    private static final String impostazioni_nome_pulsante = "Impostazioni";
    private static final String crediti_nome_pulsante = "Crediti";
    //***VARIABILI, COSTANTI E OGGETTI DI ISTANZA***
    
    //Metodo per la creazione di una finestra principale
    public static void creaFinestraPrincipale(Finestra f){
        
        //Setto il nome della pagina, simile al costruttore della superclasse
        f.setTitle(nome_gioco);        
        /*La finestra ha bisogno di 2 dimensioni, allora utilizzo un oggetto
          della classe Dimension per assegnare questi valori.*/
        Dimension dimensioni_finestra = new Dimension(larghezza, altezza);
        /*Setto le dimensioni del ContentPane della finestra in quanto voglio
          che la parte "visiva" della finestra sia ben definita in modo da
          avere il valore dei bordi in modo esplicito.*/
        f.getContentPane().setPreferredSize(dimensioni_finestra);
        //La finestra non può essere ridimensionata
        f.setResizable(false);
        /*Gestisco la chiusura della finestra tramite il tasto X richiamando il
          metodo setDefaultCloseOperation() della superclasse.
          Qui chiudo l'applicazione.*/
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
        
    //Metodo per la creazione di una finestra per la sconfitta
    public static void creaFinestraPausa(Finestra f){
        
        //Setto il nome della pagina, simile al costruttore della superclasse
        f.setTitle("Pausa");        
        /*La finestra ha bisogno di 2 dimensioni, allora utilizzo un oggetto
          della classe Dimension per assegnare questi valori.*/
        Dimension dimensioni_finestra = new Dimension(larghezza/4, altezza/4);
        /*Setto le dimensioni del ContentPane della finestra in quanto volgio
          che la parte "visuale" della finestra sia ben definita in modo da
          avere il valore dei bordi in modo esplicito*/
        f.getContentPane().setPreferredSize(dimensioni_finestra);
        //La finestra non può essere ridimensionata
        f.setResizable(false);
        /*Gestisco la chiusura della finestra tramite il tasto X richiamando il
          metodo setDefaultCloseOperation() della superclasse.
          Qui chiudo solo la finestra senza chiudere l'applicazione.*/
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
    }

    //Metodo per la creazione di una finestra per la sconfitta
    public static void creaFinestraSconfitta(Finestra f){
        
        //Setto il nome della pagina, simile al costruttore della superclasse
        f.setTitle("Hai perso");        
        /*La finestra ha bisogno di 2 dimensioni, allora utilizzo un oggetto
          della classe Dimension per assegnare questi valori.*/
        Dimension dimensioni_finestra = new Dimension(larghezza/4, altezza/4);
        /*Setto le dimensioni del ContentPane della finestra in quanto volgio
          che la parte "visuale" della finestra sia ben definita in modo da
          avere il valore dei bordi in modo esplicito*/
        f.getContentPane().setPreferredSize(dimensioni_finestra);
        f.setResizable(false); //La finestra non può essere ridimensionata
        /*Gestisco la chiusura della finestra tramite il tasto X richiamando il
          metodo setDefaultCloseOperation() della superclasse.
          Qui chiudo solo la finestra senza chiudere l'applicazione.*/
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
    }
    
    //Metodo per la creazione di una finestra per la vittoria
    public static void creaFinestraVittoria(Finestra f){
        
        //Setto il nome della pagina, simile al costruttore della superclasse
        f.setTitle("Vittoria!");        
        /*La finestra ha bisogno di 2 dimensioni, allora utilizzo un oggetto
          della classe Dimension per assegnare questi valori.*/
        Dimension dimensioni_finestra = new Dimension(larghezza/4, altezza/4);
        /*Setto le dimensioni del ContentPane della finestra in quanto volgio
          che la parte "visuale" della finestra sia ben definita in modo da
          avere il valore dei bordi in modo esplicito*/
        f.getContentPane().setPreferredSize(dimensioni_finestra);
        f.setResizable(false); //La finestra non può essere ridimensionata
        /*Gestisco la chiusura della finestra tramite il tasto X richiamando il
          metodo setDefaultCloseOperation() della superclasse.
          Qui chiudo solo la finestra senza chiudere l'applicazione.*/
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
    }
    
    //Metodo per la creazione di una finestra di dialogo dei personaggi
    public static void creaFinestraDialogo(Finestra f, String titolo){
        
        //Setto il nome della pagina, simile al costruttore della superclasse
        f.setTitle(titolo);        
        /*La finestra ha bisogno di 2 dimensioni, allora utilizzo un oggetto
          della classe Dimension per assegnare questi valori.*/
        Dimension dimensioni_finestra = new Dimension(larghezza/4, altezza/4);
        /*Setto le dimensioni del ContentPane della finestra in quanto volgio
          che la parte "visuale" della finestra sia ben definita in modo da
          avere il valore dei bordi in modo esplicito*/
        f.getContentPane().setPreferredSize(dimensioni_finestra);
        f.setResizable(false); //La finestra non può essere ridimensionata
        /*Gestisco la chiusura della finestra tramite il tasto X richiamando il
          metodo setDefaultCloseOperation() della superclasse.
          Qui chiudo solo la finestra senza chiudere l'applicazione.*/
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
    }
    
    //Metodo per la creazione e l'aggiunta dei componenti della finestra sconfitta
    public static void aggiungiComponentiPausa(Finestra master, Finestra f, Gioco gioco){
        
        //Creo un contenitore per i vari elementi della finestra
        JPanel contenitore;
        //Riempio il contenitore con gli elementi da visualizzare in caso di vittoria
        contenitore = creaPannelloPausa(master, f, gioco);
        //Aggiungo il contenitore alla finestra
        f.add(contenitore);
        
    }
    
    //Metodo per la creazione e l'aggiunta dei componenti della finestra sconfitta
    public static void aggiungiComponentiSconfitta(Finestra master, Finestra f, Gioco gioco){
        
        //Creo un contenitore per i vari elementi della finestra
        JPanel contenitore;
        //Riempio il contenitore con gli elementi da visualizzare in caso di vittoria
        contenitore = creaPannelloSconfitta(master, f, gioco);
        //Aggiungo il contenitore alla finestra
        f.add(contenitore);
        
    }
    
    //Metodo per la creazione e l'aggiunta dei componenti della finestra vittoria
    public static void aggiungiComponentiVittoria(Finestra master, Finestra f, Gioco gioco){
        
        //Creo un contenitore per i vari elementi della finestra
        JPanel contenitore;
        //Riempio il contenitore con gli elementi da visualizzare in caso di vittoria
        contenitore = creaPannelloVittoria(master, f, gioco);
        //Aggiungo il contenitore alla finestra
        f.add(contenitore);
        
    }
    
    //Metodo per la creazione e l'aggiunta dei componenti della finestra di dialogo
    public static void aggiungiComponentiDialogo(String text, Finestra master, Finestra f){
        
        //Creo un contenitore per i vari elementi della finestra
        JPanel contenitore;
        //Riempio il contenitore con gli elementi da visualizzare in caso di dialogo
        contenitore = creaPannelloDialogo(text, master, f);
        //Aggiungo il contenitore alla finestra
        f.add(contenitore);
        
    }
    
    //Metodo per la creazione e l'aggiunta dei componenti del menù principale
    public static void aggiungiComponentiMenu(Finestra f){
        
        //Creo un contenitore per i vari elementi della finestra
        JPanel contenitore;
        //Assegno momentaneamente solo il pannello dei pulsanti
        contenitore = creaPannelloPulsantiMenu(f);
        //Aggiungo il contenitore alla finestra
        f.add(contenitore);
        
    }
    
    //Metodo per la creazione di un pannello contenente una casella di testo e 3 pulsanti
    private static JPanel creaPannelloPausa(Finestra master, Finestra f, Gioco gioco){
        
        //Creo un pannello contenitore per gli elementi con GridLayout per ora
        JPanel pannello = new JPanel();
        pannello.setLayout(new GridLayout(4,1,0,10));
        //Creazione di una casella di testo a una sola riga
        //Creo il font del testo
        Font font1 = new Font(null, Font.BOLD, 20);
        JTextField testo = new JTextField("Pausa");
        testo.setEditable(false); //Non è possibile scrivere qui
	testo.setFont(font1); //setto il font alla casella di testo
	testo.setHorizontalAlignment(JTextField.CENTER); //Setto l'allineamento
        /*Creo 3 pulsanti per:
          - Giocare di nuovo
          - Tornare al menù principale
          - Uscire dal gioco e chiudere l'applicazione.*/
        JButton continua_bt = creaPulsanteMenu(master, f, "Continua");
        JButton esci_bt = creaPulsanteMenu(master, f, "Esci");
        
        
        JButton gioca_bt = new JButton("Gioca di nuovo");
        
        gioca_bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                        master.setEnabled(true);
                        f.dispose();//Chiudo la finestra attuale
                        /*Avvio un oggetto della classe Gioco per far partire la
                          schermata di gioco effettiva*/
                        gioco.restart();
                        
            }
        });
        
        
        //Aggiungo la casella di testo e i 3 pulsanti al pannello
        pannello.add(testo);
        pannello.add(continua_bt);
        pannello.add(gioca_bt);
        pannello.add(esci_bt);
        
        //Restituisco il pannello appena creato
        return pannello;
        
    }
    
    //Metodo per la creazione di un pannello contenente una casella di testo e 3 pulsanti
    private static JPanel creaPannelloSconfitta(Finestra master, Finestra f, Gioco gioco){
        
        //Creo un pannello contenitore per gli elementi con GridLayout per ora
        JPanel pannello = new JPanel();
        pannello.setLayout(new GridLayout(3,1,0,10));
        //Creazione di una casella di testo a una sola riga
        //Creo il font del testo
        Font font1 = new Font(null, Font.BOLD, 20);
        JTextField testo = new JTextField("Hai perso");
        testo.setEditable(false); //Non è possibile scrivere qui
	testo.setFont(font1); //setto il font alla casella di testo
	testo.setHorizontalAlignment(JTextField.CENTER); //Setto l'allineamento
        /*Creo 3 pulsanti per:
          - Giocare di nuovo
          - Tornare al menù principale
          - Uscire dal gioco e chiudere l'applicazione.*/
        JButton gioca_bt = new JButton("Gioca di nuovo");
        
        gioca_bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                        master.setEnabled(true);
                        f.dispose();//Chiudo la finestra attuale
                        /*Avvio un oggetto della classe Gioco per far partire la
                          schermata di gioco effettiva*/
                        gioco.restart();
                        
            }
        });
        JButton esci_bt = creaPulsanteMenu(master, f, "Esci");
        //Aggiungo la casella di testo e i 3 pulsanti al pannello
        pannello.add(testo);
        pannello.add(gioca_bt);
        pannello.add(esci_bt);
        
        //Restituisco il pannello appena creato
        return pannello;
        
    }
    
    //Metodo per la creazione di un pannello contenente una casella di testo e 3 pulsanti
    private static JPanel creaPannelloVittoria(Finestra master, Finestra f, Gioco gioco){
        
        //Creo un pannello contenitore per gli elementi con GridLayout per ora
        JPanel pannello = new JPanel();
        pannello.setLayout(new GridLayout(4,1,0,10));
        //Creazione di una casella di testo a una sola riga
        //Creo il font del testo
        Font font1 = new Font(null, Font.BOLD, 20);
        JTextField testo = new JTextField("Hai vinto!");
        testo.setEditable(false); //Non è possibile scrivere qui
	testo.setFont(font1); //setto il font alla casella di testo
	testo.setHorizontalAlignment(JTextField.CENTER); //Setto l'allineamento
        /*Creo 3 pulsanti per:
          - Giocare di nuovo
          - Tornare al menù principale
          - Uscire dal gioco e chiudere l'applicazione.*/
        JButton gioca_bt = new JButton("Gioca di nuovo");
        
        gioca_bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                        master.setEnabled(true);
                        f.dispose();//Chiudo la finestra attuale
                        /*Avvio un oggetto della classe Gioco per far partire la
                          schermata di gioco effettiva*/
                        gioco.restart();
                        
            }
        });
        JButton next_bt = new JButton("Prossimo livello");
        
        next_bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                        master.setEnabled(true);
                        f.dispose();//Chiudo la finestra attuale
                        /*Avvio un oggetto della classe Gioco per far partire la
                          schermata di gioco effettiva*/
                        gioco.nextLivel();
                        
            }
        });
        
        JButton esci_bt = creaPulsanteMenu(master, f, "Esci");
        //Aggiungo la casella di testo e i 3 pulsanti al pannello
        pannello.add(testo);
        pannello.add(next_bt);
        pannello.add(gioca_bt);
        pannello.add(esci_bt);
        
        //Restituisco il pannello appena creato
        return pannello;
        
    }
    
    //Metodo per la creazione di un pannello contenente la casella di testo del dialogo
    private static JPanel creaPannelloDialogo(String text, Finestra master, Finestra f){
        
        //Creo un pannello contenitore per il dialogo con GridLayout per ora
        JPanel pannello = new JPanel();
        pannello.setLayout(new GridLayout(1,1,0,10));
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
        pannello.add(testo);
        
        //Restituisco il pannello appena creato
        return pannello;
        
    }
    
    //Metodo per la creazione di un pannello contenente i 3 pulsanti del menù
    private static JPanel creaPannelloPulsantiMenu(Finestra f){
        
        //Creo un pannello contenitore per i pulsanti con GridLayout per ora
        JPanel pannello_pulsanti = new JPanel();
        pannello_pulsanti.setLayout(new GridLayout(3,1,0,10));
        //Creo 3 pulsanti
        JButton gioca_bt = creaPulsanteMenu(null, f, gioco_nome_pulsante);
        JButton impostazioni_bt = creaPulsanteMenu(null, f, impostazioni_nome_pulsante);
        JButton crediti_bt = creaPulsanteMenu(null, f, crediti_nome_pulsante);
        //Aggiungo i 3 pulsanti al pannello
        pannello_pulsanti.add(gioca_bt);
        pannello_pulsanti.add(impostazioni_bt);
        pannello_pulsanti.add(crediti_bt);
        
        //Restituisco il pannello appena creato
        return pannello_pulsanti;
        
    }
    
    
    
    //Metodo per la creazione di un pulsante del menù
    private static JButton creaPulsanteMenu(Finestra master, Finestra finestra, String descrizione){
        
        /*Creo un oggetto JButton come pulsante, la descrizone è passata per
          parametro come una stringa*/
        JButton pulsante = new JButton(descrizione);
        //Creo il metodo ascoltatore per ogni pulsante
        pulsante.addActionListener(new ActionListener(){
            
            Gioco gioco = null;
            
            public void actionPerformed(ActionEvent e) {
                
                //Uso uno switch per smistare i vari pulsanti disponibili.
                switch (descrizione) {
                    
                    case gioco_nome_pulsante:
                        finestra.dispose();//Chiudo la finestra attuale
                        /*Avvio un oggetto della classe Gioco per far partire la
                          schermata di gioco effettiva*/
                        gioco = new Gioco();
                        break;
                        
                        //Scrivo sulla riga di comando momentaneamente                        
                    case impostazioni_nome_pulsante:
                        System.out.println(impostazioni_nome_pulsante);
                        break;
                        
                    case crediti_nome_pulsante:
                        System.out.println(crediti_nome_pulsante);
                        break;
                        
                    case "Continua":
                        master.setEnabled(true);
                        finestra.dispose();
                        break;
                    
                    case "Gioca di nuovo":
                        master.setEnabled(true);
                        finestra.dispose();//Chiudo la finestra attuale
                        /*Avvio un oggetto della classe Gioco per far partire la
                          schermata di gioco effettiva*/
                        gioco.restart();
                        break;
                    
                    case "Menù":
                        finestra.dispose();//Chiudo la finestra attuale
                        master.dispose();//Chiudo la finestra principale
                        /*Avvio un oggetto della classe Gioco per far partire la
                          schermata di gioco effettiva*/
                        Start start = new Start();
                        break;
                    
                    case "Esci":
                        System.exit(0);
                        break;
                        
                }
                
            }
            
        });
        
        //Restituisco il pulsante appena creato
        return pulsante;
        
    }
    
    //Metodo per l'apertura di una finestra
    public static void apriFinestra(Finestra finestra){
        
        //Suggerische la guida, da controllare
        //Senza il metodo pack() non si estende, occhio!
        finestra.pack();
        finestra.setLocationRelativeTo(null); //Centro la finestra rispetto allo schermo
        finestra.setVisible(true); //Rendo visibile la finestra
                
    }
    
    //Metodo per la toolbar: JTextField per countdown e JButton per pausa
    public static void aggiungiToolBar(Finestra f, JTextField text){
        
        JToolBar toolbar = new JToolBar();
        JButton button_pausa = new JButton();
        Font text_font = new Font(null, Font.BOLD, 40);
        
        text.setEditable(false);
        text.setFont(text_font);
        text.setForeground(Color.blue);
        text.setOpaque(false);
        text.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        text.setBorder(new EmptyBorder(5,5,5,500));
        
        button_pausa.setText("Clicca qui");
        //button_pausa.setPreferredSize(new Dimension(500,100));
        button_pausa.setFont(text_font);
        button_pausa.setForeground(Color.blue);

        button_pausa.setOpaque(false);
        button_pausa.setContentAreaFilled(false);
        button_pausa.setBorderPainted(false);


        button_pausa.setBorder(new EmptyBorder(5,5,5,5));
        
        toolbar.setBorder(new EmptyBorder(5,5,5,5));
        toolbar.setOpaque(false);
        toolbar.setBorderPainted(false);
        
        toolbar.add(text);
        toolbar.add(button_pausa);
        //toolbar.setPreferredSize(new Dimension(0, 100));
        f.getContentPane().add(text, BorderLayout.PAGE_START);
    }
    
    public static void creaFinestraPausa2(JDialog f){
        
        //Setto il nome della pagina, simile al costruttore della superclasse
        f.setTitle("Pausa");        
        /*La finestra ha bisogno di 2 dimensioni, allora utilizzo un oggetto
          della classe Dimension per assegnare questi valori.*/
        Dimension dimensioni_finestra = new Dimension(larghezza/4, altezza/4);
        /*Setto le dimensioni del ContentPane della finestra in quanto volgio
          che la parte "visuale" della finestra sia ben definita in modo da
          avere il valore dei bordi in modo esplicito*/
        f.getContentPane().setPreferredSize(dimensioni_finestra);
        f.setResizable(false); //La finestra non può essere ridimensionata
        /*Gestisco la chiusura della finestra tramite il tasto X richiamando il
          metodo setDefaultCloseOperation() della superclasse.
          Qui chiudo solo la finestra senza chiudere l'applicazione.*/
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
              
    }
    
    //Metodo per la creazione e l'aggiunta dei componenti della finestra sconfitta
    public static void aggiungiComponentiPausa2(Finestra master, JDialog f){
        
        //Creo un contenitore per i vari elementi della finestra
        JPanel contenitore;
        //Riempio il contenitore con gli elementi da visualizzare in caso di vittoria
        contenitore = creaPannelloPausa2(master, f);
        //Aggiungo il contenitore alla finestra
        f.add(contenitore);
        
    }
    
    //Metodo per la creazione di un pannello contenente una casella di testo e 3 pulsanti
    private static JPanel creaPannelloPausa2(Finestra master, JDialog f){
        
        //Creo un pannello contenitore per gli elementi con GridLayout per ora
        JPanel pannello = new JPanel();
        pannello.setLayout(new GridLayout(5,1,0,10));
        //Creazione di una casella di testo a una sola riga
        //Creo il font del testo
        Font font1 = new Font(null, Font.BOLD, 20);
        JTextField testo = new JTextField("Pausa");
        testo.setEditable(false); //Non è possibile scrivere qui
	testo.setFont(font1); //setto il font alla casella di testo
	testo.setHorizontalAlignment(JTextField.CENTER); //Setto l'allineamento
        /*Creo 3 pulsanti per:
          - Giocare di nuovo
          - Tornare al menù principale
          - Uscire dal gioco e chiudere l'applicazione.*/
        JButton continua_bt = creaPulsanteMenu2(master, f, "Continua");
        JButton gioca_bt = creaPulsanteMenu2(master, f, "Gioca di nuovo");
        JButton menu_bt = creaPulsanteMenu2(master, f, "Menù");
        JButton esci_bt = creaPulsanteMenu2(master, f, "Esci");
        //Aggiungo la casella di testo e i 3 pulsanti al pannello
        pannello.add(testo);
        pannello.add(continua_bt);
        pannello.add(gioca_bt);
        pannello.add(menu_bt);
        pannello.add(esci_bt);
        
        //Restituisco il pannello appena creato
        return pannello;
        
    }
    
    //Metodo per la creazione di un pulsante del menù
    private static JButton creaPulsanteMenu2(Finestra master, JDialog finestra, String descrizione){
        
        /*Creo un oggetto JButton come pulsante, la descrizone è passata per
          parametro come una stringa*/
        JButton pulsante = new JButton(descrizione);
        //Creo il metodo ascoltatore per ogni pulsante
        pulsante.addActionListener(new ActionListener(){
            
            Gioco gioco;
            
            public void actionPerformed(ActionEvent e) {
                
                //Uso uno switch per smistare i vari pulsanti disponibili.
                switch (descrizione) {
                    
                    case gioco_nome_pulsante:
                        finestra.dispose();//Chiudo la finestra attuale
                        /*Avvio un oggetto della classe Gioco per far partire la
                          schermata di gioco effettiva*/
                        gioco = new Gioco();
                        break;
                        
                        //Scrivo sulla riga di comando momentaneamente                        
                    case impostazioni_nome_pulsante:
                        System.out.println(impostazioni_nome_pulsante);
                        break;
                        
                    case crediti_nome_pulsante:
                        System.out.println(crediti_nome_pulsante);
                        break;
                        
                    case "Continua":
                        master.setEnabled(true);
                        finestra.dispose();
                        break;
                    
                    case "Gioca di nuovo":
                        finestra.dispose();//Chiudo la finestra attuale
                        master.dispose();//Chiudo la finestra principale
                        /*Avvio un oggetto della classe Gioco per far partire la
                          schermata di gioco effettiva*/
                        gioco = new Gioco();
                        break;
                    
                    case "Menù":
                        finestra.dispose();//Chiudo la finestra attuale
                        master.dispose();//Chiudo la finestra principale
                        /*Avvio un oggetto della classe Gioco per far partire la
                          schermata di gioco effettiva*/
                        Start start = new Start();
                        break;
                    
                    case "Esci":
                        System.exit(0);
                        break;
                        
                }
                
            }
            
        });
        
        //Restituisco il pulsante appena creato
        return pulsante;
        
    }
    
    //Metodo per l'apertura di una finestra
    public static void apriFinestra2(JDialog finestra){
        
        //Suggerische la guida, da controllare
        //Senza il metodo pack() non si estende, occhio!
        finestra.pack();
        finestra.setLocationRelativeTo(null); //Centro la finestra rispetto allo schermo
        finestra.setVisible(true); //Rendo visibile la finestra
                
    }
    
}
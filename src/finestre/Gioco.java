/*
 **************************************************************
 *                     2015(c) Project by                     *
 *                                                            *
 *                      Andrea  Petrella                      *
 *                                                            *
 *  Gioco creato per l'esame di Programmazione e Laboratorio  *
 **************************************************************
 */

/*

  ***
  *** Per ora, il gioco è così strutturato:
      - Una mappa più grande della finestra, centrata rispetto alla finestra.
      - - La mappa si muove in senso opposto alla freccia premuta da tastiera e si ferma quando uno dei bordi combacia con la finestra
      - Un Giocatore, centrato rispetto la finestra.
      - - Il giocatore si muove nello stesso senso della freccia premuta da tastiera solo quando la mappa è ferma
      - Traliccio, Antagonistra e Aiutante disegnati casualmente sulla mappa.
      - - Questi si muovo insieme alla mappa
      - Interazione del Giocatore con i Personaggi
      - - Antagonista ABBOZZATO NELLA CLASSE Gioco
      - - Aiutante ABBOZZATO NELLA CLASSE Gioco
      - - Finestra di vittoria, ABBOZZATA NELLA CLASSE Finestra
      - Conto alla rovescia: Abbozzato nella classe Countdown e nei metodi Aggiorna() e iniziaGioco().
      - - Finestra di sconfitta, ABBOZZATA NELLA CLASSE Finestra
      - Premo Esc per mettere in pausa ABBOZZATO, VA COMMENTATO BENE
  ***
  *** Mancano queste cose:
      
      PROBLEMI DA RISOLVERE

      - Uniforma le scritte tutte in maiuscolo per i pulsanti
      - Commentare bene le nuove classi delel finestre
      - Eliminare la vecchia classe Finestra
      - Commentare le vecchie classi nei punti dove sia prono le finestre
      - Commentare la barretta del livello appena messa.
      - Se hai tempo, fai la descrizione del gioco su impostazioni e scrivi i crediti, altrimenti cancella quelle due classi
      - Se hai tempo, metti la musichetta di avvio

      PROBLEMI RISOLTI

      - E' stata creata la possibilità di giocare a livelli in concomitanza con il nuovo restart. Quando il gioco riparte però non funzionano gli spostamenti dal bordo al centro del giocatore
      - - Risolto: assegnavo point_centro come punto del giocatore, allora quando modificavo la posizione del giocatore modificavo anche point_centro e perdevo i riferimenti.
      - - bastava assegnare le coordinate singolarmente
      - Caricare le risorse come le immagini prima di iniziare il gioco
      - - Lo faccio, ma in alcuni casi il gioco disegna dopo qualche secondo. Il primo avvio è il drastico.
      - - Penso ad un CountDown prima di iniziare tipo quelli dei quiz, con lo sfondo del gioco già visibile ma non accessibile (credo che devo risolvere prima il primo punto per fare questo)
      - - - Per ora lo devio aprendo e chiudendo la prima volta il gioco
      - - - - Sembra risolto col nuovo timer che prevede la possibilità di partire più tardi
      - Il timer impazzisce se avvio un nuovo gioco senza che che il vecchio sia finito
      - - Risolto con il metodo restart(), con un nuovo timer nella classe Gioco e con un actionPerformed nella classe Finestra migliorato.
      - - Sostanzialmente non creo più nuovi oggetti Gioco ogni volta che clicco rigioca
      - Visualizzare le finestre di dialogo (o specie la finestra di pausa) non è il modo migliore per bloccare il gioco. Basta selezionare la finestra del gioco che tutto va avanti nonostante la pausa
      - - Risolto mettendo e levando opportunamente il KeyBinfings quando è in pausa il gioco
      - - - La finestra di pausa l'ho convertita in un JDialog nella classe finestra, sembra più carina e adatta rispetto al JFrame
      - vedi http://stackoverflow.com/questions/14304711/key-listener-doesnt-work-in-a-jframe-when-traversing-from-another-jframe
        per migliorare le pagine, hai mischiato awt e swing e questo crea dei problemi con i keyListeners
      - - Sembra funzionare pappapero!
      - C'è un errore: con la mappa grande, anche se il gioco ha disattivato l'aiutante o l'antagonista, questi non spariscono davvero e continuano ad essere interattivi.
      - - Risolto con l'if nella classe GestoreCollisioni
      - Non mi piace il while per far uscire di scena gli elementi nel metodo aggiorna(). Dovrebbero disattivarsi nella loro classe, in modo da non impedire al giocatore di interagire con il resto degli elementi del gioco
      - - Valeria suggerisce di non bloccare tutto il gioco ma di tenere fermi solo il giocatore e l'interessato quando appare una finestra di dialogo.
      - - - Abbozzato per l'antagonista e per l'aiutante. Sembra funzionare
      - Se il giocatore interagisce da sopra, gli altri andando via gli passano sopra e va evitato
      - - Risolto con la classe UscitaDiScena
      - C'è un piccolo errore: va impedito all'aiutante di andare verso il giocatore se quest'ultimo è già adiacente all'aiutante
      - - Usando la classe GestoreIncroci sembrava che avessi risolto il problema, invece me l'ha rifatto
      - - - Il motivo sta nel fatto che GestoreIncroci evita solo che l'aiutante si muova verso il giocatore, ma in realtà va evitato anche che l'aiutante si sposti dopo l'apertura del dialogo
      - - Ho notato che l'aiutante fa un altro passo dopo l'interazione, credo che vada impedito per risolvere questo problema.
      - - - Risolto mettendo in pausa il Thread Aiutante DOPO che ha effettuato il suo ultimo spostamento, non prima che lo fa. In questo modo l'aiutante modifica le sue impostazioni dopo l'ultimo spostamento
      - La vecchietta fa un passo di troppo quando interagisce
      - - Proprio come l'aiutante qui sopra andava fatto
      - La vecchia nell'uscita delle volte se ne va ancora verso il giocatore (come se andasse in diagonale su+dx)
      - - Il Thread principale era più lento dei Threads minori quindi il controllo sulle direzioni veniva fatto più tardi dello spostamento dei singoli personaggi
      - Il giocatore corre troppo
      - - Non c'è verso di migliorare a meno che non decida di stravolgere il codice mettendo tutto nel Thread giocatore come faccio con gli altri due crstiani
      - - - Risolto con un ritardo sul listener: controllo il tempo del sistema e lo confronto con quello dell'ultimo spostamento
      - Se corro con il giocatore, quando interagisco di lato continuo la corsa di un altro passo prima che esce la finestra di dialogo
      - - Avendo rallentato il giocatore, di conseguenza questa cosa non accade più

      - I tizi possono sovrapporsi in fase di creazione e bloccarsi per via dell'impedimento nei movimenti che ho messo
      - - La scelta delle coordinate funziona bene, il problema è nella gestione dei movimenti
      - - Forse avviando i singoli Threads prima di avviare il Thread principale, l'aiutante se ne va a cazzi suoi senza il controllo del Thread principale all'inizio
      - - IL CONTROLLO E' TROPPO COMPLICATO E CREDO CHE SCAPPI QUALCOSA DI IMPORTANTE PER QUESTA FUNZIONE
      - - - CREDO CHE IL CONTROLLO DEI MOVIMENTI DEBBA ESSERE FATTO NEL SINGOLO THREAD E NON DAL THREAD PRINCIPALE
      - - - - ESATTO: ANDAVA MESSO TUTTO NEL SINGOLO THREAD E AGGIUSTATA LA PAUSA IN GestioneCollisioni (mentre controllo il thread deve stare in Pausa)
      - - - - In più ho capito che la pausa minima del singolo THREAD non deve mai essere inferiore a quella del THREAD principale (mai comunque sotto i 100 ms)
      - I tizi quando escono di scena e incontrano un albero non spariscono
      - - Sti cazzi, tanto il gioco finisce troppo in fretta
      - - - SOSPETTO CHE E' COLLEGATO AL MOTIVO DI SOPRA
      - - - - Semplicemente non gestito come caso particolare, ci vorrebbe tipo una "via di fuga"
      
      
  ***

*/
package finestre;

import helpers.Finestra;
import personaggi.*;
import helpers.CaricatoreImmagini;
import helpers.GestoreAudio;
import helpers.GestoreCollisioni;
import helpers.GestoreIncroci;
import helpers.UscitaDiScena;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import java.util.Timer;
/**
 *
 * @author Andrea
 */

/*La classe Gioco ha il compito di gestire completamente l'interattività del
  videogioco.
  Estendendo la classe Canvas, in Gioco è possibile disegnare gli oggetti
  grafici.
  Implementando l'interfaccia KeyListener, Gioco gestisce le interazioni
  dell'utente tramite la pressione dei tasti della tastiera.
  Implementando l'interfaccia Runnable, gli oggetti Gioco sono Thread
  indipendenti a livello processuale. Nella fattispecie un Thread Gioco è il
  Thread principale, o "contenitore", in cui viene gestita sia l'interattività
  del gioco che la sua grafica.*/

public class Gioco extends Canvas implements Runnable {
    
    //***COSTANTI, VARIABILI E OGGETTI DI CLASSE***    
    //Dimensioni della mappa
    private static final int larghezza_mappa = Finestra.larghezza*4;
    private static final int altezza_mappa = Finestra.altezza*4;
    //Creo una costante per definire il punto centrale della finestra
    private static final Point point_center = new Point(Finestra.larghezza/2, Finestra.altezza/2);
    //Definisco il numero di alberi presenti nella mappa
    private static final int num_alberi = 121;
    //Costante per la variazione di posizione negli spostamenti
    private static final int velocita = 40;
    
    //Variabili per i punti degli elementi del gioco     
    private static Point point_mappa;
    private static Point point_giocatore;
    private static Point[] points_alberi = new Point[num_alberi];
    
    //Oggetto per gestire la finestra di gioco e quella di pausa
    public static Finestra finestra = null; 
    //public static Finestra finestra_pausa = null;
    
    //***COSTANTI, VARIABILI E OGGETTI DI ISTANZA***    
    //Variabili contenenti le immagini da caricare all'avvio
    private BufferedImage img_mappa = null;
    private BufferedImage[] img_giocatore = new BufferedImage[12];
    private BufferedImage[] img_antagonista = new BufferedImage[12];
    private BufferedImage[] img_aiutante = new BufferedImage[12];
    private BufferedImage img_traliccio = null;
    private BufferedImage img_albero = null;
    private BufferedImage img_ombra = null;
    //Threads prinicipale
    private Thread thread_gioco;
    //Variabile per controllare l'attività del Thread
    private boolean gioco_attivo = true;
    private boolean in_pausa = false;
    private boolean controllo_dialogo = false;
    //Contatore per il livello corrente
    private int livello = 1;
    /*Timer, relativa variabile di abilitazione e variabili per la scansione
      temporale*/
    Timer myTimer;
    private boolean timer_is_InPausa = true;
    private int deci = 0, sec = 0, min = 1;
    //Variabili per memorizzare il tempo di sistema
    private long old_time_system, now_time_system, delay_time_system = 65;
      
    //Oggetti degli elementi del gioco
    private Giocatore giocatore;
    private Antagonista antagonista;
    private Aiutante aiutante;
    private Traliccio traliccio;
    private Albero[] alberi = new Albero[num_alberi];
    private FinestraCountdown finestra_countdown;
    
    //Varibili per i trucchi
    private boolean trucco = false;
    private boolean turbo = false;
    
    //Metodo costruttore
    public Gioco() {
                
        //Carico le risorse da file
        caricaRisorse();
        //Creo il conto alla rovescia
        creaCountdown();
        
        //***1. CREAZIONE DELLA FINESTRA***
        //Inizializzo un oggetto Finestra per creare una nuova finestra
        finestra = new Finestra();
        Finestra.creaFinestraPrincipale(finestra);
        
        //***2. POPOLAZIONE DELLA FINESTRA***
        /*Aggiungo l'oggetto this alla finestra per disegnare nell'oggetto, in
          quanto Gioco estende la classe Canvas*/
        finestra.add(this);
        
        //Aggiungo un listener per i tasti alla finestra
        addKeyBindingsOn(finestra.getRootPane());
                
        //***3. VISUALIZZAZIONE DELLA FINESTRA***
        Finestra.apriFinestra(finestra);
        /*        
        //Creo la finestra di pausa
        finestra_pausa = new Finestra();
        Finestra.creaFinestraPausa(finestra_pausa);
        //Aggiungo i componenti alla finestra di pausa
        Finestra.aggiungiComponentiPausa(finestra, finestra_pausa, this);
        */
        //Setto i punti del gioco
        setPoints();
        //Setto il vecchio tempo del sistema
        old_time_system = System.currentTimeMillis();
        
        //Inizializzo e avvio i vari Thread del gioco
        iniziaGioco();
        
    }
    
    //Metodo per caricare le Risorse da file
    private void caricaRisorse(){
        
        /*Creo un caricatore grazie alla classe CaricatoreImmagini per prelevare
          da file le immagini dei vari elementi*/
        CaricatoreImmagini loader = new CaricatoreImmagini();
        //Carico l'imamgine della mappa
        img_mappa = loader.caricaImmagine("mappa/" + "mappa.png");
        
        //Carico le immagini di Giocatore, Aiutante e Antagonista
        for(int i = 0; i < 12; i++){
            
            img_giocatore[i] = loader.caricaImmagine("giocatore/" + "giocatore." + i + ".png");
          //  img_antagonista[i] = loader.caricaImmagine("antagonista." + i + ".png");
            img_aiutante[i] = loader.caricaImmagine("aiutante/" + "aiutante." + i + ".png");
          //  img_traliccio[i] = loader.caricaImmagine("traliccio." + i + ".png");
            img_antagonista[i] = loader.caricaImmagine("antagonista/" + "antagonista." + i + ".png");
        }
        
        //Carico le immagini di Traliccio, Albero e Ombra
        img_traliccio = loader.caricaImmagine("traliccio/" +"traliccio.png");
        img_albero = loader.caricaImmagine("albero/" + "albero.png");
        img_ombra = loader.caricaImmagine("ombra/" + "ombra.png");
        
    }
    
    //Metodo per settare i punti della mappa e del giocotare
    private void setPoints(){
        
        this.point_mappa = new Point(this.point_center.x - this.larghezza_mappa/2, this.point_center.y - this.altezza_mappa/2);
        this.point_giocatore = new Point(this.point_center.x - Giocatore.getLarghezza()/2, this.point_center.y - Giocatore.getAltezza()/2);
        
    }
    
    //Metodo che inizializza i Thread del gioco e li avvia
    private void iniziaGioco(){
        
        //Il gioco parte in pausa
        in_pausa = true;
        //Setto il gioco al livello 1
        this.livello = 1;
                
        //Richiamo il metodo per creare i punti degli alberi da disegnare
        creaPointsAlberi();
        //Inizializzo gli Oggetti Grafici
        creaOggettiGrafici();
        //Avvio i singoli Thread
        avviaThreads();
        //Avvio il timer
        myTimerStart();
        //Avvio la musica di sottofondo
        GestoreAudio.musicThemeStart();
        
    }
    
    //Metodo per inizializzare i vari Oggetti grafici
    private void creaOggettiGrafici(){
        
        //Inizializzo il Thread "contenitore" del gioco
        thread_gioco = new Thread(this);
        //Creo gli alberi
        for(int i = 0; i < num_alberi; i++){
        
            alberi[i] = new Albero(img_albero, img_ombra, points_alberi[i].x, points_alberi[i].y);
            
        }
        //Creo giocatore, traliccio, antagonista e aiutante
        giocatore = new Giocatore(img_giocatore, img_ombra, point_giocatore.x, point_giocatore.y);
        traliccio = new Traliccio(img_traliccio, img_ombra, alberi, num_alberi);
        antagonista = new Antagonista(img_antagonista, giocatore, traliccio, img_ombra, alberi, num_alberi);
        aiutante = new Aiutante(img_aiutante, giocatore, antagonista, traliccio, img_ombra, alberi, num_alberi);
        //Creo la finestra del conto alla rovescia
        finestra_countdown = new FinestraCountdown("LIVELLO " + livello);
        //Setto l'aiutante nell'oggetto antagonista
        antagonista.setAiutante(aiutante);
             
    }
    
    //Metodo per avviare i vari Threads del gioco
    private void avviaThreads(){
        
        new Thread(antagonista).start();    
        new Thread(aiutante).start();    
        thread_gioco.start(); 
        
    }
    
    //Metodo per disegnare gli elementi sullo schermo
    private void disegna(){
        
        /*Utilizzo un BufferStrategy per evitare scatti e sfarfallio delle
          immagini: disegno un elemento su un buffer e contemporaneamente
          visualizzo un buffer già disegnato*/
        BufferStrategy buffer = this.getBufferStrategy();
        
        /*Controllo se il buffer è vuoto, ovvero se è stato appena creato e lo
          inizializzo*/
        if(buffer == null){
            createBufferStrategy(2);
            return;
        }
        
        //Disegno gli oggetti grafici sul buffer
        Graphics g = buffer.getDrawGraphics();
        g.drawImage(img_mappa, point_mappa.x, point_mappa.y, larghezza_mappa, altezza_mappa, this);
        antagonista.disegna(g);
        aiutante.disegna(g);
        traliccio.disegna(g);
        for(int i = 0; i < num_alberi; i++){
        
            alberi[i].disegna(g);
            
        }
        giocatore.disegna(g);
        finestra_countdown.disegna(g);
        
        //Visualizzo il buffer disegnato
        g.dispose();
        buffer.show();      
    
    }
    
    //Metodo per gestire l'interattività del Thread Gioco
    private void aggiorna(){
        
        //Se il gioco è in pausa
        if(in_pausa){
            
            /*Metto in pausa il Thread e elimino il Listener della testiera
              per evitare movimenti in pausa*/
            pausa();
            addKeyBindingsOff(finestra.getRootPane());
            
            /*Se la finestra principale è in primo piano signica che la pausa è
              finita e quindi riattivo il gioco con le varie impostazioni*/
            if(finestra.isFocused()){
                
                /*Riattivo i vari Thread e setto la finestra di gioco in primo
                  piano riabilitandola*/
                aiutante.setIn_Pausa(false);
                antagonista.setIn_Pausa(false);
                finestra.setEnabled(true);
                finestra.setAlwaysOnTop(true);
                attiva();
                //Aggiungo di nuovo il Listener della tastiera
                addKeyBindingsOn(finestra.getRootPane());
                //Riattivo il timer
                myTimerStart();              
                
            }
            
        }
        //Se il gioco non è in pausa
        else{

            //Gestisco le interazioni tra giocatore e glia altri personaggi
            /*Se non c'è stata una precedente interazione, l'Antagonista si
              dirige verso il Giocatore quando una delle 2 coordinate
              dell'Antagonista coincide con la corrispettiva del Giocatore*/
            if(antagonista.getInterazione() == 0) antagonista.setAnimazione(GestoreIncroci.controllaIncrocioAntagonista(giocatore, antagonista));  
            /*Se non c'è stata una precedente interazione, l'Aiutante si muove
              casualmente nella mappa, evitando di andare verso il Giocatore.*/
            if(aiutante.getInterazione() == 0) aiutante.setAnimazione(GestoreIncroci.controllaIncrocioAiutante(giocatore, aiutante));                               

            /*Controllo la collisione tra Traliccio e Giocatore. Nel caso ci sia
              il gioco finisce per vittoria*/
            if(GestoreCollisioni.controllaCollisioneTraliccio2(giocatore, traliccio)){
        
                //Fermo la musica
                GestoreAudio.musicStop();
                //Avvio la musica per la vittoria
                GestoreAudio.musicClipStart(GestoreAudio.musicaYouWin());
                
                //Creo la finestra della vittoria
                Vittoria vittoria = new Vittoria(this, finestra);
                //Setto la finestra di vittoria in primo piano
                vittoria.setAlwaysOnTop(true);
                vittoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //Disabilito la finestra di gioco
                finestra.setEnabled(false);            
                //Fermo il gioco disattivandolo
                disattiva();
                //Fermo il timer
                myTimerStop();
            
            }
        
            /*Controllo se il conto alla rovescia è finito. Nel caso, il gioco
              finisce per sconfitta.*/
            else if(!myTimerIsRunning() && !trucco){
                
                //Fermo la musica
                GestoreAudio.musicStop();
                //Avvio la musica per la sconfitta
                GestoreAudio.musicClipStart(GestoreAudio.musicaGameOver());
                
                //Creo la finestra della sconfitta
                Sconfitta sconfitta = new Sconfitta(this, finestra);
                //Setto la finestra di vittoria in primo piano
                sconfitta.setAlwaysOnTop(true);
                sconfitta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //Disabilito la finestra di gioco
                finestra.setEnabled(false);                
                //Fermo il gioco disattivandolo
                disattiva();
                //Fermo il timer
                myTimerStop();
            
            }
        
            //Controllo la prima collisione tra Antagonista e Giocatore.
            else if(GestoreCollisioni.controllaCollisioneAntagonista2(giocatore, antagonista) && (antagonista.getInterazione() == 0)){
            
                //Faccio perdere tempo al giocatore con una frase
                
                //Avvio l'audio dell'antagonista
                GestoreAudio.musicClipStart(GestoreAudio.musicaPanick());
            
                //Varie frasi
                String testo = new String();
                String testo1 = "Ah l'Enel! Finalmente! Io sono senza corrente da ore! Ma ci vuole tempo? Perché sa, ho le cose nel congelatore...";
                String testo2 = "Voi dell'Enel siete davvero degli irrispettosi! Se non vi sbrigate a ridarmi corrente perderò la puntata della mia telenovella preferita! Ai miei tempi c'era più rispetto per gli anziani.";
                String testo3 = "IO VI DENUNCIO!!! Come vi permettete di levare corrente per così tanto tempo!?! Io ho sempre pagato le bollette! Non sapete chi sono io!";
                String testo4 = "Come mai sono senza corrente? Ho i vestiti da stirare, il pranzo da preparare... Non è che potete rimettere corrente giusto una mezz'oretta per usare il ferro da stiro?";
                
                //Creo un intero casuale da 1 a 4
                Random r = new Random();
                int rand = r.nextInt(4) + 1;
                
                /*Controllo l'intero creato per settare il testo tra quelli
                  disponibili*/
                switch(rand){
                    
                    case 1:
                        testo = testo1;
                        break;
                    
                    case 2:
                        testo = testo2;
                        break;  
                    
                    case 3:
                        testo = testo3;
                        break;    
                    
                    case 4:
                        testo = testo4;
                        break;                
                
                }    
            
                //Creo la finestra di dialogo
                JFrame dialogo_finestra = new JFrame();
                Dialogo dialogo = new Dialogo(testo, dialogo_finestra, "La vecchietta");
            
                /*Creo un ritardo per far visualizzare la finestra di dialogo
                  senza mettere il gioco in pausa*/
                long now = System.currentTimeMillis();
                long stop = now + 10000;
                finestra.setAlwaysOnTop(false);
                /*Impedisco alla finestra di dialogo di poter essere chiusa,
                  l'abilito e la porto in primo piano */
                dialogo_finestra.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                dialogo_finestra.setEnabled(false);
                dialogo_finestra.setAlwaysOnTop(true);
                
                /*Continuo a disegnare nella finestra principale mentre il
                  giocatore è obbligato ad aspettare*/
                while((myTimerIsRunning() || trucco) && System.currentTimeMillis() <= stop){
                    disegna();
                    finestra.setEnabled(false);
                }
                
                //Ripristino la finestra principale e chiudo quella di dialogo
                finestra.setEnabled(true);
                dialogo_finestra.setAlwaysOnTop(false);
                dialogo_finestra.dispose();
                
                //Controllo se il giocatore è sopra o sotto l'antagonista
                UscitaDiScena.controllaUscitaAntagonista(giocatore, antagonista);           
                        
            }
        
            //Controllo la prima collisione tra l'Aiutante e il Giocatore.
            else if(GestoreCollisioni.controllaCollisioneAiutante2(giocatore, aiutante) && (aiutante.getInterazione() ==0)){
            
                /*Aiuto il giocatore a trovare il Traliccio guasto indicandogli
                  la direzione*/
                
                //Avvio l'audio dell'aiutante
                GestoreAudio.musicClipStart(GestoreAudio.musicaHallelujah());
                
                /*Verifico la direzione del traliccio rispetto al giocatore e la
                  salvo in una stringa*/
                String direzione = traliccio.getDirezione(giocatore.getPunto());
                String testo = "Lei lavora all'Enel vero? Ho visto delle fiamme su un traliccio " + direzione;
            
                //Creo la finestra dialogo
                //Creo la finestra di dialogo
                JFrame dialogo_finestra = new JFrame();
                Dialogo dialogo = new Dialogo(testo, dialogo_finestra, "Il boscaiolo");
                dialogo_finestra.setAlwaysOnTop(true);
            
                //Controllo se il giocatore è sopra o sotto l'aiutante
                UscitaDiScena.controllaUscitaAiutante(giocatore, aiutante);
            
            }
        }
    }
    
    /*Sovrascrivo il metodo run della Superclasse Thread.
      Finquando il Thread è attivo, ad ogni ciclo:
      - aggiorna gli elementi tramite il metodo aggiorna()
      - ridisegno il tutto con il metodo disegna()*/
    @Override
    public void run() {
        
        while(gioco_attivo){
            
            aggiorna();
            disegna();
            
        }
                
    }
    
    //KeyListener per Swing
    public void addKeyBindingsOn(JComponent jc) {
        
        //Listener sul tasto SU
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "UP pressed");
        jc.getActionMap().put("UP pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                /*Applico un ritardo sul listener per far muovere il giocatore
                  in maniera più lenta*/
                now_time_system = System.currentTimeMillis();
                if(now_time_system >= old_time_system + delay_time_system){
                    
                    /*Se il Giocatore non si sovrappone ad altri elementi
                      grafici, effettuo il movimento*/
                    if(!GestoreCollisioni.controllaSovrapposizioneSu(giocatore, traliccio, aiutante, antagonista, alberi, num_alberi)) spostaGiu();
                    else giocatore.scegliImgSu();
                    old_time_system = System.currentTimeMillis();
                    
                }
                
            }
            
        });       
        
        //Listener sul tasto GIU'
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "DOWN pressed");
        jc.getActionMap().put("DOWN pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                /*Applico un ritardo sul listener per far muovere il giocatore
                  in maniera più lenta*/
                now_time_system = System.currentTimeMillis();
                if(now_time_system >= old_time_system + delay_time_system){
                    
                    /*Se il Giocatore non si sovrappone ad altri elementi
                      grafici, effettuo il movimento*/
                    if(!GestoreCollisioni.controllaSovrapposizioneGiu(giocatore, traliccio, aiutante, antagonista, alberi, num_alberi)) spostaSu();
                    else giocatore.scegliImgGiu();
                    old_time_system = System.currentTimeMillis();
                    
                }
                
            }
            
        });       
        
        //Listener sul tasto DESTRA
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "RIGHT pressed");
        jc.getActionMap().put("RIGHT pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                /*Applico un ritardo sul listener per far muovere il giocatore
                  in maniera più lenta*/
                now_time_system = System.currentTimeMillis();
                if(now_time_system >= old_time_system + delay_time_system){
                    
                    /*Se il Giocatore non si sovrappone ad altri elementi
                      grafici, effettuo il movimento*/
                    if(!GestoreCollisioni.controllaSovrapposizioneDx(giocatore, traliccio, aiutante, antagonista, alberi, num_alberi)) spostaSinistra();
                    else giocatore.scegliImgDx();
                    old_time_system = System.currentTimeMillis();
                    
                }
                
            }
            
        }); 
        
        //Listener sul tasto SINISTRA
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "LEFT pressed");
        jc.getActionMap().put("LEFT pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                /*Applico un ritardo sul listener per far muovere il giocatore
                  in maniera più lenta*/
                now_time_system = System.currentTimeMillis();
                if(now_time_system >= old_time_system + delay_time_system){
                    
                    /*Se il Giocatore non si sovrappone ad altri elementi
                      grafici, effettuo il movimento*/
                    if(!GestoreCollisioni.controllaSovrapposizioneSx(giocatore, traliccio, aiutante, antagonista, alberi, num_alberi)) spostaDestra();
                    else giocatore.scegliImgSx();
                    old_time_system = System.currentTimeMillis();
                    
                }
                
            }
            
        });     
        
        //Listener sul tasto ESC
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), "ESCAPE pressed");
        jc.getActionMap().put("ESCAPE pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                    //Metto il gioco in pausa per aprire il menù
                    giocoInPausa();
                    
            }
            
        });     
        
        /* *** TRUCCO STOPPO IL TIMER *** */
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "S pressed");
        jc.getActionMap().put("S pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(myTimerIsRunning()) myTimerStop();
                else myTimerStart();
                /*
                    if(timer.isRunning()) timer.stop();
                    else timer.start(); */
                    trucco = !trucco;
            }
        });    
        
        /* *** TRUCCO METTO IL TURBO *** */
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_T, 0, false), "T pressed");
        jc.getActionMap().put("T pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                turbo = !turbo;
                if(turbo) delay_time_system = 1;
                else delay_time_system = 65;
                    
            }
        });    
        
    }
    
    /*Anti listener per Swing, serve a eliminare il listener con le finestre di
      dialogo*/
    public void addKeyBindingsOff(JComponent jc) {
        
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "UP pressed");
        jc.getActionMap().put("UP pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {}
        });       
        
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "DOWN pressed");
        jc.getActionMap().put("DOWN pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {}
        });       
        
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "RIGHT pressed");
        jc.getActionMap().put("RIGHT pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {}
        }); 
        
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "LEFT pressed");
        jc.getActionMap().put("LEFT pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {}
        });     
        
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), "ESCAPE pressed");
        jc.getActionMap().put("ESCAPE pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {}
        });     
        
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "S pressed");
        jc.getActionMap().put("S pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {}
        });       
        
    }
    
    /* ***Metodi per gestire i vari spostamenti nel gioco*** */
    //Sposta il protagonista verso il basso o il resto verso l'alto
    private void spostaSu(){
        
        //Avvio l'audio per i passi
        GestoreAudio.musicClipStart(GestoreAudio.musicaWalk());
        
        //Caso in cui il giocatore è accentrato rispetto l'asse y
        if(giocatore.getPunto().y == point_giocatore.y){
        
            /*Lascio fermo il giocatore e muovo il resto verso l'alto fino a
              quando i bordi inferiori della mappa e della finestra non
              coincidono*/
            if((point_mappa.y + altezza_mappa) - velocita >=  finestra.getContentPane().getHeight()){
                
                point_mappa.y -= velocita;
                traliccio.spostaSu(velocita);
                
                for(int i = 0; i < num_alberi; i++){
                
                    alberi[i].spostaSu(velocita);
                    
                }
                antagonista.spostaSu(velocita);
                aiutante.spostaSu(velocita);
                giocatore.scegliImgGiu();
          
            }
            /*Se i bordi inferiori coincidono, muovo il giocatore verso il basso
              fino al bordo inferiore*/
            else if(((giocatore.getPunto().y + giocatore.getAltezza()) + velocita) <= finestra.getContentPane().getHeight()){
            
                giocatore.spostaGiu(velocita);
                
            }
            
        }
        //Caso in cui il giocatore è sopra il centro
        else if(giocatore.getPunto().y < point_giocatore.y){
            
            //Muovo il giocatore verso il centro
            if((giocatore.getPunto().y + velocita) <= point_giocatore.y){
                
                giocatore.spostaGiu(velocita);
                
            }
            //Muovo il giocatore verso il centro di un'eventuale scarto
            else{
                
                giocatore.spostaGiu(point_giocatore.y - giocatore.getPunto().y);
                
            }
            
        }
        //Caso in cui il giocatore è sotto il centro
        else{
            
            //Muovo il giocatore verso il basso fino al bordo inferiore
            if(((giocatore.getPunto().y + giocatore.getAltezza()) + velocita) <= finestra.getContentPane().getHeight()){
            
                giocatore.spostaGiu(velocita);
                
            }
            
        }
        
    }
        
    //Sposta il protagonista verso sinistra o il resto verso destra
    private void spostaDestra(){
        
        //Avvio l'audio per i passi
        GestoreAudio.musicClipStart(GestoreAudio.musicaWalk());
        
        //Caso in cui il giocatore è accentrato rispetto l'asse x
        if(giocatore.getPunto().x == point_giocatore.x){
            
            /*Lascio fermo il giocatore e muovo il resto verso destra fino a
              quando i bordi a sinistra della mappa e della finestra non
              coincidono*/
            if(point_mappa.x + velocita <= 0){
                
                point_mappa.x += velocita;
                traliccio.spostaDestra(velocita);
                
                for(int i = 0; i < num_alberi; i++){
                
                    alberi[i].spostaDestra(velocita);
                    
                }
                antagonista.spostaDestra(velocita);
                aiutante.spostaDestra(velocita);
                giocatore.scegliImgSx();
                
            }
            /*Se i bordi a sinistra coincidono, muovo il giocatore verso sinistra
              fino al bordo sinistro*/
            else if((giocatore.getPunto().x - velocita) >= 0){
                
                giocatore.spostaSinistra(velocita);
                
            }
            
        }
        //Caso in cui il giocatore è a sinistra rispetto il centro
        else if(giocatore.getPunto().x < point_giocatore.x){
            
            //Muovo il giocatore verso sinistra fino al bordo di sinistra
            if((giocatore.getPunto().x - velocita) >= 0){
                
                giocatore.spostaSinistra(velocita);
                
            }
            
        }
        //Caso in cui il giocatore è a destra rispetto il centro
        else{
            
            //Muovo il giocatore verso il centro
            if((giocatore.getPunto().x - velocita) >= point_giocatore.x){
                
                giocatore.spostaSinistra(velocita);
                
            }
            //Muovo il giocatore verso il centro di un'eventuale scarto
            else{
                
                giocatore.spostaSinistra(giocatore.getPunto().x - point_giocatore.x);
                
            }
            
        }
        
    }
    
    //Sposta il protagonista verso l'alto o il resto verso il basso
    private void spostaGiu(){
        
        //Avvio l'audio per i passi
        GestoreAudio.musicClipStart(GestoreAudio.musicaWalk());
        
        //Caso in cui il giocatore è accentrato rispetto l'asse y
        if(giocatore.getPunto().y == point_giocatore.y){
            
            /*Lascio fermo il giocatore e muovo il resto verso il basso fino a
              quando i bordi superiori della mappa e della finestra non
              coincidono*/
            if(point_mappa.y + velocita <= 0){
                
                point_mappa.y += velocita;
                traliccio.spostaGiu(velocita);
                
                for(int i = 0; i < num_alberi; i++){
                
                    alberi[i].spostaGiu(velocita);
                    
                }
                antagonista.spostaGiu(velocita);
                aiutante.spostaGiu(velocita);
                giocatore.scegliImgSu();
                
            }
            /*Se i bordi superiori coincidono, muovo il giocatore verso l'alto
              fino al bordo superiore*/
            else if((giocatore.getPunto().y - velocita) >= 0){
                
                giocatore.spostaSu(velocita);
                
            }
            
        }
        //Caso in cui il giocatore è sopra il centro
        else if(giocatore.getPunto().y < point_giocatore.y){
            
            //Muovo il giocatore verso l'alto fino al bordo superiore
            if((giocatore.getPunto().y - velocita) >= 0){
                
                giocatore.spostaSu(velocita);
                
            }
            
        }
        //Caso in cui il giocatore è sotto il centro
        else{
            
            //Muovo il giocatore verso il centro
            if((giocatore.getPunto().y - velocita) >= point_giocatore.y){
                
                giocatore.spostaSu(velocita);
                
            }
            //Muovo il giocatore verso il centro di un'eventuale scarto
            else{
                
                giocatore.spostaSu(giocatore.getPunto().y - point_giocatore.y);
                
            }
            
        }
        
    }
    
    //Sposta il protagonista verso destra o il resto verso sinistra
    private void spostaSinistra(){
        
        //Avvio l'audio per i passi
        GestoreAudio.musicClipStart(GestoreAudio.musicaWalk());
        
        //Caso in cui il giocatore è accentrato rispetto l'asse x
        if(giocatore.getPunto().x == point_giocatore.x){
        
            /*Lascio fermo il giocatore e muovo il resto verso sinistra fino a
              quando i bordi a destra della mappa e della finestra non
              coincidono*/
            if((point_mappa.x + larghezza_mappa) - velocita >=  finestra.getContentPane().getWidth()){
                
                point_mappa.x -= velocita;
                traliccio.spostaSinistra(velocita);
                
                for(int i = 0; i < num_alberi; i++){
                
                    alberi[i].spostaSinistra(velocita);
                    
                }
                antagonista.spostaSinistra(velocita);
                aiutante.spostaSinistra(velocita);
                giocatore.scegliImgDx();
          
            }
            /*Se i bordi a destra coincidono, muovo il giocatore verso il destra
              fino al bordo destro*/
            else if(((giocatore.getPunto().x + giocatore.getLarghezza()) + velocita) <= finestra.getContentPane().getWidth()){
            
                giocatore.spostaDestra(velocita);
                
            }
            
        }
        //Caso in cui il giocatore è a sinistra rispetto il centro
        else if(giocatore.getPunto().x < point_giocatore.x){
            
            //Muovo il giocatore verso il centro
            if((giocatore.getPunto().x + velocita) <= point_giocatore.x){
                
                giocatore.spostaDestra(velocita);
                
            }
            //Muovo il giocatore verso il centro di un'eventuale scarto
            else{
                
                giocatore.spostaDestra(point_giocatore.x - giocatore.getPunto().x);
                
            }
            
        }
        //Caso in cui il giocatore è a destra rispetto il centro
        else{
            
            //Muovo il giocatore verso destra fino al bordo destro
            if(((giocatore.getPunto().x + giocatore.getLarghezza()) + velocita) <= finestra.getContentPane().getWidth()){
            
                giocatore.spostaDestra(velocita);
                
            }
            
        }
        
    }
    
    //Metodo getter per la variabile altezza_mappa
    public static int getAltezza_mappa(){
        
        return altezza_mappa;
        
    }
    
    //Metodo getter per la variabile larghezza_mappa
    public static int getLarghezza_mappa(){
        
        return larghezza_mappa;
        
    }
    
    //Metodo getter per la variabile point_mappa
    public static Point getPoint_mappa(){
        
        return point_mappa;
        
    }
    
    //Metodo getter per la variabile point_giocatore
    public static Point getPoint_giocatore(){
        
        return point_giocatore;
        
    }
    
    //Metodo per gestire la pausa del Thread
    private void pausa(){
        
        //Costante contenente il valore di ms di pausa
        final int tempo = 5;
        
        //Gestisco l'eccezione
        try {

            //Rallento l'aggiornamento del Thread
            Thread.sleep(tempo);
            
        }
        catch (InterruptedException ex) {
            
            System.out.println("ERRORE! Thread.sleep() non eseguito");
            Logger.getLogger(Giocatore.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            
    }
    
    //Metodo per mettere in pausa il gioco
    private void giocoInPausa(){
        
        Pausa pausa = new Pausa(this, finestra);
        
        //Setto la finestra di pausa in primo piano
        pausa.setAlwaysOnTop(true);
        pausa.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //Disabilito la finestra di gioco
        finestra.setEnabled(false);      
        //Fermo il gioco disattivandolo
        disattiva();
        //Fermo il timer
        myTimerStop();
        antagonista.setIn_Pausa(true);
        aiutante.setIn_Pausa(true);
                        
    }
        
    //Metodo per creare i punti dei vari alberi da disegnare nella mappa
    private void creaPointsAlberi(){
                
        //Inizializzo ogni elemento dell'array
        for(int i = 0; i < num_alberi; i++){
        
            points_alberi[i] = new Point();
            
        }
        
        //Vari cicli e per creare file di alberi, tutti salvati in un array
        
        //i per le x, j per le y e k funge da puntatore dell'array
        int i = 0, j = 0, k = 0;
                
        for(i = 0; i < 4; i++){
            
            for(j = 0; j < 9 - 2*i; j++){
                
                if(j < (5 - i)) points_alberi[k].x = j*80 + point_mappa.x + 40;
                else points_alberi[k].x = j*80 + point_mappa.x + (larghezza_mappa - (9 - 2*i)*80 - 40);
                points_alberi[k].y = 20 + i*120 + point_mappa.y;
                k++;
                
            }
            
        }
        
        points_alberi[k].x = point_mappa.x + 40;
        points_alberi[k].y = 20 + i*120 + point_mappa.y;
        k++;
        
        //25
                
        for(i = 0; i < 7; i++){
            
            if(i < 2){
                
                for(j = 0; j < 5; j++){
                    
                    points_alberi[k].x = j*80 + 16*80 -60 + i*80;
                    points_alberi[k].y = i*120 -180;
                    k++;
                
                }
                
            }//35
            else if(i < 4){
                
                for(j = 0; j < 8; j++){
                    
                    points_alberi[k].x = j*80 + 16*80 -80 -20;
                    points_alberi[k].y = i*120 -180;
                    k++;
                
                }
                
            }//51
            else{
                
                for(j = 0; j < 9-i; j++){
                    
                    points_alberi[k].x = j*80 + 16*80 -20;
                    points_alberi[k].y = i*120 -180;
                    k++;
                
                }
                
            }//63
                        
        }
        
        for(i = 0; i < 3; i++){
                
            for(j = 0; j < 10; j++){
                    
                points_alberi[k].x = j*80 + 4*80 +20;
                points_alberi[k].y = i*120 + 10*120 -20;
                k++;
                    
            }
                               
        }//93
                
        for(j = 0; j < 6; j++){
                    
            points_alberi[k].x = j*80 -5*80 +20;
            points_alberi[k].y = 120 +20;
            k++;
                    
        }
        
        for(i = 1; i < 3; i++){
                
            for(j = 0; j < 8; j++){
                    
                points_alberi[k].x = j*80 -6*80 +20;
                points_alberi[k].y = i*120 + 120 +20;
                k++;
                    
            }
                               
        }
                
        for(j = 0; j < 6; j++){
                    
            points_alberi[k].x = j*80 -5*80 +20;
            points_alberi[k].y = 4*120 +20;
            k++;
                    
        }//121
        
    }
    
    //Metodo per la creazione di un conto alla rovescia
    private void creaCountdown(){
        
        /*Ritardo per l'avvio della Task, serve a dare il tempo al gioco di
          caricare le risorse prima che parta il countdown*/
        long delay = 1000;
        //Variabile per la scansione del tempo minimo (100 ms = 0.1 s)
        int sleep = 100;
        
        //Resetto le impostazione del timer
        resetMyTimer();
        //Creo un timer
        myTimer = new Timer();
        //Creo una TimerTask per definire i passi da eseguire ad ogni processo
        TimerTask myTask = new TimerTask() {

            @Override
            public void run() {
                //Eseguo il metodo dinamica con la finestra_countdown ogni 0.1 s
                dinamica(finestra_countdown);
            }
        };
        
        //Assegno la TimerTask con il ritardo e il tempo di scansione al Timer
        myTimer.scheduleAtFixedRate(myTask, delay, sleep);
        //Inizialmente il timer non è in pausa
        timer_is_InPausa = false;
        
    }
    
    /*Metodo per la gestione della "dinamica" del conto alla roveschia:
      Se il timer non è in pausa, ad ogni ciclo del TimerTask decremento il
      contatore del timer di 0.1 s fino ad arrivare a 0. */
    private void dinamica(FinestraCountdown text){
        
        //Controllo sulla pausa del timer
        if(!timer_is_InPausa){
        
            //Decremento i decimi di secondo
            this.deci--;
        
            //Decremento i secondi e resetto i decimi quando questi sono < 0
            if(this.deci<0){
            
                this.deci = 9;
                this.sec--;
                //Decremento i minuti e resetto i secondi quando questi sono < 0
                if (this.sec<0) {
          
                    this.sec=59;
                    this.min--;
          
                    //deci < 0; sec < 0 e min <0 --> 0:00:0 quindi mi fermo
                    if (this.min<0) {
              
                        //Fermo il timer
                        myTimerStop();
                        //Stampo a video il timer a 0
                        printTimeStop(text);
              
                    }
            
                    else{
                        
                        //Stampo a video il valore del timer
                        printTime(text);
                
                    }
            
                }
        
                else{
            
                    //Stampo a video il valore del timer
                    printTime(text);
            
                }
            
            }
        
            else{
            
                //Stampo a video il valore del timer
                printTime(text);
            
            }
     
        }
        
    }
    
    //Metodo per stampare nella FinestraCountdown il valore attuale del Timer
    private void printTime(FinestraCountdown text){
        
        text.setDeci(this.deci);
        text.setSec(this.sec);
        text.setMin(this.min);
        
    }
    
    //Metodo per stampare nella FinestraCountdown il Timer a 0
    private void printTimeStop(FinestraCountdown text){
        
        text.setDeci(0);
        text.setSec(0);
        text.setMin(0);
        
    }
    
    //Metodo per avviare/far continuare il timer
    private void myTimerStart(){
        
        this.timer_is_InPausa = false;
        
    }
    
    //Metodo per fermare il timer
    private void myTimerStop(){
        
        this.timer_is_InPausa = true;
        
    }
    
    //Metodo per controllare se il timer non è in pausa
    private boolean myTimerIsRunning(){
        
        return !this.timer_is_InPausa;
        
    }
    
    //Setter per le variabili del Timer
    private void setTimer(int deci, int sec, int min){
        
        this.deci = deci;
        this.sec = sec;
        this.min = min;
        
    }
    
    //Metodo per resettare il timer in base al livello del gioco
    private void resetMyTimer(){
        
        //Dal livello 1 al livello  4 levo 10s ad ogni livello
        if(livello <= 4) setTimer(0, 60 - 10*(livello - 1), 0);
        //Dal livello 5 al livello  8 levo  5s ad ogni livello
        else if(livello <= 8) setTimer(0, 30 - 5*(livello - 4), 0);
        //Dal livello 9 al livello 15 levo  1s ad ogni livello
        else if(livello <= 15) setTimer(0, 18 - (livello), 0);
        /*Nel caso il giocatore siuscisse ad arrivare al livello 16 la
          difficoltà non aumenterebbe e avrebbe solo 5 secondi per completare il
          gioco*/
        else setTimer(0, 5, 0);
                
            
    }
    
    //Metodo per riavviare il gioco
    public void restart(){
        
        //Fermo il gioco mentre eseguo i vari reset
        gioco_attivo = false;
        
        //Ricalcolo le coordinate dei personaggi e del traliccio
        ricalcolaCoordinate();
        //Reimposto l'immagine di default
        giocatore.setImgDefoult();
        //Resetto il timer
        resetMyTimer();
        //Disabilito i trucchi
        trucco = false;
        turbo = false;
        //Attivo i personaggi
        attivaPersonaggi();
        //Avvio il timer
        myTimerStart();
        //Stampo il livello
        finestra_countdown.setLivello("LIVELLO " + livello);
                
        //Riattivo il gioco avendo finito i reset
        gioco_attivo = true;
        //Stoppo la musica
        GestoreAudio.musicStop();
        //Riavvio la musica di sottofondo
        GestoreAudio.musicThemeStart();
        
    }
    
    //Metodo per resettare i personaggi
    private void attivaPersonaggi(){
    
        antagonista.restart();
        aiutante.restart();
        
    }
    
    //Ricalcola le coordinate dei personaggi e del traliccio
    private void ricalcolaCoordinate(){
        
        //Resetta i punti della mappa e del giocatore
        setPoints();
        giocatore.setPointX(point_giocatore.x);
        giocatore.setPointY(point_giocatore.y);
        //Ricrea ogni albero
        for(int i = 0; i < num_alberi; i++){
        
            alberi[i] = new Albero(img_albero, img_ombra, points_alberi[i].x, points_alberi[i].y);
            
        }
        //Resetta le coordinate di antagonista, aiutante e traliccio
        antagonista.CreaCoordinate(alberi, num_alberi);
        aiutante.CreaCoordinate(alberi, num_alberi);
        traliccio.CreaCoordinate(alberi, num_alberi);
        
    }
    
    //Metodo per salire di livello
    public void nextLivel(){
        
        //Incrementa il livello
        this.livello++;
        //Riavvia il gioco
        restart();
        
    }
    
    //Setter per mettere il gioco non in pausa
    public void attiva(){
        
        this.in_pausa = false;
        
    }
    
    //Setter per mettere il gioco in pausa
    public void disattiva(){
        
        this.in_pausa = true;
        
    }
    
    //Getter per l'oggetto Giocatore
    public Giocatore getGiocatore(){
        
        return this.giocatore;
        
    }
    
}

// *** COMMENTI ULTIMATI ***
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import finestre.Gioco;
import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 *
 * @author andre
 */

/*La classe GestoreAudio, di seguito scritta, è una classe "helper" ovvero
  aiuta ad ottenere un codice più ordinato riducendo la scrittura dello stesso
  codice più volte.
  Il compito di GestoreAudio è quello di caricare file audio, essendo questi
  risorse esterne, e di gestire la loro riproduzione nel gioco.*/
public class GestoreAudio {
    
    //Oggetti Clip per la riproduzione dei file audio
    private static Clip clip, clip_theme;
    
    //Metodi per i nomi dei vari file audio
    public static String musicaTema(){
        return "themesong.wav";
    }
    
    public static String musicaGameOver(){
        return "gameover.wav";
    }
    
    public static String musicaYouWin(){
        return "youwin.wav";
    }
    
    public static String musicaWalk(){
        return "walk.wav";
    }
    
    public static String musicaHallelujah(){
        return "hallelujah.wav";
    }
    
    public static String musicaPanick(){
        return "panick.wav";
    }
    
    /*Metodo per il caricamento del file audio di sottofondo e della sua
      riproduzione*/
    public static void musicThemeStart(){
        
        //Gestisco l'accezzione
        try {
            
            //Nome della cartella del progetto dove leggere il file
            String folder = "/musics/";
            
            //Carica l'url del file
            URL yourFile = Gioco.class.getResource(folder + musicaTema());
            //Variabile per la linea di ingresso
            AudioInputStream stream;
            //Formato del file audio (per la decodifica)
            AudioFormat format;
            //Informazioni della linea (tipo il volume)
            DataLine.Info info;

            //Setto la linea di ingresso con il file
            stream = AudioSystem.getAudioInputStream(yourFile);
            //Acquisisco il formato audio della linea di ingresso
            format = stream.getFormat();
            //Creo le informazioni sulla linea dal suo formato
            info = new DataLine.Info(Clip.class, format);
            //Inizializzo il clip (linea di uscita) con il DataLine dell'input
            clip_theme = (Clip) AudioSystem.getLine(info);
            //Apro e avvio il clip per la riproduzione del file audio
            clip_theme.open(stream);
            clip_theme.start();
    
        }
        catch (Exception e) {
            
            System.out.println("Errore nella riproduzione del file audio.");
            
        }
        
    }
    
    /*Metodo per il caricamento dei file audio generici e della loro
      riproduzione*/
    public static void musicClipStart(String file_name){
                
        //Gestisco l'eccezione
        try {
            
            //Nome della cartella del progetto dove leggere il file
            String folder = "/musics/";
            
            //Carica l'url del file
            URL yourFile = Gioco.class.getResource(folder + file_name);
            //Variabile per la linea di ingresso
            AudioInputStream stream;
            //Formato del file audio (per la decodifica)
            AudioFormat format;
            //Informazioni della linea (tipo il volume)
            DataLine.Info info;

            //Setto la linea di ingresso con il file
            stream = AudioSystem.getAudioInputStream(yourFile);
            //Acquisisco il formato audio della linea di ingresso
            format = stream.getFormat();
            //Creo le informazioni sulla linea dal suo formato
            info = new DataLine.Info(Clip.class, format);
            //Inizializzo il clip (linea di uscita) con il DataLine dell'input
            clip = (Clip) AudioSystem.getLine(info);
            //Apro e avvio il clip per la riproduzione del file audio
            
            clip.open(stream);
            clip.start();
            
            //volume_theme.setValue(1.0f);
    
        }
        catch (Exception e) {
            
            //whatevers
            System.out.println("Errore nella riproduzione del file audio.");
            
        }
        
    }
    
    //Metodo per fermare la musica di sottofondo
    private static void musicThemeStop(){
        
        //Gestisco l'eccezione
        try{
            
            //Fermo la riproduzione e chiudo il clip
            clip_theme.stop();
            
        }catch(Exception e){}
        
    }
    
    //Metodo per fermare la musica generica
    private static void musicClipStop(){
        
        //Gestisco l'eccezione
        try{
            
            //Fermo la riproduzione e chiudo il clip
            clip.stop();
            
        }catch(Exception e){}
        
    }
    
    //Metodo per fermare tutto l'audio
    public static void musicStop(){
        
        musicThemeStop();
        musicClipStop();
        
    }
    
}

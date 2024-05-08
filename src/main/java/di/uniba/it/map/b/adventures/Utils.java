/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.it.map.b.adventures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author gabrielepaladini
 */
public class Utils extends Thread{
    
    //variabile booleana che indica quando il gioco è finito
    private static boolean gameOver = false;
    
    //variabile che mostra a schermo il game over del gioco
    private static boolean displayGameOver = true;
    
    //variabile che indica se il thred è in esecuzione o meno
    public static boolean isRunning = true;
    
    //variabile che indica la durata in secondi
    private final int seconds;
    
    //variabile che indica il tempo rimanente
    private static int remainingTime;
    
    //variabile di tipo Object utilizzata per la sincronizzazione di porzioni di codice
    private static final Object LOCK = new Object();
    
    //costruttore con parametro 'seconds'
    public Utils(final int seconds){
        this.seconds = seconds;
    }
    
    //metodo che legge il contenuto di un file passato come parametro e lo restituisce come stringa
    public static String readFile(String nomeFile){
        StringBuilder stringBuilder = new StringBuilder();
        
        try{
            File file = new File(nomeFile);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                stringBuilder.append(line).append("\n");
            }
            scanner.close();
        }catch (FileNotFoundException e){
            System.err.println("Errore durante l'apertura del file: " + e.getMessage());
        }
        return stringBuilder.toString();
    }
    
    //metodo che carica i dati presenti su un file passato come parametro all'interno di un set di String e lo restituisce
    public static Set<String> loadFileListInSet(File file) throws IOException{
        Set<String> set = new HashSet<>();
        BufferedReader reader = null;
        
        try{
            reader = new BufferedReader(new FileReader(file));
        }catch (FileNotFoundException e){
            System.err.println("Errore durante l'apertura del file: " + e.getMessage());
        }
        
        while(reader.ready()){
            set.add(reader.readLine().trim().toLowerCase());
        }
        reader.close();
        return set;
    }
    
    //metodo che restituisce le singole parole presenti all'interno di una stringa passata come parametro
    //escludendo le stopwords
    public static List<String> parseString(String string, Set<String> stopwords){
        List<String> tokens = new ArrayList<>();
        String[] split = string.toLowerCase().split("\\s+");
        for(String t : split){
            if(!stopwords.contains(t)){
                tokens.add(t);
            }
        }
        return tokens;
    }
    
    //IMPLEMENTARE IL METODO RUN PER LA GESTIONE DEI THREADS
    
}

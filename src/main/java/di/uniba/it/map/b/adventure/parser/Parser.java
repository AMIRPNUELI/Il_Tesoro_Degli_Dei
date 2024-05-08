/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.it.map.b.adventure.parser;

import di.uniba.it.map.b.adventure.type.AdvObject;
import di.uniba.it.map.b.adventure.type.AdvObjectContainer;
import di.uniba.it.map.b.adventure.type.Command;
import di.uniba.it.map.b.adventures.Utils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author gabrielepaladini
 */
public class Parser {
    
    //insieme di elementi di tipo string che rappresentano le parole da ignorare durante l'analisi del testo
    private final Set<String> stopwords;
    
    //costruttore con parametro 'stopwords'
    public Parser(Set<String> stopwords){
        this.stopwords = stopwords;
    }
    
    //metodo che verifica se il token passato come parametro compare nella lista dei comandi e ne restituisce l'indice
    private int checkForCommand(String token, List<Command> commands){
        for(int i = 0; i < commands.size(); i++){
            if(commands.get(i).getName().equalsIgnoreCase(token) || commands.get(i).getAlias().contains(token)){
                return i;
            }
        }
        return -1;
    }
    
    //metodo che verifica se il token passato come parametro compare nella lista degli oggetti
    //se nella lista degli oggetti sono presenti 'container' ricerca il token anche nella lista degli oggetti contenuti nei container
    private int checkForObject(String token, List<AdvObject> objects){
        for(int i = 0; i < objects.size(); i++){
            if(objects.get(i).getName().equals(token) || objects.get(i).getAlias().contains(token)){
                return i;
            }
        }
        return -1;
    }
    
    public ParserOutput parse(String command, List<Command> commands, List<AdvObject> objects, List<AdvObject> inventory){
       List<String> tokens = Utils.parseString(command, stopwords);
       
       if(!tokens.isEmpty()){
           int wc = checkForCommand(tokens.get(0), commands);
           if(wc > -1){
               if(tokens.size() > 1){
                   int io = checkForObject(tokens.get(1), objects);
                   int ioinv = -1;
                   if(io < 0 && tokens.size() > 2){
                       io = checkForObject(tokens.get(2), objects);
                   }
                   if(io < 0){
                       ioinv = checkForObject(tokens.get(1), inventory);
                       if(ioinv < 0 && tokens.size() > 2){
                           ioinv = checkForObject(tokens.get(2), inventory);
                       }
                   }
                   
                   if(io > -1 && ioinv > -1){
                       return new ParserOutput(commands.get(wc), objects.get(io), inventory.get(ioinv));
                   }else if(io > -1){
                       return new ParserOutput(commands.get(wc), objects.get(io), null);
                   }else if(ioinv > -1){
                       return new ParserOutput(commands.get(wc), null, inventory.get(ioinv));
                   }else{
                       return new ParserOutput(commands.get(wc), null, null);
                   }
               }else{
                   return new ParserOutput(commands.get(wc), null);
               }
           }else{
               return new ParserOutput(null, null);
           }
       }else{
           return null;
       }
    }
}

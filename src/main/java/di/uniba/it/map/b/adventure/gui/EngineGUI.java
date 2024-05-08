/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package di.uniba.it.map.b.adventure.gui;

import di.uniba.it.iltesorodeglidei.IlTesoroDegliDei;
import di.uniba.it.map.b.adventure.database.Database;
import di.uniba.it.map.b.adventure.parser.Parser;
import di.uniba.it.map.b.adventure.parser.ParserOutput;
import di.uniba.it.map.b.adventure.type.Room;
import di.uniba.it.map.b.adventures.GameDescription;
import di.uniba.it.map.b.adventures.Utils;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 *
 * @author gabrielepaladini
 */
public class EngineGUI extends javax.swing.JFrame {
    
    //variabile che identifica il gioco in corso
    private final GameDescription game;
    
    //variabile che inizializza il parser
    private Parser parser;

    /**
     * Creates new form EngineGUI
     */
    public EngineGUI() {
        initComponents();
        this.game = new IlTesoroDegliDei();
        initializeGUI();
    }
    
    private void initializeGUI(){
        if(!GameDescription.loadedGame){
            //visualizzazione messaggi iniziali
            this.game.startGame();
            this.game.Introduction();
            startButton.setVisible(false);
            FileButton.setEnabled(false);
            HelpButton.setEnabled(false);
            InputArea.setVisible(false);
            TimeArea.setVisible(false);
            NarrationTextArea.setVisible(true);
            NarrationTextArea.setEditable(false);
            InventoryTextArea.setEditable(false);
            currentRoomTextArea.setVisible(false);            
            //visualizzazione inventario
            InventoryTextArea.setText("INVENTARIO");
            InventoryTextArea.append("\n--------------------------- \n");
        }else{
            int roomId = Database.loadPlayerRoom();
            this.game.startGame();
            Room room = EngineGUI.getRoomByID(game.getRooms(), roomId);
            if(room != null){
                game.setCurrentRoom(room);
            }
            startButton.setVisible(false);
            FileButton.setEnabled(false);
            HelpButton.setEnabled(false);
            InputArea.setVisible(false);
            TimeArea.setVisible(false);
            NarrationTextArea.setVisible(true);
            InventoryTextArea.setEditable(false);
            currentRoomTextArea.setVisible(false);
            //visualizzazione mini-mappa e ambiente
            MiniMap.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathMiniMap())));
            Views.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
            //visualizzazione inventario
            InventoryTextArea.setText("\t\tINVENTARIO");
            InventoryTextArea.append("\n---------------------- \n");
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MiniMap = new javax.swing.JLabel();
        InventoryArea = new javax.swing.JScrollPane();
        InventoryTextArea = new javax.swing.JTextArea();
        InputArea = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();
        Views = new javax.swing.JLabel();
        currentRoomTextArea = new javax.swing.JTextField();
        TextArea = new javax.swing.JScrollPane();
        NarrationTextArea = new javax.swing.JTextArea();
        TimeArea = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileButton = new javax.swing.JMenu();
        SaveButton = new javax.swing.JMenuItem();
        RestartButton = new javax.swing.JMenuItem();
        HelpButton = new javax.swing.JMenu();
        CommandsButton = new javax.swing.JMenu();
        ExitButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(736, 552));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MiniMap.setBackground(new java.awt.Color(255, 255, 255));
        MiniMap.setIcon(new javax.swing.ImageIcon("/Users/gabrielepaladini/NetBeansProjects/IlTesoroDegliDei/src/main/resources/Img/Rooms/Mappa_esterno.png")); // NOI18N
        getContentPane().add(MiniMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 0, 200, 190));

        InventoryTextArea.setBackground(new java.awt.Color(0, 0, 0));
        InventoryTextArea.setColumns(20);
        InventoryTextArea.setForeground(new java.awt.Color(255, 255, 255));
        InventoryTextArea.setRows(5);
        InventoryArea.setViewportView(InventoryTextArea);

        getContentPane().add(InventoryArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 200, 330));

        InputArea.setBackground(new java.awt.Color(0, 0, 0));
        InputArea.setForeground(new java.awt.Color(255, 255, 255));
        InputArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputAreaActionPerformed(evt);
            }
        });
        getContentPane().add(InputArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 430, 40));

        startButton.setBackground(new java.awt.Color(0, 0, 0));
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 90, 90));

        Views.setIcon(new javax.swing.ImageIcon("/Users/gabrielepaladini/NetBeansProjects/IlTesoroDegliDei/src/main/resources/Img/view/Piramide_Esterno.png")); // NOI18N
        getContentPane().add(Views, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 290));

        currentRoomTextArea.setBackground(new java.awt.Color(0, 0, 0));
        currentRoomTextArea.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(currentRoomTextArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 430, 430, 40));

        NarrationTextArea.setBackground(new java.awt.Color(0, 0, 0));
        NarrationTextArea.setColumns(20);
        NarrationTextArea.setForeground(new java.awt.Color(255, 255, 255));
        NarrationTextArea.setRows(5);
        TextArea.setViewportView(NarrationTextArea);

        getContentPane().add(TextArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 530, 120));
        getContentPane().add(TimeArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 447, 90, 60));

        FileButton.setText("File");
        FileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileButtonActionPerformed(evt);
            }
        });

        SaveButton.setText("Salva");
        FileButton.add(SaveButton);

        RestartButton.setText("Ricomincia");
        RestartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartButtonActionPerformed(evt);
            }
        });
        FileButton.add(RestartButton);

        jMenuBar1.add(FileButton);

        HelpButton.setText("Suggerimento");
        HelpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HelpButtonMouseClicked(evt);
            }
        });
        jMenuBar1.add(HelpButton);

        CommandsButton.setText("Comandi");
        CommandsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CommandsButtonMouseClicked(evt);
            }
        });
        CommandsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommandsButtonActionPerformed(evt);
            }
        });
        jMenuBar1.add(CommandsButton);

        ExitButton.setText("Esci");
        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitButtonMouseClicked(evt);
            }
        });
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        jMenuBar1.add(ExitButton);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InputAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputAreaActionPerformed
        InputArea.setText("");
        String command = evt.getActionCommand();
        
        try{
            Set<String> stopwords = Utils.loadFileListInSet(new File("/Users/gabrielepaladini/NetBeansProjects/IlTesoroDegliDei/src/main/resources/Init/stopwords.rtf"));
            parser = new Parser(stopwords);
            
            ParserOutput p = parser.parse(command, game.getCommands(), game.getCurrentRoom().getObjects(), game.getInventory());
            
            if(p.getCommand() != null){
                game.nextMove(p, this);
                InputArea.setEditable(true);
            }else{
                NarrationTextArea.setText("Non riesco a capire.");
            }
        }catch(IOException ex){
            System.err.println(ex + "Errore!");
        }
    }//GEN-LAST:event_InputAreaActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        FileButton.setEnabled(true);
        startButton.setVisible(false);
        HelpButton.setEnabled(true);
        currentRoomTextArea.setVisible(true);
        InputArea.setVisible(true);
        TimeArea.setVisible(false);
        MiniMap.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathMiniMap())));
        Views.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
        NarrationTextArea.setText(game.getCurrentRoom().getDescription());
        currentRoomTextArea.setText("Ti trovi in: " + game.getCurrentRoom().getName() + ".");
        currentRoomTextArea.setEditable(false);
        InventoryTextArea.append("- Zippo");
    }//GEN-LAST:event_startButtonActionPerformed

    private void FileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileButtonActionPerformed

    private void CommandsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommandsButtonActionPerformed
        
    }//GEN-LAST:event_CommandsButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void CommandsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CommandsButtonMouseClicked
        String commands = "Il tuo obiettivo è esplorare la piramide alla ricerca del leggendario 'Tesoro degli Dei'.\n"
                + "\nPer interagire con l'ambiente che ti circoda fai uso di questi comandi : "
                + "\n -nord                                                              ti sposti a nord"
                + "\n -sud                                                                ti sposti a sud"
                + "\n -est                                                                 ti sposti a est"
                + "\n -ovest                                                              ti sposti a ovest"
                + "\n -usa (nome_oggetto)                                    utilizzi l'oggetto indicato"                
                + "\n -premi/sposta (nome_oggetto)                            premi l'oggetto indicato"
                + "\n -apri (nome_oggetto)                                     apri l'oggetto indicato"          
                + "\n -guarda (nome stanza)                               esamini la stanza in cui ti trovi"
                + "\n -esamina (nome_oggetto)                               esamini l'oggetto indicato"
                + "\n -prendi (nome_oggetto)                                 raccogli l'oggetto indicato"
                + "\n -inserisci (nome_oggetto)                               inserisci l'oggetto indicato"
                + "\n -leggi (nome_oggetto)                                     leggi l'oggetto indicato"
                + "\n -aiuto                                                         mostra i comandi di gioco"
                + "\n\n(digita i nomi degli elementi in minuscolo senza utilizzare spazi)";
        JOptionPane.showMessageDialog(this, commands, "INFO", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_CommandsButtonMouseClicked

    private void RestartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartButtonActionPerformed
        closeWindow();
        new StartMenu().setVisible(true);
    }//GEN-LAST:event_RestartButtonActionPerformed

    private void ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitButtonMouseClicked

    private void HelpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpButtonMouseClicked
        Utils timer = new Utils(10);
        timer.start();
        
        
    }//GEN-LAST:event_HelpButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JMenu CommandsButton;
    private static javax.swing.JMenu ExitButton;
    private static javax.swing.JMenu FileButton;
    private javax.swing.JMenu HelpButton;
    private static javax.swing.JTextField InputArea;
    private static javax.swing.JScrollPane InventoryArea;
    private static javax.swing.JTextArea InventoryTextArea;
    private static javax.swing.JLabel MiniMap;
    private static javax.swing.JTextArea NarrationTextArea;
    private static javax.swing.JMenuItem RestartButton;
    private static javax.swing.JMenuItem SaveButton;
    private static javax.swing.JScrollPane TextArea;
    private static javax.swing.JLabel TimeArea;
    private static javax.swing.JLabel Views;
    private static javax.swing.JTextField currentRoomTextArea;
    private static javax.swing.JMenuBar jMenuBar1;
    private static javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables


    //metodo che stampa il valore della stringa 's' nell'area NarrationTextArea
public void NarrationTextAreaSetText(String s){
    NarrationTextArea.setText(s);
}

    //metodo che inserisce dopo un testo già presente il set inserito come parametro in NarrationTextArea
public void NarrationTextAreaAppendText(String s){
    NarrationTextArea.append(s);
}

    //metodo che aggiunge il valore della stringa 's' nell'area InventoryTextArea
public void InventoryTextAreaAppendText(String s){
    InventoryTextArea.append(s);
}

    //metodo che aggiorna la visualizzazione dell'area 'view'
public void ViewAreaSetView(){
    Views.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathView())));
}

public void ViewAreaSetViewPath(String s){
    Views.setIcon(new javax.swing.ImageIcon(getClass().getResource(s)));
}
    //metodo che aggiorna la visualizzazione della mini-mappa
public void MiniMapAreaSetView(){
    MiniMap.setIcon(new javax.swing.ImageIcon(getClass().getResource(game.getCurrentRoom().getPathMiniMap())));
}

    //metodo che aggiorna lo stato della stanza corrente
public void CurrentRoomUpdate(){
    currentRoomTextArea.setText("Ti trovi in: " + game.getCurrentRoom().getName() + ".");
}

    //metodo che permette di visualizzare la descrizione di una stanza ogni volta che ci spostiamo
public void RoomDescriptionUpdate(){
    NarrationTextArea.setText(game.getCurrentRoom().getDescription());
}

    //metodo che stampa i messaggi di output con un delay di 100 millisecondi lettera per lettera tramite un timer
public static void setTextDelay(final String s){
    
    //variavile che rappresenta un ritardo di 100 millisecondi tra le lettere
    int delay = 10;
    
    //array di interi di dimensione 1 che serve per mantenere il valore dell'indice
    //in quanto nella lambda expression la variabile index non è modificabile poiché final
    final int[] index = {0};
    
    Timer timer = new Timer(delay, e-> {
        if(index[0] < s.length()){
            String partialText = s.substring(0, index[0] + 1);
            NarrationTextArea.setText(partialText);
            index[0]++;
        }else{
            //arresta il timer una volta che tutte le lettere sono state visualizzate
            ((Timer) e.getSource()).stop();
            //rende l'area di input 'editabile'
            InputArea.setEditable(true);
            //posiziona il cursore all'inizio del testo
            InputArea.setCaretPosition(0);
            //posiziona il focus sull'area di input
            InputArea.requestFocusInWindow();
        }
    });
    timer.start();
}
    //metodo che stampa l'introduzione del gioco con un delay di 100 millisecondi lettera per lettera tramite un timer
public static void introTextSet(final String s){
    //variavile che rappresenta un ritardo di 100 millisecondi tra le lettere
    int delay = 20;
    
    //array di interi di dimensione 1 che serve per mantenere il valore dell'indice
    //in quanto nella lambda expression la variabile index non è modificabile poiché final
    final int[] index = {0};
    
    Timer timer = new Timer(delay, e-> {
       if(index[0] < s.length()){
           String partialText = s.substring(0, index[0] + 1);
           NarrationTextArea.setText(partialText);
           index[0]++;
       } else{
           ((Timer) e.getSource()).stop();
           //rende il pulsante di avvio del gioco visibile
           startButton.setVisible(true);
           //posiziona il cursore all'inizio del testo
           InputArea.setCaretPosition(0);
           //posiziona il focus sull'area di input
           InputArea.requestFocusInWindow();
       }
    });
    timer.start();
}

//metodo che ricerca la stanza passata come parametro attraverso il suo id all'interno del database
//se trova una corrispondenza la restituisce, altrimenti null
public static Room getRoomByID(final List<Room> rooms, final int roomId){
    for(Room room : rooms){
        if(room.getId() == roomId){
            return room;
        }
    }
    return null;
}

public static void closeWindow(){
    //metodo che ricava tutte le finestre aperte nell'applicazione
    java.awt.Window[] windows = java.awt.Window.getWindows();
    
    //itero tra tutte le finestre, se la finestra è un'istanza di EngineGUI la chiudo
    //con il metodo dispose()
    for(java.awt.Window window : windows){
        if(window instanceof EngineGUI){
            window.dispose();
        }
    }
}

    //metodo che mostra il tempo rimanente del timer
/*public void showTime(String text){
    EventQueue.invokeLater(() -> {
        int i = Integer.parseInt(text);
        int minutes = i / 60;
        int remainingSec = i % 60;
        
        TimeArea.setVisible(true);
        TimeArea.setText(minutes + ":" + remainingSec);
        
        Utils timerThread = new Utils(i);
        timerThread.start();        
    });
}*/

}
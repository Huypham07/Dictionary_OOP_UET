package GUI;

import javax.swing.*;
import GUI.ControlPanel.LookupGUI;
import Dict.DictionaryManagement;
import GUI.ControlPanel.AddWord.AddGUI;
import GUI.ControlPanel.TranslateGUI;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import manageData.Datatype.Word;
import raven.glasspanepopup.GlassPanePopup;
import jnafilechooser.api.JnaFileChooser;

public class DictionaryGUI extends javax.swing.JFrame {
    private CardLayout cardLayout;
    
    private DictionaryManagement dictionaryManagement;
    
    private LookupGUI lookupGUI;
    private TranslateGUI translateGUI;
    
    private ArrayList<String> Listfuntion = new ArrayList<>();
    
    public DictionaryGUI() {
        initComponents();
        init();
        GlassPanePopup.install(this);
    }
    
    private void init() {
        ImageIcon iconApp = new ImageIcon("src/data/img/logo.png");
        setIconImage(iconApp.getImage());
        
        dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.insertFromFile();
        
        cardLayout = new CardLayout(0, 0);
        
        lookupGUI = new LookupGUI();
        lookupGUI.setDictionay(dictionaryManagement);
        
        translateGUI = new TranslateGUI();
        
        
        workPanel.setLayout(cardLayout);
        
        workPanel.add("lookup",lookupGUI);
        workPanel.add("translate", translateGUI);
        
        Listfuntion.add("lookup");
        Listfuntion.add("translate");
        
        controlpanel.eventLookupGUI(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controlpanel.setSelect(controlpanel.LOOKUP);
                change(controlpanel.LOOKUP);
            }
            
        });
        
        controlpanel.eventTranslateGUI(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controlpanel.setSelect(controlpanel.TRANSLATE);
                change(controlpanel.TRANSLATE);
            }
            
        });
        
        controlpanel.eventAddGUI(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                AddGUI add = new AddGUI();
                add.eventOK(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            Word tmp = add.getWord();
                            if (!dictionaryManagement.validWord(tmp.getWord_target())) {
                                JOptionPane.showMessageDialog(add, "Invalid English Word!\nAn English word can only have alphabet character!!!");
                            } else{
                                dictionaryManagement.insertWord(tmp);
                                JOptionPane.showMessageDialog(add, "Successful!");
                                GlassPanePopup.closePopupLast();
                            }
                        }
                    }                   
                
                });
                GlassPanePopup.showPopup(add);
            }
            
        });
        
        controlpanel.eventExportGUI(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {
                ExportToFile(e);
            }
            
        });
    }
    
    private void change(int select) {
        CardLayout c = (CardLayout)(workPanel.getLayout());
        c.show(workPanel, Listfuntion.get(select));  
    }
    
    private void ExportToFile(MouseEvent e) {
        JnaFileChooser fc = new JnaFileChooser();
        boolean save = fc.showSaveDialog(this);
        fc.addFilter("test", "txt");
        if (save) {
            File file = fc.getSelectedFile();
            dictionaryManagement.dictionaryExportToFile(file.getAbsolutePath());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new GUI.roundComponent.Button();
        controlpanel = new GUI.ControlPanel.controlPanel();
        resultPanel1 = new GUI.ControlPanel.resultPanel();
        workPanel = new javax.swing.JPanel();

        button1.setText("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dictionary");
        setBackground(new java.awt.Color(245, 245, 245));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        workPanel.setBackground(new java.awt.Color(255, 255, 255));
        workPanel.setOpaque(false);

        javax.swing.GroupLayout workPanelLayout = new javax.swing.GroupLayout(workPanel);
        workPanel.setLayout(workPanelLayout);
        workPanelLayout.setHorizontalGroup(
            workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        workPanelLayout.setVerticalGroup(
            workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout resultPanel1Layout = new javax.swing.GroupLayout(resultPanel1);
        resultPanel1.setLayout(resultPanel1Layout);
        resultPanel1Layout.setHorizontalGroup(
            resultPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(workPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        resultPanel1Layout.setVerticalGroup(
            resultPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(workPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(controlpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(resultPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(controlpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resultPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        dictionaryManagement.dictionaryExportToFile("src/data/dictionary.txt");
    }//GEN-LAST:event_formWindowClosing


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DictionaryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DictionaryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DictionaryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DictionaryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DictionaryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.roundComponent.Button button1;
    private GUI.ControlPanel.controlPanel controlpanel;
    private GUI.ControlPanel.resultPanel resultPanel1;
    private javax.swing.JPanel workPanel;
    // End of variables declaration//GEN-END:variables
}

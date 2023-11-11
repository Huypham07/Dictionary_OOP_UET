package GUI.ControlPanel;

import GUI.ControlPanel.Edit.EditPanel;
import GUI.roundComponent.RoundedPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import manageData.Datatype.Word;
import manageData.Datatype.WordExplain;
import raven.glasspanepopup.GlassPanePopup;

public class AddGUI extends RoundedPanel {
    private final List<EditPanel> list = new ArrayList<>();
    
    private boolean newTopic;
    private boolean noTopic;

    public boolean isNewTopic() {
        return newTopic;
    }

    public void setNewTopic(boolean newTopic) {
        this.newTopic = newTopic;
    }

    public boolean isNoTopic() {
        return noTopic;
    }

    public void setNoTopic(boolean noTopic) {
        this.noTopic = noTopic;
    }
    
    public AddGUI() {
        initComponents();
        addNewTypeTab(1);
        Delete.setVisible(false);
    }
    
    public void addNewTypeTab(int num) {
            EditPanel newPanel = new EditPanel(num);
            list.add(newPanel);
            materialTabbed1.addTab("Type", newPanel);
            newPanel.eventType(new KeyAdapter(){
                @Override
                public void keyReleased(KeyEvent e) {
                    if (Character.isLetter(e.getKeyChar())) {
                        materialTabbed1.setTitleAt(materialTabbed1.getSelectedIndex(), newPanel.getType());
                    }
                }

            });
    }

    public Word getWord() {
        Word result = new Word();
        String eng = English.getText();
        
        if (eng.isEmpty()) {
            return null;
        }
        
        result.setWordTarget(English.getText());
        
        for (int i = 0; i < materialTabbed1.getTabCount(); i++) {
            EditPanel e = (EditPanel) materialTabbed1.getTabComponentAt(i);
            List<WordExplain> ex = e.getWordExplain();
            if (ex == null) return null;
            for (WordExplain w : ex) {
                result.addExplain(w);
            }
        }

        return result;
    }
    
    public void changeToEditGUI(Word word) {
        Delete.setVisible(true);
        list.clear();        
        materialTabbed1.removeAll();
        materialTabbed1.revalidate();
        English.setText(word.getWord_target());
        List<String> listType = new ArrayList<>();
        
        for (WordExplain w : word.getWord_explain()) {
            if(listType.contains(w.getType())) {
                list.get(listType.indexOf(w.getType())).addexplain(w.getDefinition(), w.getMeaning());
            } else {
                listType.add(w.getType());
                EditPanel e = new EditPanel(0);
                e.addexplain(w.getDefinition(), w.getMeaning());
                e.setType(w.getType());
                list.add(e);
                materialTabbed1.addTab(w.getType(), e);
            }
        }
        materialTabbed1.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tiltle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cancel = new GUI.roundComponent.Button();
        Ok = new GUI.roundComponent.Button();
        English = new GUI.roundComponent.RoundedTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        materialTabbed1 = new GUI.roundComponent.MaterialTabbed();
        AddType = new GUI.roundComponent.Button();
        Delete = new GUI.roundComponent.Button();
        DelType = new GUI.roundComponent.Button();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(215, 246, 248));
        setRoundBottomLeft(30);
        setRoundBottomRight(30);
        setRoundTopLeft(30);
        setRoundTopRight(30);

        Tiltle.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        Tiltle.setText(" Add Word");

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setOpaque(true);

        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelMouseReleased(evt);
            }
        });

        Ok.setText("Ok");

        English.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        English.setHintText("English ...");

        jCheckBox1.setText("New Topic");

        jCheckBox2.setText("No topic");

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        AddType.setText("Add Type");
        AddType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AddTypeMouseReleased(evt);
            }
        });

        Delete.setText("Delete");

        DelType.setText("Delete Type");
        DelType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DelTypeMouseReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Tiltle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(DelType, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(materialTabbed1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(English, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(AddType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tiltle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(English, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(DelType, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseReleased
        if (SwingUtilities.isLeftMouseButton(evt)) {
            GlassPanePopup.closePopupLast();
        }
    }//GEN-LAST:event_cancelMouseReleased

    private void AddTypeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddTypeMouseReleased
        if (SwingUtilities.isLeftMouseButton(evt)) {
            addNewTypeTab(1);
        }
    }//GEN-LAST:event_AddTypeMouseReleased

    private void DelTypeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelTypeMouseReleased
        if (SwingUtilities.isLeftMouseButton(evt)) {
            if (list.size() > 1) {
                list.remove(materialTabbed1.getSelectedIndex());
                materialTabbed1.removeTabAt(materialTabbed1.getSelectedIndex());
            } else {
                JOptionPane.showMessageDialog(this, "A word must have one or more explanations!");
            }
        }
    }//GEN-LAST:event_DelTypeMouseReleased

    
    public void eventOK(MouseAdapter event) {
        Ok.addMouseListener(event);
    }
    
    public void eventDelete(MouseAdapter event) {
        Delete.addMouseListener(event);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.roundComponent.Button AddType;
    private GUI.roundComponent.Button DelType;
    private GUI.roundComponent.Button Delete;
    private GUI.roundComponent.RoundedTextField English;
    private GUI.roundComponent.Button Ok;
    private javax.swing.JLabel Tiltle;
    private GUI.roundComponent.Button cancel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private GUI.roundComponent.MaterialTabbed materialTabbed1;
    // End of variables declaration//GEN-END:variables
}

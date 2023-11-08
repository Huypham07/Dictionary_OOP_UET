package GUI.ControlPanel.Learn;

import Dict.DictionaryManagement;
import GUI.ControlPanel.AddGUI;
import GUI.ControlPanel.Search.EventClick;
import GUI.roundComponent.RoundedPanel;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import manageData.Datatype.Word;
import raven.glasspanepopup.GlassPanePopup;

public class AddnewTopic extends RoundedPanel {

    public AddnewTopic() {
        initComponents();
        topicChoose.setText("Topics");
        topicChoose.eventClickSugestPanel(new EventClick() {
        @Override
        public void itemClick(String data) {
            topicChoose.setText(data);
            topicChoose.setMenuVisible(false);
            topicChoose.setShow(false);
            newTopic.setText(data);
        }
    });
    }
    
    public String getTopic() {
        return newTopic.getText();
    }
    
    public void setTopicChoose(List<String> topics) {
        topicChoose.setTopics(topics);
    }
    
    

    public Word getWord() {
        Word result = new Word();
        result.setWordTarget(English.getText());
        result.setWordType(Type.getText());
        result.addExplain(Meaning.getText());
        return result;
    }
    
    public void eventOK(MouseAdapter event) {
        Ok.addMouseListener(event);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topicChoose = new GUI.ControlPanel.Learn.TopicChoosePanel();
        newTopic = new GUI.roundComponent.RoundedTextField();
        Tiltle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Type = new GUI.roundComponent.RoundedTextField();
        English = new GUI.roundComponent.RoundedTextField();
        cancel = new GUI.roundComponent.Button();
        Ok = new GUI.roundComponent.Button();
        Meaning = new GUI.roundComponent.RoundedTextField();

        setBackground(new java.awt.Color(215, 246, 248));
        setRoundBottomLeft(10);
        setRoundBottomRight(10);
        setRoundTopLeft(10);
        setRoundTopRight(10);

        topicChoose.setBackground(new java.awt.Color(255, 255, 255));
        topicChoose.setRoundBottomLeft(20);
        topicChoose.setRoundBottomRight(20);
        topicChoose.setRoundTopLeft(20);
        topicChoose.setRoundTopRight(20);

        newTopic.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        newTopic.setHintText("Choose a topic or add a new topic ...");

        Tiltle.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        Tiltle.setText(" Add Word");

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setOpaque(true);

        Type.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Type.setHintText("Type ...");

        English.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        English.setHintText("English ...");

        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelMouseReleased(evt);
            }
        });

        Ok.setText("Ok");

        Meaning.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Meaning.setHintText("Meaning ...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tiltle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newTopic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(topicChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Meaning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(English, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(Tiltle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(topicChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(English, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(Meaning, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseReleased
        if (SwingUtilities.isLeftMouseButton(evt)) {
            GlassPanePopup.closePopupLast();
        }
    }//GEN-LAST:event_cancelMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.roundComponent.RoundedTextField English;
    private GUI.roundComponent.RoundedTextField Meaning;
    private GUI.roundComponent.Button Ok;
    private javax.swing.JLabel Tiltle;
    private GUI.roundComponent.RoundedTextField Type;
    private GUI.roundComponent.Button cancel;
    private javax.swing.JLabel jLabel2;
    private GUI.roundComponent.RoundedTextField newTopic;
    private GUI.ControlPanel.Learn.TopicChoosePanel topicChoose;
    // End of variables declaration//GEN-END:variables
}

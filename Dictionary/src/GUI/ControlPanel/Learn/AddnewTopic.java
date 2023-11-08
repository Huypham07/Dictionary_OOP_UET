package GUI.ControlPanel.Learn;

import GUI.roundComponent.RoundedPanel;
import java.awt.event.MouseAdapter;
import javax.swing.SwingUtilities;
import manageData.Datatype.Word;
import raven.glasspanepopup.GlassPanePopup;

public class AddnewTopic extends RoundedPanel {

    public AddnewTopic(String topic) {
        initComponents();
        newTopic.setText(topic);
    }
    
    public String getTopic() {
        return newTopic.getText();
    }
    
    

    public Word getWord() {
        String eng = English.getText();
        String type = Type.getText();
        String mean = Meaning.getText();
        if (eng.isEmpty() || eng == null ||
            type.isEmpty() || type == null ||
            mean.isEmpty() || mean == null) {
            return null;
        }
        Word result = new Word();
        result.setWordTarget(eng);
        result.setWordType(type);
        result.addExplain(mean);
        return result;
    }
    
    public void eventOK(MouseAdapter event) {
        Ok.addMouseListener(event);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newTopic = new GUI.roundComponent.RoundedTextField();
        Tiltle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Type = new GUI.roundComponent.RoundedTextField();
        English = new GUI.roundComponent.RoundedTextField();
        cancel = new GUI.roundComponent.Button();
        Ok = new GUI.roundComponent.Button();
        Meaning = new GUI.roundComponent.RoundedTextField();

        setBackground(new java.awt.Color(215, 246, 248));
        setRoundBottomLeft(20);
        setRoundBottomRight(20);
        setRoundTopLeft(20);
        setRoundTopRight(20);

        newTopic.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        newTopic.setHintText("Add a new topic ...");

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
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 190, Short.MAX_VALUE))
                    .addComponent(Type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Meaning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(English, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(Tiltle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(newTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(English, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(Meaning, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
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
    // End of variables declaration//GEN-END:variables
}

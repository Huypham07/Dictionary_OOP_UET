package GUI.ControlPanel.AddWord;

import GUI.roundComponent.RoundedPanel;
import GUI.roundComponent.RoundedTextField;
import GUI.roundComponent.ScrollBarCustom;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import manageData.Datatype.Word;
import net.miginfocom.swing.MigLayout;
import raven.glasspanepopup.GlassPanePopup;

public class AddGUI extends RoundedPanel {
    private final List<RoundedTextField> meanings = new ArrayList<>();

    public AddGUI() {
        initComponents();
        
        scrollPane.setVerticalScrollBar(new ScrollBarCustom());
        panel.setLayout(new MigLayout("nogrid, fillx"));
        
        for (int i = 0; i < 3; i++) {
            RoundedTextField meaning = new RoundedTextField();
            meaning.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
            meaning.setHintText("Meaning " + (meanings.size() + 1) + " ...");
            meanings.add(meaning);
            panel.removeAll();
            panel.revalidate();
            for (RoundedTextField r : meanings) {
                panel.add(r, "growx, align left, w 100::90%, wrap, gaptop 10");
            }
            panel.repaint();            
        }
    }

    public Word getWord() {
        Word result = new Word();
        result.setWordTarget(English.getText());
        result.setWordType(Type.getText());
        for (RoundedTextField m : meanings) {
            if(!m.getText().isEmpty()) {
                result.addExplain(m.getText());
            }
            
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tiltle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cancel = new GUI.roundComponent.Button();
        Ok = new GUI.roundComponent.Button();
        jPanel1 = new javax.swing.JPanel();
        English = new GUI.roundComponent.RoundedTextField();
        addMeaning = new GUI.roundComponent.Button();
        Type = new GUI.roundComponent.RoundedTextField();

        setBackground(new java.awt.Color(215, 246, 248));
        setRoundBottomLeft(30);
        setRoundBottomRight(30);
        setRoundTopLeft(30);
        setRoundTopRight(30);

        Tiltle.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        Tiltle.setText(" Add Word");

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setOpaque(true);

        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);

        panel.setBackground(new java.awt.Color(215, 246, 248));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(panel);

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setOpaque(true);

        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelMousePressed(evt);
            }
        });

        Ok.setText("Ok");

        jPanel1.setOpaque(false);

        English.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        English.setHintText("English ...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(English, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(English, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        addMeaning.setText("Add meaning");
        addMeaning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addMeaningMousePressed(evt);
            }
        });

        Type.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Type.setHintText("Type ...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Tiltle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addMeaning, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tiltle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addMeaning, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            GlassPanePopup.closePopupLast();
        }
    }//GEN-LAST:event_cancelMousePressed

    private void addMeaningMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMeaningMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            RoundedTextField meaning = new RoundedTextField();
            meaning.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
            meaning.setHintText("Meaning " + (meanings.size() + 1) + " ...");
            meanings.add(meaning);
            panel.removeAll();
            panel.revalidate();
            for (RoundedTextField r : meanings) {
                panel.add(r, "growx, align left, w 100::90%, wrap, gaptop 10");
            }
            panel.repaint();
        }
    }//GEN-LAST:event_addMeaningMousePressed

    
    public void eventOK(MouseAdapter event) {
        Ok.addMouseListener(event);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.roundComponent.RoundedTextField English;
    private GUI.roundComponent.Button Ok;
    private javax.swing.JLabel Tiltle;
    private GUI.roundComponent.RoundedTextField Type;
    private GUI.roundComponent.Button addMeaning;
    private GUI.roundComponent.Button cancel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}

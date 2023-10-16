package GUI.ControlPanel;

import GUI.roundComponent.RoundedPanel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.*;

public class controlPanel extends RoundedPanel {
    
    private Animator animator;
    private int selectFunction = 0;

    public controlPanel() {
        super(0, 0, 40, 40);
        initComponents();
        initAnimator();
    }
    
    private void initAnimator() {
        animator = new Animator(1000, new TimingTargetAdapter());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logo = new GUI.roundComponent.circleComponent();
        Tiltle = new javax.swing.JLabel();
        circleComponent1 = new GUI.roundComponent.circleComponent();
        Translate = new GUI.roundComponent.Button();
        AddWord = new GUI.roundComponent.Button();
        EditWord = new GUI.roundComponent.Button();
        Export = new GUI.roundComponent.Button();

        setBackground(new java.awt.Color(29, 42, 87));

        Logo.setBackground(new java.awt.Color(254, 236, 166));
        Logo.setIcon(new javax.swing.ImageIcon("C:\\Users\\huyho\\OneDrive\\Desktop\\Dictionary\\DictionaryCommandline\\src\\main\\java\\data\\img\\logo.png")); // NOI18N
        Logo.setOpaque(true);

        Tiltle.setFont(new java.awt.Font("Segoe UI Black", 3, 44)); // NOI18N
        Tiltle.setForeground(new java.awt.Color(255, 255, 255));
        Tiltle.setText("Dictionary");
        Tiltle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        Translate.setText("Translate");
        Translate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TranslateActionPerformed(evt);
            }
        });

        AddWord.setText("Add Word");

        EditWord.setText("Learn");
        EditWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditWordActionPerformed(evt);
            }
        });

        Export.setText("Export to FIle");
        Export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Translate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(AddWord, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(EditWord, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Export, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Tiltle, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(circleComponent1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(circleComponent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tiltle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Translate, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                    .addComponent(AddWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EditWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Export, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExportActionPerformed

    private void TranslateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TranslateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TranslateActionPerformed

    private void EditWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditWordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditWordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.roundComponent.Button AddWord;
    private GUI.roundComponent.Button EditWord;
    private GUI.roundComponent.Button Export;
    private GUI.roundComponent.circleComponent Logo;
    private javax.swing.JLabel Tiltle;
    private GUI.roundComponent.Button Translate;
    private GUI.roundComponent.circleComponent circleComponent1;
    // End of variables declaration//GEN-END:variables
}

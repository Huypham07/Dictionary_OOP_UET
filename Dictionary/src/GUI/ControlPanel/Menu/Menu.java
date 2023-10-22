package GUI.ControlPanel.Menu;

import static GUI.DictionaryGUI.change;

public class Menu extends javax.swing.JPanel {
    
    private int itemSelect = 0;

    public int getItemSelect() {
        return itemSelect;
    }

    public void setItemSelect(int itemSelect) {
        this.itemSelect = itemSelect;
    }

    public Menu() {
        initComponents();
        lookup.setSelected(true);
    }

    private void unSelectAll() {
        lookup.setSelected(false); //0
        translate.setSelected(false); //1
        addword.setSelected(false); //2
        learn.setSelected(false); //3
        export.setSelected(false); //4
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lookup = new GUI.ControlPanel.Menu.MenuItem();
        translate = new GUI.ControlPanel.Menu.MenuItem();
        addword = new GUI.ControlPanel.Menu.MenuItem();
        learn = new GUI.ControlPanel.Menu.MenuItem();
        export = new GUI.ControlPanel.Menu.MenuItem();

        setBackground(new java.awt.Color(29, 42, 87));
        setForeground(new java.awt.Color(255, 255, 255));

        lookup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/look up.png"))); // NOI18N
        lookup.setText("Look up");
        lookup.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lookup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lookupMousePressed(evt);
            }
        });

        translate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/translate.png"))); // NOI18N
        translate.setText("Translate");
        translate.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        translate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                translateMousePressed(evt);
            }
        });

        addword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/add.png"))); // NOI18N
        addword.setText("Add Word");
        addword.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        addword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addwordMousePressed(evt);
            }
        });

        learn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/learn.png"))); // NOI18N
        learn.setText("Learn");
        learn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        learn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                learnMousePressed(evt);
            }
        });

        export.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/export.png"))); // NOI18N
        export.setText("Export");
        export.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        export.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exportMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(lookup, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(translate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(addword, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(learn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(export, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lookup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(translate, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(addword, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(learn, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(export, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lookupMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lookupMousePressed
        unSelectAll();
        itemSelect = 0;
        lookup.setSelected(true);
        change(itemSelect);
    }//GEN-LAST:event_lookupMousePressed

    private void translateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_translateMousePressed
        unSelectAll();
        itemSelect = 1;
        translate.setSelected(true);
        change(itemSelect);
    }//GEN-LAST:event_translateMousePressed

    private void addwordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addwordMousePressed
        unSelectAll();
        itemSelect = 2;
        addword.setSelected(true);
    }//GEN-LAST:event_addwordMousePressed

    private void learnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_learnMousePressed
        unSelectAll();
        itemSelect = 3;
        learn.setSelected(true);
    }//GEN-LAST:event_learnMousePressed

    private void exportMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportMousePressed
        unSelectAll();
        itemSelect = 4;
        export.setSelected(true);
    }//GEN-LAST:event_exportMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.ControlPanel.Menu.MenuItem addword;
    private GUI.ControlPanel.Menu.MenuItem export;
    private GUI.ControlPanel.Menu.MenuItem learn;
    private GUI.ControlPanel.Menu.MenuItem lookup;
    private GUI.ControlPanel.Menu.MenuItem translate;
    // End of variables declaration//GEN-END:variables
}

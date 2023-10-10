package GUI.ControlPanel;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPopupMenu;
import Dict.DictionaryManagement;


public class LookupGUI extends javax.swing.JPanel {
    
    private DictionaryManagement Dictmng;
    public void setDictionay(DictionaryManagement Dictmng) {
        this.Dictmng = Dictmng;
    }

    private JPopupMenu menu;
    private searchSuggestPanel suggestPanel;
    
    public LookupGUI() {
        initComponents();
        menu = new JPopupMenu();
        suggestPanel = new searchSuggestPanel();
        menu.setBorder(BorderFactory.createLineBorder(new Color(245, 242, 242)));
        menu.add(suggestPanel);
        menu.setFocusable(false);
        suggestPanel.addEventClick(new EventClick() {
            @Override
            public void itemClick(String data) {
                menu.setVisible(false);
                textBar.setText(data);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconSearch = new GUI.roundComponent.circleComponent();
        textBar = new GUI.roundComponent.TextFieldAnimation();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        iconSearch.setIcon(new javax.swing.ImageIcon("C:\\Users\\huyho\\OneDrive\\Desktop\\Dictionary\\DictionaryCommandline\\src\\main\\java\\data\\img\\translate.png")); // NOI18N
        iconSearch.setOpaque(true);

        javax.swing.GroupLayout iconSearchLayout = new javax.swing.GroupLayout(iconSearch);
        iconSearch.setLayout(iconSearchLayout);
        iconSearchLayout.setHorizontalGroup(
            iconSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        iconSearchLayout.setVerticalGroup(
            iconSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        textBar.setBackground(new java.awt.Color(245, 242, 242));
        textBar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        textBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textBarMouseClicked(evt);
            }
        });
        textBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(textBar, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iconSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(textBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(490, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textBarMouseClicked
        if (suggestPanel.getItemSize() > 0) {
            menu.show(textBar, 0, textBar.getHeight());
        }
    }//GEN-LAST:event_textBarMouseClicked

    private void textBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBarKeyReleased
        String text = textBar.getText().trim().toLowerCase();
        if (!this.Dictmng.validWord(text)) {
            suggestPanel.setSuggestData(this.Dictmng.findWordsWithPrefix(""));//"list string da tim"
            if (suggestPanel.getItemSize() > 0) {
                //  * 2 top and bot border
                menu.show(textBar, 0, textBar.getHeight());
                menu.setPopupSize(menu.getWidth(), (suggestPanel.getItemSize() * 35) + 2);
            } 
            menu.setVisible(false);
        }
        else {
            suggestPanel.setSuggestData(this.Dictmng.findWordsWithPrefix(text));//"list string da tim"
            if (suggestPanel.getItemSize() > 0) {
                //  * 2 top and bot border
                menu.show(textBar, 0, textBar.getHeight());
                menu.setPopupSize(menu.getWidth(), (suggestPanel.getItemSize() * 35) + 2);
            } else {
                menu.setVisible(false);
            }
        }
    }//GEN-LAST:event_textBarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.roundComponent.circleComponent iconSearch;
    private GUI.roundComponent.TextFieldAnimation textBar;
    // End of variables declaration//GEN-END:variables
}

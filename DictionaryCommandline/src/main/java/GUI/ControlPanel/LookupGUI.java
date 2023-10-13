package GUI.ControlPanel;

import GUI.ControlPanel.Lookup.EventClick;
import GUI.ControlPanel.Lookup.searchSuggestPanel;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPopupMenu;
import Dict.DictionaryManagement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import manageData.Datatype.Word;


public class LookupGUI extends javax.swing.JPanel {
    private DictionaryManagement Dictmng;
    public void setDictionay(DictionaryManagement Dictmng) {
        this.Dictmng = Dictmng;
    }

    private JPopupMenu menu;
    private searchSuggestPanel suggestPanel;
    
    public LookupGUI() {
        initComponents();
        
        changeVisible(false);
        
        menu = new JPopupMenu();
        suggestPanel = new searchSuggestPanel();
        menu.setBorder(BorderFactory.createLineBorder(new Color(245, 242, 242)));
        menu.add(suggestPanel);
        menu.setFocusable(false);
        suggestPanel.addEventClick(new EventClick() {
            @Override
            public void itemClick(String data) {
                textBar.setText(data);
                suggestPanel.setSuggestData(Dictmng.findWordsWithPrefix(data));
                menu.show(textBar, 0, textBar.getHeight());
                menu.setPopupSize(menu.getWidth(), (suggestPanel.getItemSize() * 35) + 2);
                menu.setVisible(false);
            }
        });
    }
    
    private void changeVisible(boolean visible) {
        WordTarget.setVisible(visible);
        wordType.setVisible(visible);
        line.setVisible(visible);
        resultBoard.setVisible(visible);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconSearch = new GUI.roundComponent.circleComponent();
        textBar = new GUI.ControlPanel.Lookup.TextFieldAnimation();
        jPanel1 = new javax.swing.JPanel();
        WordTarget = new javax.swing.JLabel();
        wordType = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        resultBoard = new GUI.ControlPanel.Lookup.ResultBoard();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        iconSearch.setIcon(new javax.swing.ImageIcon("C:\\Users\\huyho\\OneDrive\\Desktop\\Dictionary\\DictionaryCommandline\\src\\main\\java\\data\\img\\lookup.png")); // NOI18N
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textBarMousePressed(evt);
            }
        });
        textBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textBarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBarKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        WordTarget.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        WordTarget.setForeground(new java.awt.Color(45, 45, 45));
        WordTarget.setText("Word");

        wordType.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        wordType.setForeground(new java.awt.Color(0, 48, 97));
        wordType.setText("word type - từ loại");

        jLabel1.setBackground(new java.awt.Color(220, 220, 220));
        jLabel1.setOpaque(true);

        line.setBackground(new java.awt.Color(153, 153, 153));
        line.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(line, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(WordTarget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wordType, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(resultBoard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(WordTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wordType, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
        );

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
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(53, 53, 53)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textBarMouseClicked
        if (!textBar.checkMouseOver(evt.getPoint())) {
            if (suggestPanel.getItemSize() > 0) {
                menu.show(textBar, 0, textBar.getHeight());
            }
        }
    }//GEN-LAST:event_textBarMouseClicked

    private void textBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBarKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && 
                evt.getKeyCode() != KeyEvent.VK_ENTER && evt.getKeyCode() != KeyEvent.VK_ESCAPE) {
            String text = textBar.getText().trim();
            if (!this.Dictmng.validWord(text)) {
                suggestPanel.setSuggestData(this.Dictmng.findWordsWithPrefix(""));
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
        }
    }//GEN-LAST:event_textBarKeyReleased

    private void processing() {
        textBar.execute_searching();
        Word result = Dictmng.findWord(textBar.getText().trim());
        Timer timer = new Timer(600, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Đoạn mã trong này sẽ được thực thi sau khi đợi (delay) kết thúc
                if (textBar.getShow()) {
                    textBar.close_searching();
                    if (result != null) {
                        WordTarget.setText(result.getWord_target());
                        resultBoard.setData(result.getWord_explain());
                        
                        String type = result.getWordType();
                        if (type.equals("noun")) {
                            wordType.setText(type + " - danh từ");
                        } else if (type.equals("adj")) {
                            wordType.setText(type + " - tính từ");
                        } else if (type.equals("verb")) {
                            wordType.setText(type + " - động từ");
                        }
                        
                        changeVisible(true);
                    }
                }
            }
        });

        // Kích hoạt Timer để bắt đầu đợi
        timer.setRepeats(false);  // Đặt timer chỉ chạy một lần
        timer.start();
    }
            
    private void textBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            menu.setVisible(false);
            String key = suggestPanel.getSelectedText();
            if (!key.isEmpty()) {
                textBar.setText(key);
            }
            processing();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            menu.setVisible(false);
            if (textBar.getShow()) {
                textBar.close_searching();    
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            if (menu.isVisible()) {
                suggestPanel.keyUp();
                textBar.setText(suggestPanel.getSelectedText());
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN){
            if (menu.isVisible()) {
                suggestPanel.keyDown();
                textBar.setText(suggestPanel.getSelectedText());
            }
        }
    }//GEN-LAST:event_textBarKeyPressed

    private void textBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textBarMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            if (textBar.checkMouseOver(evt.getPoint())) {
                if (!textBar.getShow()) {
                    processing();
                } else {
                    textBar.close_searching();
                }
            }
        }
    }//GEN-LAST:event_textBarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel WordTarget;
    private GUI.roundComponent.circleComponent iconSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel line;
    private GUI.ControlPanel.Lookup.ResultBoard resultBoard;
    private GUI.ControlPanel.Lookup.TextFieldAnimation textBar;
    private javax.swing.JLabel wordType;
    // End of variables declaration//GEN-END:variables
}

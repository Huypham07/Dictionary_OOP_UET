package GUI.ControlPanel;

import GUI.ControlPanel.Learn.WordPanel;
import GUI.ControlPanel.Search.EventClick;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JPanel;

public class LearnGUI extends JPanel {
    private List<List<Component>> list = new ArrayList<>();
    
    public LearnGUI() {
        initComponents();
        showButton.setBackground(new Color(153, 204, 255));
        prevButton.setBackground(new Color(153, 204, 255));
        nextButton.setBackground(new Color(153, 204, 255));
        shuffleButton.setBackground(new Color(153, 204, 255));
        
        topicChoose.eventClickSugestPanel(new EventClick() {
            @Override
            public void itemClick(String data) {
                topicChoose.setText(data);
                topicChoose.setMenuVisible(false);
                topicChoose.setShow(false);
                slideroundedPanel.clear();
                slideroundedPanel.addComponent(list.get(topicChoose.getChoose()));
                slideroundedPanel.startShow();
                WordPanel curr = (WordPanel)slideroundedPanel.getCurrentComponent();
                curr.ShowExplain(false);
                changeStateOfshowButton(curr.isShow());
            }
        });
    }
    
    public void addComponent(Component ...com) {
        slideroundedPanel.addComponent(com);
    }
    
    public void addComponent(List<Component> com) {
        list.add(com);
    }
    
    public void setTopicChoose(List<String> topics) {
        topicChoose.setTopics(topics);
    }
    
    public void startLearn() {
        topicChoose.setText("Topics");
        slideroundedPanel.clear();
        slideroundedPanel.addComponent(new WordPanel("English", "type", "Explain"));
        slideroundedPanel.startShow();
    }
    
    private void changeStateOfshowButton(boolean show) {
        if (show) {
            showButton.setText("Hide");
        } else {
            showButton.setText("Show");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showButton = new GUI.roundComponent.Button();
        prevButton = new GUI.roundComponent.Button();
        nextButton = new GUI.roundComponent.Button();
        slideroundedPanel = new GUI.ControlPanel.Learn.SlideRoundedPanel();
        topicChoose = new GUI.ControlPanel.Learn.TopicChoosePanel();
        shuffleButton = new GUI.roundComponent.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        showButton.setText("Show");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        prevButton.setText("Prev");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        slideroundedPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                slideroundedPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout slideroundedPanelLayout = new javax.swing.GroupLayout(slideroundedPanel);
        slideroundedPanel.setLayout(slideroundedPanelLayout);
        slideroundedPanelLayout.setHorizontalGroup(
            slideroundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        slideroundedPanelLayout.setVerticalGroup(
            slideroundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        topicChoose.setBackground(new java.awt.Color(153, 204, 255));
        topicChoose.setRoundBottomLeft(20);
        topicChoose.setRoundBottomRight(20);
        topicChoose.setRoundTopLeft(20);
        topicChoose.setRoundTopRight(20);

        shuffleButton.setText("Shuffle");
        shuffleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shuffleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(shuffleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addComponent(slideroundedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topicChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(345, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(topicChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(slideroundedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shuffleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        slideroundedPanel.show(slideroundedPanel.getCurrentShowing() + 1);
        WordPanel curr = (WordPanel)slideroundedPanel.getCurrentComponent();
        curr.ShowExplain(false);
        changeStateOfshowButton(curr.isShow());
    }//GEN-LAST:event_nextButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        slideroundedPanel.show(slideroundedPanel.getCurrentShowing() - 1);
        WordPanel curr = (WordPanel)slideroundedPanel.getCurrentComponent();
        curr.ShowExplain(false);
        changeStateOfshowButton(curr.isShow());
    }//GEN-LAST:event_prevButtonActionPerformed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        WordPanel curr = (WordPanel)slideroundedPanel.getCurrentComponent();
        curr.ShowExplain(!curr.isShow());
        changeStateOfshowButton(curr.isShow());
    }//GEN-LAST:event_showButtonActionPerformed

    private void slideroundedPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slideroundedPanelMousePressed
        WordPanel curr = (WordPanel)slideroundedPanel.getCurrentComponent();
        curr.ShowExplain(!curr.isShow());
        changeStateOfshowButton(curr.isShow());
    }//GEN-LAST:event_slideroundedPanelMousePressed

    private void shuffleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shuffleButtonActionPerformed
        int choice = topicChoose.getChoose();
        if (choice >= 0) {
            List<Component> copyList;
            copyList = new ArrayList<>(list.get(choice));
            Collections.shuffle(copyList);
            slideroundedPanel.clear();
            slideroundedPanel.addComponent(copyList);
            slideroundedPanel.startShow();
        }
    }//GEN-LAST:event_shuffleButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.roundComponent.Button nextButton;
    private GUI.roundComponent.Button prevButton;
    private GUI.roundComponent.Button showButton;
    private GUI.roundComponent.Button shuffleButton;
    private GUI.ControlPanel.Learn.SlideRoundedPanel slideroundedPanel;
    private GUI.ControlPanel.Learn.TopicChoosePanel topicChoose;
    // End of variables declaration//GEN-END:variables
}

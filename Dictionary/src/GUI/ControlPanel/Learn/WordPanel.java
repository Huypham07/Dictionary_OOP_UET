package GUI.ControlPanel.Learn;

import GUI.roundComponent.RoundedPanel;

public class WordPanel extends RoundedPanel {

    private String showExplain;
    private boolean Show;

    public boolean isShow() {
        return Show;
    }
    
    public WordPanel(String EWord, String wordType, String Explain) {
        initComponents();
        this.EWord.setText(EWord);
        this.wordType.setText("(" + wordType + ")");
        this.Explain.setText("");
        showExplain = Explain;
        Show = false;
    }
    
    public void ShowExplain(boolean show) {
        if (show) {
            Explain.setText(showExplain);
        } else {
            Explain.setText("");
        }
        Show = show;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EWord = new javax.swing.JLabel();
        wordType = new javax.swing.JLabel();
        Explain = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 239, 184));
        setRoundBottomLeft(30);
        setRoundBottomRight(30);
        setRoundTopLeft(30);
        setRoundTopRight(30);

        EWord.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        EWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EWord.setText("English");

        wordType.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        wordType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wordType.setText("Type");

        Explain.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        Explain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Explain.setText("Explain");
        Explain.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EWord, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                    .addComponent(wordType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Explain, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(EWord, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(wordType)
                .addGap(30, 30, 30)
                .addComponent(Explain, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EWord;
    private javax.swing.JLabel Explain;
    private javax.swing.JLabel wordType;
    // End of variables declaration//GEN-END:variables
}

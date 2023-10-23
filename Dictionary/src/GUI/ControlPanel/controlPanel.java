package GUI.ControlPanel;

import GUI.roundComponent.RoundedPanel;

public class controlPanel extends RoundedPanel {

    public controlPanel() {
        super(0, 0, 40, 40);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logo = new GUI.roundComponent.circleComponent();
        Tiltle = new javax.swing.JLabel();
        circleComponent1 = new GUI.roundComponent.circleComponent();
        menu = new GUI.ControlPanel.Menu.Menu();

        setBackground(new java.awt.Color(29, 42, 87));

        Logo.setBackground(new java.awt.Color(254, 236, 166));
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/logo.png"))); // NOI18N
        Logo.setOpaque(true);

        Tiltle.setFont(new java.awt.Font("Segoe UI Black", 3, 44)); // NOI18N
        Tiltle.setForeground(new java.awt.Color(255, 255, 255));
        Tiltle.setText("Dictionary");
        Tiltle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        circleComponent1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tiltle, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Tiltle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.roundComponent.circleComponent Logo;
    private javax.swing.JLabel Tiltle;
    private GUI.roundComponent.circleComponent circleComponent1;
    private GUI.ControlPanel.Menu.Menu menu;
    // End of variables declaration//GEN-END:variables
}

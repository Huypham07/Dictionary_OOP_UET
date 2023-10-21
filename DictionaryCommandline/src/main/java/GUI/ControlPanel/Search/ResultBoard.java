package GUI.ControlPanel.Search;

import GUI.roundComponent.ScrollBarCustom;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;

public class ResultBoard extends javax.swing.JPanel {

    public ResultBoard() {
        initComponents();
        setBackground(Color.WHITE);
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        panel.setLayout(new MigLayout("nogrid, fillx"));
    }
    
    public void setData(ArrayList<String> data) {
        panel.removeAll();
        panel.revalidate();
        for (int i = 0; i < data.size(); i++) {
            JTextPane txt = new JTextPane();
            txt.setBackground(Color.WHITE);
            txt.setFont(new Font("sansserif", 1, 20));
            txt.setForeground(new Color(80, 80, 80));
            txt.setSelectionColor(new Color(150, 150, 150));
            txt.setBorder(null);
            txt.setOpaque(false);
            txt.setEditable(false);
            txt.setText("•      " + data.get(i));
            panel.add(txt, "growx, align left, w 100::90%, wrap, gaptop 10");
        }
    }
    
    public void setData(String data) {
        panel.removeAll();
        panel.revalidate();
        JTextPane txt = new JTextPane();
        txt.setBackground(Color.WHITE);
        txt.setFont(new Font("sansserif", 1, 20));
        txt.setForeground(new Color(80, 80, 80));
        txt.setSelectionColor(new Color(150, 150, 150));
        txt.setBorder(null);
        txt.setOpaque(false);
        txt.setEditable(false);
        txt.setText(data);
        panel.add(txt, "growx, align left, w 100::90%, wrap, gaptop 10");
    }

    public void setHintData(String data) {
        panel.removeAll();
        panel.revalidate();
        JTextPane txt = new JTextPane();
        txt.setBackground(Color.WHITE);
        txt.setFont(new Font("sansserif", 1, 18));
        int c0 = getBackground().getRGB();
        int c1 = getForeground().getRGB();
        int m = 0xfefefefe;
        int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
        txt.setForeground(new Color(c2, true));
        txt.setSelectionColor(new Color(150, 150, 150));
        txt.setBorder(null);
        txt.setOpaque(false);
        txt.setEditable(false);
        txt.setText(data);
        panel.add(txt, "growx, align left, w 100::90%, wrap, gaptop 10");
    }
    public void scrollToTop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jScrollPane1.getVerticalScrollBar().setValue(0);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setAutoscrolls(true);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}

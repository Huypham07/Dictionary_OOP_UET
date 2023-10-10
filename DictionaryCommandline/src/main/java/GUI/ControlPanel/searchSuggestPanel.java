package GUI.ControlPanel;

import GUI.roundComponent.RoundedPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import net.miginfocom.swing.MigLayout;

public class searchSuggestPanel extends RoundedPanel {
    private EventClick event;
    
    public void addEventClick(EventClick event) {
        this.event = event;
    }

    public searchSuggestPanel() {
        super(10, 10, 10, 10);
        initComponents();
        setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
    }

    public void setSuggestData(ArrayList<String> data) {
        this.removeAll();
        int cnt = 0;
        for (String d : data) {
            if (cnt >= 8) break; // max of suggest can show
            
            SearchItem item = new SearchItem(d);
            //  add event
            item.addEvent(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    //  when click
                    event.itemClick(d);
                }
            });
            this.add(item, "wrap");
            //  wrap mean add to new row after this add
            cnt++;
        }
        repaint();
        revalidate();
        //  Refresh Component
    }
    
    public int getItemSize() {
        return getComponentCount();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

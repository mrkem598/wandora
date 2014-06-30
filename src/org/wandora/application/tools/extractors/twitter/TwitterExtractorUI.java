/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 * 
 * Copyright (C) 2004-2014 Wandora Team
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * 
 * TwitterExtractorUI.java
 *
 * Created on 4.11.2011, 15:11:25
 */

package org.wandora.application.tools.extractors.twitter;

import java.util.ArrayList;
import javax.swing.JDialog;
import org.wandora.application.Wandora;
import org.wandora.application.WandoraTool;
import org.wandora.application.gui.simple.SimpleButton;
import org.wandora.application.gui.simple.SimpleField;
import org.wandora.application.gui.simple.SimpleLabel;
import org.wandora.application.gui.simple.SimpleTabbedPane;
import org.wandora.utils.Tuples.T2;
import twitter4j.GeoLocation;
import twitter4j.Paging;
import twitter4j.Query;

/**
 *
 * @author akivela
 */


public class TwitterExtractorUI extends javax.swing.JPanel {

    
    private JDialog myDialog = null;
    
    private boolean wasAccepted = false;
    private boolean shouldReset = false;
    
    /** Creates new form TwitterExtractorUI */
    public TwitterExtractorUI() {
        initComponents();
    }
    
    public boolean wasAccepted() {
        return wasAccepted;
    }
    
    public boolean shouldResetTwitter() {
        return shouldReset;
    }
    
    
    public Query[] getSearchQuery() {
        String query = queryTextField.getText();
        String lang = langTextField.getText().trim();
        String until = untilTextField.getText().trim();
        String since = sinceTextField.getText().trim();
        GeoLocation geol = solveGeoLocation();
        double distance = solveDistance();
        ArrayList<Query> queries = new ArrayList();
        
        Query q = new Query(query);

        if(lang.length() > 0) q.setLang(lang);
        if(until.length() > 0) q.setUntil(until);
        if(since.length() > 0) q.setSince(since);
        if(geol != null) q.setGeoCode(geol, distance, Query.KILOMETERS);

        q.count(100);

        queries.add(q);

        return queries.toArray( new Query[] {} );
    }
    

    
    public void openDialog(Wandora w, WandoraTool caller) {
        myDialog = new JDialog(w, true);
        myDialog.add(this);
        myDialog.setTitle("Twitter extractor");
        myDialog.setSize(500, 300);
        w.centerWindow(myDialog);
        wasAccepted = false;
        shouldReset = false;
        myDialog.setVisible(true);
    }
    
    

    
    
    
    public int getPages() {
        String p = numberTextField.getText();
        try {
            int pint = Integer.parseInt(p);
            if(pint > 0) return pint;
        }
        catch(Exception e) {
            
        }
        return 0;
    }
    
    
    
    private GeoLocation solveGeoLocation() {
        String latstr = latTextField.getText().trim();
        String longstr = longTextField.getText().trim();
        if(latstr.length() > 0 && longstr.length() > 0) {
            try {
                double lat = Double.parseDouble(latstr);
                double lon = Double.parseDouble(longstr);
                return new GeoLocation(lat, lon);
            }
            catch(Exception e) {}
        }
        return null;
    }
    
    
    private double solveDistance() {
        String distanceStr = distanceTextField.getText().trim();
        double distance = 10;
        try {
            distance = Double.parseDouble(distanceStr);
        }
        catch(Exception e) {}
        return distance;
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        twitterTabbedPane = new SimpleTabbedPane();
        searchPanel = new javax.swing.JPanel();
        searchPanelInner = new javax.swing.JPanel();
        searchLabel = new SimpleLabel();
        queryTextField = new SimpleField();
        searchOptionsPanel = new javax.swing.JPanel();
        numberLabel = new SimpleLabel();
        numberTextField = new SimpleField();
        langLabel = new SimpleLabel();
        langTextField = new SimpleField();
        untilLabel = new SimpleLabel();
        untilTextField = new SimpleField();
        sinceLabel = new SimpleLabel();
        sinceTextField = new SimpleField();
        geoLocationLabel = new SimpleLabel();
        geoLocationPanel = new javax.swing.JPanel();
        latTextField = new SimpleField();
        longTextField = new SimpleField();
        distanceTextField = new SimpleField();
        buttonPanel = new javax.swing.JPanel();
        resetButton = new SimpleButton();
        fillerPanel = new javax.swing.JPanel();
        okButton = new SimpleButton();
        cancelButton = new SimpleButton();

        setLayout(new java.awt.GridBagLayout());

        searchPanel.setLayout(new java.awt.GridBagLayout());

        searchPanelInner.setLayout(new java.awt.GridBagLayout());

        searchLabel.setText("Search Twitter with a query");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        searchPanelInner.add(searchLabel, gridBagConstraints);

        queryTextField.setMinimumSize(new java.awt.Dimension(6, 21));
        queryTextField.setPreferredSize(new java.awt.Dimension(6, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        searchPanelInner.add(queryTextField, gridBagConstraints);

        searchOptionsPanel.setLayout(new java.awt.GridBagLayout());

        numberLabel.setText("Last page number (page size is 100)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 4);
        searchOptionsPanel.add(numberLabel, gridBagConstraints);

        numberTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        numberTextField.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        searchOptionsPanel.add(numberTextField, gridBagConstraints);

        langLabel.setText("Lang (ISO 639-1)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 4);
        searchOptionsPanel.add(langLabel, gridBagConstraints);

        langTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        langTextField.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        searchOptionsPanel.add(langTextField, gridBagConstraints);

        untilLabel.setText("Until (YYYY-MM-DD)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 4);
        searchOptionsPanel.add(untilLabel, gridBagConstraints);

        untilTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        untilTextField.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        searchOptionsPanel.add(untilTextField, gridBagConstraints);

        sinceLabel.setText("Since (YYYY-MM-DD)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 4);
        searchOptionsPanel.add(sinceLabel, gridBagConstraints);

        sinceTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        sinceTextField.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        searchOptionsPanel.add(sinceTextField, gridBagConstraints);

        geoLocationLabel.setText("Geo location (lat, long, distance)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 4);
        searchOptionsPanel.add(geoLocationLabel, gridBagConstraints);

        geoLocationPanel.setLayout(new java.awt.GridBagLayout());

        latTextField.setMinimumSize(new java.awt.Dimension(60, 20));
        latTextField.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 2);
        geoLocationPanel.add(latTextField, gridBagConstraints);

        longTextField.setMinimumSize(new java.awt.Dimension(60, 20));
        longTextField.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 2);
        geoLocationPanel.add(longTextField, gridBagConstraints);

        distanceTextField.setMinimumSize(new java.awt.Dimension(60, 20));
        distanceTextField.setPreferredSize(new java.awt.Dimension(60, 20));
        geoLocationPanel.add(distanceTextField, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        searchOptionsPanel.add(geoLocationPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        searchPanelInner.add(searchOptionsPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        searchPanel.add(searchPanelInner, gridBagConstraints);

        twitterTabbedPane.addTab("Search", searchPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(twitterTabbedPane, gridBagConstraints);
        twitterTabbedPane.getAccessibleContext().setAccessibleName("TwitterTabs");

        buttonPanel.setLayout(new java.awt.GridBagLayout());

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        buttonPanel.add(resetButton, gridBagConstraints);

        fillerPanel.setMinimumSize(new java.awt.Dimension(4, 4));
        fillerPanel.setPreferredSize(new java.awt.Dimension(4, 4));
        fillerPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        buttonPanel.add(fillerPanel, gridBagConstraints);

        okButton.setText("Extract");
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                okButtonMouseReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 3);
        buttonPanel.add(okButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelButtonMouseReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 4);
        buttonPanel.add(cancelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(buttonPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseReleased
        wasAccepted = false;
        if(myDialog != null) myDialog.setVisible(false);
    }//GEN-LAST:event_cancelButtonMouseReleased

    private void okButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseReleased
        wasAccepted = true;
        if(myDialog != null) myDialog.setVisible(false);
    }//GEN-LAST:event_okButtonMouseReleased

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        shouldReset = true;
    }//GEN-LAST:event_resetButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField distanceTextField;
    private javax.swing.JPanel fillerPanel;
    private javax.swing.JLabel geoLocationLabel;
    private javax.swing.JPanel geoLocationPanel;
    private javax.swing.JLabel langLabel;
    private javax.swing.JTextField langTextField;
    private javax.swing.JTextField latTextField;
    private javax.swing.JTextField longTextField;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JTextField numberTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField queryTextField;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchOptionsPanel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel searchPanelInner;
    private javax.swing.JLabel sinceLabel;
    private javax.swing.JTextField sinceTextField;
    private javax.swing.JTabbedPane twitterTabbedPane;
    private javax.swing.JLabel untilLabel;
    private javax.swing.JTextField untilTextField;
    // End of variables declaration//GEN-END:variables
}

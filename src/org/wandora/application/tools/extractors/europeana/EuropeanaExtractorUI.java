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
 */

package org.wandora.application.tools.extractors.europeana;

import java.net.URLEncoder;
import java.util.ArrayList;
import javax.swing.JDialog;
import org.wandora.application.Wandora;
import org.wandora.application.WandoraTool;
import org.wandora.application.contexts.Context;
import org.wandora.application.gui.UIBox;
import org.wandora.application.gui.WandoraOptionPane;
import org.wandora.application.gui.simple.SimpleButton;
import org.wandora.application.gui.simple.SimpleField;
import org.wandora.application.gui.simple.SimpleLabel;
import org.wandora.topicmap.TopicMapException;

/**
 *
 * @author nlaitinen
 */

public class EuropeanaExtractorUI extends javax.swing.JPanel {
    
    private Wandora wandora = null;
    private boolean accepted = false;
    private JDialog dialog = null;
    private Context context = null;
    private static final String EUROPEANA_API_BASE = "http://www.europeana.eu/api/v2/search.json";


    /**
     * Creates new form EuropeanaExtractorUI
     */
    public EuropeanaExtractorUI() {
        initComponents();
    }
    
    public boolean wasAccepted() {
        return accepted;
    }

    public void setAccepted(boolean b) {
        accepted = b;
    }

    public void open(Wandora w, Context c) {
        context = c;
        accepted = false;
        dialog = new JDialog(w, true);
        dialog.setSize(420, 200);
        dialog.add(this);
        dialog.setTitle("Europeana API extractor");
        UIBox.centerWindow(dialog, w);
        if(apiKey != null){
            forgetKeyButton.setEnabled(true);
        } else {
            forgetKeyButton.setEnabled(false);
        }
        dialog.setVisible(true);
    }

    public WandoraTool[] getExtractors(EuropeanaExtractor tool) throws TopicMapException {
        WandoraTool wt = null;
        ArrayList<WandoraTool> wts = new ArrayList();

        // ***** SEARCH *****
        String query = searchTextField.getText();
        String key = solveAPIKey();
        
        if(key == null) {
            accepted = false;
            return null;
        }
         
        String extractUrl = EUROPEANA_API_BASE + "?wskey=" + key + "&profile=standard&query=" + urlEncode(query);

        System.out.println("Search URL: " + extractUrl);

        EuropeanaSearchExtractor ex = new EuropeanaSearchExtractor();
        ex.setForceUrls(new String[]{extractUrl});
        wt = ex;
        wts.add(wt);
        
        return wts.toArray(new WandoraTool[]{});
    }

    protected static String urlEncode(String str) {
        try {
            str = URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
        }
        return str;
    }
    
    
    // -------------------  Forget API Key -------------------------------------
    
    private static String apiKey = null;

    
    public String solveAPIKey(Wandora wandora) {
        return solveAPIKey();
    }
    
    public String solveAPIKey() {
        if(apiKey == null){
            apiKey = "";
            apiKey = WandoraOptionPane.showInputDialog(Wandora.getWandora(), "Please give an API Key for Europeana API search. You can register your API Key at http://pro.europeana.eu/api", apiKey, "Europeana  API Key", WandoraOptionPane.QUESTION_MESSAGE);
            if(apiKey != null) { 
                apiKey = apiKey.trim();
            }
        }
        
        forgetKeyButton.setEnabled(true);
        return apiKey;   
    }
    
    public void forgetAuthorization() {
        apiKey = null;
        forgetKeyButton.setEnabled(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        headlineLabel = new SimpleLabel();
        searchTextField = new SimpleField();
        bottomPanel = new javax.swing.JPanel();
        forgetKeyButton = new SimpleButton();
        fillerPanel = new javax.swing.JPanel();
        okButton = new SimpleButton();
        cancelButton = new SimpleButton();

        setLayout(new java.awt.GridBagLayout());

        mainPanel.setLayout(new java.awt.GridBagLayout());

        topPanel.setLayout(new java.awt.GridBagLayout());

        headlineLabel.setText("Search Europeana database by entering search term");
        headlineLabel.setMaximumSize(new java.awt.Dimension(64, 14));
        headlineLabel.setMinimumSize(new java.awt.Dimension(64, 14));
        headlineLabel.setPreferredSize(new java.awt.Dimension(64, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        topPanel.add(headlineLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        topPanel.add(searchTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        mainPanel.add(topPanel, gridBagConstraints);

        bottomPanel.setMinimumSize(new java.awt.Dimension(250, 25));
        bottomPanel.setPreferredSize(new java.awt.Dimension(250, 25));
        bottomPanel.setLayout(new java.awt.GridBagLayout());

        forgetKeyButton.setText("Forget API Key");
        forgetKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgetKeyActionPerformed(evt);
            }
        });
        bottomPanel.add(forgetKeyButton, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout fillerPanelLayout = new javax.swing.GroupLayout(fillerPanel);
        fillerPanel.setLayout(fillerPanelLayout);
        fillerPanelLayout.setHorizontalGroup(
            fillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fillerPanelLayout.setVerticalGroup(
            fillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        bottomPanel.add(fillerPanel, gridBagConstraints);

        okButton.setLabel("Extract");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        bottomPanel.add(okButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(cancelButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        mainPanel.add(bottomPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(mainPanel, gridBagConstraints);
        mainPanel.getAccessibleContext().setAccessibleName("Europeana search");
        mainPanel.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void forgetKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgetKeyActionPerformed
       apiKey = null;
       forgetKeyButton.setEnabled(false);
    }//GEN-LAST:event_forgetKeyActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        accepted = true;
        if (this.dialog != null) {
            this.dialog.setVisible(false);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        accepted = false;
        if (this.dialog != null) {
            this.dialog.setVisible(false);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel fillerPanel;
    private javax.swing.JButton forgetKeyButton;
    private javax.swing.JLabel headlineLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}

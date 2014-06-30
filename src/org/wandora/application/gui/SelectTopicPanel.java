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
 * SelectTopicPanel.java
 *
 * Created on 17. helmikuuta 2006, 11:33
 */

package org.wandora.application.gui;




import org.wandora.topicmap.*;
import org.wandora.application.gui.simple.*;
import org.wandora.application.*;
import java.awt.*;
import java.awt.event.KeyEvent;




/**
 *
 * @author  olli
 */
public class SelectTopicPanel extends javax.swing.JPanel implements TopicSelector {
    
    private Wandora admin;
    private Topic result;
    
    /** Creates new form SelectTopicPanel */
    public SelectTopicPanel(Wandora admin) {
        this.admin=admin;
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        searchLabel = new SimpleLabel();
        radioPanel = new javax.swing.JPanel();
        baseNameRadioButton = new SimpleRadioButton();
        subjectIdentifierRadioButton = new SimpleRadioButton();
        subjectLocatorRadioButton = new SimpleRadioButton();
        searchPanel = new javax.swing.JPanel();
        searchTextField = new SimpleField();
        searchButton = new SimpleButton();
        resultTextArea = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        searchLabel.setFont(org.wandora.application.gui.UIConstants.tabFont);
        searchLabel.setText("Select");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 4, 3);
        add(searchLabel, gridBagConstraints);

        radioPanel.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(baseNameRadioButton);
        baseNameRadioButton.setSelected(true);
        baseNameRadioButton.setText("base name");
        baseNameRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        baseNameRadioButton.setFocusPainted(false);
        baseNameRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        radioPanel.add(baseNameRadioButton, gridBagConstraints);

        buttonGroup1.add(subjectIdentifierRadioButton);
        subjectIdentifierRadioButton.setText("subject identifier");
        subjectIdentifierRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        subjectIdentifierRadioButton.setFocusPainted(false);
        subjectIdentifierRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        radioPanel.add(subjectIdentifierRadioButton, gridBagConstraints);

        buttonGroup1.add(subjectLocatorRadioButton);
        subjectLocatorRadioButton.setText("subject locator");
        subjectLocatorRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        subjectLocatorRadioButton.setFocusPainted(false);
        subjectLocatorRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        radioPanel.add(subjectLocatorRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 4, 8);
        add(radioPanel, gridBagConstraints);

        searchPanel.setLayout(new java.awt.GridBagLayout());

        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        searchPanel.add(searchTextField, gridBagConstraints);

        searchButton.setText("Seek");
        searchButton.setMargin(new java.awt.Insets(0, 3, 0, 3));
        searchButton.setMaximumSize(new java.awt.Dimension(60, 19));
        searchButton.setMinimumSize(new java.awt.Dimension(60, 19));
        searchButton.setPreferredSize(new java.awt.Dimension(60, 19));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 4, 0);
        searchPanel.add(searchButton, gridBagConstraints);

        resultTextArea.setColumns(20);
        resultTextArea.setEditable(false);
        resultTextArea.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        resultTextArea.setLineWrap(true);
        resultTextArea.setRows(6);
        resultTextArea.setText("Select identifier type and enter complete identifier. Finalize by clicking the Seek button. Select result is viewed in this field.");
        resultTextArea.setWrapStyleWord(true);
        resultTextArea.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        searchPanel.add(resultTextArea, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 8, 8);
        add(searchPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        if(evt.getKeyCode()==evt.VK_ENTER){
            doSearch();
        }
    }//GEN-LAST:event_searchTextFieldKeyReleased

    @Override
    public void init(){}
    @Override
    public void cleanup(){}
    
    
    
    public void requestSearchFieldFocus() {
        searchTextField.requestFocus();
        searchTextField.selectAll();
    }
    
    
    public void doSearch(){
        String text=searchTextField.getText().trim();
        result=null;
        try {
            if(baseNameRadioButton.isSelected()){
                result=admin.getTopicMap().getTopicWithBaseName(text);
            }
            else if(subjectIdentifierRadioButton.isSelected()){
                result=admin.getTopicMap().getTopic(text);
            }
            else{
                result=admin.getTopicMap().getTopicBySubjectLocator(text);
            }
        }catch(TopicMapException tme){
            tme.printStackTrace(); // TODO EXCEPTION
            return;
        }
        if(result==null){
            resultTextArea.setText("Topic not found");
        }
        else{
            try{
                String resText="Found topic\n"+
                               "Base name: "+result.getBaseName()+"\n"+
                               "Subject identifiers:\n";

                for(Locator l : result.getSubjectIdentifiers()){
                    resText+="    "+l.toExternalForm()+"\n";
                }
                if(result.getSubjectLocator()!=null) resText+="Subject locator: "+result.getSubjectLocator().toExternalForm()+"\n";
                resultTextArea.setText(resText);
            }catch(TopicMapException tme){
                tme.printStackTrace(); // TODO EXCEPTION
                resultTextArea.setText("Exception retrieving topic info");
            }
        }
    }
    
    @Override
    public Topic getSelectedTopic(){
        return result;
    }
    
    @Override
    public Topic[] getSelectedTopics(){
        if(result==null) return new Topic[0];
        else return new Topic[]{result};
    }

    @Override
    public Component getPanel() {
        return this;
    }
    
    @Override
    public String getSelectorName(){
        return "Select";
    }
    
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        doSearch();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyTyped
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            doSearch();
        }
    }//GEN-LAST:event_searchTextFieldKeyTyped
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton baseNameRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel radioPanel;
    private javax.swing.JTextArea resultTextArea;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JRadioButton subjectIdentifierRadioButton;
    private javax.swing.JRadioButton subjectLocatorRadioButton;
    // End of variables declaration//GEN-END:variables
    
}

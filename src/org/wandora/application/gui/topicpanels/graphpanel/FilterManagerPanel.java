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
 * FilterManagerPanel.java
 *
 * Created on 29. kes�kuuta 2007, 14:01
 */

package org.wandora.application.gui.topicpanels.graphpanel;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.wandora.application.gui.simple.*;
import org.wandora.application.gui.*;
import org.wandora.application.*;



/**
 *
 * @author  olli
 */
public class FilterManagerPanel extends javax.swing.JPanel implements ActionListener {
    
    private Wandora admin = null;
    private DefaultListModel filteredTopicsModel;
    private DefaultListModel filteredTopicTypesModel;
    private DefaultListModel filteredAssociationTypesModel;
    
    private GraphFilter topicNodeFilter;
    
    /** Creates new form FilterManagerPanel */
    public FilterManagerPanel(Wandora admin) {
        filteredTopicsModel=new DefaultListModel();
        filteredTopicTypesModel=new DefaultListModel();
        filteredAssociationTypesModel=new DefaultListModel();
        initComponents();
    }
    
    public void refreshAll(){
        refreshTopicList();
        refreshTopicTypeList();
        refreshAssociationTypeList();
    }
    
    
    JDialog filterDialog = null;
    public JDialog getDialogForMe(Wandora admin) {
        if(filterDialog == null) {
            filterDialog = new JDialog(admin, false);
            filterDialog.setLayout(new BorderLayout());
            filterDialog.setSize(300, 400);
            filterDialog.setTitle("Graph Filter Manager");
            filterDialog.setJMenuBar(getMenuBar(admin));
            if(admin != null) admin.centerWindow(filterDialog);
        }
        filterDialog.add(this, BorderLayout.CENTER);
        filterDialog.add(footerPanel, BorderLayout.SOUTH);
        return filterDialog;
    }
    public JMenuBar getMenuBar(Wandora admin) {
        JMenuBar filterManagerMenuBar = new JMenuBar();
        SimpleMenu fileMenu = new SimpleMenu("File");
        fileMenu.addActionListener(this);
        fileMenu.add( new SimpleMenuItem("New set", this ) );
        fileMenu.add( new SimpleMenuItem("Load set", this) );
        fileMenu.add( new SimpleMenuItem("Save set", this) );
        fileMenu.add( new JSeparator(JSeparator.HORIZONTAL) );
        fileMenu.add( new SimpleMenuItem("Clear set", this) );
        fileMenu.add( new JSeparator(JSeparator.HORIZONTAL) );
        fileMenu.add( new SimpleMenuItem("Exit", this) );
        
        filterManagerMenuBar.add(fileMenu);
        return filterManagerMenuBar;
    }
    
    
    public void setTopicNodeFilter(GraphFilter topicNodeFilter){
        this.topicNodeFilter=topicNodeFilter;
        refreshAll();
    }
    
    private void refreshTopicList(){
        filteredTopicsModel.clear();
        for(TopicNode tn : topicNodeFilter.getFilteredNodes()){
            filteredTopicsModel.addElement(tn);
        }
    }
    private void refreshTopicTypeList(){
        filteredTopicTypesModel.clear();
        for(TopicNode tn : topicNodeFilter.getFilteredNodeTypes()){
            filteredTopicTypesModel.addElement(tn);
        }
        
    }
    private void refreshAssociationTypeList(){
        filteredAssociationTypesModel.clear();
        for(TopicNode tn : topicNodeFilter.getFilteredEdgeTypes()){
            filteredAssociationTypesModel.addElement(tn);
        }
        if(topicNodeFilter.getFilterInstances()){
            filteredAssociationTypesModel.addElement("Instances");
        }
        if(topicNodeFilter.getFilterOccurrences()){
            filteredAssociationTypesModel.addElement("Occurrences");
        }
    }


    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        footerPanel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        okButton = new org.wandora.application.gui.simple.SimpleButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new org.wandora.application.gui.simple.SimpleComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new org.wandora.application.gui.simple.SimpleLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        filteredTopicList = new javax.swing.JList();
        removeFilteredTopicButton = new SimpleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new org.wandora.application.gui.simple.SimpleLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        filteredAssociationTypesList = new javax.swing.JList();
        removeFilteredAssociationTypeButton = new SimpleButton();

        footerPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(9, 5, 5, 5);
        footerPanel.add(jSeparator2, gridBagConstraints);

        okButton.setText("Ok");
        okButton.setMaximumSize(new java.awt.Dimension(70, 21));
        okButton.setMinimumSize(new java.awt.Dimension(70, 21));
        okButton.setPreferredSize(new java.awt.Dimension(70, 21));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        footerPanel.add(okButton, gridBagConstraints);

        setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(9, 5, 0, 5);
        jPanel3.add(jComboBox1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jPanel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 5);
        jPanel4.add(jSeparator1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Filtered nodes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel1, gridBagConstraints);

        filteredTopicList.setModel(filteredTopicsModel);
        jScrollPane1.setViewportView(filteredTopicList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        removeFilteredTopicButton.setText("Unfilter node");
        removeFilteredTopicButton.setMargin(new java.awt.Insets(2, 6, 2, 6));
        removeFilteredTopicButton.setMaximumSize(new java.awt.Dimension(95, 21));
        removeFilteredTopicButton.setMinimumSize(new java.awt.Dimension(95, 21));
        removeFilteredTopicButton.setPreferredSize(new java.awt.Dimension(95, 21));
        removeFilteredTopicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFilteredTopicButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel1.add(removeFilteredTopicButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Filtered edge types");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel3, gridBagConstraints);

        filteredAssociationTypesList.setModel(filteredAssociationTypesModel);
        jScrollPane3.setViewportView(filteredAssociationTypesList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(jScrollPane3, gridBagConstraints);

        removeFilteredAssociationTypeButton.setText("Unfilter type");
        removeFilteredAssociationTypeButton.setMargin(new java.awt.Insets(2, 6, 2, 6));
        removeFilteredAssociationTypeButton.setMaximumSize(new java.awt.Dimension(95, 21));
        removeFilteredAssociationTypeButton.setMinimumSize(new java.awt.Dimension(95, 21));
        removeFilteredAssociationTypeButton.setPreferredSize(new java.awt.Dimension(95, 21));
        removeFilteredAssociationTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFilteredAssociationTypeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(removeFilteredAssociationTypeButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        add(jPanel4, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if(filterDialog != null) {
            filterDialog.setVisible(false);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void removeFilteredAssociationTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFilteredAssociationTypeButtonActionPerformed
        Object sel=filteredAssociationTypesList.getSelectedValue();
        if(sel!=null){
            if(sel instanceof TopicNode){
                topicNodeFilter.releaseEdgeType((TopicNode)sel);
                refreshAssociationTypeList();
            }
            else if(sel.equals("Instances")){
                topicNodeFilter.setFilterInstances(false);
                refreshAssociationTypeList();
            }
        }
    }//GEN-LAST:event_removeFilteredAssociationTypeButtonActionPerformed

    private void removeFilteredTopicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFilteredTopicButtonActionPerformed
        Object sel=filteredTopicList.getSelectedValue();
        if(sel!=null){
            topicNodeFilter.releaseNode((TopicNode)sel);
            refreshTopicList();
        }
    }//GEN-LAST:event_removeFilteredTopicButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList filteredAssociationTypesList;
    private javax.swing.JList filteredTopicList;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton okButton;
    private javax.swing.JButton removeFilteredAssociationTypeButton;
    private javax.swing.JButton removeFilteredTopicButton;
    // End of variables declaration//GEN-END:variables
    
    
    
    // ----------------------------------------------------- ACTION LISTENER ---
    
    
    
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Action preformed in FilterManagerPanel: "+actionEvent.getActionCommand());
        String ac = actionEvent.getActionCommand();
        if("Exit".equalsIgnoreCase(ac)) {
            if(filterDialog != null) {
                filterDialog.setVisible(false);
            }
        }
    }
}
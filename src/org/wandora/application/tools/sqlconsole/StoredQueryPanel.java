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
 * StoredQueryPanel.java
 *
 * Created on 28. joulukuuta 2004, 15:13
 */

package org.wandora.application.tools.sqlconsole;


import org.wandora.application.tools.sqlconsole.gui.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
/**
 *
 * @author  olli
 */
public class StoredQueryPanel extends javax.swing.JPanel {
    
    private Map<String,StoredQuery> storedQueries;
    private Map<String,JTextComponent> paramMap=new TreeMap<String,JTextComponent>();
    private SQLConsolePanel parent;
    
    /** Creates new form StoredQueryPanel */
    public StoredQueryPanel(SQLConsolePanel parent,Map<String,StoredQuery> storedQueries) {
        this.storedQueries=storedQueries;
        this.parent=parent;
        initComponents();
        queryComboBox.setEditable(false);
        setupQueryComboBox();
    }
    
    private void setupQueryComboBox(){
        queryComboBox.removeAllItems();
        for(String q : storedQueries.keySet()){
            queryComboBox.addItem(q);
        }        
    }
    
    public void selectQuery(String name){
        queryComboBox.setSelectedItem(name);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        scrollPane = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        queryComboBox = new javax.swing.JComboBox();
        parameterLabelsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        editButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        executeButton = new javax.swing.JButton();
        descriptionPane = new javax.swing.JTextPane();
        parameterFieldsPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        queryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryComboBoxActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(queryComboBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(parameterLabelsPanel, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        editButton.setText("Muokkaa");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jPanel3.add(editButton);

        newButton.setText("Uusi");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        jPanel3.add(newButton);

        deleteButton.setText("Poista");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jPanel3.add(deleteButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanel3, gridBagConstraints);

        executeButton.setText("Suorita");
        executeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeButtonActionPerformed(evt);
            }
        });

        jPanel4.add(executeButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jPanel1, gridBagConstraints);

        descriptionPane.setEditable(false);
        descriptionPane.setFocusable(false);
        descriptionPane.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        jPanel2.add(descriptionPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        jPanel2.add(parameterFieldsPanel, gridBagConstraints);

        scrollPane.setViewportView(jPanel2);

        add(scrollPane, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String q=(String)queryComboBox.getSelectedItem();
        if(q!=null){
            storedQueries.remove(q);
            parent.switchToSimple(null);
        }        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        StoredQuery query=new StoredQuery("","","");
        parent.switchToEdit(query);        
    }//GEN-LAST:event_newButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        String q=(String)queryComboBox.getSelectedItem();
        StoredQuery query=new StoredQuery("","","");
        if(q!=null){
            StoredQuery qu=(StoredQuery)storedQueries.get(q);
            if(qu!=null) query=qu;
        }
        parent.switchToEdit(query);
    }//GEN-LAST:event_editButtonActionPerformed

    private void executeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeButtonActionPerformed
        String q=(String)queryComboBox.getSelectedItem();
        if(q==null) return;
        StoredQuery query=storedQueries.get(q);
        if(query==null) return;
        String replaced=QueryProcessor.replaceParams(query.getQuery(),paramMap);
        parent.executeQuery(replaced);
    }//GEN-LAST:event_executeButtonActionPerformed

    private void queryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryComboBoxActionPerformed
        String q=(String)queryComboBox.getSelectedItem();
        if(q==null) return;
        StoredQuery query=storedQueries.get(q);
        if(query==null) return;
        descriptionPane.setText(query.getDescription());
        String[] params=QueryProcessor.parseParemeterFields(query.getQuery());
        paramMap=QueryProcessor.fillQueryFields(params, parameterLabelsPanel,parameterFieldsPanel);
        parent.setSimpleSize();
    }//GEN-LAST:event_queryComboBoxActionPerformed
        
    public int getPreferredHeight(){
        return (int)scrollPane.getViewport().getPreferredSize().getHeight();
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextPane descriptionPane;
    private javax.swing.JButton editButton;
    private javax.swing.JButton executeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton newButton;
    private javax.swing.JPanel parameterFieldsPanel;
    private javax.swing.JPanel parameterLabelsPanel;
    private javax.swing.JComboBox queryComboBox;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
    
}

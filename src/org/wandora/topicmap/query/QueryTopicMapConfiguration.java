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
 */

package org.wandora.topicmap.query;
import org.wandora.topicmap.*;
import org.wandora.application.*;
import java.util.*;
import org.wandora.application.gui.simple.*;
import org.wandora.application.gui.*;
import javax.script.*;

/**
 *
 * @author  olli
 */
public class QueryTopicMapConfiguration extends TopicMapConfigurationPanel {
    
    private QueryTopicMap.QueryInfo currentItem;
    private Wandora wandora;
    private javax.swing.DefaultListModel listModel;
    private javax.swing.JDialog editDialog;
    
    /** Creates new form QueryTopicMapConfiguration */
    public QueryTopicMapConfiguration(Collection<QueryTopicMap.QueryInfo> queryInfos,Wandora wandora) {
        this(wandora);
        fillData(queryInfos);
    }
    
    public QueryTopicMapConfiguration(Wandora wandora) {
        this.wandora=wandora;
        this.listModel=new javax.swing.DefaultListModel();
        initComponents();
    }
    
    public void fillData(Collection<QueryTopicMap.QueryInfo> queryInfos){
        currentItem=null;
        
        listModel.removeAllElements();
        for(QueryTopicMap.QueryInfo info : queryInfos){
            listModel.addElement(info);
        }
    }
    
    public void saveCurrent(){
        if(currentItem==null) return;
        currentItem.name=nameTextField.getText();
        currentItem.type=typeTextField.getText();
        currentItem.engine=engineComboBox.getSelectedItem().toString();
        currentItem.script=scriptTextPane.getText();
    }
    
    private void openEditDialog(QueryTopicMap.QueryInfo info){
        editDialog=new javax.swing.JDialog(wandora,"Edit query",true);
        
        currentItem=info;
        ArrayList<String> engines=WandoraScriptManager.getAvailableEngines();
        engineComboBox.removeAllItems();
        for(int i=0;i<engines.size();i++){
            String e=engines.get(i);
            engineComboBox.addItem(e);
        }   
        nameTextField.setText(currentItem.name);
        typeTextField.setText(currentItem.type);
        engineComboBox.setSelectedItem(currentItem.engine);
        scriptTextPane.setText(currentItem.script);
        
        editDialog.getContentPane().add(editPanel);
        editDialog.setSize(400, 500);
        org.wandora.utils.swing.GuiTools.centerWindow(editDialog, wandora);
        
        editDialog.setVisible(true);
    }

    @Override
    public Object getParameters() {
        saveCurrent();
        QueryTopicMapParams ret=new QueryTopicMapParams(wandora);
        for(int i=0;i<listModel.size();i++){
            QueryTopicMap.QueryInfo info=(QueryTopicMap.QueryInfo)listModel.get(i);
            ret.queryInfos.add(info);
        }
        return ret;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        editPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scriptTextPane = new SimpleTextPane();
        jLabel1 = new SimpleLabel();
        engineComboBox = new SimpleComboBox();
        jLabel4 = new SimpleLabel();
        nameTextField = new SimpleField();
        jLabel5 = new SimpleLabel();
        typeTextField = new SimpleField();
        jPanel3 = new javax.swing.JPanel();
        checkButton = new SimpleButton();
        okButton = new SimpleButton();
        cancelButton = new SimpleButton();
        jPanel2 = new javax.swing.JPanel();
        addButton = new SimpleButton();
        deleteButton = new SimpleButton();
        editButton = new SimpleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        queryList = new javax.swing.JList();

        editPanel.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setViewportView(scriptTextPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 0, 5);
        editPanel.add(jScrollPane1, gridBagConstraints);

        jLabel1.setText("Script engine");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        editPanel.add(jLabel1, gridBagConstraints);

        engineComboBox.setEditable(true);
        engineComboBox.setPreferredSize(new java.awt.Dimension(124, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        editPanel.add(engineComboBox, gridBagConstraints);

        jLabel4.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 1);
        editPanel.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 5, 0, 5);
        editPanel.add(nameTextField, gridBagConstraints);

        jLabel5.setText("Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        editPanel.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        editPanel.add(typeTextField, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        checkButton.setText("Check Script");
        checkButton.setMargin(new java.awt.Insets(2, 4, 2, 4));
        checkButton.setPreferredSize(new java.awt.Dimension(80, 23));
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(checkButton, gridBagConstraints);

        okButton.setText("OK");
        okButton.setMaximumSize(new java.awt.Dimension(80, 23));
        okButton.setMinimumSize(new java.awt.Dimension(80, 23));
        okButton.setPreferredSize(new java.awt.Dimension(80, 23));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel3.add(okButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.setMaximumSize(new java.awt.Dimension(80, 23));
        cancelButton.setMinimumSize(new java.awt.Dimension(80, 23));
        cancelButton.setPreferredSize(new java.awt.Dimension(80, 23));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(cancelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        editPanel.add(jPanel3, gridBagConstraints);

        setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        addButton.setText("Add");
        addButton.setMaximumSize(new java.awt.Dimension(70, 23));
        addButton.setMinimumSize(new java.awt.Dimension(70, 23));
        addButton.setPreferredSize(new java.awt.Dimension(70, 23));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel2.add(addButton, gridBagConstraints);

        deleteButton.setText("Delete");
        deleteButton.setMaximumSize(new java.awt.Dimension(70, 23));
        deleteButton.setMinimumSize(new java.awt.Dimension(70, 23));
        deleteButton.setPreferredSize(new java.awt.Dimension(70, 23));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel2.add(deleteButton, gridBagConstraints);

        editButton.setText("Edit");
        editButton.setMaximumSize(new java.awt.Dimension(70, 23));
        editButton.setMinimumSize(new java.awt.Dimension(70, 23));
        editButton.setPreferredSize(new java.awt.Dimension(70, 23));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel2.add(editButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        add(jPanel2, gridBagConstraints);

        queryList.setFont(UIConstants.labelFont);
        queryList.setModel(listModel);
        jScrollPane2.setViewportView(queryList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 3, 5);
        add(jScrollPane2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private String checkScript(String engineString,String script){
        WandoraScriptManager sm=new WandoraScriptManager();
        ScriptEngine engine=sm.getScriptEngine(engineString);
        if(engine==null){
            return "Couldn't find script engine";
        }
        try{
            Object o=engine.eval(script);
            if(o==null){
                return "Script returned null.";
            }
            else if(!(o instanceof org.wandora.query2.Directive)){
                return "Script didn't return an instance of Directive.<br>"+
                       "Class of return value is "+o.getClass().getName();
            }
        }catch(ScriptException se){
            return "ScriptException at line "+se.getLineNumber()+" column "+se.getColumnNumber()+"<br>"+se.getMessage();
        }
        catch(Exception e){
            e.printStackTrace();
            return "Exception occurred during execution: "+e.getClass().getName()+" "+e.getMessage();
        }
        return null;        
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        listModel.addElement(new QueryTopicMap.QueryInfo("New query"));
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int s=queryList.getSelectedIndex();
        if(s!=-1) listModel.remove(s);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String message=checkScript(engineComboBox.getSelectedItem().toString(),scriptTextPane.getText());
        if(message!=null){
            int c=WandoraOptionPane.showConfirmDialog(wandora, "Unabled to evaluate script. Do you want continue?<br><br>"+message,"Error in query");
            if(c!=WandoraOptionPane.YES_OPTION) return;
        }
        
        saveCurrent();
        editDialog.setVisible(false);
        queryList.repaint();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        editDialog.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        Object o=queryList.getSelectedValue();
        if(o!=null) openEditDialog((QueryTopicMap.QueryInfo)o);
    }//GEN-LAST:event_editButtonActionPerformed

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        String m=checkScript(engineComboBox.getSelectedItem().toString(),scriptTextPane.getText());
        if(m!=null){
            WandoraOptionPane.showMessageDialog(wandora, m, "Error in query", WandoraOptionPane.ERROR_MESSAGE);        
        }
        else WandoraOptionPane.showMessageDialog(wandora, "No errors", "No errors", WandoraOptionPane.INFORMATION_MESSAGE);        
    }//GEN-LAST:event_checkButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton checkButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JPanel editPanel;
    private javax.swing.JComboBox engineComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JList queryList;
    private javax.swing.JTextPane scriptTextPane;
    private javax.swing.JTextField typeTextField;
    // End of variables declaration//GEN-END:variables
    
    public static class QueryTopicMapParams {
        public Wandora wandora;
        public ArrayList<QueryTopicMap.QueryInfo> queryInfos;
        public QueryTopicMapParams(Wandora wandora){
            this(wandora,new ArrayList<QueryTopicMap.QueryInfo>());
        }
        public QueryTopicMapParams(Wandora wandora,ArrayList<QueryTopicMap.QueryInfo> queryInfos){
            this.wandora=wandora;
            this.queryInfos=queryInfos;
        }
    }
    
}

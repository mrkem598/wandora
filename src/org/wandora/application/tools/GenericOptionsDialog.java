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
 * 
 * GenericOptionsDialog.java
 *
 * Created on 25. heinäkuuta 2006, 15:30
 */

package org.wandora.application.tools;



import org.wandora.application.gui.simple.*;
import org.wandora.application.*;
import org.wandora.application.gui.*;
import org.wandora.topicmap.*;
import org.wandora.utils.Textbox;
import org.wandora.utils.swing.GuiTools;
import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 * <p>
 * This is a class to display a customizable options dialog. You can choose how
 * many and what kinds of fields there will be in the dialog. However if you need
 * a more complex options dialog than just a collection input fields, you will need
 * to make a separate class for that. This class is only able to make simple
 * options dialogs but at the same time it is very easy to use this class.
 * </p>
 *
 * @author  olli
 */
public class GenericOptionsDialog extends javax.swing.JDialog {
    
    protected String[][] fieldData;
    protected boolean wasCancelled=true;
    protected Wandora admin;
    protected JPanel paddingPanel;

    /** 
     * Creates and initializes an options dialog. You need to give a string for
     * dialog title and a short info text. You will also need to give a data
     * structure describing all fields used in the dialog. See initFields for
     * description about the data structure. Wandora is needed if field type
     * "topic" is used.
     */
    public GenericOptionsDialog(java.awt.Frame parent, String title,String info,boolean modal,String[][] fields,Wandora admin) {
        super(parent, modal);
        this.admin=admin;
        this.fieldData=fields;
        initComponents();
        
        this.setTitle(title);
        infoLabel.setText("<html>"+info+"</html>");
        
        GuiTools.centerWindow(this,parent);
    }

    public GenericOptionsDialog(java.awt.Frame parent, String title,String info,boolean modal,String[][] fields) {
        this(parent,title,info,modal,fields,null);
    }

    /**
     * Gets the values from this options dialog. Return value is a map that
     * maps field IDs to their values. Note that all values are converted to
     * string regardless of the field type. Boolean fields are converted to
     * "true" or "false".
     */
    public Map<String,String> getValues(){
        return ((GenericOptionsPanel)contentPanel).getValues();
    }
    
    
    public GenericOptionsPanel getContentPanel(){
        return (GenericOptionsPanel)contentPanel;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        scrollPane = new SimpleScrollPane();
        contentPanel = new GenericOptionsPanel(fieldData,admin);
        jPanel1 = new javax.swing.JPanel();
        okButton = new org.wandora.application.gui.simple.SimpleButton();
        cancelButton = new org.wandora.application.gui.simple.SimpleButton();
        infoLabel = new org.wandora.application.gui.simple.SimpleLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        contentPanel.setLayout(new javax.swing.BoxLayout(contentPanel, javax.swing.BoxLayout.LINE_AXIS));
        scrollPane.setViewportView(contentPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 4);
        getContentPane().add(scrollPane, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        okButton.setText("OK");
        okButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        okButton.setMaximumSize(new java.awt.Dimension(70, 23));
        okButton.setMinimumSize(new java.awt.Dimension(70, 23));
        okButton.setPreferredSize(new java.awt.Dimension(70, 23));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        jPanel1.add(okButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        cancelButton.setMaximumSize(new java.awt.Dimension(70, 23));
        cancelButton.setMinimumSize(new java.awt.Dimension(70, 23));
        cancelButton.setPreferredSize(new java.awt.Dimension(70, 23));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(jPanel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(infoLabel, gridBagConstraints);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-442)/2, (screenSize.height-339)/2, 442, 339);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        wasCancelled=true;
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        wasCancelled=false;
        this.setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed
    
    /**
     * Checks if user closed the dialog with the cancel button.
     */
    public boolean wasCancelled(){
        return wasCancelled;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    protected javax.swing.JPanel contentPanel;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
    
}

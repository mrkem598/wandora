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
 * ExtractProgressDialog.java
 *
 * Created on 29. marraskuuta 2004, 10:58
 */

package org.wandora.application.tools.extractors.datum;
import org.wandora.application.tools.extractors.*;
import org.wandora.application.gui.*;
import org.wandora.application.gui.simple.*;
import org.wandora.application.*;
import javax.swing.*;
import java.io.*;
/**
 *
 * @author  olli
 */
public class ExtractProgressDialog extends javax.swing.JDialog {
    
    protected ExtractTool extractTool;
    
    /** Creates new form ExtractProgressDialog */
    public ExtractProgressDialog(java.awt.Frame parent, boolean modal,ExtractTool extractTool) {
        super(parent, modal);
        this.setTitle("Extraction on progress...");
        this.extractTool=extractTool;
        initComponents();
        progressBar.setMinimum(0);
        progressBar.setMaximum(1000);

        this.setLocation(parent.getLocation().x+parent.getWidth()/2-this.getWidth()/2, 
                         parent.getLocation().y+parent.getHeight()/2-this.getHeight()/2);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        scrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        progressBar = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        saveLogButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        abortButton = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(scrollPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(progressBar, gridBagConstraints);

        saveLogButton.setText("Save Log");
        saveLogButton.setEnabled(false);
        saveLogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveLogButtonActionPerformed(evt);
            }
        });

        jPanel1.add(saveLogButton);

        closeButton.setText("Close");
        closeButton.setEnabled(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jPanel1.add(closeButton);

        abortButton.setText("Abort");
        abortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abortButtonActionPerformed(evt);
            }
        });

        jPanel1.add(abortButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        setSize(new java.awt.Dimension(430, 357));
    }//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void abortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abortButtonActionPerformed
        extractTool.abortExtraction();
    }//GEN-LAST:event_abortButtonActionPerformed

    private void saveLogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveLogButtonActionPerformed
        SimpleFileChooser fc=UIConstants.getFileChooser();
        fc.setMultiSelectionEnabled(false);
        if(fc.open(this, SimpleFileChooser.SAVE_DIALOG)==SimpleFileChooser.APPROVE_OPTION){
            File f=fc.getSelectedFile();
            try{
                FileOutputStream out=new FileOutputStream(f);
                Writer writer=new OutputStreamWriter(out);
                writer.write(textArea.getText());
                writer.flush();
                out.close();
            }catch(IOException ioe){
                WandoraOptionPane.showMessageDialog(this, "IO Exception: "+ioe.getMessage());
            }
        }
    }//GEN-LAST:event_saveLogButtonActionPerformed
    
    public void setProgress(double d){
        if(d<0){
            if(!progressBar.isIndeterminate()) progressBar.setIndeterminate(true);
        }
        else{
            if(progressBar.isIndeterminate()) progressBar.setIndeterminate(false);
            int p=(int)(progressBar.getMaximum()*d);
            if(p<0) p=0;
            else if(p>progressBar.getMaximum()) p=100;
            progressBar.setValue(p);
        }
    }
    
    public void addLine(String line){
        textArea.append(line+"\n");
        java.awt.Dimension d=textArea.getPreferredScrollableViewportSize();
        textArea.scrollRectToVisible(new java.awt.Rectangle(0,(int)d.getHeight(),1,1));
    }
    
    public void processEnded(){
        setProgress(1.0);
        abortButton.setEnabled(false);
        saveLogButton.setEnabled(true);
        closeButton.setEnabled(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abortButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton saveLogButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
    
}

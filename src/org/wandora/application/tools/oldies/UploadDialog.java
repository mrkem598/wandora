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
 * UploadDialog.java
 *
 * Created on October 4, 2004, 1:56 PM
 */

package org.wandora.application.tools.oldies;



import org.wandora.application.*;
import org.wandora.application.gui.*;
import org.wandora.application.gui.simple.*;


import java.io.*;
import javax.swing.*;

/**
 *
 * @author  olli
 */
public class UploadDialog extends javax.swing.JDialog {
    
    private Wandora parent;
    private String[] dirs;
    
    /** Creates new form UploadDialog */
    public UploadDialog(Wandora parent, boolean modal) {
        super(parent, modal);
        this.parent=parent;
        //WandoraAdminManager manager=parent.getManager();
        try{
            //String[] list=manager.listDirectories("/");
            //dirs=new String[list.length+1];
            dirs[0]="/";
            //System.arraycopy(list, 0, dirs, 1, list.length);
        }
        catch(Exception se){
            dirs=new String[0];
            this.hide();
            parent.handleError(se);
            return;
        }        
        initComponents();
        
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

        fileTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        remoteDirComboBox = new JComboBox(dirs);
        jPanel1 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setTitle("Upload file");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        fileTextField.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        getContentPane().add(fileTextField, gridBagConstraints);

        browseButton.setText("Browse");
        browseButton.setPreferredSize(new java.awt.Dimension(80, 20));
        browseButton.setMargin(new java.awt.Insets(0, 14, 0, 14));
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 15);
        getContentPane().add(browseButton, gridBagConstraints);

        remoteDirComboBox.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(remoteDirComboBox, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.setPreferredSize(new java.awt.Dimension(75, 23));
        cancelButton.setMargin(new java.awt.Insets(0, 14, 0, 14));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel1.add(cancelButton);

        okButton.setText("Upload");
        okButton.setPreferredSize(new java.awt.Dimension(75, 23));
        okButton.setMargin(new java.awt.Insets(0, 14, 0, 14));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jPanel1.add(okButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 1, 1, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel1.setText("File");
        jLabel1.setPreferredSize(new java.awt.Dimension(70, 18));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 0, 5);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setText("Remote Dir");
        jLabel2.setPreferredSize(new java.awt.Dimension(70, 18));
        jLabel2.setMinimumSize(new java.awt.Dimension(53, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 5);
        getContentPane().add(jLabel2, gridBagConstraints);

        jProgressBar1.setToolTipText("Upload progress");
        jProgressBar1.setString("");
        jProgressBar1.setPreferredSize(new java.awt.Dimension(150, 5));
        jProgressBar1.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jProgressBar1, gridBagConstraints);

        setSize(new java.awt.Dimension(475, 132));
    }//GEN-END:initComponents

    
    
    
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        
        try{
            /*
            final WandoraAdminManager manager=parent.getManager();
            final UploadDialog thisf=this;
            String dir=remoteDirComboBox.getSelectedItem().toString();
            final File file=new File(fileTextField.getText());
            if(!file.exists()){
                WandoraOptionPane.showMessageDialog(this,"File not found error!", "File not found", WandoraOptionPane.ERROR_MESSAGE);
                return;
            }
            String remoteFile=file.getName();
            if(!dir.equals("/"))
                remoteFile=dir+"/"+remoteFile;
            
            if(manager.fileExists(remoteFile)){
                if(WandoraOptionPane.showConfirmDialog(this,"File already exists. Would you like to overwrite existing file?", "Overwrite?",WandoraOptionPane.YES_NO_OPTION)
                        ==WandoraOptionPane.NO_OPTION){
                            return;
                }
            }
            okButton.setEnabled(false);
            cancelButton.setEnabled(false);
            remoteDirComboBox.setEnabled(false);
            fileTextField.setEnabled(false);
            browseButton.setEnabled(false);
            
            final FileInputStream fis=new FileInputStream(file);
            final ProgressInputStream pis=new ProgressInputStream(fis);
            final String remoteFilef=remoteFile;
            final Thread uploader=new Thread(){
                public void run(){
                    try{
                        String url=manager.upload(pis,remoteFilef,file.length(),true);
                        pis.close();

                        WandoraOptionPane.showInputDialog("File uploaded succesfully! URL of the uploaded file is", "" + url);                    
                    } catch(IOException ioe) {
                        WandoraOptionPane.showMessageDialog(thisf, ioe.toString(), WandoraOptionPane.ERROR_MESSAGE);                        
                    } catch(Exception e) {
                        parent.handleError(e);                        
                    }
                    thisf.setVisible(false);
                }
            };
            uploader.start();
            Thread progressUpdater=new Thread(){
                public void run(){
                    double size=file.length();
                    while(uploader.isAlive()){
                        try{
                            Thread.sleep(1000);
                        }catch(InterruptedException ie){return;}
                        double read=pis.getNumBytesRead();
                        jProgressBar1.setValue((int)(100.0*read/size));
                    }
                }
            };
            progressUpdater.start();
                         * 

        }
        catch(IOException ioe){
            WandoraOptionPane.showMessageDialog(this, ioe.toString(), WandoraOptionPane.ERROR_MESSAGE);
        
        *
        */
        }
        catch(Exception e){
            parent.handleError(e);
        }

        
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        SimpleFileChooser chooser=UIConstants.getFileChooser();
        if(chooser.open(parent, SimpleFileChooser.OPEN_DIALOG)==SimpleFileChooser.APPROVE_OPTION){
            fileTextField.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_browseButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox remoteDirComboBox;
    // End of variables declaration//GEN-END:variables
 

}

class ProgressInputStream extends InputStream {
    private InputStream in;
    private long read;
    public ProgressInputStream(InputStream in){
        this.in=in;
        read=0;
    }
    public long getNumBytesRead(){
        return read;
    }
    public int available() throws IOException {
        return in.available();
    }
    public void close() throws IOException {
        in.close();
    }
    public void mark(int readlimit){
        in.mark(readlimit);
    }
    public void reset() throws IOException {
        in.reset();
    }
    public boolean markSupported(){
        return in.markSupported();
    }
    public long skip(long n) throws IOException{
        long i=in.skip(n);
        if(i!=-1) read+=i;
        return i;
    }
    public int read() throws IOException {
        int i=in.read();
        if(i!=-1) read++;
        return i;
    }
    public int read(byte[] b) throws IOException {
        int i=in.read(b);
        if(i!=-1) read+=i;
        return i;
    }
    public int read(byte[] b,int off,int len)throws IOException {
        int i=in.read(b,off,len);
        if(i!=-1) read+=i;
        return i;
    }
}

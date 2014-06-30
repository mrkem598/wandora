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
 * ErrorDialog.java
 *
 * Created on 25.11.2011, 14:22:23
 */




package org.wandora.application.gui;




import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.wandora.application.Wandora;
import org.wandora.application.gui.simple.SimpleButton;
import org.wandora.application.gui.simple.SimpleLabel;
import org.wandora.application.gui.simple.SimpleTabbedPane;

/**
 *
 * @author akivela
 */


public class ErrorDialog extends javax.swing.JDialog {

    private int button=-1;
    
    
    
    /** Creates new form ErrorDialog */
    public ErrorDialog(Wandora w, Exception e) {
        super(w, true);
        initComponents();
        this.setSize(600,400);
        w.centerWindow(this);
        setTitle("Exception occurred");
        setError(e);
        okButton.setVisible(false);
        setVisible(true);
    }
    
    public ErrorDialog(Wandora w, Error e) {
        super(w, true);
        initComponents();
        this.setSize(600,400);
        w.centerWindow(this);
        setTitle("Error occurred");
        setError(e);
        okButton.setVisible(false);
        setVisible(true);
    }
    
    public ErrorDialog(Wandora w, boolean modal, Throwable e, String message) {
        super(w, modal);
        initComponents();
        this.setSize(600,400);
        setTitle("Wandora failed to perform");
        w.centerWindow(this);
        okButton.setVisible(false);
        stacktraceTextPane.setText(getStacktTace(e));
        messageLabel.setText("<html>"+message+"</html>");
    }
    
    public ErrorDialog(Wandora w, boolean modal, Throwable e, String message, String no, String yes) {
        super(w, modal);
        initComponents();
        setTitle("Wandora failed to perform");
        this.setSize(600,400);
        w.centerWindow(this);
        closeButton.setText(no);
        if(yes!=null) okButton.setText(yes);
        else okButton.setVisible(false);
        if(e!=null) {
            stacktraceTextPane.setText(getStacktTace(e));
        }
        messageLabel.setText(message);
        w.centerWindow(this);
    }
    
    
    
    // -------------------------------------------------------------------------
    
    
    
    public void setError(Exception ex) {
        stacktraceTextPane.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        stacktraceTextPane.setText(getStacktTace(ex));
        String msg = "An exception has occurred in Wandora. Exception message follows:\n\n"+ex.getMessage();
        messageLabel.setText("<html>"+msg+"</html>");
    }
    
    public void setError(Error er) {
        stacktraceTextPane.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        stacktraceTextPane.setText(getStacktTace(er));
        String msg = "An error has occurred in Wandora. Exception message follows:\n\n"+er.getMessage();
        messageLabel.setText("<html>"+msg+"</html>");
    }
    
    public int getButton(){
        return button;
    }
    
    
    private String getStacktTace(Throwable e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
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

        errorTabbedPane = new SimpleTabbedPane();
        messagePanel = new javax.swing.JPanel();
        messageLabel = new SimpleLabel();
        stacktracePanel = new javax.swing.JPanel();
        stacktraceScrollPane = new javax.swing.JScrollPane();
        stacktraceTextPane = new javax.swing.JTextPane();
        buttonPanel = new javax.swing.JPanel();
        buttonpanelFillerPanel = new javax.swing.JPanel();
        okButton = new SimpleButton();
        closeButton = new SimpleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        messagePanel.setLayout(new java.awt.GridBagLayout());

        messageLabel.setText("Exception");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 22, 12, 22);
        messagePanel.add(messageLabel, gridBagConstraints);

        errorTabbedPane.addTab("Message", messagePanel);

        stacktracePanel.setLayout(new java.awt.GridBagLayout());

        stacktraceScrollPane.setViewportView(stacktraceTextPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        stacktracePanel.add(stacktraceScrollPane, gridBagConstraints);

        errorTabbedPane.addTab("Stacktrace", stacktracePanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(errorTabbedPane, gridBagConstraints);

        buttonPanel.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout buttonpanelFillerPanelLayout = new javax.swing.GroupLayout(buttonpanelFillerPanel);
        buttonpanelFillerPanel.setLayout(buttonpanelFillerPanelLayout);
        buttonpanelFillerPanelLayout.setHorizontalGroup(
            buttonpanelFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );
        buttonpanelFillerPanelLayout.setVerticalGroup(
            buttonpanelFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        buttonPanel.add(buttonpanelFillerPanel, gridBagConstraints);

        okButton.setText("OK");
        okButton.setMargin(new java.awt.Insets(2, 4, 2, 4));
        okButton.setMinimumSize(new java.awt.Dimension(75, 23));
        okButton.setPreferredSize(new java.awt.Dimension(75, 23));
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                okButtonMouseReleased(evt);
            }
        });
        okButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                okButtonKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        buttonPanel.add(okButton, gridBagConstraints);

        closeButton.setText("Close");
        closeButton.setMargin(new java.awt.Insets(2, 4, 2, 4));
        closeButton.setMinimumSize(new java.awt.Dimension(75, 23));
        closeButton.setPreferredSize(new java.awt.Dimension(75, 23));
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                closeButtonMouseReleased(evt);
            }
        });
        closeButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                closeButtonKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        buttonPanel.add(closeButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        getContentPane().add(buttonPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseReleased
        button=1;
        this.setVisible(false);
    }//GEN-LAST:event_okButtonMouseReleased

    private void okButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_okButtonKeyReleased
        if(KeyEvent.VK_ENTER == evt.getKeyCode()) {
            button=1;
            this.setVisible(false);
        }
    }//GEN-LAST:event_okButtonKeyReleased

    private void closeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseReleased
        button=0;
        this.setVisible(false);
    }//GEN-LAST:event_closeButtonMouseReleased

    private void closeButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_closeButtonKeyReleased
        if(KeyEvent.VK_ENTER == evt.getKeyCode()) {
            button=0;
            this.setVisible(false);
        }
    }//GEN-LAST:event_closeButtonKeyReleased

 
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel buttonpanelFillerPanel;
    private javax.swing.JButton closeButton;
    private javax.swing.JTabbedPane errorTabbedPane;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JPanel messagePanel;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel stacktracePanel;
    private javax.swing.JScrollPane stacktraceScrollPane;
    private javax.swing.JTextPane stacktraceTextPane;
    // End of variables declaration//GEN-END:variables
}

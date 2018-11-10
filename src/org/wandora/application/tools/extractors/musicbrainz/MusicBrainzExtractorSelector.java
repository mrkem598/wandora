/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 *
 * Copyright (C) 2004-2016 Wandora Team
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
 * GeoNamesExtractorSelector.java
 *
 * MusicBrainzExtractorSelector.java
 *
 * Created on 24.8.2009, 10:25:12
 */

package org.wandora.application.tools.extractors.musicbrainz;

import org.wandora.application.*;
import org.wandora.application.gui.*;
import org.wandora.application.gui.simple.*;


/**
 *
 * @author akivela
 */
public class MusicBrainzExtractorSelector extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;

	public static final int ARTIST_TAB = 100;
    public static final int RELEASES_TAB = 101;
    public static final int TRACKS_TAB = 102;
    
    

    private boolean accepted = false;




    /** Creates new form MusicBrainzExtractorSelector */
    public MusicBrainzExtractorSelector(Wandora wandora) {
        super(wandora, true);
        initComponents();
        this.setSize(500, 200);
        UIBox.centerWindow(this, wandora);
    }



    

    public boolean getAccepted() {
        return accepted;
    }



    public int getSelectedTab() {
        if(artistsPanel.equals(tabbedPane.getSelectedComponent()))
            return ARTIST_TAB;
        if(releasesPanel.equals(tabbedPane.getSelectedComponent()))
            return RELEASES_TAB;
        if(tracksPanel.equals(tabbedPane.getSelectedComponent()))
            return TRACKS_TAB;
        return 0;
    }

    public String getArtists() {
        return this.artistTextField.getText();
    }

    public boolean getAdditionalArtistInfo() {
        return this.additionalArtistInfoCheckBox.isSelected();
    }

    public String getReleases() {
        return this.releasesTextField.getText();
    }

    public boolean getAdditionalReleaseInfo() {
        return this.additionalReleaseInfoCheckBox.isSelected();
    }

    public String getTracks() {
        return this.tracksTextField.getText();
    }

    public boolean getAdditionalTrackInfo() {
        return this.additionalTrackInfoCheckBox.isSelected();
    }

    public int getPage() {
        int page = 1;
        try {
            String pageStr = this.pageTextField.getText().trim();
            page = Integer.parseInt(pageStr);
            if(page < 1) page = 1;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return page;
    }
    
    // -------------------------------------------------------------------------

    

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tabbedPane = new SimpleTabbedPane();
        artistsPanel = new javax.swing.JPanel();
        artistLabel = new SimpleLabel();
        artistTextField = new SimpleField();
        additionalArtistInfoCheckBox = new javax.swing.JCheckBox();
        releasesPanel = new javax.swing.JPanel();
        releasesLabel = new SimpleLabel();
        releasesTextField = new SimpleField();
        additionalReleaseInfoCheckBox = new javax.swing.JCheckBox();
        tracksPanel = new javax.swing.JPanel();
        tracksLabel = new SimpleLabel();
        tracksTextField = new SimpleField();
        additionalTrackInfoCheckBox = new javax.swing.JCheckBox();
        buttonPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pageLabel = new SimpleLabel();
        pageTextField = new SimpleField();
        fillerPanel = new javax.swing.JPanel();
        okButton = new SimpleButton();
        cancelButton = new SimpleButton();

        setTitle("MusicBrainz extractor");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        artistsPanel.setLayout(new java.awt.GridBagLayout());

        artistLabel.setText("<html>Search artists from MusicBrainz with given query. Query can be either an artist identifier or a string matching artist name.</html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        artistsPanel.add(artistLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        artistsPanel.add(artistTextField, gridBagConstraints);

        additionalArtistInfoCheckBox.setText("<html>Get also artists details. This requires additional web service calls. MusicBrainz web service limits connections to one web service call per second.</html>");
        additionalArtistInfoCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        artistsPanel.add(additionalArtistInfoCheckBox, gridBagConstraints);

        tabbedPane.addTab("Artists", artistsPanel);

        releasesPanel.setLayout(new java.awt.GridBagLayout());

        releasesLabel.setText("<html>Search releases from MusicBrainz with given query. Query can be either a release identifier or a string matching release name.</html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        releasesPanel.add(releasesLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        releasesPanel.add(releasesTextField, gridBagConstraints);

        additionalReleaseInfoCheckBox.setText("<html>Get also release details. This requires additional web service calls. MusicBrainz web service limits connections to one web service call per second.</html>");
        additionalReleaseInfoCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        releasesPanel.add(additionalReleaseInfoCheckBox, gridBagConstraints);

        tabbedPane.addTab("Releases", releasesPanel);

        tracksPanel.setLayout(new java.awt.GridBagLayout());

        tracksLabel.setText("<html>Search tracks from MusicBrainz with given query. Query can be either a track identifier or a string matching track name.</html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        tracksPanel.add(tracksLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        tracksPanel.add(tracksTextField, gridBagConstraints);

        additionalTrackInfoCheckBox.setText("<html>Get also track details. This requires additional web service calls. MusicBrainz web service limits connections to one web service call per second.</html>");
        additionalTrackInfoCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        tracksPanel.add(additionalTrackInfoCheckBox, gridBagConstraints);

        tabbedPane.addTab("Tracks", tracksPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        getContentPane().add(tabbedPane, gridBagConstraints);

        buttonPanel.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        pageLabel.setText("page");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel1.add(pageLabel, gridBagConstraints);

        pageTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pageTextField.setText("1");
        pageTextField.setMinimumSize(new java.awt.Dimension(30, 23));
        pageTextField.setPreferredSize(new java.awt.Dimension(30, 23));
        jPanel1.add(pageTextField, new java.awt.GridBagConstraints());

        buttonPanel.add(jPanel1, new java.awt.GridBagConstraints());

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
        buttonPanel.add(fillerPanel, gridBagConstraints);

        okButton.setText("OK");
        okButton.setPreferredSize(new java.awt.Dimension(75, 21));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        buttonPanel.add(okButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.setPreferredSize(new java.awt.Dimension(75, 21));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        getContentPane().add(buttonPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        accepted = false;
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        accepted = true;
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox additionalArtistInfoCheckBox;
    private javax.swing.JCheckBox additionalReleaseInfoCheckBox;
    private javax.swing.JCheckBox additionalTrackInfoCheckBox;
    private javax.swing.JLabel artistLabel;
    private javax.swing.JTextField artistTextField;
    private javax.swing.JPanel artistsPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel fillerPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JTextField pageTextField;
    private javax.swing.JLabel releasesLabel;
    private javax.swing.JPanel releasesPanel;
    private javax.swing.JTextField releasesTextField;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel tracksLabel;
    private javax.swing.JPanel tracksPanel;
    private javax.swing.JTextField tracksTextField;
    // End of variables declaration//GEN-END:variables

}

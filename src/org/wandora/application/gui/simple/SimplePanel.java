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
 * SimplePanel.java
 *
 * Created on 7. lokakuuta 2005, 16:50
 */

package org.wandora.application.gui.simple;


import org.wandora.application.gui.*;
import org.wandora.application.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;



/**
 *
 * @author akivela
 */
public class SimplePanel extends JPanel {

    
    
    /** Creates a new instance of SimplePanel */
    public SimplePanel() {
    }
    
    

    @Override
    public void paint(Graphics g) {
        UIConstants.preparePaint(g);
        super.paint(g);
    }
    
    
    
    @Override
    public void setBorder(Border border) {
        if(border instanceof TitledBorder) {
            TitledBorder titledBorder = (TitledBorder) border;
            titledBorder.setTitleFont(UIConstants.panelTitleFont); 
        }
        super.setBorder(border);        
    }
    
}

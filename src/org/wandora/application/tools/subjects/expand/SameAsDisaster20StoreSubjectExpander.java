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
 */


package org.wandora.application.tools.subjects.expand;

import org.wandora.application.contexts.Context;


/**
 *
 * @author akivela
 */


public class SameAsDisaster20StoreSubjectExpander extends SameAsSubjectExpander {
    
    
    public SameAsDisaster20StoreSubjectExpander() {}
    public SameAsDisaster20StoreSubjectExpander(Context preferredContext) {
        setContext(preferredContext);
    }
    
    
    // -------------------------------------------------------------------------
    
    
    
    @Override
    public String getName() {
        return "Expand subject with sameas.org's Disaster 20 store";
    }

    @Override
    public String getDescription() {
        return "Add topic subjects returned by the Disaster 20 store of sameas.org service.";
    }
    
    
    // -------------------------------------------------------------------------
    

    @Override
    protected String getExpandingRequestBase() {
        return "http://sameas.org/store/disaster20/json";
    }
}

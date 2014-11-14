/*
 * Copyright (C) 2014 daniel
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
package com.bermudi.fifi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author daniel
 */
public final class TeamManager{
    private static final String DIR = Team.TEAM_LOC;
    private static final String EXT = ".fifo";
    
    public static void saveTeam(Team team) throws FileNotFoundException, IOException {
        
        String id = Integer.toString(team.getID());
        
        FileOutputStream fs = new FileOutputStream(DIR+id+EXT);
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(team);
        os.close();
        fs.close();
        
    }
    
    public static Team loadTeam(Team team) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        String id = Integer.toString(team.getID());
        
        FileInputStream fs = new FileInputStream(DIR+id+EXT);
        ObjectInputStream os = new ObjectInputStream(fs);
        team = (Team)os.readObject();
        os.close();
        fs.close();
        
        return team;
        
    }
}

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

import com.jaunt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author daniel
 */
public class Team {

    private static int teamQty = 0;

    private final String name;
    private final float rating;
    private final String crest;
    private final int id;

    public String getCrestWebLink(String team) {
        String crestLink = "";
        team = team.replaceAll(" ", "%20");

        try {
            UserAgent userAgent = new UserAgent();
            userAgent.visit("http://en.wikipedia.org/wiki/Special:Search?search=" + team);
            crestLink = userAgent.doc.findFirst("<table class=\"infobox vcard\">").findFirst("<img>").getAt("src");
        } catch (JauntException e) {         //if an HTTP/connection error occurs, handle JauntException.
            System.err.println(e);
        }

        return crestLink;
    }

    private String saveCrestFile(String link) throws IOException {
        String filename;
        String directory = "crests";
        String ext = link.substring(link.length() - 3);
        filename = id +"."+ ext;

        BufferedImage image = null;

        URL url = new URL(link);
        image = ImageIO.read(url);
        File outputfile = new File(directory+"/"+filename);
        ImageIO.write(image, ext, outputfile);

        return filename;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public int getID() {
        return id;
    }

    public String getCrest() {
        return crest;
    }

    public Team(String name, float rating) throws IOException {
        this.name = name;
        this.rating = rating;
        this.id = ++teamQty;
        this.crest = saveCrestFile(getCrestWebLink(name));

    }
    
}

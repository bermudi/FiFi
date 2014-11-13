/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bermudi.fifi;

import java.util.Scanner;
import com.jaunt.*;

/**
 *
 * @author daniel
 */
public class Team {

    private static int teamQty = 0;
    
    private String name;
    private float rating;
    private String crest;
    private int id;

//    public void getInfo() {
//
//        System.out.println(name);
//        System.out.println(rating);
//        System.out.println(crest);
//    }
    
    public String getCrestWebLink (String team) {
        String crestLink = "";
        team = team.replaceAll(" ", "%20");
        
        try {
            UserAgent userAgent = new UserAgent();                       
            userAgent.visit("http://en.wikipedia.org/wiki/Special:Search?search="+team);
            crestLink = userAgent.doc.findFirst("<table class=\"infobox vcard\">").findFirst("<img>").getAt("src");            
        } catch (JauntException e) {         //if an HTTP/connection error occurs, handle JauntException.
            System.err.println(e);
        }
        
        return crestLink;
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
    
    public void Team(String name, float rating) {
        this.name = name;
        this.rating = rating;
        this.crest = getCrestWebLink(name);
        this.id = teamQty++;
        
    }

}

class TeamBuilder {

    public static void main(String[] args) {

        int sel;
        Scanner input = new Scanner(System.in);
        System.out.println("Please select an item from the menu");

        while (true) {

            System.out.println("1. Show Teams");
            System.out.println("2. Add Team");
            System.out.println("3. Delete Team");
            System.out.println("9. Exit");

            sel = input.nextInt();

            switch (sel) {
                case 1:
                    
                    break;
                case 2:
                    createTeam();
                    break;
                case 3:
                    //
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Try again smart ass");
                    System.out.println();
            }
        }

    }

    static public void createTeam() {
        String team;
        Scanner input = new Scanner(System.in);
        team = input.nextLine();
        team = team.replaceAll(" ", "%20");
        System.out.println(team);
        
        try {
            UserAgent userAgent = new UserAgent();                       //create new userAgent (headless browser).
            userAgent.visit("http://en.wikipedia.org/wiki/Special:Search?search="+team); //visit a url              
            //System.out.println(userAgent.doc.innerHTML());
            String crestLink = userAgent.doc.findFirst("<table class=\"infobox vcard\">").findFirst("<img>").getAt("src");            
            System.out.println("crest link: " + crestLink);
        } catch (JauntException e) {         //if an HTTP/connection error occurs, handle JauntException.
            System.err.println(e);
        }
    
    }

}

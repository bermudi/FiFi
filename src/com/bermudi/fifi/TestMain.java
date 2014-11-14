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

import java.io.IOException;


/**
 *
 * @author daniel
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Team team1 = new Team("Manchester United", 4.5f);
        Team team2 = new Team("Real Madrid FC", 4.5f);
        Team team3 = new Team("PSG FC", 4.5f);
        Team team4 = new Team("Liverpool FC", 4f);
        Team team5 = new Team("Arsenal FC", 5f);
        Team team6 = new Team("FC Barcelona", 5f);
        
        TeamManager.saveTeam(team1);
        TeamManager.saveTeam(team2);
        TeamManager.saveTeam(team3);
        TeamManager.saveTeam(team4);
        TeamManager.saveTeam(team5);
        TeamManager.saveTeam(team6);
        
        Team team7 = new Team();
        Team team8 = new Team();
        Team team9 = new Team();
        Team team10 = new Team();
        Team team11 = new Team();
        Team team12 = new Team();
        
        team7 = TeamManager.loadTeam(team1);
        team8 = TeamManager.loadTeam(team2);
        team9 = TeamManager.loadTeam(team3);
        team10 = TeamManager.loadTeam(team4);
        team11 = TeamManager.loadTeam(team5);
        team12 = TeamManager.loadTeam(team6);
        
    }
    
//    public static void main(String[] args) {
//        int sel;
//        Scanner input = new Scanner(System.in);
//        System.out.println("Please select an item from the menu");
//
//        while (true) {
//
//            System.out.println("1. Show Teams");
//            System.out.println("2. Add Team");
//            System.out.println("3. Delete Team");
//            System.out.println("9. Exit");
//
//            sel = input.nextInt();
//
//            switch (sel) {
//                case 1:
//
//                    break;
//                case 2:
//                    //
//                    break;
//                case 3:
//                    //
//                    break;
//                case 9:
//                    return;
//                default:
//                    System.out.println("Try again smart ass");
//                    System.out.println();
//            }
//        }
//
//    }
//
//    

}

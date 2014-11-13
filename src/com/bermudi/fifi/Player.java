/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bermudi.fifi;

/**
 *
 * @author daniel
 */
public class Player {

    private static int playerQty = 0;

    private int id;
    String name;
    Team[] teams = new Team[2];

    public void Player(String name) {

        this.name = name;
        this.id = playerQty++;
    }

    public void Player() {

        this.Player(Integer.toString(playerQty));
    }
}

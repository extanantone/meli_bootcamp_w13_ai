package com.app.game;

import com.app.game.elements.Nave;
import com.app.game.elements.NaveGroup;
import com.app.game.elements.Point;

public class App {
    public static void main(String[] args) {
        Board game = new Board();
        //Win
        Nave n1 = new Nave("Star", new Point(1, 1));
        // No Win
        Nave n2 = new Nave("Star_0_points", new Point(2, 2));
        Nave n3 = new Nave("Gamer", new Point(99, 100));
        game.Inscribe(n1);
        game.Inscribe(n2);
        game.Inscribe(n3);
        NaveGroup group = new NaveGroup();
        game.Inscribe(group);
        group.addNave(new Nave("G1", new Point(0, 99)));
        group.addNave(new Nave("G2", new Point(0, 101)));
        group.addNave(new Nave("G3", new Point(-1,100)));
        group.addNave(new Nave("G4", new Point(1, 100)));

        game.attackAsteroid(new Point(0, 0));
        game.attackAsteroid(new Point(0, 100));
        game.attackAsteroid(new Point(100, 100));
        System.out.println();
        System.out.println("Naves status");
        for(Nave n:game.getNaves()){
            System.out.println(n.getName()+" - Points: "+n.getPoints());
        }

        System.out.println();
        System.out.println("Status Groups:");
        for(NaveGroup g:game.getGroups()){
            System.out.println("Id: "+g.getId()+" - "+g.getPoints());
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;


public class cell{
    int xPos;
    int yPos;
    int dimension;
    int[] gridPos;
    boolean[] walls;
    boolean visited;
    boolean discovered;
    cell(int dimension, int xGridPos, int yGridPos){
        this.dimension = dimension;
        visited = false;
        discovered = false;
        gridPos = new int[]{xGridPos,yGridPos};
        xPos = (xGridPos*dimension)+5;
        yPos = (yGridPos*dimension)+5;
//      ORDER: Top, Right, Bottom, Left
        walls = new boolean[]{true,true,true,true};
    }

}


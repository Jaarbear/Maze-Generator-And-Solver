import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void mazeGeneration(JFrame frame, board Board){
        ArrayList<cell> visitedCells = new ArrayList<cell>();
        Board.setVisited(0,0);
        visitedCells.add(Board.getCell(0,0));
        while(visitedCells.size()>0){
            cell currentCell = visitedCells.remove(visitedCells.size()-1);
            ArrayList<cell> neighbors = (Board.getNeighbors(currentCell.gridPos[0],currentCell.gridPos[1]));
            if(neighbors.size() != 0){
                cell randomNeighbor;
                randomNeighbor = Board.getRandomElement(neighbors);
                Board.removeWalls(currentCell.gridPos[0],currentCell.gridPos[1],randomNeighbor.gridPos[0],randomNeighbor.gridPos[1]);
                randomNeighbor.visited = true;
                visitedCells.add(currentCell);
                visitedCells.add(randomNeighbor);
            }
            else{
                if(visitedCells.size()-1 >0){
                    currentCell = visitedCells.remove(visitedCells.size() - 1);
                    ArrayList<cell> neighbors2 = (Board.getNeighbors(currentCell.gridPos[0], currentCell.gridPos[1]));
                    if (neighbors2.size() > 0) {
                        cell randomNeighbor;
                        randomNeighbor = Board.getRandomElement(neighbors2);
                        Board.removeWalls(currentCell.gridPos[0], currentCell.gridPos[1], randomNeighbor.gridPos[0], randomNeighbor.gridPos[1]);
                        randomNeighbor.visited = true;
                        currentCell.visited = true;
                        visitedCells.add(currentCell);
                        visitedCells.add(randomNeighbor);
                    }
                }
                else{
                    break;
                }
            }
            try{ Thread.sleep(5);
            }catch (InterruptedException e){
            }
            frame.repaint();
        }
        Board.fillInSquares = true;
    }
    public static void depthFirstSearch(JFrame frame, board Board){
        Board.stack.add(Board.getCell(0,0));
        while(Board.fillInSquares){
            cell currentCell = Board.stack.get(Board.stack.size()-1);
            ArrayList<cell> undiscoveredNeighbors = Board.getUndiscoveredNeighbors(currentCell.gridPos[0],currentCell.gridPos[1]);
            if(currentCell.gridPos[0] == 34 && currentCell.gridPos[1] == 34){
                break;
            }
            if(undiscoveredNeighbors.size() == 0){
                Board.stack.remove(Board.stack.size()-1);
            }
            else{
                undiscoveredNeighbors.get(0).discovered = true;
                Board.stack.add(undiscoveredNeighbors.remove(0));
            }
            try{
                Thread.sleep(5);
            }catch (InterruptedException e){
            }
            frame.repaint();
        }
    }
    public static void main(String [] args){
        int windowWidth = 725;
        int windowHeight = 750;
        int cellDimension = 20;
        JFrame frame = new JFrame();
        board Board = new board(710, 710, cellDimension);
        frame.setSize(windowWidth,windowHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        Board.drawGrid();
        frame.add(Board);
        frame.setVisible(true);
        /*Maze Generation*/
        mazeGeneration(frame,Board);
        /*Search Algorithm*/
        depthFirstSearch(frame,Board);
    }
}


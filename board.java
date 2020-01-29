import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class board extends JComponent {
    private int windowW;
    private int windowH;
    private int cellDim;
    private cell[][] cells;
    Boolean fillInSquares = false;
    ArrayList<cell> stack = new ArrayList<cell>();
    board(int windowW, int windowH, int cellDim){
        this.windowH = windowH-10;
        this.windowW = windowW-10;
        this.cellDim = cellDim;
        cells = new cell[windowW/cellDim][windowH/cellDim];
    }
    public void setVisited(int cellX, int cellY){
        cells[cellX][cellY].visited = true;
    }
    public cell getCell(int cellX, int cellY){
        return cells[cellX][cellY];
    }
    public void drawGrid(){
        for(int i=0; i<(windowW/cellDim); i++){
            for(int j=0; j<(windowH/cellDim); j++){
                cell testCell = new cell(cellDim,i,j);
                cells[i][j] = testCell;
            }
        }
    }
    public void drawASquare(Graphics2D g2, cell cell){
        boolean inStack = false;
        for(int i=0; i<stack.size(); i++){
            if(stack.get(i) == cell){
                inStack = true;
            }
        }
        if(cell.walls[0] == true){
            Line2D.Double squareLine1 = new Line2D.Double(cell.xPos, cell.yPos, cell.xPos + cellDim, cell.yPos);
            g2.draw(squareLine1);
        }
        else if(cell.discovered && inStack){
            g2.setColor(Color.gray);
            Line2D.Double squareLine1 = new Line2D.Double(cell.xPos, cell.yPos, cell.xPos + cellDim, cell.yPos);
            g2.draw(squareLine1);
            g2.setColor(Color.black);
        }
        else if(cell.discovered && !inStack){
            g2.setColor(Color.darkGray);
            Line2D.Double squareLine1 = new Line2D.Double(cell.xPos, cell.yPos, cell.xPos + cellDim, cell.yPos);
            g2.draw(squareLine1);
            g2.setColor(Color.black);
        }
        else{
            g2.setColor(Color.lightGray);
            Line2D.Double squareLine1 = new Line2D.Double(cell.xPos, cell.yPos, cell.xPos + cellDim, cell.yPos);
            g2.draw(squareLine1);
            g2.setColor(Color.black);
        }
        if(cell.walls[1] == true){
            Line2D.Double squareLine2 = new Line2D.Double(cell.xPos + cellDim, cell.yPos, cell.xPos + cellDim, cell.yPos + cellDim);
            g2.draw(squareLine2);
        }
        else if(cell.discovered && inStack){
            g2.setColor(Color.gray);
            Line2D.Double squareLine2 = new Line2D.Double(cell.xPos + cellDim, cell.yPos, cell.xPos + cellDim, cell.yPos + cellDim);
            g2.draw(squareLine2);
            g2.setColor(Color.black);
        }
        else if(cell.discovered && !inStack){
            g2.setColor(Color.darkGray);
            Line2D.Double squareLine2 = new Line2D.Double(cell.xPos + cellDim, cell.yPos, cell.xPos + cellDim, cell.yPos + cellDim);
            g2.draw(squareLine2);
            g2.setColor(Color.black);
        }
        else{
            g2.setColor(Color.lightGray);
            Line2D.Double squareLine2 = new Line2D.Double(cell.xPos + cellDim, cell.yPos, cell.xPos + cellDim, cell.yPos + cellDim);
            g2.draw(squareLine2);
            g2.setColor(Color.black);
        }
        for(int i=0; i<cell.walls.length; i++){
            if(cell.walls[i] == false){
                fillCell(g2,cell.xPos,cell.yPos,Color.lightGray);
                return;
            }
        }
        if(cell.walls[2] == true){
            Line2D.Double squareLine3 = new Line2D.Double(cell.xPos,cell.yPos + cellDim, cell.xPos + cellDim, cell.yPos + cellDim);
            g2.draw(squareLine3);
        }
        else if(cell.discovered && inStack){
            g2.setColor(Color.gray);
            Line2D.Double squareLine3 = new Line2D.Double(cell.xPos,cell.yPos + cellDim, cell.xPos + cellDim, cell.yPos + cellDim);
            g2.draw(squareLine3);
            g2.setColor(Color.black);
        }
        else if(cell.discovered && !inStack){
            g2.setColor(Color.darkGray);
            Line2D.Double squareLine3 = new Line2D.Double(cell.xPos,cell.yPos + cellDim, cell.xPos + cellDim, cell.yPos + cellDim);
            g2.draw(squareLine3);
            g2.setColor(Color.black);
        }
        else{
            g2.setColor(Color.lightGray);
            Line2D.Double squareLine3 = new Line2D.Double(cell.xPos,cell.yPos + cellDim, cell.xPos + cellDim, cell.yPos + cellDim);
            g2.draw(squareLine3);
            g2.setColor(Color.black);
        }
        if(cell.walls[3] == true){
            Line2D.Double squareLine4 = new Line2D.Double(cell.xPos, cell.yPos, cell.xPos, cell.yPos + cellDim);
            g2.draw(squareLine4);
        }
        else if(cell.discovered && inStack){
            g2.setColor(Color.gray);
            Line2D.Double squareLine4 = new Line2D.Double(cell.xPos, cell.yPos, cell.xPos, cell.yPos + cellDim);
            g2.draw(squareLine4);
            g2.setColor(Color.black);
        }
        else if(cell.discovered && !inStack){
            g2.setColor(Color.darkGray);
            Line2D.Double squareLine4 = new Line2D.Double(cell.xPos, cell.yPos, cell.xPos, cell.yPos + cellDim);
            g2.draw(squareLine4);
            g2.setColor(Color.black);
        }
        else{
            g2.setColor(Color.lightGray);
            Line2D.Double squareLine4 = new Line2D.Double(cell.xPos, cell.yPos, cell.xPos, cell.yPos + cellDim);
            g2.draw(squareLine4);
            g2.setColor(Color.black);
        }
//        if(fillInSquares == true){
//            fillWalls(g2);
//        }
    }
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));
        for (int i = 0; i < windowW / cellDim; i++) {
            for (int j = 0; j < windowH / cellDim; j++) {
                drawASquare(g2, cells[i][j]);
            }
        }
        for(int i=0; i<cells.length; i++){
            for(int j=0; j<cells.length; j++){
                if(cells[i][j].discovered){
                    fillPath(g2, cells[i][j].xPos, cells[i][j].yPos, Color.darkGray);
                }
            }
        }
        for(int i=0; i<stack.size()-1; i++){
            fillPath(g2,stack.get(i).xPos, stack.get(i).yPos,Color.gray);
        }
        if(fillInSquares){
            g2.setColor(Color.blue);
            fillCell(g2,stack.get(stack.size()-1).xPos, stack.get(stack.size()-1).yPos, Color.blue);
            fillCell(g2,cells[0][0].xPos,cells[0][0].yPos,Color.GREEN);
            fillCell(g2,cells[cells.length-1][cells.length-1].xPos,cells[cells.length-1][cells.length-1].yPos,Color.red);
        }
        for(int i=0; i<stack.size()-1; i++){
            drawPath(g2, stack.get(i), stack.get(i+1));
        }
        Rectangle2D.Double border = new Rectangle2D.Double(5,5,700,700);
        g2.draw(border);

    }
    public ArrayList<cell> getNeighbors(int cellX, int cellY){
        ArrayList<cell> neighbors = new ArrayList<cell>();
        if(cellY-1>=0 && !cells[cellX][cellY-1].visited){
            neighbors.add(cells[cellX][cellY-1]);
        }
        if(cellX+1<cells.length && !cells[cellX+1][cellY].visited){
            neighbors.add(cells[cellX+1][cellY]);
        }
        if(cellY+1<cells[0].length && !cells[cellX][cellY+1].visited){
            neighbors.add(cells[cellX][cellY+1]);
        }
        if(cellX-1>=0  && !cells[cellX-1][cellY].visited){
            neighbors.add(cells[cellX-1][cellY]);
        }
//        Zig Zag Maze
//        if(cellX+1<cells.length && !cells[cellX+1][cellY].visited){
//            neighbors.add(cells[cellX+1][cellY]);
//        }
//        if(cellX-1>=0  && !cells[cellX-1][cellY].visited){
//            neighbors.add(cells[cellX-1][cellY]);
//        }
//        if(cellY+1<cells[0].length && !cells[cellX][cellY+1].visited){
//            neighbors.add(cells[cellX][cellY+1]);
//        }
//        if(cellY-1>=0 && !cells[cellX][cellY-1].visited){
//            neighbors.add(cells[cellX][cellY-1]);
//        }
        return neighbors;
    }
    public ArrayList<cell> getUndiscoveredNeighbors(int cellX, int cellY){
        ArrayList<cell> neighbors = new ArrayList<cell>();
        if(cellX+1<cells.length && !cells[cellX+1][cellY].discovered && cells[cellX][cellY].walls[1] == false){
            neighbors.add(cells[cellX+1][cellY]);
        }
        if(cellY+1<cells[0].length && !cells[cellX][cellY+1].discovered && cells[cellX][cellY].walls[2] == false){
            neighbors.add(cells[cellX][cellY+1]);
        }
        if(cellX-1>=0  && !cells[cellX-1][cellY].discovered && cells[cellX][cellY].walls[3] == false){
            neighbors.add(cells[cellX-1][cellY]);
        }
        if(cellY-1>=0 && !cells[cellX][cellY-1].discovered && cells[cellX][cellY].walls[0] == false){
            neighbors.add(cells[cellX][cellY-1]);
        }

        return neighbors;
    }
    public cell getRandomElement(ArrayList<cell> cells){
//      zig Zag Behavior
//      int whichCell = 0;
        int whichCell = (int) (Math.random() * (cells.size()));
        return cells.remove(whichCell);
    }
    public void fillCell(Graphics2D g2, int cellX, int cellY, Color color){
        Rectangle2D.Double fillIn = new Rectangle2D.Double(cellX+1,cellY+1,cellDim-2,cellDim-1);
        g2.setColor(color);
        g2.fill(fillIn);
        g2.draw(fillIn);
        g2.setColor(Color.black);
    }
    public void fillPath(Graphics2D g2, int cellX, int cellY, Color color){
        Rectangle2D.Double fillIn = new Rectangle2D.Double(cellX+1,cellY+1,cellDim-2,cellDim-1.5);
        g2.setColor(color);
        g2.fill(fillIn);
        g2.draw(fillIn);
        g2.setColor(Color.black);
    }
    public void drawPath(Graphics2D g2, cell cell1, cell cell2){
        g2.setColor(Color.red);
//        g2.setStroke(new BasicStroke(1));
        Line2D.Double path = new Line2D.Double(cell1.xPos+1+(cellDim/2), cell1.yPos+1+(cellDim/2), cell2.xPos+1+(cellDim/2), cell2.yPos+1+(cellDim/2));
        g2.draw(path);
//        g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.black);
    }
    public void removeWalls(int cell1X, int cell1Y, int cell2X, int cell2Y){
        cells[cell1X][cell1Y].visited = true;
        cells[cell2X][cell2Y].visited = true;
        if(Math.abs(cell1X-cell2X)!=1 && Math.abs(cell1Y-cell2Y)!=1){
            return;
        }
        if(Math.abs(cell1X-cell2X)==1 && Math.abs(cell1Y-cell2Y)==1){
            return;
        }
        else if(cell1X>cell2X){
            cells[cell1X][cell1Y].walls[3] = false;
            cells[cell2X][cell2Y].walls[1] = false;
        }
        else if(cell1X<cell2X){
            cells[cell1X][cell1Y].walls[1] = false;
            cells[cell2X][cell2Y].walls[3] = false;
        }
        else if(cell1Y<cell2Y){
            cells[cell1X][cell1Y].walls[2] = false;
            cells[cell2X][cell2Y].walls[0] = false;
        }
        else if(cell1Y>cell2Y){
            cells[cell1X][cell1Y].walls[0] = false;
            cells[cell2X][cell2Y].walls[2] = false;
        }
    }
}

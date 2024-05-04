public class Cell implements Comparable<Cell> {
    private int aliveNeighbors;
    private boolean isAlive;
    private String pointName;

    public Cell(boolean isAlive, String pointName) {
        this.isAlive = isAlive;
        this.aliveNeighbors = 0;
        this.pointName = pointName;
    }

    public String getPointName() {
        return pointName;
    }

    public void setAliveNeighbors(int aliveNeighbors) {
        this.aliveNeighbors = aliveNeighbors;
    }

    public int getAliveNeighbors() {
        return aliveNeighbors;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int compareTo(Cell other) {
        return Integer.compare(this.aliveNeighbors, other.aliveNeighbors);
    }

    public String toString() {
        return pointName + ":" + aliveNeighbors;
    }
}
import java.util.Arrays;

public class Universe {
    private Cell[][] grid;
    private int size;

    public Universe(int size) {
        this.size = size;
        this.grid = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.grid[i][j] = new Cell(false, i + "-" + j);
            }
        }
    }

    public void setCell(int x, int y, boolean isAlive) {
        grid[x][y].setIsAlive(isAlive);
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public void updateNeighbors() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int aliveNeighbors = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (x == 0 && y == 0) continue;
                        int newX = (i + x + size) % size;
                        int newY = (j + y + size) % size;
                        if (grid[newX][newY].isAlive()) {
                            aliveNeighbors++;
                        }
                    }
                }
                grid[i][j].setAliveNeighbors(aliveNeighbors);
            }
        }
    }

    public void So() {
        Cell[] cells = new Cell[1000];
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[index++] = grid[i][j];
            }
        }
        Arrays.sort(cells, 0, index);
        for (int i = 0; i < index; i++) {
                System.out.println(cells[i]);
        }
    }
}

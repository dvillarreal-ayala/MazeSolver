/**
 * Solves the given maze using DFS or BFS
 * @author Ms. Namasivayam
 * @version 03/10/2023
 */
//Damian Villarreal-Ayala, Menlo School CS2
import java.util.ArrayList;
import java.util.Stack;

public class MazeSolver {
    private Maze maze;

    public MazeSolver() {
        this.maze = null;
    }

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    /**
     * Starting from the end cell, backtracks through
     * the parents to determine the solution
     * @return An arraylist of MazeCells to visit in order
     */
    public ArrayList<MazeCell> getSolution() {
        // TODO: Get the solution from the maze
        // Should be from start to end cells
        Stack<MazeCell> reverseOrder = new Stack<MazeCell>();
        ArrayList<MazeCell> correctOrder = new ArrayList<MazeCell>();
        //Use a MazeCell instead of variables.
        MazeCell M = maze.getEndCell();
        //While the cell isn't the starting cell, push the cell into the reverseOrder Stack and M to the parent Cell.
        //maze.getCell(row, col).equals(maze.getStartCell()) == false
        while(M.equals(maze.getStartCell()) == false)
        {
            reverseOrder.push(M);
            M = M.getParent();
        }
        reverseOrder.push(maze.getStartCell());
        //While Stack isn't empty, use pop to add to correctOrder ArrayList and remove from the reverseOrder Stack.
        while(!reverseOrder.empty())
        {
            correctOrder.add(reverseOrder.pop());
        }
        return correctOrder;
    }

    /**
     * Performs a Depth-First Search to solve the Maze
     * @return An ArrayList of MazeCells in order from the start to end cell
     */
    public ArrayList<MazeCell> solveMazeDFS() {
        // TODO: Use DFS to solve the maze
        // Explore the cells in the order: NORTH, EAST, SOUTH, WEST
        Stack<MazeCell> cellsToVisit = new Stack<MazeCell>();
        ArrayList<MazeCell> visitedCells = new ArrayList<MazeCell>();
        //Cell we will use to traverse the maze.
        MazeCell M = maze.getStartCell();

//        for(int i = 0; i < maze.; i++)
//        {
//
//        }
        visitedCells.add(M);

        return null;
    }

    /**
     * Performs a Breadth-First Search to solve the Maze
     * @return An ArrayList of MazeCells in order from the start to end cell
     */
    public ArrayList<MazeCell> solveMazeBFS() {
        // TODO: Use BFS to solve the maze
        // Explore the cells in the order: NORTH, EAST, SOUTH, WEST
        return null;
    }

    public static void main(String[] args) {
        // Create the Maze to be solved
        Maze maze = new Maze("Resources/maze3.txt");

        // Create the MazeSolver object and give it the maze
        MazeSolver ms = new MazeSolver();
        ms.setMaze(maze);

        // Solve the maze using DFS and print the solution
        ArrayList<MazeCell> sol = ms.solveMazeDFS();
        maze.printSolution(sol);

        // Reset the maze
        maze.reset();

        // Solve the maze using BFS and print the solution
        sol = ms.solveMazeBFS();
        maze.printSolution(sol);
    }
}

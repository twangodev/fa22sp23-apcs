package hw;

public class Maze {

    String[] data = {
            "xxxxxxxxxxxxxxxxxxxx",
            "x  x    x   x      x",
            "x  x x  x   x  xxx x",
            "x  x x  x xxx  x x x",
            "x  x x  x x   x  x x",
            "x  x x  x x x  x x x",
            "x x  x x  x x  x x x",
            "x  x x  x x x  x x x",
            "x  x x  x   x  x   x",
            "x    x      x  x ^ x",
            "xxxxxxxxxxxxxxxxxxxx"};

    char[][] maze;

    public Maze() {
        maze = new char[data.length][data[0].length()];
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j<maze[0].length; j++) {
                maze[i][j] = data[i].charAt(j);
            }
        }
    }

    public void printMaze() {
        for (char[] chars : maze) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

    public boolean findPath(int x, int y) {
        if(maze[x][y] == 'x' || maze[x][y] == '.') return false;
        if(maze[x][y] == '^') {
            return true;
        }

        maze[x][y]='.';


        return findPath(x-1, y) || findPath(x+1, y) || findPath(x, y-1) || findPath(x, y+1);
    }

    public static void main (String[] args) {
        Maze mz = new Maze();
        mz.printMaze();
        mz.findPath(1, 1);
        mz.printMaze();
    }

}


/**
 * Write a description of class main here.
 *
 * @author (Charles Easter)
 * @version (DATE)
 */
import javax.swing.JOptionPane;
public class Run
{
   public static void main(){
       Read.lettersAcrossTop();
       int mazeNum = 0;
       String ident = "";
       while (mazeNum == 0) {
           ident = Read.getCoord("Identifier?"); 
           mazeNum = Maze.identMaze(ident);
           }
       //Set the correct maze as TheMaze (static boolean[][] in class Maze
       Maze.setTheMaze(mazeNum);
       String start = Read.getCoord("Starting Point? (lit square)");
       String goal = Read.getCoord("Goal? (red triangle)");
       //asks the user to verify the imputs.  calls Run.main() if not correct. 
       boolean done = Read.verify(ident, mazeNum, start, goal);
       //if done is false, it means verify() didn't call Run.main() and the job isn't done
       if (!done) {
           Path.find(start, goal);
           if(!Read.letters){
              start = Read.translate(start);                 
              goal = Read.translate(goal);
           }
           String message = "Maze# " + mazeNum + 
                            "\nStart: " + start + ", " + 
                            "\nGoal: " + goal + ", " + 
                            "\nWinning Path: " + Path.getWinDirections();                 
           JOptionPane.showMessageDialog(null, message);
       }
   }
}

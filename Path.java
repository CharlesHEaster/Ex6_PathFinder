
/**
 * Write a description of class Path here.
 *
 * @author (Charles Easter)
 * @version (DATE)
 */

import java.util.Vector;
import javax.swing.JOptionPane;

public class Path {
   private static Vector<Path> all = new Vector();
   private static Vector<Path> wins = new Vector();
   public Position goal, pos;
   public String directions;
   public Vector<Position> history = new Vector<Position>();
   
   public Path(Position curpos){
     pos = curpos;
     directions = "";
     history = new Vector<Position>();//remove this if it starts acting like static variable again
   }
   
   public Path() {
     pos = new Position();
     history = new Vector<Position>();
     directions = "";
    }
   
   public Path(Path oldPath){
       pos = oldPath.getPosition();
       history = oldPath.getHistory();
       directions = oldPath.getDirections();
    }
    
   public Path(Position curpos, Vector<Position> his, String dir){
     pos = curpos;
     history = new Vector<Position>(his);
     directions = dir;
     
   } 
   
   //get and set functions
   public void setPosition(Position curpos) {
     pos = curpos;  
    }
     
   public void setDirections(String dir) {
     directions = dir;  
    }
    
   public void setHistory(Vector<Position> hist) {
        history = hist;
    }
   
   public Position getPosition(){
     return pos;  
    }
   
   public String getDirections(){
     return directions;  
    }
   
   public Vector getHistory(){
     return history;
   }
    
   public String toStringHistory() {
       String message = "";
       
       for (int i = 0; i < history.size(); i++) {
         
         message += history.get(i) + ", ";
        }
       return message;
   }
     
   public String toString(){
       String str = "Pos: " + pos;
       str += "\nHistory: " + toStringHistory(); 
       str += "\nDirections: " + getDirections();
       return str;
    }
   
   public static String toStringPaths(){
      String message = "";
      Path path = new Path();
      for (int i = 0; i < Path.all.size(); i++){
          path = Path.all.get(i);
          message += "PATH-" + i;
          message += "\n" + path.toString();
          message += "\n\n";
      }
       return message;
   }
   
   
   public static String toStringWins(){
      String message = "";
      for (int i = 0; i < Path.wins.size(); i++){
          message += "PATH-" + i;
          message += "\n" + Path.wins.get(i).toString();
          message += "\n\n";
      }
       return message;
   
   }
    
   public static void find(String sta, String goa) {
       Vector<Path> wins = new Vector();
       //grab arguments
      Position goal = Read.convert(goa);
      Position startPos = new Position(Read.convert(sta));
       //Start first position
      Path startPath = new Path(startPos);
       //Add first path to list of paths
      Path.all.add(startPath);
       //iniatalize interation variables
      boolean beenHere$ = false;
      Path tempPath = new Path();
      String newDir;
      Path newPath = new Path();
       //start the loop.  exits when no paths are on list
      while (Path.all.size() > 0){
         //Grab the next Path off list
         tempPath = new Path(Path.all.get(0));
         Path.all.remove(0);
         //create directional vairables for this postion
         Position wallLEFT =    new Position(tempPath.pos.getY(), tempPath.pos.getX() - 1);
         Position wallUP =      new Position(tempPath.pos.getY() - 1, tempPath.pos.getX());
         Position wallRIGHT =   new Position(tempPath.pos.getY(), tempPath.pos.getX() + 1);
         Position wallDOWN =    new Position(tempPath.pos.getY() + 1, tempPath.pos.getX());
         Position moveLEFT =    new Position(tempPath.pos.getY(), tempPath.pos.getX() - 2);
         Position moveUP =      new Position(tempPath.pos.getY() - 2, tempPath.pos.getX());
         Position moveRIGHT =   new Position(tempPath.pos.getY(), tempPath.pos.getX() + 2);
         Position moveDOWN =    new Position(tempPath.pos.getY() + 2, tempPath.pos.getX());
         //read history
             //reset beenHere$
         beenHere$ = false;
         Position histPos = new Position();
         for (int i = 0; i < tempPath.history.size(); i++) {
             histPos = tempPath.history.get(i);
             if (histPos.equals(tempPath.pos)) {
                 beenHere$ = true;
             }
             //sets beenHere$ to true if it has ever been there
         }
         
         //check history
         if (beenHere$) { //do nothing, let branch die
            }else if(goal.equals(tempPath.pos)) { //check win 
               Path.wins.add(new Path(tempPath)); //add to win list
               return;
            } else { //do all the other things
                //add current position to history
                tempPath.history.add(tempPath.pos);
                //check walls, add directions, move
                if (!Maze.getTheMaze(wallLEFT.getY(), wallLEFT.getX())){
                    newDir = tempPath.directions + "Left, ";
                    newPath = new Path(moveLEFT, tempPath.history, newDir);
                    Path.all.add(newPath);
                }
                if (!Maze.getTheMaze(wallUP.getY(), wallUP.getX())){
                    newDir = tempPath.directions + "Up, ";
                    newPath = new Path(moveUP, tempPath.history, newDir);
                    Path.all.add(newPath);
                }
                if (!Maze.getTheMaze(wallRIGHT.getY(), wallRIGHT.getX())){
                    newDir = tempPath.directions + "Right, ";
                    newPath = new Path(moveRIGHT, tempPath.history, newDir);
                    Path.all.add(newPath);
                }
                if (!Maze.getTheMaze(wallDOWN.getY(), wallDOWN.getX())){
                    newDir = tempPath.directions + "Down, ";
                    newPath = new Path(moveDOWN, tempPath.history, newDir);
                    Path.all.add(newPath);
                }      
         }
      }
   }
   public static String getWinDirections(){
       String theAnswer = "";
       if (Path.wins.size() == 0) {
           theAnswer += "Something Fucked Up";
        } else {
            theAnswer += Path.wins.get(0).getDirections();
        }
       return theAnswer;
    }
}


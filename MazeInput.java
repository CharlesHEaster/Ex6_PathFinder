
/**
 * This is a one time Maze input prompt.  I will copy the output and hardcode it into the maze class
 * 
 * Post Script:  So it worked, but gave a shit ton of extra output.  I found that the last line of the arrays was the proper maze output.
 * I really don't get why the rest of the output came out, but I don't really care anymore.
 * *14-5-2020 ** NOPE!  Turns out, all the outputs were the same, here I dive in again.
 * *16-5-2020 So the output of system stacks until i restart blueJ.  that sucks balls.  all sorted now though
 * 
 * 
 *
 * @author (Charles Easter)
 * @version (09-05-2020)
 */
import javax.swing.JOptionPane;
import java.util.Arrays;

public class MazeInput {
    public static void main(){
       //Make an empty maze 13x13
       boolean[][] Maze = new boolean[13][13];
       //Make row 1 be walls (true)
       for (int j = 0; j < Maze[0].length; j++){
           Maze[0][j] = true;
       }
       java.util.Arrays.fill(Maze[0], true);
       //Get Row Input
       for (int i = 1; i < Maze.length - 1; i++){
           //Make first column a wall
           Maze[i][0] = true;
           //get the rest of the row
           for (int j = 1; j < Maze[i].length - 1; j++) {
               //Make Dots empty
               if (i % 2 == 1 && j % 2 == 1){
                   
               }
               //Make corners empty
               else if (i % 2 == 0 && j % 2 == 0){
                    
               }
               //if not a dot or corner, ask
               else               
               {
                    int Answer = JOptionPane.showConfirmDialog(null,"Is [" + i + "][" + j + "] a wall?", "Please select",
                                 JOptionPane.YES_NO_OPTION); 
                    if (Answer == 1){
                        
                        }
                        else if (Answer == 0){
                        Maze[i][j] = true;
                    } 
               }
           }
           //Make Last Column a wall
           Maze[i][Maze[i].length - 1] = true;
       }
        //Make last row all walls
       java.util.Arrays.fill(Maze[Maze.length - 1], true);
        //Print it
       
       String message = " _____________\n";
       //if i is odd and j is odd use i+1
       for (int i = 1; i < Maze.length; i += 2) {
         for (int j = 0; j < Maze[i].length; j++) {
             if (j % 2 == 0){
                 //normal i
                 if (Maze[i][j]){
                     message += "|";
                 } else if (!Maze[i][j]){
                        message += " ";
                   
                 }
             }
             if (j % 2 == 1) {
                // i + 1    
                if (Maze[i + 1][j]){
                     message += "_";
                } else if (!Maze[i + 1][j]){
                        message += "  ";
                }
             
             }
             
         }
         message += "\n";
       }
       
       JOptionPane.showMessageDialog(null, message);
       
       String message2 = "{";
       for (int i = 0; i < Maze.length; i++) {
           message2 += "{";
           for (int j = 0; j < Maze[i].length; j++) {
             if (Maze[i][j]) {
                 message2 += "true";
              } else {
                 message2 += "false";
              }
             if (j != Maze[i].length - 1) {
                message2 += ", ";
              } else {
                message2 += "}";
              }
            }
           if (i != Maze.length - 1) {
             message2 += ", ";
            } else {
                message2 += "}";
            }
        }
       System.out.println(message2);
    }
}



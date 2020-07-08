    
    /**
     * Write a description of class Maze here.
     *
     * @author (Charles Easter)
     * @version (DATE)
     */
    import javax.swing.JOptionPane;
    public class Maze {
        
        private static boolean[][] TheMaze = new boolean[13][];
        
        public static boolean[][] getTheMaze(){
            return TheMaze;
        }
        
        public static boolean getTheMaze(int y, int x){
         return Maze.TheMaze[y][x];   
        }
        
        public static String showTheMaze(){
            String message = "";
            for (int i = 0; i < Maze.TheMaze.length; i++){
                for (int j = 0; j < Maze.TheMaze[i].length; j++) {
                    if (i % 2 == 0 && j % 2 == 0){
                         message += "#";
                     } else if (Maze.TheMaze[i][j]) {
                         message += "#";
                     } else {
                         message += "_";
                     }
                 
                }
                message += "\n";
            }
            return message;
        }
        
        public static int identMaze(String identifer){
            String ident = identifer;
            int mazeNum;
            if ("A2".equals(ident) || "F3".equals(ident)){
                mazeNum = 1;
            } else if ("E2".equals(ident) || "B4".equals(ident)){
                mazeNum = 2;
            } else if ("D4".equals(ident) || "E4".equals(ident)){
                mazeNum = 3;
            } else if ("A1".equals(ident) || "A4".equals(ident)){
                mazeNum = 4;
            } else if ("E3".equals(ident) || "D6".equals(ident)){
                mazeNum = 5;
            } else if ("C5".equals(ident) || "E1".equals(ident)){
                mazeNum = 6;
            } else if ("B1".equals(ident) || "B6".equals(ident)){
                mazeNum = 7;
            } else if ("D1".equals(ident) || "C4".equals(ident)){
                mazeNum = 8;
            } else if ("A5".equals(ident) || "C2".equals(ident)){
                mazeNum = 9;
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, that identifier doesn't match\n " + ident);
                mazeNum = 0;
            }
            return mazeNum;
        }
    
        public static void setTheMaze(int maz){
            int mazeNum = maz;
            
            if (mazeNum == 1) {
                    boolean[][] maze = 
                    {{true, true, true, true, true, true, true, true, true, true, true, true, true},
                    {true, false, false, false, false, false, true, false, false, false, false, false, true}, 
                    {true, false, false, true, false, false, false, false, false, true, false, true, true}, 
                    {true, false, true, false, false, false, true, false, false, false, false, false, true}, 
                    {true, false, false, false, false, true, false, true, false, true, false, false, true}, 
                    {true, false, true, false, false, false, true, false, false, false, false, false, true}, 
                    {true, false, false, true, false, false, false, false, false, true, false, false, true}, 
                    {true, false, true, false, false, false, false, false, true, false, false, false, true}, 
                    {true, false, false, true, false, true, false, true, false, true, false, false, true}, 
                    {true, false, false, false, false, false, true, false, false, false, true, false, true}, 
                    {true, false, false, true, false, false, false, false, false, true, false, false, true}, 
                    {true, false, false, false, true, false, false, false, true, false, false, false, true}, 
                    {true, true, true, true, true, true, true, true, true, true, true, true, true}};
                    TheMaze = maze;
                } else if (mazeNum == 2) { 
                    boolean[][] maze = {{true, true, true, true, true, true, true, true, true, true, true, true, true}, 
                    {true, false, false, false, false, false, true, false, false, false, false, false, true}, 
                    {true, true, false, false, false, true, false, false, false, false, false, true, true}, 
                    {true, false, false, false, true, false, false, false, true, false, false, false, true}, 
                    {true, false, false, true, false, false, false, true, false, true, false, false, true}, 
                    {true, false, true, false, false, false, true, false, false, false, false, false, true}, 
                    {true, false, false, false, false, true, false, false, false, true, false, false, true}, 
                    {true, false, false, false, true, false, false, false, true, false, true, false, true}, 
                    {true, false, false, true, false, false, false, true, false, false, false, false, true}, 
                    {true, false, true, false, true, false, true, false, false, false, true, false, true}, 
                    {true, false, false, false, false, false, false, false, false, true, false, false, true}, 
                    {true, false, true, false, false, false, true, false, false, false, false, false, true}, 
                    {true, true, true, true, true, true, true, true, true, true, true, true, true}};
                    TheMaze = maze;
                } else if (mazeNum == 3) { 
                    boolean[][] maze = {{true, true, true, true, true, true, true, true, true, true, true, true, true}, 
                    {true, false, false, false, false, false, true, false, true, false, false, false, true}, 
                    {true, false, false, true, false, false, false, false, false, false, false, false, true}, 
                    {true, false, true, false, true, false, true, false, false, false, true, false, true}, 
                    {true, true, false, false, false, false, false, true, false, true, false, false, true}, 
                    {true, false, false, false, true, false, true, false, false, false, true, false, true}, 
                    {true, false, false, false, false, false, false, false, false, false, false, false, true}, 
                    {true, false, true, false, true, false, true, false, true, false, true, false, true}, 
                    {true, false, false, false, false, false, false, false, false, false, false, false, true}, 
                    {true, false, true, false, false, false, true, false, true, false, true, false, true}, 
                    {true, false, false, true, false, true, false, false, false, false, false, false, true}, 
                    {true, false, false, false, false, false, false, false, true, false, false, false, true}, 
                    {true, true, true, true, true, true, true, true, true, true, true, true, true}};
                    TheMaze = maze;
                } else if (mazeNum == 4) {
                    boolean[][] maze = {{true, true, true, true, true, true, true, true, true, true, true, true, true}, 
                    {true, false, false, false, true, false, false, false, false, false, false, false, true}, 
                    {true, false, false, false, false, true, false, true, false, true, false, false, true}, 
                    {true, false, true, false, true, false, false, false, false, false, false, false, true}, 
                    {true, false, false, false, false, false, false, true, false, true, false, false, true}, 
                    {true, false, true, false, false, false, true, false, false, false, true, false, true}, 
                    {true, false, false, true, false, true, false, false, false, true, false, false, true}, 
                    {true, false, true, false, false, false, false, false, false, false, false, false, true}, 
                    {true, false, false, true, false, true, false, true, false, true, false, false, true}, 
                    {true, false, false, false, false, false, false, false, false, false, true, false, true}, 
                    {true, false, false, true, false, true, false, true, false, false, false, false, true}, 
                    {true, false, false, false, false, false, true, false, false, false, true, false, true}, 
                    {true, true, true, true, true, true, true, true, true, true, true, true, true}};
                    TheMaze = maze;
                } else if (mazeNum == 5) {
                    boolean[][] maze = {{true, true, true, true, true, true, true, true, true, true, true, true, true}, 
                    {true, false, false, false, false, false, false, false, false, false, false, false, true}, 
                    {true, true, false, true, false, true, false, true, false, false, false, false, true}, 
                    {true, false, false, false, false, false, false, false, false, false, true, false, true}, 
                    {true, false, false, true, false, true, false, false, false, true, false, true, true}, 
                    {true, false, false, false, true, false, false, false, true, false, false, false, true}, 
                    {true, false, false, false, false, true, false, true, false, false, false, false, true}, 
                    {true, false, true, false, false, false, false, false, true, false, true, false, true}, 
                    {true, false, false, true, false, true, false, false, false, true, false, false, true}, 
                    {true, false, true, false, false, false, false, false, false, false, true, false, true}, 
                    {true, false, false, false, false, true, false, true, false, true, false, false, true}, 
                    {true, false, true, false, false, false, false, false, false, false, false, false, true}, 
                    {true, true, true, true, true, true, true, true, true, true, true, true, true}};
                    TheMaze = maze;
                } else if (mazeNum == 6) {
                    boolean[][] maze = {{true, true, true, true, true, true, true, true, true, true, true, true, true}, 
                    {true, false, true, false, false, false, true, false, false, false, false, false, true}, 
                    {true, false, false, false, false, false, false, true, false, false, false, false, true}, 
                    {true, false, true, false, true, false, true, false, false, false, true, false, true}, 
                    {true, false, false, false, false, false, false, false, false, true, false, false, true}, 
                    {true, false, false, false, true, false, true, false, true, false, false, false, true}, 
                    {true, false, false, true, false, true, false, false, false, false, false, true, true}, 
                    {true, false, false, false, true, false, false, false, true, false, true, false, true}, 
                    {true, true, false, false, false, false, false, false, false, false, false, false, true}, 
                    {true, false, false, false, true, false, true, false, true, false, false, false, true}, 
                    {true, false, false, true, false, true, false, false, false, true, false, false, true}, 
                    {true, false, false, false, false, false, false, false, true, false, false, false, true}, 
                    {true, true, true, true, true, true, true, true, true, true, true, true, true}};
                    TheMaze = maze;
                } else if (mazeNum == 7) {
                    boolean[][] maze = {{true, true, true, true, true, true, true, true, true, true, true, true, true}, 
                    {true, false, false, false, false, false, false, false, true, false, false, false, true}, 
                    {true, false, false, true, false, true, false, false, false, false, false, false, true}, 
                    {true, false, true, false, false, false, true, false, false, false, true, false, true}, 
                    {true, false, false, false, false, true, false, true, false, true, false, false, true}, 
                    {true, false, false, false, true, false, false, false, true, false, false, false, true}, 
                    {true, true, false, true, false, false, false, true, false, false, false, true, true}, 
                    {true, false, false, false, true, false, false, false, false, false, true, false, true}, 
                    {true, false, false, false, false, false, false, true, false, true, false, false, true}, 
                    {true, false, true, false, true, false, false, false, false, false, true, false, true}, 
                    {true, false, false, true, false, true, false, true, false, false, false, false, true}, 
                    {true, false, false, false, false, false, false, false, false, false, false, false, true}, 
                    {true, true, true, true, true, true, true, true, true, true, true, true, true}};
                    TheMaze = maze;
                } else if (mazeNum == 8) {
                    boolean[][] maze = {{true, true, true, true, true, true, true, true, true, true, true, true, true}, 
                    {true, false, true, false, false, false, false, false, true, false, false, false, true}, 
                    {true, false, false, false, false, true, false, false, false, false, false, false, true}, 
                    {true, false, false, false, false, false, true, false, false, false, true, false, true}, 
                    {true, false, false, true, false, true, false, true, false, true, false, false, true}, 
                    {true, false, true, false, false, false, false, false, false, false, true, false, true}, 
                    {true, false, false, false, false, true, false, true, false, false, false, false, true}, 
                    {true, false, true, false, false, false, true, false, false, false, false, false, true}, 
                    {true, false, false, true, false, false, false, true, false, true, false, true, true}, 
                    {true, false, true, false, true, false, false, false, false, false, false, false, true}, 
                    {true, false, false, false, false, true, false, true, false, true, false, true, true}, 
                    {true, false, false, false, false, false, false, false, false, false, false, false, true}, 
                    {true, true, true, true, true, true, true, true, true, true, true, true, true}};
                    TheMaze = maze;
                } else if (mazeNum == 9) {
                    boolean[][] maze = {{true, true, true, true, true, true, true, true, true, true, true, true, true}, 
                    {true, false, true, false, false, false, false, false, false, false, false, false, true}, 
                    {true, false, false, false, false, true, false, true, false, false, false, false, true}, 
                    {true, false, true, false, true, false, false, false, true, false, true, false, true}, 
                    {true, false, false, false, false, false, false, true, false, false, false, false, true}, 
                    {true, false, false, false, false, false, true, false, false, false, true, false, true}, 
                    {true, false, false, true, false, true, false, false, false, true, false, false, true}, 
                    {true, false, true, false, true, false, false, false, true, false, false, false, true}, 
                    {true, false, false, false, false, false, false, true, false, true, false, false, true}, 
                    {true, false, true, false, true, false, true, false, false, false, true, false, true}, 
                    {true, false, false, false, false, false, false, false, false, false, false, true, true}, 
                    {true, false, false, false, true, false, false, false, true, false, false, false, true}, 
                    {true, true, true, true, true, true, true, true, true, true, true, true, true}};
                    TheMaze = maze;
            }
        }

        public static void deepCopy(boolean[][] source, boolean[][] destination){
            for (int i = 0; i < source.length; i++) {
                for (int j = 0; j < source[i].length; j++) {
                    destination[i][j] = source[i][j];
                }
            }
        }
    }
    
        
        
    
        
        
        
        
        
        
        
        

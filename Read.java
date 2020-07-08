
/**
 * A fully static class.  Contains static variables to control the translation of inputs from 
 * letters across the top format (default) to letters down the side.
 * 
 *
 * @author (Charles Easter)
 * @version (DATE)
 */
import javax.swing.JOptionPane;

public class Read{
    public static boolean letters;
    public static boolean alreadyTranslated$;
    // Asks user if they want letters across the top (or else or down the side)
    public static void lettersAcrossTop() {
        int $letters = JOptionPane.showConfirmDialog(null, "Letters across the top?", 
                "Where do you want the letters?",JOptionPane.YES_NO_CANCEL_OPTION);
        boolean letters = false;
        if ($letters == 0){
            Read.letters = true;
        } else if ($letters == 1){
            Read.letters = false;
        }

    }

    public static boolean verify(String id, int ma, String st, String goa){
        String ident = id;
        int mazeNum = ma;
        String start = st;
        String goal = goa;
        String letters = "";
        //check if letters are down the side
        if (Read.letters){
            letters += "Letters Across the Top";  //and leave coordinates the same
        } else if (!Read.letters){
            letters += "Letters Down the Side";  //and translate coordinates only for verify message output
            ident = Read.translate(ident);
            start = Read.translate(start);
            goal = Read.translate(goal);  
        }

        String verify = letters + "\nIdentifier: " + ident + " (Maze#" + mazeNum + ")\nStarting Point: " + start + "\nGoal: " + goal;
        int correct$ = JOptionPane.showConfirmDialog(null, verify, 
                "--Please Verify Values--",JOptionPane.YES_NO_CANCEL_OPTION);
        boolean done = false;
        //if user clicks OK the verify() returns false, as in not finished
        if (correct$ == 0){
            done = false;
        } else if (correct$ == 1){ //if user clicks no, verify() runs Run.main()
            Run.main();             // and returns true, because when it finishes main() the job is done
            done = true;
        }
        return done;
    }

    //method, checkes if int is character in range
    public static boolean isChar(int character){
        int charac = character;
        if (64 < charac && charac < 71) {
            return true;
        } else {
            return false;
        }
    }
    //method, checkes if int is number in range
    public static boolean isNumb(int number){
        int numb = number;
        if (48 < numb && numb < 55) {
            return true;
        } else {
            return false;
        }
    }

    public static String getCoord(String prom) {
        Read.alreadyTranslated$ = false;
        String prompt = prom;
        int char1num = 0;
        int char2num = 0;
        //asks user for a coordinate given the prompt.
        //Sanatizes upper case and order
        //Formats return to UpperChar#
        String coord = JOptionPane.showInputDialog(prompt);

        coord = coord.replaceAll("\\s","");

        //if input string is too long or too short, eliminate spaces
        while (coord.length() != 2) {
            String tooLong = "Nope, try again. No more or less than 2 characters.";
            coord = JOptionPane.showInputDialog(tooLong);
            coord = coord.replaceAll("\\s","");
        }

        //set specific character values
        char1num = coord.charAt(0);
        char2num = coord.charAt(1);

        //if number comes first, switch
        if (char1num < char2num){
            int temp = char1num;
            char1num = char2num;
            char2num = temp;
        }

        //if letter is lowercase, uppercase it
        if (96 < char1num && char1num < 123){
            char1num = char1num - 32;
        }

        //if chars not in range
        String coordOut = "";
        if (!(isChar(char1num) && isNumb(char2num))){
            JOptionPane.showMessageDialog(null, "Nope, try again. \nRanges 1-6 and A-F.");
            coordOut = getCoord(prompt);
        } 

        //reconstruct coord
        String a = Character.toString((char)char1num);
        String b = Character.toString((char)char2num);
        coord = a + b;

        //if recursion used, grab that coord, not the higher level one
        if (coordOut.length() > 0) {
            coord = coordOut;   
        }

        // translate from letters down and change static variable so it doesn't repeat with recursion
        if (!Read.letters && !Read.alreadyTranslated$) {
            coord = translate(coord);
            Read.alreadyTranslated$ = true;
        }

        //returns capitol letter, number, and in 'letters across the top' format

        return coord;

    }
    //Translates letters down the side to letters across the top
    public static String translate(String coord) {
        String input = coord;

        char char1 = coord.charAt(0);
        char char2 = coord.charAt(1);

        switch (char1){
            case 'A': {
                char1 = '1';

                break;
            }
            case 'B': {
                char1 = '2';

                break;
            }
            case 'C': {
                char1 = '3';

                break;
            }
            case 'D': {
                char1 = '4';

                break;
            }
            case 'E': {
                char1 = '5';

                break;
            }
            case 'F': {
                char1 = '6';

                break;
            } 
        }
        switch (char2){
            case '1': {
                char2 = 'A';

                break;
            }
            case '2': {
                char2 = 'B';

                break;
            }
            case '3': {
                char2 = 'C';

                break;
            }
            case '4': {
                char2 = 'D';

                break;
            }
            case '5': {
                char2 = 'E';

                break;
            }
            case '6': {
                char2 = 'F';

                break;
            } 
        }

        
        return String.valueOf(char2) + String.valueOf(char1);
    }

    //converts good CharNum to maze matrix coordinates
    public static Position convert(String coo) {
        String coord = coo;
        char char1 = coord.charAt(0);
        char char2 = coord.charAt(1);
        Position pos = new Position(0, 0);
        switch (char1){
            case 'A': {
                pos.setX(1);
                break;
            }
            case 'B': {
                pos.setX(3);
                break;
            }
            case 'C': {
                pos.setX(5);
                break;
            }
            case 'D': {
                pos.setX(7);
                break;
            }
            case 'E': {
                pos.setX(9);
                break;
            }
            case 'F': {
                pos.setX(11);
                break;
            } 
        }
        switch (char2){
            case '1': {
                pos.setY(1);
                break;
            }
            case '2': {
                pos.setY(3);
                break;
            }
            case '3': {
                pos.setY(5);
                break;
            }
            case '4': {
                pos.setY(7);
                break;
            }
            case '5': {
                pos.setY(9);
                break;
            }
            case '6': {
                pos.setY(11);
                break;
            } 
        }
        return pos;
    }

}

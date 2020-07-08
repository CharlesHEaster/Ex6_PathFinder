
/**
 * Write a description of class pos here.
 *
 * @author (Charles Easter)
 * @version (DATE)
 */
public class Position
{
   private int x;
   private int y;
   
   public Position(){}
   
   public Position(int ycoo, int xcoo) {
    x = xcoo;
    y = ycoo;
    
    }
   
   public Position(Position oldPos) {
    x = oldPos.getX();
    y = oldPos.getY();
    
    }
   
   public int getX(){
       return x;
    }
   
   public int getY(){
       return y;
   }
    
   public void setX(int ex){
     x = ex;  
       
    }
    
   public void setY(int why){
     y = why;  
    }
    
   public String toString(){
     return "[" + y + ", " + x + "]";  
    }
    
   // Overriding equals() to compare two Complex objects 
   @Override
   public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Position)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Position c = (Position) o; 
          
        // Compare the data members and return accordingly  
        return Double.compare(x, c.x) == 0
                && Double.compare(y, c.y) == 0; 
    }   
}

//Mickie Blair
//Final Project - Exotic Moves
//Invalid Input Exception

package finalprojectexoticmoves;

public class InvalidInputException extends Exception{
    
    /**
     * Constructor - No Args
     */
    InvalidInputException(){
       super();
        
    }
    
    /**
     * Constructor with message
     * @param m Message
     */
    InvalidInputException(String m){
        super(m);
    }
}
